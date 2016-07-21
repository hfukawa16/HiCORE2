package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

/**
 * 代休管理台帳（個人） (THQ130)画面サブ画面での要素データです。
 */
public class DailyShiftDataTHQ130Sub extends DailyShiftData {

	private static final long serialVersionUID = -8179642994718632931L;

	// Post用処理日（YYYYMM）
	private String Post_shoriYm;

	// 選択中処理日（YYYYMM）
	private String Selected_shoriYm;

	private ArrayList<String> shoriYm = new ArrayList<String>();

	private ArrayList<String> shoriYmJP = new ArrayList<String>();

	// Ｌｉｓｔ要素データ
	private DailyShiftDataLine rowData;

	public void clear() {
		Post_shoriYm = null;
		Selected_shoriYm = null;
		shoriYm.clear();
		shoriYmJP.clear();
		rowData.Clear();
	}

	public String getPost_shoriYm() {
		return Post_shoriYm;
	}

	public void setPost_shoriYm(String post_shoriYm) {
		Post_shoriYm = post_shoriYm;
	}

	public DailyShiftDataLine getRowData() {
		return rowData;
	}

	public void setRowData(DailyShiftDataLine rowData) {
		this.rowData = rowData;
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
