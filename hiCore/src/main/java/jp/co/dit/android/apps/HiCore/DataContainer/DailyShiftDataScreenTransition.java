package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.HashMap;

/**
 * 勤務表入出力での画面間移動にて使用される要素データです。
 */
public class DailyShiftDataScreenTransition extends DailyShiftData {

	/**
	 *
	 */
	private static final long serialVersionUID = 5250446828628750330L;
	/**
	 *
	 */

	// 画面遷移時の共通項目（hidden項目）
	HashMap<String,String> hidden_map = new HashMap<String, String>();

//	private String sysTime;		// サーバ返却値(システム時刻)
//	private String stat;		// サーバ返却値(？)
//	private String proc;		// サーバ返却値(？)
//	private String hidPgCode;	// サーバ返却値(画面ＩＤ)
	private String message;		// サーバ返却値(エラーメッセージ等)
//	private String addUserCode;	// サーバ返却値(代休管理台帳にて使用されている)
//	private String dispMode;	// サーバ返却値(代休管理台帳にて使用されている)
//	private String shoriYm;		// サーバ返却値(代休管理台帳にて使用されている)
//	private String userCode;	// サーバ返却値(休暇取得状況一覧にて使用されている)

	public void clear() {
		hidden_map.clear();
	}

	public void setHiddenData(String name, String Value) {
		hidden_map.put(name, Value);
	}

	public HashMap<String, String> getHiddenData() {
		return hidden_map;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

/*
	public String getSysTime() {
		return sysTime;
	}
	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getProc() {
		return proc;
	}
	public void setProc(String proc) {
		this.proc = proc;
	}
	public String getHidPgCode() {
		return hidPgCode;
	}
	public void setHidPgCode(String hidPgCode) {
		this.hidPgCode = hidPgCode;
	}

	public String getAddUserCode() {
		return addUserCode;
	}

	public void setAddUserCode(String addUserCode) {
		this.addUserCode = addUserCode;
	}

	public String getDispMode() {
		return dispMode;
	}

	public void setDispMode(String dispMode) {
		this.dispMode = dispMode;
	}



	public String getShoriYm() {
		return shoriYm;
	}



	public void setShoriYm(String shoriYm) {
		this.shoriYm = shoriYm;
	}



	public String getUserCode() {
		return userCode;
	}



	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
*/
}
