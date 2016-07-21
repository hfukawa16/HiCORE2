package jp.co.dit.android.apps.HiCore.HttpsControl;


import jp.co.dit.android.apps.HiCore.R;
import jp.co.dit.android.apps.HiCore.DataBean.BaseBean;
import jp.co.dit.android.apps.https.lib.CommunicationControl;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * バックグラウンドタスク 実行時引数()、進捗単位(Void)、処理結果()
 */
public abstract class AsyncTaskBase extends
		AsyncTask<BaseBean, Void, Integer> {

	// インターフェース
	public interface AsyncTaskCallback  {
		// データ取得イベントリスナー
		public abstract void OnDataGetListener();
	}

	// 処理中カスタムダイアログ
	private Dialog dialog = null;

	// 呼び出し元アクテイビテイ
	private Context uiActivity_;

	// コールバッククラス
	private AsyncTaskCallback callback = null;;

	// カスタムダイアログのタイトル
	private String customDailogTitle = "通信中";
	private String customDailogMessage = "データ取得中・・・";

	// エラーＩＤ
	protected static final int TaskError_UnknownUser = -100; // ログインユーザ不正
	protected static final int TaskError_UnknownHost = -101; // ホスト名不正
	protected static final int TaskError_Exception = -102; // 通信不正
	protected static final int TaskWaring = -103; // 処理警告

	// サーバ通信制御
	public CommunicationControl cControl = CommunicationControl.getInstance(); // サーバ通信制御管理クラス

	public AsyncTaskBase(Context activity) {
		super();
		uiActivity_ = activity;
		this.callback = (AsyncTaskCallback) activity;

	}


	/** バックグラウンド実行前処理*/
	@Override
	public void onPreExecute() {
		// バックグラウンドの処理前にUIスレッドでダイアログ表示
		dialog = new Dialog(uiActivity_); 				// ダイアログクラス生成
		dialog.setTitle(customDailogTitle); 			// タイトル文言セット
		dialog.setContentView(R.layout.custom_dailog); 	// カスタムダイアログviewセット
		dialog.setCancelable(false); 					// キャンセル未使用
		dialog.show();

		TextView CustomDialogText = (TextView) dialog
				.findViewById(R.id.CustomDialogText);
		CustomDialogText.setText(customDailogMessage);

		// 自作アイコンのアニメーション起動
		set_WaitingIcon(true);
	}

	/** バックグラウンド実行後処理*/
	@Override
	public void onPostExecute(Integer result) {

		// リソース情報取得
		Resources res = uiActivity_.getResources();

		// 自作アイコンのアニメーション停止
		set_WaitingIcon(false);

		// 処理中ダイアログをクローズ
		dialog.dismiss();
		dialog = null;

		//実行結果判定（正常ならば呼び元にコールバック）
		switch (result){
		case 0:
			callback.OnDataGetListener();		//コールバック
			break;

		case TaskError_UnknownUser :
			DisplyErrorAlertDialog(res.getString(R.string.Msg_WaringTitle),
			res.getString(R.string.Msg_LoginErrMsg) + '\n' + cControl.getMessage()
			+ cControl.getMessage());
			break;

		case TaskError_UnknownHost:
			DisplyErrorAlertDialog(res.getString(R.string.Msg_HostErrTitle) ,
					res.getString(R.string.Msg_HostErrMsg) );
			break;

		case TaskError_Exception:
			DisplyErrorAlertDialog(res.getString(R.string.Msg_ConnectErrTitle) ,
					res.getString(R.string.Msg_ConnectErrMsg) );
			break;

		case TaskWaring:
			DisplyErrorAlertDialog(res.getString(R.string.Msg_WaringTitle) ,"");
//			cControl.getMessage() );
			break;

		}
	}

	// 処理中のアニメーション表示
	protected void set_WaitingIcon(boolean _Visibility) {

		ImageView CustomDialogImg = (ImageView) dialog
				.findViewById(R.id.CustomDialogImage);

		if (_Visibility) {
			// アニメーションアイコン表示
			CustomDialogImg.setVisibility(View.VISIBLE);
			// アニメーションアイコンの回転開始
			Animation anim = AnimationUtils.loadAnimation(uiActivity_,
					R.anim.rotate);
			CustomDialogImg.startAnimation(anim);
		} else {
			// アニメーションアイコンの回転停止
			CustomDialogImg.clearAnimation();
			// アニメーションアイコン非表示
			CustomDialogImg.setVisibility(View.INVISIBLE);
		}

	}

	// 警告ダイアログ表示処理
	public void DisplyErrorAlertDialog(String msgTitle, String msgInfo) {

		AlertDialog.Builder ad = new AlertDialog.Builder(uiActivity_);

		ad.setTitle(msgTitle);
		ad.setMessage(msgInfo);

		ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		ad.create();
		ad.show();
	}

	// データ取得後コールバックリスナ設定
	public void setOnDataGetListener(AsyncTaskCallback  _callBack) {
		callback = (_callBack == null) ? null : _callBack;
	}

	/**
	 * customDailogTitleを設定します。
	 * @param customDailogTitle customDailogTitle
	 */
	//	カスタムダイアログのタイトル
	public void setCustomDailogTitle(String customDailogTitle) {
		this.customDailogTitle = customDailogTitle;
	}

	//	カスタムダイアログのメッセージ
	public void setDailogMessage(String customDailogMessage) {
		this.customDailogMessage = customDailogMessage;
	}


}
