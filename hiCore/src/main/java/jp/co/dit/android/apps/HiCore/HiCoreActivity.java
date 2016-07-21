package jp.co.dit.android.apps.HiCore;

import jp.co.dit.android.apps.HiCore.Calendar.lib.HiCoreCalendar;
import jp.co.dit.android.apps.HiCore.DataBean.LOGINBean;
import jp.co.dit.android.apps.HiCore.DataBean.SM010Bean;
import jp.co.dit.android.apps.HiCore.DataBean.TWE110Bean;
import jp.co.dit.android.apps.HiCore.DataBean.TWE110DailyEmployment;
import jp.co.dit.android.apps.HiCore.HttpsControl.AsyncTaskBase;
import jp.co.dit.android.apps.HiCore.HttpsControl.AsyncTaskPost;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HiCoreActivity extends HiCoreBaseActivity  {
	private final static String TAG = HiCoreActivity.class.getSimpleName();

	private static final LOGINBean LOGINBean = null;

	HiCoreCalendar cv; // 勤務表カレンダークラス

	SharedPreferences sp; // config設定

	Intent intent = new Intent(); // 他activity連携クラス

	boolean flg_LayoutMain = true; // 表示画面レイアウトフラグ（true時が通常画面表示中）

	// メニュー画面情報コンテナ
	SM010Bean DS_SM010 = new SM010Bean();

	// 勤務表入力状況コンテナ
	TWE110Bean DS_TWE110 = new TWE110Bean();


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 計測開始
//		StopWatch.start();

		// 通常メイン画面生成
		setContentView(R.layout.main);

		// メイン画面中のカレンダ生成
		cv = (HiCoreCalendar) findViewById(R.id.caln);
		cv.initHiCoreCalendar();

		// メニュー画面取得非同期通信処理
		AsyncTaskBase task = new AsyncTaskPost(this);
		task.setDailogMessage(getString(R.string.SM010_Msg_POSTDailog));
		task.execute(DS_SM010,DS_TWE110);

		// 計測終了
//		StopWatch.printMilliTime(new Throwable().getStackTrace()[0].getMethodName() + " milli: ");

	}

    @Override
    public void onRestart(){
        super.onRestart();
        Log.v("LifeCycle", "onRestart");
    }

	
	// メニュー押下時
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// 通常画面表示ならメニューをロード
		if (flg_LayoutMain) {
			getMenuInflater().inflate(R.menu.hicore_main_manu, menu);
		}
		return true;
	}

	// メニューアイテム選択時
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean ret = true;

		switch (item.getItemId()) {
		default:
			ret = super.onOptionsItemSelected(item);
			break;

		case R.id.menu1_Item1:
			// "勤務表入力"

			// テストでPJ一覧取得
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.TEST_Of_PJT010_Activity");
			startActivity(intent);
			break;
		case R.id.menu1_Item2:
			// "勤務表日次照会（個人）"
			break;
		case R.id.menu1_Item3:
			// "勤務表月次照会（個人）"
			break;
		case R.id.menu1_Item4:
			// "勤務表承認状況照会"
			break;
		case R.id.menu1_Item5:
			// "プロジェクト承認状況照会"
			break;
		case R.id.menu2_Item1:
			// "申請入力"
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.TAE110_Activity");
			startActivity(intent);
			break;
		case R.id.menu2_Item2:
			// "申請一覧 "
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.TAE120_Activity");
			startActivity(intent);
			break;
		case R.id.menu3_Item1:
			// "休暇取得状況一覧（個人）"
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.THQ110_Activity");
			startActivity(intent);
			break;
		case R.id.menu3_Item2:
			// "代休管理台帳（個人） "
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.THQ130_Activity");
			startActivity(intent);
			break;
		case R.id.menu4_Item1:
			// "パスワード更新"
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.TSE190_Activity");
			startActivity(intent);
			break;

		case R.id.menuSeting:
			// "設定"
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.MenuPreferenceActivity");
			startActivity(intent);
			break;
		}
		return ret;
	}

	// カレンダー先月表示押下時
	public void cal_PrevOnClick(View v) {
//		cv.HiCoreCalendarAddMonth(-1);
	}

	// カレンダー当日表示押下時
	public void cal_DateOnClick(View v) {
//		cv.initHiCoreCalendar();
	}

	// カレンダー翌月表示押下時
	public void cal_NextOnClick(View v) {
//		cv.HiCoreCalendarAddMonth(1);
	}

	// 日付押下時
	public void cal_DayOnClick(View v) {

		//押下されたボタンの日付(Text)を取得
		Button btn = (Button) v;
		String Day = btn.getText().toString();

		//押下した日の状態を確認
   		switch  (DS_SM010.getDayDivList().get( Integer.parseInt(Day) - 1)){
			// 承認待、総承認待、総務確定の場合は参照のみである事を通知
   		case	3:
   			Toast.makeText(this, R.string.Msg_cal_status_ca3, Toast.LENGTH_SHORT).show();
   			break;
   		case	4:
   			Toast.makeText(this, R.string.Msg_cal_status_ca4, Toast.LENGTH_SHORT).show();
   			break;
   		case	6:
   			Toast.makeText(this, R.string.Msg_cal_status_ca6, Toast.LENGTH_SHORT).show();
   			break;
   		}

		
		//対象日付の勤務データを取得
		TWE110DailyEmployment ts = DS_TWE110.getpList().get(DS_TWE110.getShoriYm() + Day);
		
		//対象日付の勤務データを引数にTWE110(勤務入力)処理の呼出し
		intent.setClassName(this,"jp.co.dit.android.apps.HiCore.TWE110_InputDayActivity");
		intent.putExtra("DATA1", ts);
		startActivity(intent);
	}

	// サーバ通信制御管理クラスからのデータ取得イベント
	public void OnDataGetListener() {

		// 取得したメニュー画面情報より表示カレンダーへ状態適用
		// Infoメッセージを表示
		TextView DisplayMessage = (TextView) findViewById(R.id.messageText);
		
		DisplayMessage.setText(DS_SM010.getManuInfo());

		// カレンダーの表示年月と運用年月が違う場合は、カレンダー初期日を運用月に変更
		if (cv.getInit_MM() != DS_SM010.getMonOperations() || 
			cv.getInit_YYYY() != DS_SM010.getYerOperations()) {
			// 取得してきた運用年月をセット
			cv.setInit_MM(DS_SM010.getMonOperations()); 
			cv.setInit_YYYY(DS_SM010.getYerOperations());
		}

		// カレンダーの再初期表示
		cv.initHiCoreCalendar();

		// カレンダーの表示日に取得してきた入力状態を反映
		// for ループによる取得
		for (int i = 0; i < DS_SM010.getDayDivList().size(); i++) {
			// 1:未入力 2:仮登録 3:承認待ち 4:総務確定 5:差戻し 6:総務承認待ち
			cv.setDayDraw(i + 1, DS_SM010.getDayDivList().get(i));
		}

		// 取得したユーザ情報を通知
		String ToastMsg = new String();
		ToastMsg += DS_SM010.getUser_name();
		ToastMsg += '\n';
		ToastMsg += DS_SM010.getUser_affiliation();
		ToastMsg += '\n';
		ToastMsg += DS_SM010.getUser_post();
		ToastMsg += '\n';
		ToastMsg += DS_SM010.getUser_workSystem();
		Toast.makeText(this, ToastMsg, Toast.LENGTH_LONG).show();

	}


}