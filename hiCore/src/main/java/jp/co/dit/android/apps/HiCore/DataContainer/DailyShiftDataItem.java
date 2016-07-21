package jp.co.dit.android.apps.HiCore.DataContainer;

/**
 * 勤務表入出力での全ての要素データクラスです。
 */
public class DailyShiftDataItem extends DailyShiftData {

	/**
	 *
	 */
	private static final long serialVersionUID = 6167839524097334849L;
	private int dd; // 日付
	private int rowId; // no
	private int dy; // 曜日（月～日）
	private String kinmuDay; // 日付
	private int shozokuJigyoCode; // 内部コード　所属事業部コード・・らしい
	private int shozokuBushoCode; // 内部コード　所属部署コード・・らしい
	private int shokukyuCode; // 内部コード　職級コード・・らしい
	private int empKbn; // 内部コード　社員区分・・らしい
	private int kinmuGrpCode; // 内部コード　勤務グループコード・・らしい
	private int calendarKubun; // カレンダー区分 "0:平常 1:休日 4:祝日"
	private int hoteiKyujituFlag; // 内部コード　法定休日フラグ・・らしい
	private String shouninJoutaiName; // 承認状態名（「未入力」「仮登録」等）
	private int shouninJoutai; // 承認状態コード(100、200等)
	private String kinmuCode; // 勤務コード
	private int shukinHH; // 出勤時間
	private int taikinHH; // 退勤時間
	private int hoseiHH; // 補正
	private int shugyoHH; // 実働時間　時
	private int shugyoMM; // 実働時間　分
	private int totalShugyoHH; // 内部コード　合計実働時間　時
	private int totalShugyoMM; // 内部コード　合計実働時間　分
	private int kyukeiHH; // 内部コード　休憩時間　時
	private int kyukeiMM; // 内部コード　休憩時間　分
	private int jikanGaiHH; // 内部コード　時間外　時
	private int jikanGaiMM; // 内部コード　時間外　分
	private int houteiNaiHH; // 内部コード　法定内　時
	private int houteiNaiMM; // 内部コード　法定内　分
	private int houteiGaiHH; // 内部コード　法定外　時
	private int houteiGaiMM; // 内部コード　法定外　分
	private int houteiNaiKyushutuHH; // 内部コード　法定内休出　時
	private int houteiNaiKyushutuMM; // 内部コード　法定内休出　分
	private int houteiGaiKyushutuHH; // 内部コード　法定外休出　時
	private int houteiGaiKyushutuMM; // 内部コード　法定外休出　分
	private int sinyaHH; // 内部コード　深夜　時
	private int sinyaMM; // 内部コード　深夜　分
	private int shoteiNaiSinyaHH; // 内部コード　所定内　時
	private int shoteiNaiSinyaMM; // 内部コード　所定内　分
	private int shoteiGaiSinyaHH; // 内部コード　所定外　時
	private int shoteiGaiSinyaMM; // 内部コード　所定外 　分
	private int kyukaCode; // 休暇等種別
	private String biko; // 備考
	private String sinseiJoutai; // 内部コード　申請状態
	private int sinseiCode; // 内部コード　申請コード
	private int tikokuHH; // 内部コード　遅刻
	private int tikokuMM; // 内部コード　遅刻
	private int sotaiHH; // 内部コード　早退
	private int sotaiMM; // 内部コード　早退
	private int hushugyoHH; // 内部コード　不就業
	private int hushugyoMM; // 内部コード　不就業
	private int jikishouninCode; // 内部コード　時期承認コード
	private String jikishouninName; // 内部コード　時期承認名
	private String shorimaeShounin; // 内部コード　処理前承認
	private String saishuDay; // 内部コード　最終日
	private int saishuShoriUserCode; // 内部コード　最終処理ユーザコード
	private String saishuShoriUserName; // 内部コード　最終処理ユーザ名
	private int saishuShoriDaikoUserCode; // 内部コード　最終処理代行ユーザコード
	private String saishuShoriDaikoUserName; // 内部コード　最終処理代行ユーザ名
	private int sasimodosiRiyu; // 内部コード　差し戻し理由
	private String rowClassName; // 内部コード　？？
	private String weekClassName; // 内部コード　？？
	private String permission; // 内部コード　？？

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public String getKinmuDay() {
		return kinmuDay;
	}

