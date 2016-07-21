package jp.co.dit.android.apps.HiCore.DataBean;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/** メニュー画面 */
public class SM010Bean extends BaseBean {

    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    /** メニューページフラグ？    */
   	private String menuPg = null;

   	/** メニューでの開閉ステータス    （ブラウザ用なので不要だけどいちおう）*/
   	@SuppressWarnings("unused")
	private String state1 = null;
   	@SuppressWarnings("unused")
	private String state2 = null;
   	@SuppressWarnings("unused")
   	private String state3 = null;
   	@SuppressWarnings("unused")
   	private String state5 = null;
   	@SuppressWarnings("unused")
   	private String state6 = null;
   	@SuppressWarnings("unused")
   	private String state7 = null;

   	/** ユーザ情報    */
   	private String user_name = null;			//ユーザ名
   	private String user_affiliation = null;		//所属
   	private String user_post = null;			//役職
   	private String user_workSystem = null;		//勤務体系
   	
   	/** カレンダー情報    */
   	private String input_state = null;		//入力状態タイトル
//	private String input_gif = null;		//対象月のgifファイルパス
	private int monOperations=0;			//運用月
	private int yerOperations=0;			//運用年

	/** メニュー上部の運用月インフォメーション */
	private String manuInfo= null;

    /** リスト配列(Max31日分の入力状況ステータス）    */
    private List<Integer> dayDivList = null;	//状態リスト

   	
   	
    public SM010Bean(){
   		super();
   		
   		this.cls();
    }

   	void cls(){
   		super.cls();

   		//デフォルト値のセット
   		this.setPgCode("SM010");
   		this.setStat("2");

   	    /** メニューページフラグ？    */
   	   	setMenuPg(null);

   	   	/** メニューでの開閉ステータス    （ブラウザ用なので不要だけどいちおう）*/
   	   	state1 = null;
   	   	state2 = null;
   	   	state3 = null;
   	   	state5 = null;
   	   	state6 = null;
   	   	state7 = null;

   	   	/** ユーザ情報    */
   	   	user_name = null;						//ユーザ名
   	   	user_affiliation = null;				//所属
   	   	user_post = null;						//役職
   	   	user_workSystem = null;					//勤務体系
   	   	
   	   	/** カレンダー情報    */
   	   	setInput_state(null);					//入力状態タイトル
//   	   	input_gif = null;						//対象月のgifファイルパス
   	   	monOperations = 0;						//運用月
   	   	yerOperations = 0;						//運用年

   		manuInfo = null;						//運用月インフォメーション

   	    /** リスト配列(Max31日分の勤務列データ）    */
   	    dayDivList = null;						//状態リスト
   	    dayDivList = new ArrayList<Integer>();	//状態リスト
   	   	
   	}

