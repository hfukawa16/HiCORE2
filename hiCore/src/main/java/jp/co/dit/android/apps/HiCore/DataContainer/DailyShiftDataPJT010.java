package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

/**
 * プロジェクトコード検索 (PJT010) 画面での要素データです。
 */
public class DailyShiftDataPJT010 extends DailyShiftData {

	private static final long serialVersionUID = -8179642994718632931L;


	// プロジェクト コード
	private ArrayList<String>  	prCode= new ArrayList<String>();
	// プロジェクト 名
	private ArrayList<String>  	prName= new ArrayList<String>();

	// 検索方法 "0":コード検索 "1":名称検索
	private String 	searchkbn;
	// 検索条件入力 "文字列"
	private String 	searchword;


	public void Clear() {
		searchkbn = null;
		searchword = null;
		prCode.clear();
		prName.clear();
	}


	public ArrayList<String> getPrCode() {
		return prCode;
	}


	public void setPrCode(ArrayList<String> prCode) {
		this.prCode = prCode;
	}
	public void setPrCode(String prCode) {
		this.prCode.add(prCode);
	}


	public ArrayList<String> getPrName() {
		return prName;
	}


	public void setPrName(ArrayList<String> prName) {
		this.prName = prName;
	}

	public void setPrName(String prName) {
		this.prName.add(prName);
	}


	public String getSearchkbn() {
		return searchkbn;
	}


	public void setSearchkbn(String searchkbn) {
		this.searchkbn = searchkbn;
	}


	public String getSearchword() {
		return searchword;
	}


	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
