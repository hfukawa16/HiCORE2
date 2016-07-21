package jp.co.dit.android.apps.HiCore.DataContainer;

/**
  * 勤務表入出力でのプロジェクトコード毎の時間要素データです。
 */
public class DailyShiftDataPojectCodeTime extends DailyShiftData {


	/**
	 *
	 */
	private static final long serialVersionUID = -1973816491877681096L;
	private int  projectCodeHH;
	private int  projectCodeAuth;


	public int getProjectCodeHH() {
		return projectCodeHH;
	}
	public void setProjectCodeHH(int projectCodeHH) {
		this.projectCodeHH = projectCodeHH;
	}
	public int getProjectCodeAuth() {
		return projectCodeAuth;
	}
	public void setProjectCodeAuth(int projectCodeAuth) {
		this.projectCodeAuth = projectCodeAuth;
	}




}