	public void setKinmuDay(String kinmuDay) {
		this.kinmuDay = kinmuDay;
	}

	public int getShozokuJigyoCode() {
		return shozokuJigyoCode;
	}

	public void setShozokuJigyoCode(int shozokuJigyoCode) {
		this.shozokuJigyoCode = shozokuJigyoCode;
	}

	public int getShozokuBushoCode() {
		return shozokuBushoCode;
	}

	public void setShozokuBushoCode(int shozokuBushoCode) {
		this.shozokuBushoCode = shozokuBushoCode;
	}

	public int getShokukyuCode() {
		return shokukyuCode;
	}

	public void setShokukyuCode(int shokukyuCode) {
		this.shokukyuCode = shokukyuCode;
	}

	public int getEmpKbn() {
		return empKbn;
	}

	public void setEmpKbn(int empKbn) {
		this.empKbn = empKbn;
	}

	public int getKinmuGrpCode() {
		return kinmuGrpCode;
	}

	public void setKinmuGrpCode(int kinmuGrpCode) {
		this.kinmuGrpCode = kinmuGrpCode;
	}

	public int getCalendarKubun() {
		return calendarKubun;
	}

	public void setCalendarKubun(int calendarKubun) {
		this.calendarKubun = calendarKubun;
	}

	public int getHoteiKyujituFlag() {
		return hoteiKyujituFlag;
	}

	public void setHoteiKyujituFlag(int hoteiKyujituFlag) {
		this.hoteiKyujituFlag = hoteiKyujituFlag;
	}

	public String getShouninJoutaiName() {
		return shouninJoutaiName;
	}

	public void setShouninJoutaiName(String shouninJoutaiName) {
		this.shouninJoutaiName = shouninJoutaiName;
	}

	public int getShouninJoutai() {
		return shouninJoutai;
	}

	public void setShouninJoutai(int shouninJoutai) {
		this.shouninJoutai = shouninJoutai;
	}

	public String getKinmuCode() {
		return kinmuCode;
	}

	public void setKinmuCode(String kinmuCode) {
		this.kinmuCode = kinmuCode;
	}

	public int getShukinHH() {
		return shukinHH;
	}

	public void setShukinHH(int shukinHH) {
		this.shukinHH = shukinHH;
	}

	public int getTaikinHH() {
		return taikinHH;
	}

	public void setTaikinHH(int taikinHH) {
		this.taikinHH = taikinHH;
	}

	public int getHoseiHH() {
		return hoseiHH;
	}

	public void setHoseiHH(int hoseiHH) {
		this.hoseiHH = hoseiHH;
	}

	public int getShugyoHH() {
		return shugyoHH;
	}

	public void setShugyoHH(int shugyoHH) {
		this.shugyoHH = shugyoHH;
	}

	public int getShugyoMM() {
		return shugyoMM;
	}

	public void setShugyoMM(int shugyoMM) {
		this.shugyoMM = shugyoMM;
	}

	public int getTotalShugyoHH() {
		return totalShugyoHH;
	}

	public void setTotalShugyoHH(int totalShugyoHH) {
		this.totalShugyoHH = totalShugyoHH;
	}

	public int getTotalShugyoMM() {
		return totalShugyoMM;
	}

	public void setTotalShugyoMM(int totalShugyoMM) {
		this.totalShugyoMM = totalShugyoMM;
	}

	public int getKyukeiHH() {
		return kyukeiHH;
	}

	public void setKyukeiHH(int kyukeiHH) {
		this.kyukeiHH = kyukeiHH;
	}

	public int getKyukeiMM() {
		return kyukeiMM;
	}

