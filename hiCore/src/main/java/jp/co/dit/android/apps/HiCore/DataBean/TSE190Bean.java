package jp.co.dit.android.apps.HiCore.DataBean;
import org.jsoup.nodes.Document;

/**パスワード更新 (TSE190)*/
public class TSE190Bean extends BaseBean {


    /** シリアルバージョンID */
    private static final long serialVersionUID = 1L;

    /** パスワードのリミット？フラグ    */
   	private String passwdLimitFlg = null;

    /** 現パスワード    */
   	private String prePass = null;

    /** 新パスワード    */
   	private String newPass = null;

    /** 新パスワード（確認）    */
   	private String conPass = null;

    public TSE190Bean(){
   		super();

		this.cls();
	}
	
	void cls(){
		super.cls();

   		//デフォルト値のセット
   		this.setPgCode("TSE190");
   		this.setStat("2");

   	    /** パスワードのリミット？フラグ    */
   	   	passwdLimitFlg = null;

   	    /** 現パスワード    */
   	   	prePass = null;

   	    /** 新パスワード    */
   	   	newPass = null;

   	    /** 新パスワード（確認）    */
   	   	conPass = null;
	}
		   
   	
   	public TSE190Bean setDataconte(Document d) {
		super.setDataconte(d);

	    /** パスワードのリミット？フラグ    */
		this.passwdLimitFlg = d.select("input[name=passwdLimitFlg]").first().attr("value");
		
		

		return this;
	}



}
