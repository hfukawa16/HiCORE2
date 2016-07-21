package jp.co.dit.android.apps.HiCore.DataBean;

public class ConfigData {

    /** シリアルバージョンID */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    private String url = null;			//接続先設定
   	private String userId = null;		//接続ユーザ
   	private String password = null;		//接続パスワード

   	
	public ConfigData() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url セットする url
	 */
	public void setUrl(String url) {
		this.url = url;
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

}