	public void setKyukeiMM(int kyukeiMM) {
		this.kyukeiMM = kyukeiMM;
	}

	public int getJikanGaiHH() {
		return jikanGaiHH;
	}

	public void setJikanGaiHH(int jikanGaiHH) {
		this.jikanGaiHH = jikanGaiHH;
	}

	public int getJikanGaiMM() {
		return jikanGaiMM;
	}

	public void setJikanGaiMM(int jikanGaiMM) {
		this.jikanGaiMM = jikanGaiMM;
	}

	public int getHouteiNaiHH() {
		return houteiNaiHH;
	}

	public void setHouteiNaiHH(int houteiNaiHH) {
		this.houteiNaiHH = houteiNaiHH;
	}

	public int getHouteiNaiMM() {
		return houteiNaiMM;
	}

	public void setHouteiNaiMM(int houteiNaiMM) {
		this.houteiNaiMM = houteiNaiMM;
	}

	public int getHouteiGaiHH() {
		return houteiGaiHH;
	}

	public void setHouteiGaiHH(int houteiGaiHH) {
		this.houteiGaiHH = houteiGaiHH;
	}

	public int getHouteiGaiMM() {
		return houteiGaiMM;
	}

	public void setHouteiGaiMM(int houteiGaiMM) {
		this.houteiGaiMM = houteiGaiMM;
	}

	public int getHouteiNaiKyushutuHH() {
		return houteiNaiKyushutuHH;
	}

	public void setHouteiNaiKyushutuHH(int houteiNaiKyushutuHH) {
		this.houteiNaiKyushutuHH = houteiNaiKyushutuHH;
	}

	public int getHouteiNaiKyushutuMM() {
		return houteiNaiKyushutuMM;
	}

	public void setHouteiNaiKyushutuMM(int houteiNaiKyushutuMM) {
		this.houteiNaiKyushutuMM = houteiNaiKyushutuMM;
	}

	public int getHouteiGaiKyushutuHH() {
		return houteiGaiKyushutuHH;
	}

	public void setHouteiGaiKyushutuHH(int houteiGaiKyushutuHH) {
		this.houteiGaiKyushutuHH = houteiGaiKyushutuHH;
	}

	public int getHouteiGaiKyushutuMM() {
		return houteiGaiKyushutuMM;
	}

	public void setHouteiGaiKyushutuMM(int houteiGaiKyushutuMM) {
		this.houteiGaiKyushutuMM = houteiGaiKyushutuMM;
	}

	public int getSinyaHH() {
		return sinyaHH;
	}

	public void setSinyaHH(int sinyaHH) {
		this.sinyaHH = sinyaHH;
	}

	public int getSinyaMM() {
		return sinyaMM;
	}

	public void setSinyaMM(int sinyaMM) {
		this.sinyaMM = sinyaMM;
	}

	public int getShoteiNaiSinyaHH() {
		return shoteiNaiSinyaHH;
	}

	public void setShoteiNaiSinyaHH(int shoteiNaiSinyaHH) {
		this.shoteiNaiSinyaHH = shoteiNaiSinyaHH;
	}

	public int getShoteiNaiSinyaMM() {
		return shoteiNaiSinyaMM;
	}

	public void setShoteiNaiSinyaMM(int shoteiNaiSinyaMM) {
		this.shoteiNaiSinyaMM = shoteiNaiSinyaMM;
	}

	public int getShoteiGaiSinyaHH() {
		return shoteiGaiSinyaHH;
	}

	public void setShoteiGaiSinyaHH(int shoteiGaiSinyaHH) {
		this.shoteiGaiSinyaHH = shoteiGaiSinyaHH;
	}

	public int getShoteiGaiSinyaMM() {
		return shoteiGaiSinyaMM;
	}

	public void setShoteiGaiSinyaMM(int shoteiGaiSinyaMM) {
		this.shoteiGaiSinyaMM = shoteiGaiSinyaMM;
	}

	public int getKyukaCode() {
		return kyukaCode;
	}

