package blackHorse;

import java.util.List;

import blackHorseUtil.UserToken;

public class UserSetRequsetURL {
	private String strHost;
	private String strPath;
	private String token;
	private String usertoken;
	private String pool;
	private String prefer;
	private String stock;
	public UserSetRequsetURL(String strHost, String strPath, String token, String username, 
			String pool, String prefer, String stock) {
		// TODO Auto-generated constructor stub
		this.strHost = strHost;
		this.strPath = strPath;
		this.token = token;
		this.usertoken = UserToken.getUserToken(username);
		this.pool = pool;
		this.prefer = prefer;
		this.stock = stock;
	}
	
	public String getStrHost() {
		return strHost;
	}

	public String getStrPath() {
		return strPath;
	}

	public String getToken() {
		return token;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public String getPool() {
		return pool;
	}

	public String getPrefer() {
		return prefer;
	}

	public String getStock() {
		return stock;
	}

	public void setStrHost(String strHost) {
		this.strHost = strHost;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String toString(){
		StringBuilder strUrl = new StringBuilder();
		strUrl.append(getStrHost());
		strUrl.append(getStrPath());
		strUrl.append("?");
		strUrl.append("token=");
		strUrl.append(getToken());
		strUrl.append("&usertoken=");
		strUrl.append(getUsertoken());
		strUrl.append("&pool=");
		strUrl.append(getPool());
		return strUrl.toString();
	}
	
	public String preferUrl(String strPrefer) {
		StringBuilder strUrl = new StringBuilder(this.toString());
		strUrl.append("&prefer=");
		strUrl.append(strPrefer);
		return strUrl.toString();
	}
	
	public String stockUrl(String strStock) {
		StringBuilder strUrl = new StringBuilder(this.toString());
		strUrl.append("&Stock=");
		strUrl.append(strStock);
		return strUrl.toString();
	}
	
	public String stockUrl() {
		StringBuilder strUrl = new StringBuilder(this.toString());
		strUrl.append("&Stock=");
		strUrl.append(getStock());
		return strUrl.toString();
	}
}
