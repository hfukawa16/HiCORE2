package jp.co.dit.android.apps.HiCore;

import jp.co.dit.android.apps.HiCore.DataBean.LOGINBean;
import jp.co.dit.android.apps.HiCore.HttpsControl.AsyncTaskBase;
import jp.co.dit.android.apps.HiCore.HttpsControl.AsyncTaskLogin;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class LoginActivity extends HiCoreBaseActivity implements OnCheckedChangeListener {

	// 画面オブジェクト
	private static  EditText LoginUserId = null;
	private static  Switch RegPassSW = null;
	private static  Switch RegUserSW = null;
	private static  TextView LoginPassWd = null;
	private static  Switch RegAutoSW = null;

	
	// SharedPreferncesオブジェクト取得
	private SharedPreferences sp;
	private EditText loginUserId2;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.login);

		// 自動ログイン判定（自動ログイン未登録時はログインレイアウトで入力催促）
		sp = PreferenceManager.getDefaultSharedPreferences(this); // SharedPreferncesの取得

		// SharedPrefernces から自動ログインの可否チェック
		if (sp.getBoolean("RegAutologinSwitch", false)) {
			// ログインの非同期処理
			this.RunLogin();
//			return;
		}

		// ログイン画面生成
		setContentView(R.layout.login);

		//画面オブジェクト取得
		LoginUserId = (EditText) findViewById(R.id.UserId);
		LoginPassWd = (EditText) findViewById(R.id.PassWord);
		RegUserSW = (Switch) findViewById(R.id.RegUserSwitch);
		RegPassSW = (Switch) findViewById(R.id.RegPasswordSwitch);
		RegAutoSW = (Switch) findViewById(R.id.RegAutologinSwitch);

		//自動ログインの可否swichリスナー設定
		RegAutoSW.setOnCheckedChangeListener(this); 

		// 保存情報のロード
		Loading_Login_Menu();

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}


	//警告ダイアログ画面を表示
	public void errDialogDisp(int msgusernotinput) {

		AlertDialog.Builder dlg = new AlertDialog.Builder(this);

//		ad.setTitle(R.string.PassWord_ErrTitle);
		dlg.setMessage(msgusernotinput);
//		dlg.setCancelable(true); //戻るキーで閉じる     
		
		dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		dlg.create();
		dlg.show();
	}

	//警告ダイアログ画面を表示
	public void moveFocus(TextView obj) {
		obj.setFocusableInTouchMode(true);//Focusをhogeに移動
		obj.requestFocus(View.FOCUS_UP);
	}
		

	//ログイン通信処理
	public void RunLogin() {

		// ログイン情報コンテナ
		LOGINBean loginDs = new LOGINBean();
		
		// サーバ通信に使用するユーザ設定
		loginDs.setUserId(sp.getString("UserId", null));
		loginDs.setPassword(sp.getString("PassWord", null));

		// ログイン非同期通信処理
		AsyncTaskBase task = new AsyncTaskLogin(this);
		task.setDailogMessage(getString(R.string.LOGIN_Msg_PostDailog));
		task.execute(loginDs);
	}
		

	// ログインボタン押下時
	public void Login_buttonOnClick(View v) {

		//ユーザIDの入力がされていない場合、警告ダイアログ画面を表示して再入力
		if (LoginUserId.getText().toString().equals("")){
			this.errDialogDisp(R.string.LOGIN_MsgUserNotInput);
			this.moveFocus(LoginUserId);
			return;
		}
			
		//パスワードの入力がされていない場合、警告ダイアログ画面を表示して再入力
		if (LoginPassWd.getText().toString().equals("")){
			this.errDialogDisp(R.string.LOGIN_MsgPassNotInput);
			this.moveFocus(LoginPassWd);
			return;
		}
		
		//画面入力内容を保存
		this.Saveing_Login_Menu();
		
		//ログインの実行
		this.RunLogin();
	}

	
	// アカウント情報のロード
	private void Loading_Login_Menu() {

		// SharedPrefernces から画面項目へのセット
		LoginUserId.setText(sp.getString("UserId", null));
		LoginPassWd.setText(sp.getString("PassWord", null));
		RegUserSW.setChecked(sp.getBoolean("RegUserSwitch", true));
		RegPassSW.setChecked(sp.getBoolean("RegPasswordSwitch", true));
		RegAutoSW.setChecked(sp.getBoolean("RegAutologinSwitch", false));
	}

	// アカウント情報のセーブ
	private void Saveing_Login_Menu() {

		//画面項目の値をSharedPrefernces保存
		sp.edit().putString("UserId", LoginUserId.getText().toString()).commit();
		sp.edit().putString("PassWord", LoginPassWd.getText().toString()).commit();
		sp.edit().putBoolean("RegUserSwitch", RegUserSW.isChecked()).commit();
		sp.edit().putBoolean("RegPasswordSwitch", RegPassSW.isChecked()).commit();
		sp.edit().putBoolean("RegAutologinSwitch", RegAutoSW.isChecked()).commit();

		// SharedPrefernces への値のセット
		if (RegUserSW.isChecked() == false){		//ユーザIDの保存しない場合は削除
			sp.edit().remove("UserId").commit();
		}
		
		if (RegPassSW.isChecked() == false){		//パスワードの保存しない場合は削除
			sp.edit().remove("PassWord").commit();
		}

	}


	//Switchのステータスチェンジ時
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO 自動生成されたメソッド・スタブ

		//自動ログイン設定時はユーザ、パスワードの自動設定化して非活性
		if (isChecked == true) {
			RegUserSW.setChecked(true);
			RegUserSW.setEnabled(false);
			RegPassSW.setChecked(true);
			RegPassSW.setEnabled(false);

		//自動ログイン設定解除時はユーザ、パスワードの活性
		}else{
			RegUserSW.setEnabled(true);
			RegPassSW.setEnabled(true);
		}
	}


	//ログイン正常時
	@Override
	public void OnDataGetListener() {
		// TODO 自動生成されたメソッド・スタブ

		Intent intent = new Intent(); // 他activity連携クラス

		intent.setClassName(this,
				"jp.co.dit.android.apps.HiCore.HiCoreActivity");
		startActivity(intent);

	}

}
