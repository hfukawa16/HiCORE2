package jp.co.dit.android.apps.HiCore;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTSE190;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class TSE190_Activity extends HiCoreBaseActivity implements OnClickListener {
	private final static String TAG = TSE190_Activity.class.getSimpleName();

	// パスワード更新データクラス
	DailyShiftDataTSE190 ds;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 画面表示
		setContentView(R.layout.tse190_layout);
		setTitle(R.string.TSE190_Title);

		// 登録ボタン押下
		Button Btn = (Button) findViewById(R.id.TSE190_OK_button);
		Btn.setOnClickListener(this);


	}
	// 登録ボタン処理
	public void onClick(View arg0){

		EditText editText;

		//通信用データクラス生成
		ds = new DailyShiftDataTSE190();

		//現パスワード設定
		editText = (EditText) findViewById(R.id.OldPassWord);
		ds.setPrePass(editText.getText().toString());

		//新パスワード
		editText = (EditText) findViewById(R.id.NewPassWord1);
		ds.setNewPass(editText.getText().toString());

		//新パスワード（確認）
		editText = (EditText) findViewById(R.id.NewPassWord2);
		ds.setConPass(editText.getText().toString());

		//バックグラウンド実行
//		cControl.postTSE190(this, ds);

	}


	public void OnDataGetListener() {
		// リソース情報取得
		Resources res = this.getResources();

		//パスワード書き換え
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

		// SharedPrefernces への値のセット
		sp.edit().putString("password", ds.getNewPass().toString()).commit();

		//完了ダイアログ
		AlertDialog.Builder ad = new AlertDialog.Builder(this);

		//ダイアログタイトル・メッセージセット
		ad.setTitle(res.getString(R.string.Msg_UpdateOkTitle));
		ad.setMessage(res.getString(R.string.Msg_UpdatePasswordMsg));

		ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				finish();
			}
		});
		ad.create();
		ad.show();
	}
}