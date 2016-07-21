package jp.co.dit.android.apps.HiCore;

import java.util.ArrayList;
import java.util.Iterator;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftData;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataLine;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ130;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class THQ130_Activity extends HiCoreBaseActivity  {
	private final static String TAG = THQ130_Activity.class.getSimpleName();

	// 代休管理台帳データクラス
	DailyShiftDataLine ds;

	boolean flg_LatoutMain = true; // 表示画面レイアウトフラグ（true時が通常画面表示中）

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 画面表示
		setContentView(R.layout.thq130_layout);
		setTitle(R.string.THQ130_Title);

		// 通信用データクラス生成(リスト配列)
		ds = new DailyShiftDataLine();

		// バックグラウンド実行
//		cControl.getTHQ130(this, ds);

	}

	// データ取得イベント
	public void OnDataGetListener() {
		// TODO 自動生成されたメソッド・スタブ
		TextView tv;

		// layoutフォルダーからxmlファイルを取得
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// スクロールview取得
		LinearLayout sv = (LinearLayout) findViewById(R.id.THQ130_linearLayout);
		sv.removeAllViews();

		// 取得した通信データからスクロールviewにview追加
		ArrayList<DailyShiftData> children = ds.getChildren();
		Iterator<DailyShiftData> it = children.iterator();

		while (it.hasNext()) {
			// 要素から1行取得
			DailyShiftDataTHQ130 data = (DailyShiftDataTHQ130) it.next();

			// 新しくビューを生成
			View view = inflater.inflate(R.layout.thq130_list_layout, null);

			// Viewに取得したデータを設定
			if (data.getNo() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_No);
				tv.setText(data.getNo());
			}

			if (data.getDate() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_Date);
				tv.setText(data.getDate() + data.getDayOfTheWeek1());
			}

			if (data.getHours() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_Hours);
				tv.setText(data.getHours());
			}

			if (data.getWorkedHours() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_WorkedHours);
				tv.setText(data.getWorkedHours());
			}

			if (data.getExpirationDate() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_ExpirationDate);
				tv.setText(data.getExpirationDate() + data.getDayOfTheWeek2());
			}

			if (data.getAcquisitionDate() != null) {
				tv = (TextView) view.findViewById(R.id.THQ130_AcquisitionDate);
				tv.setText(data.getAcquisitionDate().toString());
			}

			sv.addView(view);
		}
	}



	// メニュー押下時
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
			getMenuInflater().inflate(R.menu.thq130_sub_manu, menu);
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

		case R.id.thq130_SubMmen1:
			// "全ての台帳表示"
			Intent intent = new Intent(); // 他activity連携クラス
			intent.setClassName(this,
					"jp.co.dit.android.apps.HiCore.THQ130_SubActivity");
			startActivity(intent);
			break;

		}
		return ret;
	}


}