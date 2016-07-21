package jp.co.dit.android.apps.HiCore.DataContainer;


/**
 * 代休管理台帳（個人） (THQ130)画面での要素データです。
 */
public class DailyShiftDataTHQ130 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	//No
	private String 		No;
	//出勤日
	private String 		Date;
	//曜日
	private String 		DayOfTheWeek1;
	//勤務時間
	private String 		Hours;
	//実働時間
	private String 		WorkedHours;
	//有効期限
	private String 		ExpirationDate;
	//曜日
	private String 		DayOfTheWeek2;
	//取得日
	private String 		AcquisitionDate;


	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDayOfTheWeek1() {
		return DayOfTheWeek1;
	}
	public void setDayOfTheWeek1(String dayOfTheWeek1) {
		DayOfTheWeek1 = dayOfTheWeek1;
	}
	public String getHours() {
		return Hours;
	}
	public void setHours(String hours) {
		Hours = hours;
	}
	public String getWorkedHours() {
		return WorkedHours;
	}
	public void setWorkedHours(String workedHours) {
		WorkedHours = workedHours;
	}
	public String getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}
	public String getDayOfTheWeek2() {
		return DayOfTheWeek2;
	}
	public void setDayOfTheWeek2(String dayOfTheWeek2) {
		DayOfTheWeek2 = dayOfTheWeek2;
	}
	public String getAcquisitionDate() {
		return AcquisitionDate;
	}
	public void setAcquisitionDate(String acquisitionDate) {
		AcquisitionDate = acquisitionDate;
	}

}