	public void setKyukaCode(int kyukaCode) {
		this.kyukaCode = kyukaCode;
	}

	public String getBiko() {
		return biko;
	}

	public void setBiko(String biko) {
		this.biko = biko;
	}

	public String getSinseiJoutai() {
		return sinseiJoutai;
	}

	public void setSinseiJoutai(String sinseiJoutai) {
		this.sinseiJoutai = sinseiJoutai;
	}

	public int getSinseiCode() {
		return sinseiCode;
	}

	public void setSinseiCode(int sinseiCode) {
		this.sinseiCode = sinseiCode;
	}

	public int getTikokuHH() {
		return tikokuHH;
	}

	public void setTikokuHH(int tikokuHH) {
		this.tikokuHH = tikokuHH;
	}

	public int getTikokuMM() {
		return tikokuMM;
	}

	public void setTikokuMM(int tikokuMM) {
		this.tikokuMM = tikokuMM;
	}

	public int getSotaiHH() {
		return sotaiHH;
	}

	public void setSotaiHH(int sotaiHH) {
		this.sotaiHH = sotaiHH;
	}

	public int getSotaiMM() {
		return sotaiMM;
	}

	public void setSotaiMM(int sotaiMM) {
		this.sotaiMM = sotaiMM;
	}

	public int getHushugyoHH() {
		return hushugyoHH;
	}

	public void setHushugyoHH(int hushugyoHH) {
		this.hushugyoHH = hushugyoHH;
	}

	public int getHushugyoMM() {
		return hushugyoMM;
	}

	public void setHushugyoMM(int hushugyoMM) {
		this.hushugyoMM = hushugyoMM;
	}

	public int getJikishouninCode() {
		return jikishouninCode;
	}

	public void setJikishouninCode(int jikishouninCode) {
		this.jikishouninCode = jikishouninCode;
	}

	public String getJikishouninName() {
		return jikishouninName;
	}

	public void setJikishouninName(String jikishouninName) {
		this.jikishouninName = jikishouninName;
	}

	public String getShorimaeShounin() {
		return shorimaeShounin;
	}

	public void setShorimaeShounin(String shorimaeShounin) {
		this.shorimaeShounin = shorimaeShounin;
	}

	public String getSaishuDay() {
		return saishuDay;
	}

	public void setSaishuDay(String saishuDay) {
		this.saishuDay = saishuDay;
	}

	public int getSaishuShoriUserCode() {
		return saishuShoriUserCode;
	}

	public void setSaishuShoriUserCode(int saishuShoriUserCode) {
		this.saishuShoriUserCode = saishuShoriUserCode;
	}

	public String getSaishuShoriUserName() {
		return saishuShoriUserName;
	}

	public void setSaishuShoriUserName(String saishuShoriUserName) {
		this.saishuShoriUserName = saishuShoriUserName;
	}

	public int getSaishuShoriDaikoUserCode() {
		return saishuShoriDaikoUserCode;
	}

	public void setSaishuShoriDaikoUserCode(int saishuShoriDaikoUserCode) {
		this.saishuShoriDaikoUserCode = saishuShoriDaikoUserCode;
	}

	public String getSaishuShoriDaikoUserName() {
		return saishuShoriDaikoUserName;
	}

	public void setSaishuShoriDaikoUserName(String saishuShoriDaikoUserName) {
		this.saishuShoriDaikoUserName = saishuShoriDaikoUserName;
	}

	public int getSasimodosiRiyu() {
		return sasimodosiRiyu;
	}

	public void setSasimodosiRiyu(int sasimodosiRiyu) {
		this.sasimodosiRiyu = sasimodosiRiyu;
	}

	public String getRowClassName() {
		return rowClassName;
	}

	public void setRowClassName(String rowClassName) {
		this.rowClassName = rowClassName;
	}

	public String getWeekClassName() {
		return weekClassName;
	}

	public void setWeekClassName(String weekClassName) {
		this.weekClassName = weekClassName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
