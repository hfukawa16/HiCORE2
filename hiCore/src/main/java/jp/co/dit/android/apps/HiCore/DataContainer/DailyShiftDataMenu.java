package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * 勤務表入出力でのMenu画面での要素データです。
 */
public class DailyShiftDataMenu extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;

	//メニュー上部の運用月インフォメーション
	private String manuInfo;
	//運用月
	private int monOperations;
	//ユーザ情報（氏名など）
	private List<String> userInfo = new ArrayList<String>();

	//日々の入力状況
	private List<Integer> inputStatusList = new ArrayList<Integer>();

	public void Clear() {
		this.manuInfo = null;
		this.monOperations = 0;
		this.userInfo.clear();
		this.inputStatusList.clear();
	}

	public String getManuInfo() {
		return manuInfo;
	}
	public void setManuInfo(String manuInfo) {
		this.manuInfo = manuInfo;
	}
	public int getMonOperations() {
		return monOperations;
	}
	public void setMonOperations(int monOperations) {
		this.monOperations = monOperations;
	}
	public void setMonOperations(String monOperations) {
		this.monOperations = Integer.valueOf(monOperations);
	}

	public List<String> getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo.add(userInfo);
	}
	public List<Integer> getInputStatusList() {
		return inputStatusList;
	}
	public void setInputStatusList(Integer inputStatusList) {
		this.inputStatusList.add(inputStatusList);
	}




}
