package blackHorseUtil;

import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import requestUtils.HttpRequest;

public class UserToken {
	private String UserName = null;
	
	
	
	public UserToken() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getUserToken(String userName) {
		StringBuilder stringBuilder = new StringBuilder("appId=3&reqId=3-`uuidgen`&userIp=10.15.54.204&exp=3600&userId=");
		stringBuilder.append(userName);
		JSONObject jsObject = JSONObject.fromObject(HttpRequest.sendGet("http://10.15.107.167/gettoken",stringBuilder.toString())) ;
		return (String) jsObject.get("token");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(UserToken.getUserToken("ycltest003"));
	}

}
