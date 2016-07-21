package jp.co.dit.android.apps.HiCore;

import java.util.ArrayList;
import java.util.Iterator;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftData;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataLine;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ130;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTHQ130Sub;
import jp.co.dit.android.apps.lib.DurmScrollView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class THQ130_SubActivity extends HiCoreBaseActivity  {
	private final static String TAG = THQ130_SubActivity.class.getSimpleName();

	// 代休管理台帳データクラス
	DailyShiftDataLine dsrow;
	DailyShiftDataTHQ130Sub ds;

	String DurmTitleString = new String();


	int flg_select = 0;	//	サーバ返却された選択位置
	int flg_DurmSelect = 0;	//	ドラムピッカーで選択された位置

	private LayoutInflater inflater;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 画面表示
		setContentView(R.layout.thq130_sub_layout);
		setTitle(R.string.THQ130_Title);

		// 通信用データクラス生成(リスト配列)
		ds = new DailyShiftDataTHQ130Sub();
		dsrow = new DailyShiftDataLine();
		ds.setRowData(dsrow);

		// 初期データ取得のバックグラウンド実行
		DataGet_With_Date(null);
//		cControl.getTHQ130_Sub(this, ds);

	}

	public void OnDataGetListener() {
		// TODO 自動生成されたメソッド・スタブ

		// 　年月プルダウンの設定
		setDateSpinner();

		// 　リストへのデータ設定
		setList_Of_CompensatoryLeave();
	}

	// 代休一覧のリスト表示
	public void setList_Of_CompensatoryLeave() {
		TextView tv;

		// layoutフォルダーからxmlファイルを取得
		this.inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// スクロールview取得
		LinearLayout sv = (LinearLayout) findViewById(R.id.THQ130_linearLayout);
		sv.removeAllViews();

		// 取得した通信データからスクロールviewにview追加
		ArrayList<DailyShiftData> children = dsrow.getChildren();
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

	// 年月プルダウンもどきへの設定
	public void setDateSpinner() {

		// 取得データリストのイテレータ
		Iterator<String> s_it;
		flg_select = 0;


		// アイテムの選択位置取得
		s_it = ds.getShoriYm().iterator();
		while (s_it.hasNext()) {
			if (ds.getSelected_shoriYm().equals((String) s_it.next().toString())) {
				break;
			}
			flg_select++;
		}


		// 選択位置の取得文字列データをプルダウンもどきに設定
		TextView text = (TextView) this.findViewById(R.id.THQ130_subSelectText);
		text.setText(ds.getShoriYmJP().get(flg_select));

	}


	// 年月プルダウンもどき押下時
	public void DateSelectOnClick(View v) {

		//	カスタムダイアログxml取得
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.custom_durrm_dailog,
				(ViewGroup) findViewById(R.id.CustomDurmDailog));

		// カスタムダイアログのタイトルセット
		TextView durmTitle =	(TextView) layout.findViewById(R.id.DurmTitle);
		durmTitle.setText("年月");

		//	年月ドラム選択ダイアログ表示
		final AlertDialog.Builder builder = new AlertDialog.Builder(THQ130_SubActivity.this);
		//	タイトルに初期選択「年月」をセット
//		DurmTitleString  = ds.getShoriYmJP().get(flg_select).toString();
		builder.setTitle(ds.getShoriYmJP().get(flg_select).toString());
		//	カスタムダイアログxmlを追加
		builder.setView(layout);
		//	OKボタン表示と、イベントリスナ登録
		builder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int which) {

						// 選択された位置の日付でデータ取得
						if (flg_select != flg_DurmSelect) {
							DataGet_With_Date(ds.getShoriYm().get(flg_DurmSelect));
						}

					}
				});
		final AlertDialog durmDaialog = builder.show();


		//	ドラムスクロールビュー取得
		DurmScrollView durm = (DurmScrollView) layout.findViewById(R.id.DurmScrollView);
		//	ドラム表示文字列のセット
		durm.addDurmString(ds.getShoriYmJP());
		//	ドラム選択位置設定
		durm.setDurmSelected(flg_select);
		//	ドラム選択リスナ
		durm.setOnChangeDurmListener(new DurmScrollView.OnChangeDurmListener() {
			public void OnChangeDurm(String durmSelectedString, int durmSelected) {
				//DateDrumPickerにて設定された時刻をテキスト領域に表示
				durmDaialog.setTitle(durmSelectedString);
				//選択位置フラグを更新
				flg_DurmSelect = durmSelected;
			}
		});
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
		ds.clear();
		// 取得日設定
		ds.setPost_shoriYm(para);
		// バックグラウンド実行
//		cControl.postTHQ130_Sub(this, ds);
	}


}