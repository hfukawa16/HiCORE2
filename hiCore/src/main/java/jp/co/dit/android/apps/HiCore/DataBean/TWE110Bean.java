package jp.co.dit.android.apps.HiCore.DataBean;
import java.util.HashMap;
import java.util.Map;

import jp.co.dit.android.apps.HiCore.StopWatch;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**勤務表入力 (TWE110)*/
public class TWE110Bean extends BaseBean {

    /** シリアルバージョンID */
    private static final long serialVersionUID = 1L;

    /** 処理対象年月    */
   	private String shoriYm = null;

	/** 最大行数    */
    private int maxRows = 0;

//	/** 勤務日付    */
 //  	private String kinmuDay =  null;

    /** リスト配列(Max31日分の勤務列データ）    */
//	private ArrayList<dataconte> pList;

	private Map<String, TWE110DailyEmployment> pList;

	
//    /** リスト配列(Max31日分の勤務列データ）    */
//    ArrayList<dataconte> pList = new ArrayList<dataconte>();
    
    public TWE110Bean(){
   		super();

		this.cls();
	}
	
	void cls(){
		super.cls();
   		//デフォルト値のセット
   		this.setPgCode("TWE110");
   		this.setStat("2");

   	    /** 処理対象年月    */
   	   	shoriYm = null;

   		/** 最大行数    */
   	    maxRows = 0;

   	    /** リスト配列(Max31日分の勤務列データ）    */
//   	    pList = new ArrayList<dataconte>();
   	   	pList = new HashMap<String, TWE110DailyEmployment>();
//   	    pList.clear();
	}

    public TWE110Bean setDataconte(Document doc) {
		super.setDataconte(doc);

		// 計測開始
		StopWatch.start();

		
		/** 日付    */
		Elements aa = doc.select("select[name=shoriYm]").first().getElementsByTag("option");
        for (Element aa1 : aa) {
       		if (aa1.getElementsByAttribute("selected").text().isEmpty() == false) {
       			this.shoriYm =  aa1.getElementsByAttribute("selected").val();
       		}
        }

		/** 最大行数    */
		this.maxRows =  Integer.parseInt( doc.select("input[name=maxRows]").first().attr("value") );

	    /** リスト配列(Max31日分の勤務列データ）    */
		for (int i = 0; i < this.maxRows; i++){
			
			/** 勤務日付    */
//			this.setKinmuDay(doc.select("input[name=kinmuDay" + i + "]").first().attr("value"));

			TWE110DailyEmployment ds = new TWE110DailyEmployment();	//インスタンス作成
			ds.setDailyRow(doc, i);
			//格納
//			pList.put(doc.select("input[name=kinmuDay" + i + "]").first().attr("value"), ds);
			pList.put(this.shoriYm + (i+1), ds);
//			this.shoriYm
		}

		// 計測終了
		StopWatch.printMilliTime(new Throwable().getStackTrace()[0].getMethodName() + " milli: ");

		
		
		return this;
	}


	/**
	 * @return shoriYm
	 */
	public String getShoriYm() {
		return shoriYm;
	}


	/**
	 * @param shoriYm セットする shoriYm
	 */
	public void setShoriYm(String shoriYm) {
		this.shoriYm = shoriYm;
	}

    public int getMaxRows() {
		return maxRows;
	}


	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	//map(POST用)
	public Map<String, String> postMap(Map<String, String> map) {

//		this.setStat("11");
//		this.setProc("2");

		//基底のセット
		super.postMap(map);

		//処理年月
		map.put("shoriYm", this.shoriYm);
		
		// 最大行数    
		map.put("maxRows", String.valueOf(pList.size()));
		
	    /* リスト配列(Max31日分の勤務列データ）    */
		int i =0;
		for (String key :  this.pList.keySet()) {
			this.pList.get(key).postMap(map, i);
	        i=i+1;
	    }

		return map;
		
	}

	/**
	 * @return pList
	 */
	public Map<String, TWE110DailyEmployment> getpList() {
		return pList;
	}

	/**
	 * @param pList セットする
	 */
	public void setpList(Map<String, TWE110DailyEmployment> pList) {
		this.pList = pList;
	}

}