    public SM010Bean setDataconte(Document d) {
		super.setDataconte(d);

	    /** メニューページフラグ？    */
		this.setMenuPg(d.select("input[name=menuPg]").first().attr("value"));

	   	/** ステータス？    */
		this.state1 =  d.select("input[name=state1]").first().attr("value");
		this.state2 =  d.select("input[name=state2]").first().attr("value");
		this.state3 =  d.select("input[name=state3]").first().attr("value");
		this.state5 =  d.select("input[name=state5]").first().attr("value");
		this.state6 =  d.select("input[name=state6]").first().attr("value");
		this.state7 =  d.select("input[name=state7]").first().attr("value");

	   	/** ユーザ情報    */
		Elements tableEl = d.select("table");														//tableタグのエレメントを抽出

		this.setUser_name(tableEl.get(23).select("table").select("td").get(1).text());					//ユーザ名
		this.setUser_affiliation(tableEl.get(23).select("table").select("td").get(3).text());			//所属
		this.setUser_post(tableEl.get(23).select("table").select("td").get(4).text());					//役職
		this.setUser_workSystem(tableEl.get(23).select("table").select("td").get(5).text());			//勤務体系

	   	/** カレンダー情報    */
		this.setInput_state(tableEl.get(24).select("img").get(10).attr("alt"));					//タイトル
//		this.input_gif = tableEl.get(24).select("img").get(10).attr("src");					//月のgif

		/** メニュー上部の運用月インフォメーションを取得*/ 
		this.setManuInfo(d.select("div[class=exp1]").get(1).text());
		
		/** 運用月インフォメーションから運用年月を取得 */ 
		//YYYY年MM　を抽出
		int indexFrom = this.manuInfo.indexOf("△▲運用月は");
		indexFrom += "△▲運用月は".length();
		int indexTo = this.manuInfo.indexOf("月です▲△");
		String StrYYYYMM = this.manuInfo.substring(indexFrom,indexTo);
		//YYYY年MM　より、YYYY MM　を分離して取得
		String StrYYYY = StrYYYYMM.substring(0, StrYYYYMM.indexOf("年"));
		String StrMM = StrYYYYMM.substring(StrYYYYMM.indexOf("年")+"年".length());
		//取得したＹＹＹＹ　ＭＭの全角⇒半角変換
		StrYYYY = Normalizer.normalize(StrYYYY, Form.NFKC);
		StrMM = Normalizer.normalize(StrMM, Form.NFKC);

		//取得した値を数値変換して保存
		this.yerOperations = Integer.valueOf(StrYYYY).intValue();
		this.monOperations = Integer.valueOf(StrMM).intValue();
		
			    
		/** カレンダーの日々の入力ステータスを取得*/ 
		Elements tdEl = tableEl.get(26).select("td");					//日々のステータス
		for (Element i: tdEl){
			if 	(i.select("div").isEmpty() == false)
			{
		   		switch  (i.attr("class")){
		   		
		   		case	"ca0":
		   			this.dayDivList.add(0);
		   			break;
		   		case	"ca1":
		   			this.dayDivList.add(1);
		   			break;
		   		case	"ca2":
		   			this.dayDivList.add(2);
		   			break;
		   		case	"ca3":
		   			this.dayDivList.add(3);
		   			break;
		   		case	"ca4":
		   			this.dayDivList.add(4);
		   			break;
		   		case	"ca5":
		   			this.dayDivList.add(5);
		   			break;
		   		case	"ca6":
		   			this.dayDivList.add(6);
		   			break;
		   		}
			}
			
		}
		
		return this;
		
	}

	/**
	 * @return manuInfo
	 */
	public String getManuInfo() {
		return manuInfo;
	}

	/**
	 * @param manuInfo セットする manuInfo
	 */
	public void setManuInfo(String manuInfo) {
		this.manuInfo = manuInfo;
	}

	/**
	 * @return monOperations
	 */
	public int getMonOperations() {
		return monOperations;
	}

	/**
	 * @param monOperations セットする monOperations
	 */
	public void setMonOperations(int monOperations) {
		this.monOperations = monOperations;
	}

	/**
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name セットする user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return user_affiliation
	 */
	public String getUser_affiliation() {
		return user_affiliation;
	}

	/**
	 * @param user_affiliation セットする user_affiliation
	 */
	public void setUser_affiliation(String user_affiliation) {
		this.user_affiliation = user_affiliation;
	}

	/**
	 * @return user_post
	 */
	public String getUser_post() {
		return user_post;
	}

	/**
	 * @param user_post セットする user_post
	 */
	public void setUser_post(String user_post) {
		this.user_post = user_post;
	}

	/**
	 * @return input_state
	 */
	public String getInput_state() {
		return input_state;
	}

	/**
	 * @param input_state セットする input_state
	 */
	public void setInput_state(String input_state) {
		this.input_state = input_state;
	}

	/**
	 * リスト配列(Max31日分の入力状況ステータス）を取得します。
	 * @return リスト配列(Max31日分の入力状況ステータス）
	 */
	public List<Integer> getDayDivList() {
	    return dayDivList;
	}

	/**
	 * リスト配列(Max31日分の入力状況ステータス）を設定します。
	 * @param dayDivList リスト配列(Max31日分の入力状況ステータス）
	 */
	public void setDayDivList(List<Integer> dayDivList) {
	    this.dayDivList = dayDivList;
	}

	/**
	 * @return user_workSystem
	 */
	public String getUser_workSystem() {
		return user_workSystem;
	}

	/**
	 * @param user_workSystem セットする user_workSystem
	 */
	public void setUser_workSystem(String user_workSystem) {
		this.user_workSystem = user_workSystem;
	}

	/**
	 * @return menuPg
	 */
	public String getMenuPg() {
		return menuPg;
	}

	/**
	 * @param menuPg セットする menuPg
	 */
	public void setMenuPg(String menuPg) {
		this.menuPg = menuPg;
	}

	/**
	 * @return yerOperations
	 */
	public int getYerOperations() {
		return yerOperations;
	}

	/**
	 * @param yerOperations セットする yerOperations
	 */
	public void setYerOperations(int yyyy) {
		yerOperations = yyyy;
	}




}
