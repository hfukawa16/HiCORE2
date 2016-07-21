package jp.co.dit.android.apps.HiCore.DataContainer;


/**
 * パスワード更新 (TSE190)画面での要素データです。
 */
public class DailyShiftDataTSE190 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	//現パスワード
	private String 	prePass;
	//新パスワード
	private String 	newPass;
	//新パスワード（確認）
	private String 	conPass;


	public String getPrePass() {
		return prePass;
	}
	public void setPrePass(String prePass) {
		this.prePass = prePass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getConPass() {
		return conPass;
	}
	public void setConPass(String conPass) {
		this.conPass = conPass;
	}

}
