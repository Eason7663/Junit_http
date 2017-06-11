package fileOperator;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import blackHorseUtil.UserToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONExtrator {
	private String strSrc = null;
	private JsonObject jsObject = null;
	public JSONExtrator(JsonObject strJson) {
		this.jsObject = strJson;
		// TODO Auto-generated constructor stub
	}
	
	public JsonElement getValueObject(String strKey) {
		return jsObject.get(strKey);
	}
	
	public JSONArray getValueArray(String strKey) {
		JSONArray jsonArray = new JSONArray();

		return jsonArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try {
        	JsonParser parser=new JsonParser();  //´´½¨JSON½âÎöÆ÷
			JsonObject object=(JsonObject) parser.parse(new FileReader("dat\\result.txt"));
			JsonArray jsonArray = object.get("Data").getAsJsonObject().get("RepDataBlackHorseRecommend").getAsJsonArray();
			
			for (JsonElement jsonElement : jsonArray) {
				 
			}
			
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
