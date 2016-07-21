package jp.co.dit.android.apps.HiCore.DataBean;

import java.util.Map;

/** ログアウト時用 */
public class LOGOUTBean extends BaseBean {

    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

   	public LOGOUTBean(){
   		super();
   		this.cls();
   	}
   	
   	void cls(){
   		super.cls();

   		//デフォルト値のセット
   		this.setPgCode("LGOUT");
   		this.setStat("11");
   	}
   	

	public Map<String, String> getMap(Map<String, String> map) {
		super.getMap(map);

		return map;
	}

}
