package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

/**
 * 申請一覧 (TAE110) 画面での要素データです。
 */
public class DailyShiftDataTAE110 extends DailyShiftData {

	private static final long serialVersionUID = -8179642994718632931L;

	// 申請区分
	private String sinseiKbn;
	// 休暇コード
	private String kyukaCode;
	// 申請期間from
	private String from;	// YYYY/MM/DD
	// 申請期間to
	private String to;		// YYYY/MM/DD
	// "～"固定
	private String 	separate1;
	// "～"固定
	private String 	separate2;
	// 理由
	private String 	reason;
	// プロジェクト コード
	private String 	prCode;
	// プロジェクト 名
	private String 	prName;

	// 申請区分リスト(SELECT Value)
	private ArrayList<String> sinseiKbnValueList = new ArrayList<String>(2);
	// 申請区分リスト(SELECT 文字列)
	private ArrayList<String> sinseiKbnStringList = new ArrayList<String>(2);

	// 申請一覧のＬｉｓｔ要素データ
	private DailyShiftDataLine rowData01;

	public void Clear() {
		sinseiKbn = null;
		kyukaCode = null;
		from = null;
		to = null;
		separate1 = null;
		separate2 = null;
		reason = null;
		prCode = null;
		prName = null;
		sinseiKbnValueList.clear();
		sinseiKbnStringList.clear();
		rowData01.Clear();
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


	public String getSinseiKbn() {
		return sinseiKbn;
	}

	public void setSinseiKbn(String sinseiKbn) {
		this.sinseiKbn = sinseiKbn;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getSeparate1() {
		return separate1;
	}


	public void setSeparate1(String separate1) {
		this.separate1 = separate1;
	}


	public String getSeparate2() {
		return separate2;
	}


	public void setSeparate2(String separate2) {
		this.separate2 = separate2;
	}

	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getPrCode() {
		return prCode;
	}


	public void setPrCode(String prCode) {
		this.prCode = prCode;
	}


	public String getPrName() {
		return prName;
	}


	public void setPrName(String prName) {
		this.prName = prName;
	}


	public ArrayList<String> getSinseiKbnValueList() {
		return sinseiKbnValueList;
	}


	public void setSinseiKbnValueList(ArrayList<String> sinseiKbnValueList) {
		this.sinseiKbnValueList = sinseiKbnValueList;
	}

	public void addSinseiKbnValueList(String sinseiKbnValue) {
		this.sinseiKbnValueList.add(sinseiKbnValue);
	}


	public ArrayList<String> getSinseiKbnStringList() {
		return sinseiKbnStringList;
	}


	public void setSinseiKbnStringList(ArrayList<String> sinseiKbnStringList) {
		this.sinseiKbnStringList = sinseiKbnStringList;
	}

	public void addSinseiKbnStringList(String sinseiKbnString) {
		this.sinseiKbnStringList.add(sinseiKbnString);
	}


	public String getKyukaCode() {
		return kyukaCode;
	}


	public void setKyukaCode(String kyukaCode) {
		this.kyukaCode = kyukaCode;
	}

}
