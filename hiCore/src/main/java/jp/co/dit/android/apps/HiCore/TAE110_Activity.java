package jp.co.dit.android.apps.HiCore;

import java.util.ArrayList;

import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftData;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataLine;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTAE110;
import jp.co.dit.android.apps.HiCore.DataContainer.DailyShiftDataTAE110_Row01;
import android.os.Bundle;

public class TAE110_Activity extends HiCoreBaseActivity  {
	private final static String TAG = TAE110_Activity.class.getSimpleName();

	// 代休管理台帳データクラス
	DailyShiftDataLine dsrow01;
	DailyShiftDataTAE110 ds;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		// 通信用データクラス生成(リスト配列)
		ds = new DailyShiftDataTAE110();
		// 申請の一覧表示用
		dsrow01 = new DailyShiftDataLine();
		ds.setRowData01(dsrow01);


//		cControl.getTAE110(this, ds);


	}

	public void OnDataGetListener() {

		// 区分
		ArrayList<String> a = ds.getSinseiKbnStringList();
		
		
		//申請内容selseされたら
		ArrayList<DailyShiftData> children = dsrow01.getChildren();
		DailyShiftDataTAE110_Row01 a2 = (DailyShiftDataTAE110_Row01) children.get(0);
		ArrayList<String> b = a2.getSinseiNaiyouValueList();
		

		
		
		
		
		
		
//		while (it.hasNext()) {
			// 要素から1行取得
//			DailyShiftDataTAE110_Row01 data = (DailyShiftDataTAE110_Row01) it.next();
//			Log.d(TAG,"getSinseiNaiyouStringList"+data.getSinseiNaiyouStringList());

//		}

	}



}