package fileOperator;

import net.sf.json.JSONObject;

public class JSONExtrator {
	private String strSrc = null;
	private JSONObject jsObject = null;
	public JSONExtrator(String strSrc) {
		jsObject = new JSONObject().fromObject(strSrc);
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject getValue(String strKey) {
		
		return jsObject.getJSONObject(strKey);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
