package jp.co.dit.android.apps.HiCore.DataBean;

import java.util.Map;

/** ログイン時用 */
public class LOGINBean extends BaseBean {

    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    /** ユーザ情報    */
   	private String kinmuBushoCode = "";
	private String kinmuBushoName = "";
   	private String userId = "";
   	private String password = "";
   	private String actUser = "";

   	public LOGINBean(){
   		super();
   		
   		this.cls();

   	}
   	
   	void cls(){
   		super.cls();

   		//デフォルト値のセット
   		this.setPgCode("LOGIN");
   		this.setStat("11");
//   		this.set_system_time_("0");

   	   	/** ユーザ情報    */
   	   	kinmuBushoCode = "";
   		kinmuBushoName = "";
   	   	userId = "";
   	   	password = "";
   	   	actUser = "";
   	}
   	
   	/**
	 * @return kinmuBushoName
	 */
	public String getKinmuBushoName() {
		return kinmuBushoName;
	}
	/**
	 * @param kinmuBushoName セットする kinmuBushoName
	 */
	public void setKinmuBushoName(String kinmuBushoName) {
		this.kinmuBushoName = kinmuBushoName;
	}
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return actUser
	 */
	public String getActUser() {
		return actUser;
	}
	/**
	 * @param actUser セットする actUser
	 */
	public void setActUser(String actUser) {
		this.actUser = actUser;
	}
	/**
	 * @return kinmuBushoCode
	 */
	public String getKinmuBushoCode() {
		return kinmuBushoCode;
	}
	/**
	 * @param kinmuBushoCode セットする kinmuBushoCode
	 */
	public void setKinmuBushoCode(String kinmuBushoCode) {
		this.kinmuBushoCode = kinmuBushoCode;
	}

	public Map<String, String> getMap(Map<String, String> map) {
		super.getMap(map);
		
		map.put("kinmuBushoCode", this.kinmuBushoCode);
		map.put("kinmuBushoName", this.kinmuBushoName);
		map.put("userId", this.userId);
		map.put("password", this.password);
		map.put("actUser", this.actUser);

		return map;
	}

}
