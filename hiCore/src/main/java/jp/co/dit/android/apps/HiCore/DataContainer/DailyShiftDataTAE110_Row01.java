package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

/**
 * 申請一覧 (TAE110) 画面での「申請内容」要素データです。
 */
public class DailyShiftDataTAE110_Row01 extends DailyShiftData {

	private static final long serialVersionUID = -8179642994718632931L;

	// 申請内容一覧のＬｉｓｔ(SELECT Value)
	private ArrayList<String> sinseiNaiyouValueList = new ArrayList<String>();
	// 申請内容一覧のＬｉｓｔ(文字列)
	private ArrayList<String> sinseiNaiyouStringList = new ArrayList<String>();

	public void Clear() {
		sinseiNaiyouValueList.clear();
		sinseiNaiyouStringList.clear();
	}

	public ArrayList<String> getSinseiNaiyouValueList() {
		return sinseiNaiyouValueList;
	}

	public void setSinseiNaiyouValueList(ArrayList<String> sinseiNaiyouValueList) {
		this.sinseiNaiyouValueList = sinseiNaiyouValueList;
	}
	public void addSinseiNaiyouValueList(String sinseiNaiyouValue) {
		this.sinseiNaiyouValueList.add(sinseiNaiyouValue);
	}

	public ArrayList<String> getSinseiNaiyouStringList() {
		return sinseiNaiyouStringList;
	}

	public void setSinseiNaiyouStringList(ArrayList<String> sinseiNaiyouStringList) {
		this.sinseiNaiyouStringList = sinseiNaiyouStringList;
	}

	public void addSinseiNaiyouStringList(String sinseiNaiyouString) {
		this.sinseiNaiyouStringList.add(sinseiNaiyouString);
	}


}
