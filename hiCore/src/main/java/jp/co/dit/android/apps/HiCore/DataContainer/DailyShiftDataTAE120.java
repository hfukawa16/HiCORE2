package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

/**
 * 申請一覧 (TAE120) 画面での要素データです。
 */
public class DailyShiftDataTAE120 extends DailyShiftData {

	private static final long serialVersionUID = -8179642994718632931L;

	// Post用処理日（YYYYMM）
	private String Post_shoriYm;

	// 選択中処理日（YYYYMM）
	private String Selected_shoriYm;

	// 内部処理用リスト処理日（YYYYMM）
	private ArrayList<String> shoriYm = new ArrayList<String>();

	// リストボックス用処理日（YYYY年MM月）
	private ArrayList<String> shoriYmJP = new ArrayList<String>();

	// 申請一覧のＬｉｓｔ要素データ
	private DailyShiftDataLine rowData01;

	public void Clear() {
		Post_shoriYm = null;
		Selected_shoriYm = null;
		shoriYm.clear();
		shoriYmJP.clear();
		rowData01.Clear();
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

	public String getSelected_shoriYm() {
		return Selected_shoriYm;
	}

	public void setSelected_shoriYm(String selected_shoriYm) {
		Selected_shoriYm = selected_shoriYm;
	}

}
