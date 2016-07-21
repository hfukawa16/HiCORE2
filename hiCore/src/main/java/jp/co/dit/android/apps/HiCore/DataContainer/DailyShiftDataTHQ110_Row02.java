package jp.co.dit.android.apps.HiCore.DataContainer;


/**
 * 休暇取得状況一覧（個人） (THQ110)画面での要素データです。
 */
public class DailyShiftDataTHQ110_Row02 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	//NO
	private String No;

	//取得日付
	private String AcquisitionDate;

	//休暇区分
	private String VacationSegment;

	public void Clear() {
		No = null;
		AcquisitionDate = null;
		VacationSegment = null;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getAcquisitionDate() {
		return AcquisitionDate;
	}

	public void setAcquisitionDate(String acquisitionDate) {
		AcquisitionDate = acquisitionDate;
	}

	public String getVacationSegment() {
		return VacationSegment;
	}

	public void setVacationSegment(String vacationSegment) {
		VacationSegment = vacationSegment;
	}

}