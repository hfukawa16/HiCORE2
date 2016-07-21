package jp.co.dit.android.apps.HiCore.DataContainer;



/**
 * 休暇取得状況一覧（個人） (THQ110)画面での要素データです。
 */
public class DailyShiftDataTHQ110_Row01 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	//休暇区分
	private String VacationSegment;

	//付与
	private String Grant;

	//前月残日数
	private String RemainingDaysLastMon;

	//使用
	private String Use;

	//残日数
	private String RemainingDays;

	public void Clear() {
		VacationSegment = null;
		Grant = null;
		RemainingDaysLastMon = null;
		Use = null;
		RemainingDays = null;
	}

	public String getVacationSegment() {
		return VacationSegment;
	}

	public void setVacationSegment(String vacationSegment) {
		VacationSegment = vacationSegment;
	}

	public String getGrant() {
		return Grant;
	}

	public void setGrant(String grant) {
		Grant = grant;
	}

	public String getRemainingDaysLastMon() {
		return RemainingDaysLastMon;
	}

	public void setRemainingDaysLastMon(String remainingDaysLastMon) {
		RemainingDaysLastMon = remainingDaysLastMon;
	}

	public String getUse() {
		return Use;
	}

	public void setUse(String use) {
		Use = use;
	}

	public String getRemainingDays() {
		return RemainingDays;
	}

	public void setRemainingDays(String remainingDays) {
		RemainingDays = remainingDays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
