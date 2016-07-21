package jp.co.dit.android.apps.HiCore.DataContainer;



/**
 * 申請一覧 (TAE120)画面での要素データです。
 */
public class DailyShiftDataTAE120_Row01 extends DailyShiftData {


	private static final long serialVersionUID = -8179642994718632931L;


	// 申請日
		private String ApplicationDate;
	// 承認状況
		private String ApprovalStatus;
	// 事前
		private String Prior;
	// 申請内容
		private String TheApplicationForm;
	// 申請期間
		private String TheApplicationPeriod;
	// 申請時刻
		private String ApplicationTime;
	// 理　由
		private String Why;
	// プロジェクト
		private String Project;


	public void Clear() {
		ApplicationDate= null;
		ApprovalStatus= null;
		Prior= null;
		TheApplicationForm= null;
		TheApplicationPeriod= null;
		ApplicationTime= null;
		Why= null;
		Project= null;

	}


	public String getApplicationDate() {
		return ApplicationDate;
	}


	public void setApplicationDate(String applicationDate) {
		ApplicationDate = applicationDate;
	}


	public String getApprovalStatus() {
		return ApprovalStatus;
	}


	public void setApprovalStatus(String approvalStatus) {
		ApprovalStatus = approvalStatus;
	}


	public String getPrior() {
		return Prior;
	}


	public void setPrior(String prior) {
		Prior = prior;
	}


	public String getTheApplicationForm() {
		return TheApplicationForm;
	}


	public void setTheApplicationForm(String theApplicationForm) {
		TheApplicationForm = theApplicationForm;
	}


	public String getTheApplicationPeriod() {
		return TheApplicationPeriod;
	}


	public void setTheApplicationPeriod(String theApplicationPeriod) {
		TheApplicationPeriod = theApplicationPeriod;
	}


	public String getApplicationTime() {
		return ApplicationTime;
	}


	public void setApplicationTime(String applicationTime) {
		ApplicationTime = applicationTime;
	}


	public String getWhy() {
		return Why;
	}


	public void setWhy(String why) {
		Why = why;
	}


	public String getProject() {
		return Project;
	}


	public void setProject(String project) {
		Project = project;
	}


}
