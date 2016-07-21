package jp.co.dit.android.apps.HiCore;

import java.util.ArrayList;
import java.util.Iterator;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftData;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataLine;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ110;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ110_Row01;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ110_Row02;
import android.content.Context;
import android.content.res.Resources;
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

public class THQ110_Activity extends HiCoreBaseActivity implements
		OnItemSelectedListener {
	private final static String TAG = THQ110_Activity.class.getSimpleName();

	// 代休管理台帳データクラス
	DailyShiftDataLine dsrow01;
	DailyShiftDataLine dsrow02;
	DailyShiftDataTHQ110 ds;

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
		setContentView(R.layout.thq110_layout);
		setTitle(R.string.THQ110_Title);

		// Spinner用アダプター設定
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// Spinner設定
		spinner = (Spinner) findViewById(R.id.THQ110_spinner);
		spinner.setAdapter(adapter); // アダプターを設定
		spinner.setOnItemSelectedListener(this); // 選択時リスナー登録

		// 通信用データクラス生成(リスト配列)
		ds = new DailyShiftDataTHQ110();
		// 休暇台帳用
		dsrow01 = new DailyShiftDataLine();
		ds.setRowData01(dsrow01);
		// 休暇取得一覧用
		dsrow02 = new DailyShiftDataLine();
		ds.setRowData02(dsrow02);

		// 初期データ取得のバックグラウンド実行
//		cControl.getTHQ110(this, ds);

	}

	public void OnDataGetListener() {

		// インフォメーションメッセージの追記
		Resources res = this.getResources();		// リソース情報取得
		if (ds.getInfo_Message() != null) {
			TextView tv = (TextView) findViewById(R.id.THQ110_InfoMessage);
			tv.setText(ds.getInfo_Message()
					+ res.getString(R.string.THQ110_Message));
		}

		// 　年月プルダウンの設定
		setDateSpinner();

		// 　休暇台帳へのデータ設定
		setVacationLedger();

		// 　休暇取得一覧へのデータ設定
		setList_Of_VacationAcquired();

	}

	// 代休一覧のリスト表示
	public void setVacationLedger() {
		TextView tv;

		// 休暇台帳を格納するview取得
		LinearLayout lv = (LinearLayout) findViewById(R.id.THQ110_DetailLinear1);
		lv.removeAllViews();

		// layoutフォルダーからxmlファイルを取得
		this.inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// xmlファイルから休暇台帳ビューを生成
		TableLayout tbl = (TableLayout) inflater.inflate(
				R.layout.thq110_list_layout1, null);

		// 取得した通信データから休暇台帳ビューに1行追加
		ArrayList<DailyShiftData> children = dsrow01.getChildren();
		Iterator<DailyShiftData> it = children.iterator();

		while (it.hasNext()) {
			// 要素から1行取得
			DailyShiftDataTHQ110_Row01 data = (DailyShiftDataTHQ110_Row01) it
					.next();

			// 新しく休暇台帳rowビューを生成
			TableRow rowView = (TableRow) inflater.inflate(
					R.layout.thq110_list_layout1_row, null);

			// Viewに取得したデータを設定
			if (data.getVacationSegment() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_01);
				tv.setText(data.getVacationSegment());
			}

			if (data.getGrant() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_02);
				tv.setText(data.getGrant());
			}
			if (data.getRemainingDaysLastMon() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_03);
				tv.setText(data.getRemainingDaysLastMon());
			}
			if (data.getUse() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_04);
				tv.setText(data.getUse());
			}
			if (data.getRemainingDays() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row01_05);
				tv.setText(data.getRemainingDays());
			}

			// TblLayoutに作成した1行分をセット
			tbl.addView(rowView);
		}

		// 休暇台帳を格納
		lv.addView(tbl);
	}

	// 代休一覧のリスト表示
	public void setList_Of_VacationAcquired() {
		TextView tv;

		// 休暇取得一覧を格納するview取得
		LinearLayout lv = (LinearLayout) findViewById(R.id.THQ110_DetailLinear2);
		lv.removeAllViews();

		// layoutフォルダーからxmlファイルを取得
		this.inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// xmlファイルから休暇取得一覧ビューを生成
		TableLayout tbl = (TableLayout) inflater.inflate(
				R.layout.thq110_list_layout2, null);
		// 休暇取得一覧のスクロールビュー格納レイアウトを取得
		LinearLayout scView = (LinearLayout) tbl
				.findViewById(R.id.scrollLinear1);

		// 取得した通信データから休暇台帳ビューに1行追加
		ArrayList<DailyShiftData> children = dsrow02.getChildren();
		Iterator<DailyShiftData> it = children.iterator();

		while (it.hasNext()) {
			// 要素から1行取得
			DailyShiftDataTHQ110_Row02 data = (DailyShiftDataTHQ110_Row02) it
					.next();

			// 新しく休暇取得一覧rowビューを生成
			TableRow rowView = (TableRow) inflater.inflate(
					R.layout.thq110_list_layout2_row, null);

			// Viewに取得したデータを設定
			if (data.getNo() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row02_01);
				tv.setText(data.getNo());
			}

			if (data.getAcquisitionDate() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row02_02);
				tv.setText(data.getAcquisitionDate());
			}
			if (data.getVacationSegment() != null) {
				tv = (TextView) rowView.findViewById(R.id.THQ110_row02_03);
				tv.setText(data.getVacationSegment());
			}

			// TblLayoutに作成した1行分をセット
			scView.addView(rowView);
		}

		// 休暇台帳を格納
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
			if (ds.getSelected_shoriYm().equals((String) s_it.next().toString())) {
				break;
			}
			flg_select++;
		}

		// 選択位置指定
		spinner.setSelection(flg_select);
		// アダプターの表示更新
		adapter.notifyDataSetChanged();

		//翌月ボタンの表示／非表示判定
		Button nbtn = (Button) findViewById(R.id.NextDisplayBtn);
		if (adapter.getCount() == flg_select+1){
			nbtn.setVisibility(View.INVISIBLE);
		}else{
			nbtn.setVisibility(View.VISIBLE);
		}

		//前月ボタンの表示／非表示判定
		Button pbtn = (Button) findViewById(R.id.PrevDisplayBtn);
		if (flg_select == 0){
			pbtn.setVisibility(View.INVISIBLE);
		}else{
			pbtn.setVisibility(View.VISIBLE);
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
//		cControl.postTHQ110(this, ds);
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