package jp.co.dit.android.apps.HiCore.DataBean;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**届出申請一覧 (TAE120)*/
public class TAE120Bean extends BaseBean {

    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

   	private String keijoYm = null;
   	private String sortColumn = null;
   	private String sortOrder = null;
   	private String key1 = null;
   	private String key2 = null;
   	private String key3 = null;
   	private String key4 = null;
   	private String kyuka_teate_kbn = null;

   	public TAE120Bean(){
   		super();
   		
   		this.cls();

   	}
   	
   	void cls(){
   		super.cls();

   		//デフォルト値のセット
   		this.setPgCode("TAE120");
   		this.setStat("11");
//   		this.set_system_time_("0");

   	   	keijoYm = null;
   	   	sortColumn = null;
   	   	sortOrder = null;
   	   	key1 = null;
   	   	key2 = null;
   	   	key3 = null;
   	   	key4 = null;
   	   	kyuka_teate_kbn = null;
   	}
   	
   	public TAE120Bean setDataconte(Document d) {
		super.setDataconte(d);

		//いつもの
		this.keijoYm = "";
		Elements aa = d.select("select[name=keijoYm]").first().getElementsByTag("option");
        for (Element aa1 : aa) {
       		if (aa1.getElementsByAttribute("selected").text().isEmpty() == false) {
       			this.keijoYm =  aa1.getElementsByAttribute("selected").val();
       			break;
       		}
        }

		
		this.sortColumn =  d.select("input[name=sortColumn]").first().attr("value");
		this.sortOrder =  d.select("input[name=sortOrder]").first().attr("value");
		this.key1 =  d.select("input[name=key1]").first().attr("value");
		this.key2 =  d.select("input[name=key2]").first().attr("value");
		this.key3 =  d.select("input[name=key3]").first().attr("value");
		this.key4 =  d.select("input[name=key4]").first().attr("value");
		this.kyuka_teate_kbn =  d.select("input[name=kyuka_teate_kbn]").first().attr("value");

	
		//申請一覧リスト
		Elements aaaaaa = d.select("table").get(7).select("tr[bgcolor=#FFFFFF]");
	
		TAE120ListingElements aaaa2;
        for (Element aa1 : aaaaaa) {
        	aaaa2 = new TAE120ListingElements(aa1);
        }
		
		return this;
	}

	/**
	 * keijoYmを取得します。
	 * @return keijoYm
	 */
	public String getKeijoYm() {
	    return keijoYm;
	}

	/**
	 * keijoYmを設定します。
	 * @param keijoYm keijoYm
	 */
	public void setKeijoYm(String keijoYm) {
	    this.keijoYm = keijoYm;
	}

	/**
	 * sortColumnを取得します。
	 * @return sortColumn
	 */
	public String getSortColumn() {
	    return sortColumn;
	}

	/**
	 * sortColumnを設定します。
	 * @param sortColumn sortColumn
	 */
	public void setSortColumn(String sortColumn) {
	    this.sortColumn = sortColumn;
	}

	/**
	 * sortOrderを取得します。
	 * @return sortOrder
	 */
	public String getSortOrder() {
	    return sortOrder;
	}

	/**
	 * sortOrderを設定します。
	 * @param sortOrder sortOrder
	 */
	public void setSortOrder(String sortOrder) {
	    this.sortOrder = sortOrder;
	}

	/**
	 * key1を取得します。
	 * @return key1
	 */
	public String getKey1() {
	    return key1;
	}

	/**
	 * key1を設定します。
	 * @param key1 key1
	 */
	public void setKey1(String key1) {
	    this.key1 = key1;
	}

	/**
	 * key2を取得します。
	 * @return key2
	 */
	public String getKey2() {
	    return key2;
	}

	/**
	 * key2を設定します。
	 * @param key2 key2
	 */
	public void setKey2(String key2) {
	    this.key2 = key2;
	}

	/**
	 * key3を取得します。
	 * @return key3
	 */
	public String getKey3() {
	    return key3;
	}

	/**
	 * key3を設定します。
	 * @param key3 key3
	 */
	public void setKey3(String key3) {
	    this.key3 = key3;
	}

	/**
	 * key4を取得します。
	 * @return key4
	 */
	public String getKey4() {
	    return key4;
	}

	/**
	 * key4を設定します。
	 * @param key4 key4
	 */
	public void setKey4(String key4) {
	    this.key4 = key4;
	}

	/**
	 * kyuka_teate_kbnを取得します。
	 * @return kyuka_teate_kbn
	 */
	public String getKyuka_teate_kbn() {
	    return kyuka_teate_kbn;
	}

	/**
	 * kyuka_teate_kbnを設定します。
	 * @param kyuka_teate_kbn kyuka_teate_kbn
	 */
	public void setKyuka_teate_kbn(String kyuka_teate_kbn) {
	    this.kyuka_teate_kbn = kyuka_teate_kbn;
	}



}
