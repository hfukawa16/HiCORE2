package jp.co.dit.android.apps.https.lib;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import jp.co.dit.android.apps.HiCore.DataBean.BaseBean;
import jp.co.dit.android.apps.HiCore.DataBean.LOGINBean;
import jp.co.dit.android.apps.HiCore.DataBean.LOGOUTBean;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import android.os.Message;
import android.os.StrictMode;

/**
 * HiCore勤務表との連携機能クラス (HttpsClientの受け渡し化など、改造の余地ありますが当座として作成)
 *
 * @param
 */
public class CommunicationControl {
	
	//ログ出力用のTAG
	@SuppressWarnings("unused")
	private final static String TAG = CommunicationControl.class.getSimpleName();
	
	// シングルトン化
	private static CommunicationControl instance = new CommunicationControl();

	// サーバ通信用URL固定値
	private static final String URL_HTTPS = "https://staffs2.ditgroup.jp/bs/default";

	// httpクライアントインスタンス
   	private Connection conn;

   	// 通信パラメータMAP
   	Map<String, String> map = new HashMap<String, String>();

	private String _system_time = "0";
	private String message=null;

	/**
	 * HiCore勤務表との連携機能クラス (https通信クラス設定)
	 *
	 * @param
	 */
	private CommunicationControl() {

		// プロキシの設定（ホストとポート）
		// テスト用なので・・・最後は消す
//       System.setProperty("https.proxyHost", "172.31.101.13");
//        System.setProperty("https.proxyPort", "8080");

		//本来は非同期で実施する
		//3.1からはStrictModeがデフォルトでONになっているので，OFFにするため，以下の一文を必要があります．
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
		
        // キープアライブ設定（リクエスト毎にセッションは張りなおす）
        System.setProperty("http.keepAlive", "false");

		this.conn = Jsoup.connect(URL_HTTPS);

       	//httpのステータスエラーは無視する
		this.conn.ignoreHttpErrors(true);

       	//ブラウザをMozillaとして設定
		this.conn.userAgent("Mozilla");

       	//タイムアウト
		this.conn.timeout(2000);

	}

	/**
	 * インスタンス取得
	 *
	 * @param
	 */
	public static CommunicationControl getInstance() {
		return instance;
	}

	
	// 通信処理
	private Response httpPost(BaseBean cn) throws Exception {

		//POSTパラメータのセット(データコンテナの内容でPOSTパラメータ設定)
    	this.conn.request().data().clear();	//クリア

		//サーバメッセージのクリア
		this.message = null;

    	// 通信で持ちまわるシステム時刻のセット
    	cn.set_system_time_(_system_time);

    	//postパラメータをmapにセット
    	this.conn.data(cn.getMap(map));

		//POSTの実行と、結果返却
		return conn.method(Method.POST).execute();

	}
	
	// ログイン処理
	public void Login(LOGINBean cn) throws Exception {
		//通信の実施
		Response res = this.httpPost(cn);

		// ログインでエラーがある場合はエクセプション発行
       	if (res.statusCode() == 500) {
//    	    System.out.println(res.statusCode());
			throw new LoginException();
       	}

       	// レスポンスからCookieを取得して通信クラスにセット
        Map<String, String> cookies = res.cookies();
//	    System.out.println(cookies);
	 
   		for (Map.Entry<String, String> cookie : cookies.entrySet()) {
   			this.conn.cookie(cookie.getKey(), cookie.getValue());
   		}
	}

	// ログアウト処理
	public void Logout(LOGOUTBean cn) throws Exception {
		//通信の実施
		this.httpPost(cn);
	}

	/**画面への登録の呼びだしと、データ格納 
	 * @throws Exception */
	public void screenPost(BaseBean cn) throws Exception {
		//通信の実施
		Response res = this.httpPost(cn);

   		//レスポンスデータをデータコンテナにセット
		cn.setDataconte(res.parse());
		
    	// 通信で持ちまわるシステム時刻を退避
		_system_time = cn.get_system_time_();

		// サーバからの警告メッセージ
		this.message = cn.getAtt();

	}


	public String getMessage() {
		return message;
	}
}
