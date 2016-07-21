package jp.co.dit.android.apps.HiCore.DataBean;
import java.util.Map;

import org.jsoup.nodes.Document;


abstract public class BaseBean  {
	
    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    //接続先
//   	private String url = null;			//接続先設定

    /** システム時刻    */
    private String _system_time_ = "0";
    /** 制御コード    */
    private String stat = null;
    /** 手続きコード    */
    private String proc = null;
    /** 画面コード    */
    private String pgCode = null;
    /** アラートメッセージ    */
   	private String att = null;
    /** フォーカス項目    */
   	private String focusAtt = null;

	/*	コンストラクタ	*/
   	BaseBean(){
	}
   	
   	void cls(){
   	    /** システム時刻    */
   	    _system_time_ = "0";
   	    /** 制御コード    */
   	    stat = null;
   	    /** 手続きコード    */
   	    proc = null;
   	    /** 画面コード    */
   	    pgCode = null;
   	    /** アラートメッセージ    */
   	   	att = null;
   	    /** フォーカス項目    */
   	   	focusAtt = null;  		
   	}

   	public BaseBean setDataconte(Document d){
	    /** htmlDocument    */
		Document doc = d;

	    /** システム時刻    */
		this._system_time_ = doc.select("input[name=_system_time_]").first().attr("value");

	    /** 制御コード    */
		this.stat = doc.select("input[name=stat]").first().attr("value");

	    /** 手続きコード    */
		this.proc = doc.select("input[name=proc]").first().attr("value");

	    /** 画面コード    */
		this.pgCode = doc.select("input[name=pgCode]").first().attr("value");

	    /** アラートメッセージ    */
		if (d.select("div[class=att]").text().isEmpty() == false){
			this.att = d.select("div[class=att]").text();
		}

	    /** フォーカス項目    */
   		String[] splitItem = doc.data().split(";");			//case部をsplit
		boolean swFlg = false;								//switch文の出現フラグ

		String aaa = null;
		for (String a1 : splitItem){
//		    System.out.println(a1);
			if (a1.indexOf("var itemNo") != -1){
				aaa = a1.substring(a1.length()-3);				//フォーカスの項目No値を取得
			}
			if (a1.indexOf("switch(itemNo)") != -1){			//フォーカスのswitch文を検索
				swFlg = true;									//該当候補のswitch文発見
			}
			if (swFlg){											//フォーカス内の位置を検索
				
				if (a1.indexOf("}") != -1){
					swFlg=false;								//該当候補のswitch文終了
				}else{
					if (a1.indexOf("case "+ aaa) != -1){		//該当case位置を発見フォーカスが存在
						String[] a2 = a1.split("\\.");			//スピリット
						if (a2.length > 1 ){
							this.focusAtt = a2[1];				//ここで少し考慮しないと
						}
						swFlg=false;
					}
				}

				
			}

		}
		return this;
   	}

	/**
	 * システム時刻を設定します。
	 * @param system_time_ システム時刻
	 */
	public void set_system_time_(String system_time_) {
	    this._system_time_ = system_time_;
	}

	/**
	 * @return stat
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * @param stat セットする stat
	 */
	public void setStat(String stat) {
		this.stat = stat;
	}

	/**
	 * @return proc
	 */
	public String getProc() {
		return proc;
	}

	/**
	 * @param proc セットする proc
	 */
	public void setProc(String proc) {
		this.proc = proc;
	}

	/**
	 * @return pgCode
	 */
	public String getPgCode() {
		return pgCode;
	}

	/**
	 * @param pgCode セットする pgCode
	 */
	public void setPgCode(String pgCode) {
		this.pgCode = pgCode;
	}

	/**
	 * @return att
	 */
	public String getAtt() {
		return att;
	}

	/**
	 * @return focusAtt
	 */
	public String getFocusAtt() {
		return focusAtt;
	}


	/**
	 * @return _system_time_
	 */
	public String get_system_time_() {
		return _system_time_;
	}

	/**
	 * @param _system_time_ セットする _system_time_
	 */
//	public void set_system_time_(String _system_time_) {
//		this._system_time_ = _system_time_;
//	}

	//map(Get用)
	public Map<String, String> getMap(Map<String, String> map) {
		map.clear();
		map.put("_system_time_", this._system_time_);		//システムタイム（持回り項目なので後で変更するかも）
		map.put("stat", this.stat);							//ステータス（初期表示や、一覧表示など画面表示方法の生業?		）
		map.put("pgCode", this.pgCode);						//画面ID
		
		if (this.proc != null){
			map.put("proc", this.proc);						//処理コード(仮登録などで使用)
		}
		return map;
		
	}

	//map(POST用)
	public Map<String, String> postMap(Map<String, String> map) {
		this.getMap(map);
		return map;
		
	}

}
