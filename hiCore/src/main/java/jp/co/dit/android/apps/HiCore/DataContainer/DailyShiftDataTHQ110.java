package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;


/**
 * 休暇取得状況一覧（個人） (THQ110)画面での要素データです。
 */
public class DailyShiftDataTHQ110 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	//Post用処理日（YYYYMM）
	private String 		Post_shoriYm;

	//選択中処理日（YYYYMM）
	private String 		Selected_shoriYm;

	//可変メッセージ文言
	private String 		Info_Message;

	//内部処理用リスト処理日（YYYYMM）
	private ArrayList<String> shoriYm = new ArrayList<String>();

	//リストボックス用処理日（YYYY年MM月）
	private ArrayList<String> shoriYmJP = new ArrayList<String>();

	//休暇台帳のＬｉｓｔ要素データ
	private DailyShiftDataLine rowData01;

	//休暇取得一覧のＬｉｓｔ要素データ
	private DailyShiftDataLine rowData02;

	public void Clear() {
		Post_shoriYm = null;
		Selected_shoriYm = null;
		Info_Message = null;
		shoriYm.clear();
		shoriYmJP.clear();
		rowData01.Clear();
		rowData02.Clear();
	}


	public String getPost_shoriYm() {
		return Post_shoriYm;
	}
	public void setPost_shoriYm(String post_shoriYm) {
		Post_shoriYm = post_shoriYm;
	}
	public DailyShiftDataLine getRowData01() {
		return rowData01;
	}
	public void setRowData01(DailyShiftDataLine rowData) {
		this.rowData01 = rowData;
	}
	public void addRowData01(DailyShiftData rowData) {
		this.rowData01.addDailyShift(rowData);
	}

	public DailyShiftDataLine getRowData02() {
		return rowData02;
	}
	public void setRowData02(DailyShiftDataLine rowData) {
		this.rowData02 = rowData;
	}
	public void addRowData02(DailyShiftData rowData) {
		this.rowData02.addDailyShift(rowData);
	}


	public ArrayList<String> getShoriYm() {
		return shoriYm;
	}
	public void setShoriYm(ArrayList<String> shoriYm) {
		this.shoriYm = shoriYm;
	}
	public void setShoriYm(String shoriYm) {
		this.shoriYm.add(shoriYm);
	}
	public ArrayList<String> getShoriYmJP() {
		return shoriYmJP;
	}
	public void setShoriYmJP(ArrayList<String> shoriYmJP) {
		this.shoriYmJP = shoriYmJP;
	}
	public void setShoriYmJP(String shoriYmJP) {
		this.shoriYmJP.add(shoriYmJP);
	}


	public String getInfo_Message() {
		return Info_Message;
	}


	public void setInfo_Message(String info_Message) {
		Info_Message = info_Message;
	}


	public String getSelected_shoriYm() {
		return Selected_shoriYm;
	}


	public void setSelected_shoriYm(String selected_shoriYm) {
		Selected_shoriYm = selected_shoriYm;
	}

}
