package jp.co.dit.android.apps.HiCore;

import jp.co.dit.android.apps.HiCore.HttpsControl.AsyncTaskBase.AsyncTaskCallback;
import jp.co.dit.android.apps.https.lib.CommunicationControl;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public abstract class HiCoreBaseActivity extends FragmentActivity implements AsyncTaskCallback {

	private static CommunicationControl HiCoreCom;

	// サーバ通信制御
	CommunicationControl cControl = CommunicationControl.getInstance(); // サーバ通信制御管理クラス

	// 画面初期表示判定フラグ
	Boolean flg_farstDiplay = true;	// true:初表示 false:表示済み

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// サーバ通信制御管理クラスのconfig設定
//		this.setCommunicationControlConfig();

		// ウィンドウタイトルの色設定
		setTitleColor(Color.parseColor("#66CCFF"));
	}

	@Override
	public void setContentView(int layoutResID) {

		if (flg_farstDiplay) {
			// アイコン表示を有効にする
			requestWindowFeature(Window.FEATURE_LEFT_ICON);
			// コンテンツセット
			super.setContentView(layoutResID);
			// アイコン表示
			setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
					R.drawable.dit_logo);
			// 初期表示フラグをfalse（済み）セット
			flg_farstDiplay = false;
		} else {
			// コンテンツセット
			super.setContentView(layoutResID);
		}
	}

//	public abstract void OnDataGetListener();

	// サーバ通信制御管理クラスへの設定情報セット
//	public void setCommunicationControlConfig() {
//		SharedPreferences sp = PreferenceManager
//				.getDefaultSharedPreferences(this); // SharedPreferncesの取得
//		cControl.setURL_HOST(sp.getString("hostname", "staffs2.ditgroup.jp")); // サーバ通信に使用するホスト名設定
//		cControl.setUserID(sp.getString("account", "")); // サーバ通信に使用するユーザ設定
//		cControl.setPassWord(sp.getString("password", "")); // サーバ通信に使用するパスワード設定
//	}

}