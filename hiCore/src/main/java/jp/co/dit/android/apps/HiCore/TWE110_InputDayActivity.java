package jp.co.dit.android.apps.HiCore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.dit.android.apps.HiCore.DataBean.TWE110DailyEmployment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialog;

import org.joda.time.DateTime;


public class TWE110_InputDayActivity extends HiCoreBaseActivity
		implements OnClickListener, RadialTimePickerDialog.OnTimeSetListener
{
	private final static String TAG = TWE110_InputDayActivity.class.getSimpleName();

	private static final String FRAG_TAG_TIME_PICKER = "timePickerDialogFragment";

	//画面オブジェクト
	private TextView shukinHH;

	private TextView taikinHH;

	private TextView hoseiHH;

	private EditText biko;

	private Button submitBtn;

	// パスワード更新データクラス
////////////////////	DailyShiftDataTSE190 ds;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 画面表示
		setContentView(R.layout.twe110_daily_layout);
		setTitle(R.string.TWE110_Title);

		//カレンダー画面からのデータ受け取り
        Intent intent = getIntent();
        TWE110DailyEmployment data = (TWE110DailyEmployment)intent.getSerializableExtra("DATA1");


		//画面オブジェクト取得
        shukinHH = (EditText) findViewById(R.id.TWE110_input_shukinHH);
        taikinHH = (EditText) findViewById(R.id.TWE110_input_taikinHH);
        hoseiHH = (EditText) findViewById(R.id.TWE110_input_hoseiHH);
        biko = (EditText) findViewById(R.id.TWE110_input_biko);
        submitBtn = (Button)findViewById(R.id.TWE110_input_btnSubmit);

		//フォーカス不可（別処理にて時刻入力させる為）
        shukinHH.setFocusable(false);
        taikinHH.setFocusable(false);
        hoseiHH.setFocusable(false);
        
		//パーミッションが保護状態ならsubmitボタン、入力欄は非活性
        if (data.getPermission().toString().equals("1")){
        	submitBtn.setEnabled(false);
        	biko.setEnabled(false);
        	shukinHH.setEnabled(false);
        	taikinHH.setEnabled(false);
        	hoseiHH.setEnabled(false);
        }


        
		//画面に打穀済みならhintの消去
        if (data.getShukinHH() != "" || data.getTaikinHH() != ""){
        	biko.setHint("");
        }

		//画面にセット
        shukinHH.setText(strTimeCv(data.getShukinHH()));
        taikinHH.setText(strTimeCv(data.getTaikinHH()));
        hoseiHH.setText(strTimeCv(data.getHoseiHH()));
        biko.setText(data.getBiko());
       
        //StringBuilder().
        
///		TWE110DailyEmployment ts = DS_TWE110.getpList().get(Day);

//        Log.v("SampleIntentNext", data.getVal() + " " + data.getStr());
        
//		// 登録ボタン押下
//		Button Btn = (Button) findViewById(R.id.TSE190_OK_button);
///		Btn.setOnClickListener(this);


	}

	@Override
	public void OnDataGetListener() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	//仮登録のクリック
	public void submit(View v) {
		
		 int wwwww = 1;
		 
		 wwwww = 3;
		
	}

	//キャンセルのクリック
	public void cancel(View v) {
		 finish();
	}

	//時刻項目のオンクリック
	public void date_OnClick(View v) {

		DateTime now = DateTime.now();
		RadialTimePickerDialog timePickerDialog = RadialTimePickerDialog
				.newInstance(TWE110_InputDayActivity.this, now.getHourOfDay(), now.getMinuteOfHour(),
						DateFormat.is24HourFormat(TWE110_InputDayActivity.this));
			timePickerDialog.show(getSupportFragmentManager(), FRAG_TAG_TIME_PICKER);

		 int wwwww = 1;
		 
		 wwwww = 3;
//		 finish();
	}
	
	
	public  String strTimeCv(String str) {
		
		String strTmp  = new String();
		 
		if (str.isEmpty() == false){
			//":"を付加
			StringBuilder sb = new StringBuilder();
			sb.append( str);
			sb.insert(2, ":");
			strTmp = new String(sb);
		}

		return strTmp;
	}
	public  String timeStrCv(String str) {
		String strTmp  = new String();

		if (str.isEmpty() == false){
			//":"を削除
			Pattern pattern = Pattern.compile(":"); 
			Matcher matcher = pattern.matcher(str); 
			strTmp = matcher.replaceAll("");
		}
    	return strTmp;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onTimeSet(RadialTimePickerDialog dialog, int hourOfDay, int minute) {

	}
}