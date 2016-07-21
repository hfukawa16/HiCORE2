package jp.co.dit.android.apps.HiCore;

import java.util.ArrayList;
import java.util.Iterator;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftData;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataLine;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTAE120;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTAE120_Row01;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TAE120_Activity extends HiCoreBaseActivity implements
		OnItemSelectedListener {
	private final static String TAG = TAE120_Activity.class.getSimpleName();

	// 代休管理台帳データクラス
	DailyShiftDataLine dsrow01;
	DailyShiftDataTAE120 ds;

	// Spinner用アダプター
	ArrayAdapter<String> adapter;

	// 画面表示Spinner
	Spinner spinner;

	int flg_select = 0;

	private LayoutInflater inflater;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 画面表示
		setContentView(R.layout.tae120_layout);
		setTitle(R.string.TAE120_Title);

		// Spinner用アダプター設定
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// Spinner設定
		spinner = (Spinner) findViewById(R.id.TAE120_spinner);
		spinner.setAdapter(adapter); // アダプターを設定
		spinner.setOnItemSelectedListener(this); // 選択時リスナー登録

		// 通信用データクラス生成(リスト配列)
		ds = new DailyShiftDataTAE120();
		// 申請の一覧表示用
		dsrow01 = new DailyShiftDataLine();
		ds.setRowData01(dsrow01);

		// 初期データ取得のバックグラウンド実行
//		cControl.getTAE120(this, ds);

	}

	public void OnDataGetListener() {

		// 　年月プルダウンの設定
		setDateSpinner();

		// 　申請の一覧表へのデータ設定
		setListOfApplicants();

	}

	// 申請の一覧のリスト表示
	public void setListOfApplicants() {
		TextView tv;

		// 申請一覧のを格納するview取得
		LinearLayout lv = (LinearLayout) findViewById(R.id.TAE120_DetailLinear1);
		lv.removeAllViews();

		// layoutフォルダーからxmlファイルを取得
		this.inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// xmlファイルから申請一覧ビューを生成
		TableLayout tbl = (TableLayout) inflater.inflate(
				R.layout.tae120_list_layout1, null);
		//一覧格納用のLinearLayout取得
		LinearLayout sl = (LinearLayout) tbl.findViewById(R.id.scrollLinearLayout);

		// 取得した通信データから休暇台帳ビューに1行追加
		ArrayList<DailyShiftData> children = dsrow01.getChildren();
		Iterator<DailyShiftData> it = children.iterator();

		while (it.hasNext()) {
			// 要素から1行取得
			DailyShiftDataTAE120_Row01 data = (DailyShiftDataTAE120_Row01) it
					.next();

			// 新しく休暇台帳rowビューを生成
			TableRow rowView = (TableRow) inflater.inflate(
					R.layout.tae120_list_layout1_row, null);

			// Viewに取得したデータを設定
			if (data.getApplicationDate() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_01);
				tv.setText(data.getApplicationDate());
			}

			if (data.getApprovalStatus() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_02);
				tv.setText(data.getApprovalStatus());
			}
			if (data.getPrior() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_03);
				tv.setText(data.getPrior());
			}
			if (data.getTheApplicationForm() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_04);
				tv.setText(data.getTheApplicationForm());
			}
			if (data.getTheApplicationPeriod() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_05);
				tv.setText(data.getTheApplicationPeriod());
			}
			if (data.getApplicationTime() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_05);
				tv.setText(data.getApplicationTime());
			}
			if (data.getWhy() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_05);
				tv.setText(data.getWhy());
			}
			if (data.getProject() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_05);
				tv.setText(data.getProject());
			}

			// TblLayoutに作成した1行分をセット
			sl.addView(rowView);
		}

		// 申請一覧を格納
		lv.addView(tbl);
	}

	// 年月プルダウンへの設定
	public void setDateSpinner() {

		// アダプタのクリア
		adapter.clear();

		Iterator<String> s_it;
		flg_select = 0;

		// 取得データリストから年月（日本語付き）アイテムをリスト追加
		s_it = ds.getShoriYmJP().iterator();
		while (s_it.hasNext()) {
			// 要素から1行取得してリスト追加
			adapter.add((String) s_it.next());
		}

		// アイテムの選択位置決定
		s_it = ds.getShoriYm().iterator();
		while (s_it.hasNext()) {
			if (ds.getSelected_shoriYm()
					.equals((String) s_it.next().toString())) {
				break;
			}
			flg_select++;
		}

		// 選択位置指定
		spinner.setSelection(flg_select);
		// アダプターの表示更新
		adapter.notifyDataSetChanged();

		// 翌月ボタンの表示／非表示判定
		Button btn = (Button) findViewById(R.id.NextDisplayBtn);
		if (adapter.getCount() == flg_select + 1) {
			btn.setVisibility(View.INVISIBLE);
		} else {
			btn.setVisibility(View.VISIBLE);
		}
	}

	// 前月表示押下時
	public void PrevDisplayOnClick(View v) {

		String para = null;
		if (ds.getShoriYm().get(flg_select - 1) != null) {
			para = ds.getShoriYm().get(flg_select - 1);
		}
		// データ取得
		DataGet_With_Date(para);
	}

	// 翌月表示押下時
	public void NextDisplayOnClick(View v) {

		String para = null;
		if (ds.getShoriYm().get(flg_select + 1) != null) {
			para = ds.getShoriYm().get(flg_select + 1);
		}
		// データ取得
		DataGet_With_Date(para);
	}

	// 年月指定データ取得
	public void DataGet_With_Date(String para) {

		// データコンテナ初期化クリア
		ds.Clear();
		// 取得日設定
		ds.setPost_shoriYm(para);
		// バックグラウンド実行
//		cControl.postTAE120(this, ds);
	}

	public void onItemSelected(AdapterView<?> adapterView, View view,
			int position, long id) {
		// TODO 自動生成されたメソッド・スタブ

		// 選択された位置の日付でデータ取得
		if (flg_select != position) {
			DataGet_With_Date(ds.getShoriYm().get(position));
		}
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}