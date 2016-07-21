package jp.co.dit.android.apps.HiCore.DataBean;
import java.io.Serializable;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TWE110DailyEmployment implements Serializable{

    /**
	 * @return dd
	 */
	public String getDd() {
		return dd;
	}

	/**
	 * @param dd セットする dd
	 */
	public void setDd(String dd) {
		this.dd = dd;
	}

	/**
	 * @return rowId
	 */
	public int getRowId() {
		return rowId;
	}

	/**
	 * @param rowId セットする rowId
	 */
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	/**
	 * @return dy
	 */
	public String getDy() {
		return dy;
	}

	/**
	 * @param dy セットする dy
	 */
	public void setDy(String dy) {
		this.dy = dy;
	}

	/**
	 * @return kinmuDay
	 */
	public String getKinmuDay() {
		return kinmuDay;
	}

	/**
	 * @param kinmuDay セットする kinmuDay
	 */
	public void setKinmuDay(String kinmuDay) {
		this.kinmuDay = kinmuDay;
	}

	/**
	 * @return shozokuBushoCode
	 */
	public String getShozokuBushoCode() {
		return shozokuBushoCode;
	}

	/**
	 * @param shozokuBushoCode セットする shozokuBushoCode
	 */
	public void setShozokuBushoCode(String shozokuBushoCode) {
		this.shozokuBushoCode = shozokuBushoCode;
	}

	/**
	 * @return shokukyuCode
	 */
	public String getShokukyuCode() {
		return shokukyuCode;
	}

	/**
	 * @param shokukyuCode セットする shokukyuCode
	 */
	public void setShokukyuCode(String shokukyuCode) {
		this.shokukyuCode = shokukyuCode;
	}

	/**
	 * @return empKbn
	 */
	public String getEmpKbn() {
		return empKbn;
	}

	/**
	 * @param empKbn セットする empKbn
	 */
	public void setEmpKbn(String empKbn) {
		this.empKbn = empKbn;
	}

	/**
	 * @return kinmuGrpCode
	 */
	public String getKinmuGrpCode() {
		return kinmuGrpCode;
	}

	/**
	 * @param kinmuGrpCode セットする kinmuGrpCode
	 */
	public void setKinmuGrpCode(String kinmuGrpCode) {
		this.kinmuGrpCode = kinmuGrpCode;
	}

	/**
	 * @return calendarKubun
	 */
	public String getCalendarKubun() {
		return calendarKubun;
	}

	/**
	 * @param calendarKubun セットする calendarKubun
	 */
	public void setCalendarKubun(String calendarKubun) {
		this.calendarKubun = calendarKubun;
	}

	/**
	 * @return hoteiKyujituFlag
	 */
	public String getHoteiKyujituFlag() {
		return hoteiKyujituFlag;
	}

	/**
	 * @param hoteiKyujituFlag セットする hoteiKyujituFlag
	 */
	public void setHoteiKyujituFlag(String hoteiKyujituFlag) {
		this.hoteiKyujituFlag = hoteiKyujituFlag;
	}

	/**
	 * @return kinmuCodeString
	 */
	public String getKinmuCodeString() {
		return kinmuCodeString;
	}

	/**
	 * @param kinmuCodeString セットする kinmuCodeString
	 */
	public void setKinmuCodeString(String kinmuCodeString) {
		this.kinmuCodeString = kinmuCodeString;
	}

	/**
	 * @return shugyoHH
	 */
	public String getShugyoHH() {
		return shugyoHH;
	}

	/**
	 * @param shugyoHH セットする shugyoHH
	 */
	public void setShugyoHH(String shugyoHH) {
		this.shugyoHH = shugyoHH;
	}

	/**
	 * @return shugyoMM
	 */
	public String getShugyoMM() {
		return shugyoMM;
	}

	/**
	 * @param shugyoMM セットする shugyoMM
	 */
	public void setShugyoMM(String shugyoMM) {
		this.shugyoMM = shugyoMM;
	}

	/**
	 * @return totalShugyoHH
	 */
	public String getTotalShugyoHH() {
		return totalShugyoHH;
	}

	/**
	 * @param totalShugyoHH セットする totalShugyoHH
	 */
	public void setTotalShugyoHH(String totalShugyoHH) {
		this.totalShugyoHH = totalShugyoHH;
	}

	/**
	 * @return totalShugyoMM
	 */
	public String getTotalShugyoMM() {
		return totalShugyoMM;
	}

	/**
	 * @param totalShugyoMM セットする totalShugyoMM
	 */
	public void setTotalShugyoMM(String totalShugyoMM) {
		this.totalShugyoMM = totalShugyoMM;
	}

	/**
	 * @return shoteiRoudouHH
	 */
	public String getShoteiRoudouHH() {
		return shoteiRoudouHH;
	}

	/**
	 * @param shoteiRoudouHH セットする shoteiRoudouHH
	 */
	public void setShoteiRoudouHH(String shoteiRoudouHH) {
		this.shoteiRoudouHH = shoteiRoudouHH;
	}

	/**
	 * @return shoteiRoudouMM
	 */
	public String getShoteiRoudouMM() {
		return shoteiRoudouMM;
	}

	/**
	 * @param shoteiRoudouMM セットする shoteiRoudouMM
	 */
	public void setShoteiRoudouMM(String shoteiRoudouMM) {
		this.shoteiRoudouMM = shoteiRoudouMM;
	}

	/**
	 * @return kyukeiHH
	 */
	public String getKyukeiHH() {
		return kyukeiHH;
	}

	/**
	 * @param kyukeiHH セットする kyukeiHH
	 */
	public void setKyukeiHH(String kyukeiHH) {
		this.kyukeiHH = kyukeiHH;
	}

	/**
	 * @return kyukeiMM
	 */
	public String getKyukeiMM() {
		return kyukeiMM;
	}

	/**
	 * @param kyukeiMM セットする kyukeiMM
	 */
	public void setKyukeiMM(String kyukeiMM) {
		this.kyukeiMM = kyukeiMM;
	}

	/**
	 * @return jikanGaiHH
	 */
	public String getJikanGaiHH() {
		return jikanGaiHH;
	}

	/**
	 * @param jikanGaiHH セットする jikanGaiHH
	 */
	public void setJikanGaiHH(String jikanGaiHH) {
		this.jikanGaiHH = jikanGaiHH;
	}

	/**
	 * @return jikanGaiMM
	 */
	public String getJikanGaiMM() {
		return jikanGaiMM;
	}

	/**
	 * @param jikanGaiMM セットする jikanGaiMM
	 */
	public void setJikanGaiMM(String jikanGaiMM) {
		this.jikanGaiMM = jikanGaiMM;
	}

	/**
	 * @return houteiNaiHH
	 */
	public String getHouteiNaiHH() {
		return houteiNaiHH;
	}

	/**
	 * @param houteiNaiHH セットする houteiNaiHH
	 */
	public void setHouteiNaiHH(String houteiNaiHH) {
		this.houteiNaiHH = houteiNaiHH;
	}

	/**
	 * @return houteiNaiMM
	 */
	public String getHouteiNaiMM() {
		return houteiNaiMM;
	}

	/**
	 * @param houteiNaiMM セットする houteiNaiMM
	 */
	public void setHouteiNaiMM(String houteiNaiMM) {
		this.houteiNaiMM = houteiNaiMM;
	}

	/**
	 * @return houteiGaiHH
	 */
	public String getHouteiGaiHH() {
		return houteiGaiHH;
	}

	/**
	 * @param houteiGaiHH セットする houteiGaiHH
	 */
	public void setHouteiGaiHH(String houteiGaiHH) {
		this.houteiGaiHH = houteiGaiHH;
	}

	/**
	 * @return houteiGaiMM
	 */
	public String getHouteiGaiMM() {
		return houteiGaiMM;
	}

	/**
	 * @param houteiGaiMM セットする houteiGaiMM
	 */
	public void setHouteiGaiMM(String houteiGaiMM) {
		this.houteiGaiMM = houteiGaiMM;
	}

	/**
	 * @return houteiNaiKyushutuHH
	 */
	public String getHouteiNaiKyushutuHH() {
		return houteiNaiKyushutuHH;
	}

	/**
	 * @param houteiNaiKyushutuHH セットする houteiNaiKyushutuHH
	 */
	public void setHouteiNaiKyushutuHH(String houteiNaiKyushutuHH) {
		this.houteiNaiKyushutuHH = houteiNaiKyushutuHH;
	}

	/**
	 * @return houteiNaiKyushutuMM
	 */
	public String getHouteiNaiKyushutuMM() {
		return houteiNaiKyushutuMM;
	}

	/**
	 * @param houteiNaiKyushutuMM セットする houteiNaiKyushutuMM
	 */
	public void setHouteiNaiKyushutuMM(String houteiNaiKyushutuMM) {
		this.houteiNaiKyushutuMM = houteiNaiKyushutuMM;
	}

	/**
	 * @return houteiGaiKyushutuHH
	 */
	public String getHouteiGaiKyushutuHH() {
		return houteiGaiKyushutuHH;
	}

	/**
	 * @param houteiGaiKyushutuHH セットする houteiGaiKyushutuHH
	 */
	public void setHouteiGaiKyushutuHH(String houteiGaiKyushutuHH) {
		this.houteiGaiKyushutuHH = houteiGaiKyushutuHH;
	}

	/**
	 * @return houteiGaiKyushutuMM
	 */
	public String getHouteiGaiKyushutuMM() {
		return houteiGaiKyushutuMM;
	}

	/**
	 * @param houteiGaiKyushutuMM セットする houteiGaiKyushutuMM
	 */
	public void setHouteiGaiKyushutuMM(String houteiGaiKyushutuMM) {
		this.houteiGaiKyushutuMM = houteiGaiKyushutuMM;
	}

	/**
	 * @return sinyaHH
	 */
	public String getSinyaHH() {
		return sinyaHH;
	}

	/**
	 * @param sinyaHH セットする sinyaHH
	 */
	public void setSinyaHH(String sinyaHH) {
		this.sinyaHH = sinyaHH;
	}

	/**
	 * @return sinyaMM
	 */
	public String getSinyaMM() {
		return sinyaMM;
	}

	/**
	 * @param sinyaMM セットする sinyaMM
	 */
	public void setSinyaMM(String sinyaMM) {
		this.sinyaMM = sinyaMM;
	}

	/**
	 * @return shoteiNaiSinyaHH
	 */
	public String getShoteiNaiSinyaHH() {
		return shoteiNaiSinyaHH;
	}

	/**
	 * @param shoteiNaiSinyaHH セットする shoteiNaiSinyaHH
	 */
	public void setShoteiNaiSinyaHH(String shoteiNaiSinyaHH) {
		this.shoteiNaiSinyaHH = shoteiNaiSinyaHH;
	}

	/**
	 * @return shoteiNaiSinyaMM
	 */
	public String getShoteiNaiSinyaMM() {
		return shoteiNaiSinyaMM;
	}

	/**
	 * @param shoteiNaiSinyaMM セットする shoteiNaiSinyaMM
	 */
	public void setShoteiNaiSinyaMM(String shoteiNaiSinyaMM) {
		this.shoteiNaiSinyaMM = shoteiNaiSinyaMM;
	}

	/**
	 * @return shoteiGaiSinyaHH
	 */
	public String getShoteiGaiSinyaHH() {
		return shoteiGaiSinyaHH;
	}

	/**
	 * @param shoteiGaiSinyaHH セットする shoteiGaiSinyaHH
	 */
	public void setShoteiGaiSinyaHH(String shoteiGaiSinyaHH) {
		this.shoteiGaiSinyaHH = shoteiGaiSinyaHH;
	}

	/**
	 * @return shoteiGaiSinyaMM
	 */
	public String getShoteiGaiSinyaMM() {
		return shoteiGaiSinyaMM;
	}

	/**
	 * @param shoteiGaiSinyaMM セットする shoteiGaiSinyaMM
	 */
	public void setShoteiGaiSinyaMM(String shoteiGaiSinyaMM) {
		this.shoteiGaiSinyaMM = shoteiGaiSinyaMM;
	}

	/**
	 * @return kyukaCode
	 */
	public String getKyukaCode() {
		return kyukaCode;
	}

	/**
	 * @param kyukaCode セットする kyukaCode
	 */
	public void setKyukaCode(String kyukaCode) {
		this.kyukaCode = kyukaCode;
	}

	/**
	 * @return kyukaCodeTwo
	 */
	public String getKyukaCodeTwo() {
		return kyukaCodeTwo;
	}

	/**
	 * @param kyukaCodeTwo セットする kyukaCodeTwo
	 */
	public void setKyukaCodeTwo(String kyukaCodeTwo) {
		this.kyukaCodeTwo = kyukaCodeTwo;
	}

	/**
	 * @return kyukaShutokuKubun
	 */
	public String getKyukaShutokuKubun() {
		return kyukaShutokuKubun;
	}

	/**
	 * @param kyukaShutokuKubun セットする kyukaShutokuKubun
	 */
	public void setKyukaShutokuKubun(String kyukaShutokuKubun) {
		this.kyukaShutokuKubun = kyukaShutokuKubun;
	}

	/**
	 * @return sinseiJoutai
	 */
	public String getSinseiJoutai() {
		return sinseiJoutai;
	}

	/**
	 * @param sinseiJoutai セットする sinseiJoutai
	 */
	public void setSinseiJoutai(String sinseiJoutai) {
		this.sinseiJoutai = sinseiJoutai;
	}

	/**
	 * @return sinseiCode
	 */
	public String getSinseiCode() {
		return sinseiCode;
	}

	/**
	 * @param sinseiCode セットする sinseiCode
	 */
	public void setSinseiCode(String sinseiCode) {
		this.sinseiCode = sinseiCode;
	}

	/**
	 * @return sinseiJoutaiTwo
	 */
	public String getSinseiJoutaiTwo() {
		return sinseiJoutaiTwo;
	}

	/**
	 * @param sinseiJoutaiTwo セットする sinseiJoutaiTwo
	 */
	public void setSinseiJoutaiTwo(String sinseiJoutaiTwo) {
		this.sinseiJoutaiTwo = sinseiJoutaiTwo;
	}

	/**
	 * @return sinseiCodeTwo
	 */
	public String getSinseiCodeTwo() {
		return sinseiCodeTwo;
	}

	/**
	 * @param sinseiCodeTwo セットする sinseiCodeTwo
	 */
	public void setSinseiCodeTwo(String sinseiCodeTwo) {
		this.sinseiCodeTwo = sinseiCodeTwo;
	}

	/**
	 * @return tikokuHH
	 */
	public String getTikokuHH() {
		return tikokuHH;
	}

	/**
	 * @param tikokuHH セットする tikokuHH
	 */
	public void setTikokuHH(String tikokuHH) {
		this.tikokuHH = tikokuHH;
	}

	/**
	 * @return tikokuMM
	 */
	public String getTikokuMM() {
		return tikokuMM;
	}

	/**
	 * @param tikokuMM セットする tikokuMM
	 */
	public void setTikokuMM(String tikokuMM) {
		this.tikokuMM = tikokuMM;
	}

	/**
	 * @return sotaiHH
	 */
	public String getSotaiHH() {
		return sotaiHH;
	}

	/**
	 * @param sotaiHH セットする sotaiHH
	 */
	public void setSotaiHH(String sotaiHH) {
		this.sotaiHH = sotaiHH;
	}

	/**
	 * @return sotaiMM
	 */
	public String getSotaiMM() {
		return sotaiMM;
	}

	/**
	 * @param sotaiMM セットする sotaiMM
	 */
	public void setSotaiMM(String sotaiMM) {
		this.sotaiMM = sotaiMM;
	}

	/**
	 * @return hushugyoHH
	 */
	public String getHushugyoHH() {
		return hushugyoHH;
	}

	/**
	 * @param hushugyoHH セットする hushugyoHH
	 */
	public void setHushugyoHH(String hushugyoHH) {
		this.hushugyoHH = hushugyoHH;
	}

	/**
	 * @return hushugyoMM
	 */
	public String getHushugyoMM() {
		return hushugyoMM;
	}

	/**
	 * @param hushugyoMM セットする hushugyoMM
	 */
	public void setHushugyoMM(String hushugyoMM) {
		this.hushugyoMM = hushugyoMM;
	}

	/**
	 * @return jikishouninCode
	 */
	public String getJikishouninCode() {
		return jikishouninCode;
	}

	/**
	 * @param jikishouninCode セットする jikishouninCode
	 */
	public void setJikishouninCode(String jikishouninCode) {
		this.jikishouninCode = jikishouninCode;
	}

	/**
	 * @return jikishouninName
	 */
	public String getJikishouninName() {
		return jikishouninName;
	}

	/**
	 * @param jikishouninName セットする jikishouninName
	 */
	public void setJikishouninName(String jikishouninName) {
		this.jikishouninName = jikishouninName;
	}

	/**
	 * @return shorimaeShounin
	 */
	public String getShorimaeShounin() {
		return shorimaeShounin;
	}

	/**
	 * @param shorimaeShounin セットする shorimaeShounin
	 */
	public void setShorimaeShounin(String shorimaeShounin) {
		this.shorimaeShounin = shorimaeShounin;
	}

	/**
	 * @return saishuDay
	 */
	public String getSaishuDay() {
		return saishuDay;
	}

	/**
	 * @param saishuDay セットする saishuDay
	 */
	public void setSaishuDay(String saishuDay) {
		this.saishuDay = saishuDay;
	}

	/**
	 * @return saishuShoriUserCode
	 */
	public String getSaishuShoriUserCode() {
		return saishuShoriUserCode;
	}

	/**
	 * @param saishuShoriUserCode セットする saishuShoriUserCode
	 */
	public void setSaishuShoriUserCode(String saishuShoriUserCode) {
		this.saishuShoriUserCode = saishuShoriUserCode;
	}

	/**
	 * @return saishuShoriUserName
	 */
	public String getSaishuShoriUserName() {
		return saishuShoriUserName;
	}

	/**
	 * @param saishuShoriUserName セットする saishuShoriUserName
	 */
	public void setSaishuShoriUserName(String saishuShoriUserName) {
		this.saishuShoriUserName = saishuShoriUserName;
	}

	/**
	 * @return saishuShoriDaikoUserCode
	 */
	public String getSaishuShoriDaikoUserCode() {
		return saishuShoriDaikoUserCode;
	}

	/**
	 * @param saishuShoriDaikoUserCode セットする saishuShoriDaikoUserCode
	 */
	public void setSaishuShoriDaikoUserCode(String saishuShoriDaikoUserCode) {
		this.saishuShoriDaikoUserCode = saishuShoriDaikoUserCode;
	}

	/**
	 * @return saishuShoriDaikoUserName
	 */
	public String getSaishuShoriDaikoUserName() {
		return saishuShoriDaikoUserName;
	}

	/**
	 * @param saishuShoriDaikoUserName セットする saishuShoriDaikoUserName
	 */
	public void setSaishuShoriDaikoUserName(String saishuShoriDaikoUserName) {
		this.saishuShoriDaikoUserName = saishuShoriDaikoUserName;
	}

	/**
	 * @return sasimodosiRiyu
	 */
	public String getSasimodosiRiyu() {
		return sasimodosiRiyu;
	}

	/**
	 * @param sasimodosiRiyu セットする sasimodosiRiyu
	 */
	public void setSasimodosiRiyu(String sasimodosiRiyu) {
		this.sasimodosiRiyu = sasimodosiRiyu;
	}

	/**
	 * @return rowClassName
	 */
	public String getRowClassName() {
		return rowClassName;
	}

	/**
	 * @param rowClassName セットする rowClassName
	 */
	public void setRowClassName(String rowClassName) {
		this.rowClassName = rowClassName;
	}

	/**
	 * @return weekClassName
	 */
	public String getWeekClassName() {
		return weekClassName;
	}

	/**
	 * @param weekClassName セットする weekClassName
	 */
	public void setWeekClassName(String weekClassName) {
		this.weekClassName = weekClassName;
	}

	/**
	 * @return permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission セットする permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @return jikantai1HH
	 */
	public String getJikantai1HH() {
		return jikantai1HH;
	}

	/**
	 * @param jikantai1hh セットする jikantai1HH
	 */
	public void setJikantai1HH(String jikantai1hh) {
		jikantai1HH = jikantai1hh;
	}

	/**
	 * @return jikantai1MM
	 */
	public String getJikantai1MM() {
		return jikantai1MM;
	}

	/**
	 * @param jikantai1mm セットする jikantai1MM
	 */
	public void setJikantai1MM(String jikantai1mm) {
		jikantai1MM = jikantai1mm;
	}

	/**
	 * @return jikantai2HH
	 */
	public String getJikantai2HH() {
		return jikantai2HH;
	}

	/**
	 * @param jikantai2hh セットする jikantai2HH
	 */
	public void setJikantai2HH(String jikantai2hh) {
		jikantai2HH = jikantai2hh;
	}

	/**
	 * @return jikantai2MM
	 */
	public String getJikantai2MM() {
		return jikantai2MM;
	}

	/**
	 * @param jikantai2mm セットする jikantai2MM
	 */
	public void setJikantai2MM(String jikantai2mm) {
		jikantai2MM = jikantai2mm;
	}

	/**
	 * @return jikantai3HH
	 */
	public String getJikantai3HH() {
		return jikantai3HH;
	}

	/**
	 * @param jikantai3hh セットする jikantai3HH
	 */
	public void setJikantai3HH(String jikantai3hh) {
		jikantai3HH = jikantai3hh;
	}

	/**
	 * @return jikantai3MM
	 */
	public String getJikantai3MM() {
		return jikantai3MM;
	}

	/**
	 * @param jikantai3mm セットする jikantai3MM
	 */
	public void setJikantai3MM(String jikantai3mm) {
		jikantai3MM = jikantai3mm;
	}

	/**
	 * @return jikantai4HH
	 */
	public String getJikantai4HH() {
		return jikantai4HH;
	}

	/**
	 * @param jikantai4hh セットする jikantai4HH
	 */
	public void setJikantai4HH(String jikantai4hh) {
		jikantai4HH = jikantai4hh;
	}

	/**
	 * @return jikantai4MM
	 */
	public String getJikantai4MM() {
		return jikantai4MM;
	}

	/**
	 * @param jikantai4mm セットする jikantai4MM
	 */
	public void setJikantai4MM(String jikantai4mm) {
		jikantai4MM = jikantai4mm;
	}

	/**
	 * @return jikantai5HH
	 */
	public String getJikantai5HH() {
		return jikantai5HH;
	}

	/**
	 * @param jikantai5hh セットする jikantai5HH
	 */
	public void setJikantai5HH(String jikantai5hh) {
		jikantai5HH = jikantai5hh;
	}

	/**
	 * @return jikantai5MM
	 */
	public String getJikantai5MM() {
		return jikantai5MM;
	}

	/**
	 * @param jikantai5mm セットする jikantai5MM
	 */
	public void setJikantai5MM(String jikantai5mm) {
		jikantai5MM = jikantai5mm;
	}

	/**
	 * @return jikantai6HH
	 */
	public String getJikantai6HH() {
		return jikantai6HH;
	}

	/**
	 * @param jikantai6hh セットする jikantai6HH
	 */
	public void setJikantai6HH(String jikantai6hh) {
		jikantai6HH = jikantai6hh;
	}

	/**
	 * @return jikantai6MM
	 */
	public String getJikantai6MM() {
		return jikantai6MM;
	}

	/**
	 * @param jikantai6mm セットする jikantai6MM
	 */
	public void setJikantai6MM(String jikantai6mm) {
		jikantai6MM = jikantai6mm;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return shukinHH
	 */
	public String getShukinHH() {
		return shukinHH;
	}

	/**
	 * @return taikinHH
	 */
	public String getTaikinHH() {
		return taikinHH;
	}

	/**
	 * @param shouninJoutaiName セットする shouninJoutaiName
	 */
	public void setShouninJoutaiName(String shouninJoutaiName) {
		this.shouninJoutaiName = shouninJoutaiName;
	}

	/**
	 * @param shouninJoutai セットする shouninJoutai
	 */
	public void setShouninJoutai(String shouninJoutai) {
		this.shouninJoutai = shouninJoutai;
	}

	/** シリアルバージョンID */
    private static final long serialVersionUID = 1L;

    /** 日付    */
    private String dd = null;
    /** 行番号    */
    private int rowId =  0;
    /** 曜日    */
    private String dy = null;
	/** 勤務日付    2015-07-01形式*/
    private String kinmuDay = null;
    /** 所属部署コード    */
    private String shozokuBushoCode = null;
    /** 職位等級    */
    private String shokukyuCode = null;
    /** 採用区分    */
    private String empKbn = null;
    /** 勤務区分グループコード    */
    private String kinmuGrpCode = null;
    /** カレンダ区分    */
    private String calendarKubun = null;
    /** 法定休日フラグ    */
    private String hoteiKyujituFlag = null;
    /** 承認状態名    */
    private String shouninJoutaiName = null;
    /** 承認状態    */
    private String shouninJoutai = null;
    /** 勤務コード    */
    private String kinmuCode = null;
    /** 勤務コード名称(option選択内容)    */
    private String kinmuCodeString = null;
    /** 出勤時刻    */
    private String shukinHH = null;
    /** 退勤時刻    */
    private String taikinHH = null;
    /** 補正時間    */
    private String hoseiHH = null;
    /** 就業時間    */
    private String shugyoHH = null;
    /** 就業時間    */
    private String shugyoMM = null;
    /** 総就業時間    */
    private String totalShugyoHH = null;
    /** 総就業時間    */
    private String totalShugyoMM = null;
    /** 所定労働時間    */
    private String shoteiRoudouHH = null;
    /** 所定労働時間    */
    private String shoteiRoudouMM = null;
    /** 休憩時間    */
    private String kyukeiHH = null;
    /** 休憩時間    */
    private String kyukeiMM = null;
    /** 時間外    */
    private String jikanGaiHH = null;
    /** 時間外    */
    private String jikanGaiMM = null;
    /** 法定内時間外    */
    private String houteiNaiHH = null;
    /** 法定内時間外    */
    private String houteiNaiMM = null;
    /** 法定外時間外    */
    private String houteiGaiHH = null;
    /** 法定外時間外    */
    private String houteiGaiMM = null;
    /** 法定内休出時間    */
    private String houteiNaiKyushutuHH = null;
    /** 法定内休出時間    */
    private String houteiNaiKyushutuMM = null;
    /** 法定外休出時間    */
    private String houteiGaiKyushutuHH = null;
    /** 法定外休出時間    */
    private String houteiGaiKyushutuMM = null;
    /** 内深夜早朝時間    */
    private String sinyaHH = null;
    /** 内深夜早朝時間    */
    private String sinyaMM = null;
    /** 所定内深夜時間    */
    private String shoteiNaiSinyaHH = null;
    /** 所定内深夜時間    */
    private String shoteiNaiSinyaMM = null;
    /** 所定外深夜時間    */
    private String shoteiGaiSinyaHH = null;
    /** 所定外深夜時間    */
    private String shoteiGaiSinyaMM = null;
    /** 休暇１    */
    private String kyukaCode = null;
    /** 休暇２    */
    private String kyukaCodeTwo = null;
    /** 備考    */
    private String biko = null;
    /** 休暇取得区分    */
    private String kyukaShutokuKubun = null;
    /** 申請状態    */
    private String sinseiJoutai = null;
    /** 申請コード    */
    private String sinseiCode = null;
    /** 申請状態２    */
    private String sinseiJoutaiTwo = null;
    /** 申請コード２    */
    private String sinseiCodeTwo = null;
    /** 遅刻時間    */
    private String tikokuHH = null;
    /** 遅刻時間    */
    private String tikokuMM = null;
    /** 早退時間    */
    private String sotaiHH = null;
    /** 早退時間    */
    private String sotaiMM = null;
    /** 不就業時間    */
    private String hushugyoHH = null;
    /** 不就業時間    */
    private String hushugyoMM = null;
    /** 次期承認者    */
    private String jikishouninCode = null;
    /** 次期承認者氏名    */
    private String jikishouninName = null;
    /** 処理前承認状態    */
    private String shorimaeShounin = null;
    /** 最終処理日時    */
    private String saishuDay = null;
    /** 最終処理ユーザ    */
    private String saishuShoriUserCode = null;
    /** 最終処理ユーザ氏名    */
    private String saishuShoriUserName = null;
    /** 最終処理代行ユーザ    */
    private String saishuShoriDaikoUserCode = null;
    /** 最終処理代行ユーザ名    */
    private String saishuShoriDaikoUserName = null;
    /** 差戻し理由    */
    private String sasimodosiRiyu = null;
    /** 明細行ClassName    */
    private String rowClassName = null;
    /** 曜日ClassName    */
    private String weekClassName = null;
    /** 入力許可    0:入力可能 1:入力不可 */
    private String permission = null;
    /** 時間帯集計１    */
    private String jikantai1HH = null;
    /** 時間帯集計１    */
    private String jikantai1MM = null;
    /** 時間帯集計２    */
    private String jikantai2HH = null;
    /** 時間帯集計２    */
    private String jikantai2MM = null;
    /** 時間帯集計３    */
    private String jikantai3HH = null;
    /** 時間帯集計３    */
    private String jikantai3MM = null;
    /** 時間帯集計４    */
    private String jikantai4HH = null;
    /** 時間帯集計４    */
    private String jikantai4MM = null;
    /** 時間帯集計５    */
    private String jikantai5HH = null;
    /** 時間帯集計５    */
    private String jikantai5MM = null;
    /** 時間帯集計６    */
    private String jikantai6HH = null;
    /** 時間帯集計６    */
    private String jikantai6MM = null;

    
	 void setDailyRow(Document doc, int rowId) {

		// 計測開始
//		 StopWatch.start();

			// 行番号   
			this.rowId = rowId;
			// 日付   
			this.dd =  doc.select("input[name=dd" + rowId + "]").first().attr("value");
			// 曜日   
			this.dy =  doc.select("input[name=dy" + rowId + "]").first().attr("value");
			// 勤務日付   
			this.kinmuDay =  doc.select("input[name=kinmuDay" + rowId + "]").first().attr("value");
			// 所属部署コード   
//			this.shozokuBushoCode =  doc.select("input[name=shozokuBushoCode" + rowId + "]").first().attr("value");
			// 職位等級   
//			this.shokukyuCode =  doc.select("input[name=shokukyuCode" + rowId + "]").first().attr("value");
			// 採用区分   
//			this.empKbn =  doc.select("input[name=empKbn" + rowId + "]").first().attr("value");
			// 勤務区分グループコード   
//			this.kinmuGrpCode =  doc.select("input[name=kinmuGrpCode" + rowId + "]").first().attr("value");
			// カレンダ区分   
//			this.calendarKubun =  doc.select("input[name=calendarKubun" + rowId + "]").first().attr("value");
			// 法定休日フラグ   
//			this.hoteiKyujituFlag =  doc.select("input[name=hoteiKyujituFlag" + rowId + "]").first().attr("value");
			// 承認状態名   
//			this.shouninJoutaiName =  doc.select("input[name=shouninJoutaiName" + rowId + "]").first().attr("value");
			// 承認状態   
			this.shouninJoutai =  doc.select("input[name=shouninJoutai" + rowId + "]").first().attr("value");
			// 勤務コード   
			this.kinmuCode = "";
			if (doc.select("select[name=kinmuCode" + rowId + "]").isEmpty()== false) {
				Elements aa = doc.select("select[name=kinmuCode" + rowId + "]").first().getElementsByTag("option");
				for (Element aa1 : aa) {
					if (aa1.getElementsByAttribute("selected").text().isEmpty() == false) {
						this.kinmuCode =  aa1.attr("value");
						this.kinmuCodeString =  aa1.getElementsByAttribute("selected").text();
					}
				}
			}
	        
			// 勤務コード文字列   
//			this.kinmuCodeString = "";
//			Elements aa = doc.select("select[name=kinmuCode" + rowId + "]").first().getElementsByTag("option");
//	        for (Element aa1 : aa) {
//	       		if (aa1.getElementsByAttribute("selected").text().isEmpty() == false) {
//	       			this.kinmuCodeString =  aa1.getElementsByAttribute("selected").text();
//	       		}
//	        }
			// 出勤時刻   
			this.shukinHH =  doc.select("input[name=shukinHH" + rowId + "]").first().attr("value");
			// 退勤時刻   
			this.taikinHH =  doc.select("input[name=taikinHH" + rowId + "]").first().attr("value");
			// 補正時間   
			this.hoseiHH =  doc.select("input[name=hoseiHH" + rowId + "]").first().attr("value");
/*
			// 就業時間   
			this.shugyoHH =  doc.select("input[name=shugyoHH" + rowId + "]").first().attr("value");
			// 就業時間   
			this.shugyoMM =  doc.select("input[name=shugyoMM" + rowId + "]").first().attr("value");
			// 総就業時間   
			this.totalShugyoHH =  doc.select("input[name=totalShugyoHH" + rowId + "]").first().attr("value");
			// 総就業時間   
			this.totalShugyoMM =  doc.select("input[name=totalShugyoMM" + rowId + "]").first().attr("value");
			// 所定労働時間   
			this.shoteiRoudouHH =  doc.select("input[name=shoteiRoudouHH" + rowId + "]").first().attr("value");
			// 所定労働時間   
			this.shoteiRoudouMM =  doc.select("input[name=shoteiRoudouMM" + rowId + "]").first().attr("value");
			// 休憩時間   
			this.kyukeiHH =  doc.select("input[name=kyukeiHH" + rowId + "]").first().attr("value");
			// 休憩時間   
			this.kyukeiMM =  doc.select("input[name=kyukeiMM" + rowId + "]").first().attr("value");
			// 時間外   
			this.jikanGaiHH =  doc.select("input[name=jikanGaiHH" + rowId + "]").first().attr("value");
			// 時間外   
			this.jikanGaiMM =  doc.select("input[name=jikanGaiMM" + rowId + "]").first().attr("value");
			// 法定内時間外   
			this.houteiNaiHH =  doc.select("input[name=houteiNaiHH" + rowId + "]").first().attr("value");
			// 法定内時間外   
			this.houteiNaiMM =  doc.select("input[name=houteiNaiMM" + rowId + "]").first().attr("value");
			// 法定外時間外   
			this.houteiGaiHH =  doc.select("input[name=houteiGaiHH" + rowId + "]").first().attr("value");
			// 法定外時間外   
			this.houteiGaiMM =  doc.select("input[name=houteiGaiMM" + rowId + "]").first().attr("value");
			// 法定内休出時間   
			this.houteiNaiKyushutuHH =  doc.select("input[name=houteiNaiKyushutuHH" + rowId + "]").first().attr("value");
			// 法定内休出時間   
			this.houteiNaiKyushutuMM =  doc.select("input[name=houteiNaiKyushutuMM" + rowId + "]").first().attr("value");
			// 法定外休出時間   
			this.houteiGaiKyushutuHH =  doc.select("input[name=houteiGaiKyushutuHH" + rowId + "]").first().attr("value");
			// 法定外休出時間   
			this.houteiGaiKyushutuMM =  doc.select("input[name=houteiGaiKyushutuMM" + rowId + "]").first().attr("value");
			// 内深夜早朝時間   
			this.sinyaHH =  doc.select("input[name=sinyaHH" + rowId + "]").first().attr("value");
			// 内深夜早朝時間   
			this.sinyaMM =  doc.select("input[name=sinyaMM" + rowId + "]").first().attr("value");
			// 所定内深夜時間   
			this.shoteiNaiSinyaHH =  doc.select("input[name=shoteiNaiSinyaHH" + rowId + "]").first().attr("value");
			// 所定内深夜時間   
			this.shoteiNaiSinyaMM =  doc.select("input[name=shoteiNaiSinyaMM" + rowId + "]").first().attr("value");
			// 所定外深夜時間   
			this.shoteiGaiSinyaHH =  doc.select("input[name=shoteiGaiSinyaHH" + rowId + "]").first().attr("value");
			// 所定外深夜時間   
			this.shoteiGaiSinyaMM =  doc.select("input[name=shoteiGaiSinyaMM" + rowId + "]").first().attr("value");
			// 休暇１   
			this.kyukaCode =  doc.select("input[name=kyukaCode" + rowId + "]").first().attr("value");
			// 休暇２   
			this.kyukaCodeTwo =  doc.select("input[name=kyukaCodeTwo" + rowId + "]").first().attr("value");
*/
			// 備考   
			this.biko =  doc.select("input[name=biko" + rowId + "]").first().attr("value");
/*
			// 休暇取得区分   
			this.kyukaShutokuKubun =  doc.select("input[name=kyukaShutokuKubun" + rowId + "]").first().attr("value");
			// 申請状態   
			this.sinseiJoutai =  doc.select("input[name=sinseiJoutai" + rowId + "]").first().attr("value");
			// 申請コード   
			this.sinseiCode =  doc.select("input[name=sinseiCode" + rowId + "]").first().attr("value");
			// 申請状態２   
			this.sinseiJoutaiTwo =  doc.select("input[name=sinseiJoutaiTwo" + rowId + "]").first().attr("value");
			// 申請コード２   
			this.sinseiCodeTwo =  doc.select("input[name=sinseiCodeTwo" + rowId + "]").first().attr("value");
			// 遅刻時間   
			this.tikokuHH =  doc.select("input[name=tikokuHH" + rowId + "]").first().attr("value");
			// 遅刻時間   
			this.tikokuMM =  doc.select("input[name=tikokuMM" + rowId + "]").first().attr("value");
			// 早退時間   
			this.sotaiHH =  doc.select("input[name=sotaiHH" + rowId + "]").first().attr("value");
			// 早退時間   
			this.sotaiMM =  doc.select("input[name=sotaiMM" + rowId + "]").first().attr("value");
			// 不就業時間   
			this.hushugyoHH =  doc.select("input[name=hushugyoHH" + rowId + "]").first().attr("value");
			// 不就業時間   
			this.hushugyoMM =  doc.select("input[name=hushugyoMM" + rowId + "]").first().attr("value");
			// 次期承認者   
			this.jikishouninCode =  doc.select("input[name=jikishouninCode" + rowId + "]").first().attr("value");
			// 次期承認者氏名   
			this.jikishouninName =  doc.select("input[name=jikishouninName" + rowId + "]").first().attr("value");
			// 処理前承認状態   
			this.shorimaeShounin =  doc.select("input[name=shorimaeShounin" + rowId + "]").first().attr("value");
			// 最終処理日時   
			this.saishuDay =  doc.select("input[name=saishuDay" + rowId + "]").first().attr("value");
			// 最終処理ユーザ   
			this.saishuShoriUserCode =  doc.select("input[name=saishuShoriUserCode" + rowId + "]").first().attr("value");
			// 最終処理ユーザ氏名   
			this.saishuShoriUserName =  doc.select("input[name=saishuShoriUserName" + rowId + "]").first().attr("value");
			// 最終処理代行ユーザ   
			this.saishuShoriDaikoUserCode =  doc.select("input[name=saishuShoriDaikoUserCode" + rowId + "]").first().attr("value");
			// 最終処理代行ユーザ名   
			this.saishuShoriDaikoUserName =  doc.select("input[name=saishuShoriDaikoUserName" + rowId + "]").first().attr("value");
			// 差戻し理由   
			this.sasimodosiRiyu =  doc.select("input[name=sasimodosiRiyu" + rowId + "]").first().attr("value");
			// 明細行ClassName   
			this.rowClassName =  doc.select("input[name=rowClassName" + rowId + "]").first().attr("value");
			// 曜日ClassName   
			this.weekClassName =  doc.select("input[name=weekClassName" + rowId + "]").first().attr("value");
*/
			// 入力許可   
			this.permission =  doc.select("input[name=permission" + rowId + "]").first().attr("value");
/*
			// 時間帯集計１   
			this.jikantai1HH =  doc.select("input[name=jikantai1HH" + rowId + "]").first().attr("value");
			// 時間帯集計１   
			this.jikantai1MM =  doc.select("input[name=jikantai1MM" + rowId + "]").first().attr("value");
			// 時間帯集計２   
			this.jikantai2HH =  doc.select("input[name=jikantai2HH" + rowId + "]").first().attr("value");
			// 時間帯集計２   
			this.jikantai2MM =  doc.select("input[name=jikantai2MM" + rowId + "]").first().attr("value");
			// 時間帯集計３   
			this.jikantai3HH =  doc.select("input[name=jikantai3HH" + rowId + "]").first().attr("value");
			// 時間帯集計３   
			this.jikantai3MM =  doc.select("input[name=jikantai3MM" + rowId + "]").first().attr("value");
			// 時間帯集計４   
			this.jikantai4HH =  doc.select("input[name=jikantai4HH" + rowId + "]").first().attr("value");
			// 時間帯集計４   
			this.jikantai4MM =  doc.select("input[name=jikantai4MM" + rowId + "]").first().attr("value");
			// 時間帯集計５   
			this.jikantai5HH =  doc.select("input[name=jikantai5HH" + rowId + "]").first().attr("value");
			// 時間帯集計５   
			this.jikantai5MM =  doc.select("input[name=jikantai5MM" + rowId + "]").first().attr("value");
			// 時間帯集計６   
			this.jikantai6HH =  doc.select("input[name=jikantai6HH" + rowId + "]").first().attr("value");
			// 時間帯集計６   
			this.jikantai6MM =  doc.select("input[name=jikantai6MM" + rowId + "]").first().attr("value");
*/
		
		// 計測終了
//		StopWatch.printMilliTime(new Throwable().getStackTrace()[0].getMethodName() + " milli: ");

		
		
	}

	//map(POST用)
	public Map<String, String> postMap(Map<String, String> map, int rowId) {

		map.put("dd" + rowId, this.dd);													/** 日付    						*/
		map.put("rowId" + rowId, String.valueOf(rowId));								/** 行番号    						*/
		map.put("dy" + rowId, this.dy);													/** 曜日    (無くても登録されるけどシステムエラーになるから)*/
		map.put("kinmuDay" + rowId, this.kinmuDay);										/** 勤務日付    2015-07-01形式		*/
		map.put("shouninJoutai" + rowId, this.shouninJoutai);							/** 承認状態    					*/
		map.put("kinmuCode" + rowId, this.kinmuCode);									/** 勤務コード    					*/
		map.put("shukinHH" + rowId, this.shukinHH);										/** 出勤時刻    					*/
		map.put("taikinHH" + rowId, this.taikinHH);										/** 退勤時刻    					*/
		map.put("hoseiHH" + rowId, this.hoseiHH);										/** 補正時間    					*/
		map.put("permission" + rowId, this.permission);									/** 入力許可    0固定でもいいかも	*/
		map.put("biko" + rowId, this.biko);												/** 備考    						*/
//		map.put("shozokuBushoCode" + rowId, this.shozokuBushoCode);						/** 所属部署コード    */
//		map.put("shokukyuCode" + rowId, this.shokukyuCode);								/** 職位等級    */
//		map.put("empKbn" + rowId, this.empKbn);											/** 採用区分    */
//		map.put("kinmuGrpCode" + rowId, this.kinmuGrpCode);								/** 勤務区分グループコード    */
//		map.put("calendarKubun" + rowId, this.calendarKubun);							/** カレンダ区分    */
//		map.put("hoteiKyujituFlag" + rowId, this.hoteiKyujituFlag);						/** 法定休日フラグ    */
//		map.put("shouninJoutaiName" + rowId, this.shouninJoutaiName);					/** 承認状態名    */
//		map.put("shugyoHH" + rowId, this.shugyoHH);										/** 就業時間    */
//		map.put("shugyoMM" + rowId, this.shugyoMM);										/** 就業時間    */
//		map.put("totalShugyoHH" + rowId, this.totalShugyoHH);							/** 総就業時間    */
//		map.put("totalShugyoMM" + rowId, this.totalShugyoMM);							/** 総就業時間    */
//		map.put("shoteiRoudouHH" + rowId, this.shoteiRoudouHH);							/** 所定労働時間    */
//		map.put("shoteiRoudouMM" + rowId, this.shoteiRoudouMM);							/** 所定労働時間    */
//		map.put("kyukaShutokuKubun" + rowId, this.kyukaShutokuKubun);					/** 休暇取得区分    */
//		map.put("shorimaeShounin" + rowId, this.shorimaeShounin);						/** 処理前承認状態    */
//		map.put("saishuDay" + rowId, this.saishuDay);									/** 最終処理日時    */
//		map.put("saishuShoriUserCode" + rowId, this.saishuShoriUserCode);				/** 最終処理ユーザ    */
//		map.put("saishuShoriUserName" + rowId, this.saishuShoriUserName);				/** 最終処理ユーザ氏名    */
//		map.put("saishuShoriDaikoUserCode" + rowId, this.saishuShoriDaikoUserCode);		/** 最終処理代行ユーザ    */
//		map.put("saishuShoriDaikoUserName" + rowId, this.saishuShoriDaikoUserName);		/** 最終処理代行ユーザ名    */
//		map.put("sasimodosiRiyu" + rowId, this.sasimodosiRiyu);							/** 差戻し理由    */
//		map.put("rowClassName" + rowId, this.rowClassName);								/** 明細行ClassName    */
//		map.put("weekClassName" + rowId, this.weekClassName);							/** 曜日ClassName    */
		

		
		
		return map;
		
	}

	/**
	 * 承認状態名を取得します。
	 * @return 承認状態名
	 */
	public String getShouninJoutaiName() {
	    return shouninJoutaiName;
	}

	/**
	 * 承認状態を取得します。
	 * @return 承認状態
	 */
	public String getShouninJoutai() {
	    return shouninJoutai;
	}


	/**
	 * 勤務コードを取得します。
	 * @return 勤務コード
	 */
	public String getKinmuCode() {
	    return kinmuCode;
	}

	/**
	 * 勤務コードを設定します。
	 * @param kinmuCode 勤務コード
	 */
	public void setKinmuCode(String kinmuCode) {
	    this.kinmuCode = kinmuCode;
	}

	/**
	 * 出勤時刻を設定します。
	 * @param shukinHH 出勤時刻
	 */
	public void setShukinHH(String shukinHH) {
	    this.shukinHH = shukinHH;
	}

	/**
	 * 退勤時刻を設定します。
	 * @param taikinHH 退勤時刻
	 */
	public void setTaikinHH(String taikinHH) {
	    this.taikinHH = taikinHH;
	}

	/**
	 * 補正時間を取得します。
	 * @return 補正時間
	 */
	public String getHoseiHH() {
	    return hoseiHH;
	}

	/**
	 * 補正時間を設定します。
	 * @param hoseiHH 補正時間
	 */
	public void setHoseiHH(String hoseiHH) {
	    this.hoseiHH = hoseiHH;
	}

	/**
	 * 備考を取得します。
	 * @return 備考
	 */
	public String getBiko() {
	    return biko;
	}

	/**
	 * 備考を設定します。
	 * @param biko 備考
	 */
	public void setBiko(String biko) {
	    this.biko = biko;
	}

}
