package jp.co.dit.android.apps.HiCore.DataBean;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TAE120ListingElements {


    /** シリアルバージョンID */
    private static final long serialVersionUID = 1L;

    private String sinseiNitiji = null;			//申請日
    private String shouninJoutai = null;		//承認状況
    private String jizen = null;				//事前

    private String sinsei = null;				//申請内容
//    private String kaisu = null;				//回数
    private String kubunn = null;				//区分
    private String shouninKikan = null;				//申請期間
//  private String shouninTime = null;				//申請時刻
    private String shouninReson = null;				//理　由


	public TAE120ListingElements(Element e) {
		// TODO 自動生成されたコンストラクター・スタブ
		Elements aaa = e.select("td");
		this.sinseiNitiji =  e.select("td").get(0).text();
		this.shouninJoutai =  e.select("td").get(1).text();
		this.jizen =  e.select("td").get(2).text();
		this.sinsei =  e.select("td").get(3).text();
		this.kubunn =  e.select("td").get(5).text();
		this.shouninKikan =  e.select("td").get(6).text();
		this.shouninReson =  e.select("td").get(12).text();
//		System.out.println(aaa);


	
	}


}
