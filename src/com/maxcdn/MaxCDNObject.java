package com.maxcdn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MaxCDNObject extends JSONObject {
	public int code;
	public boolean error = false;
	
	public MaxCDNObject() throws JSONException{
		super();
		//this.put(key, data);
		//code = this.getInt("code");
	}
	public MaxCDNObject(String json) throws JSONException{
		super(json);
		code = new JSONObject(json).getInt("code");	
		if(this.has("error")) error = true;
	}
	
	public String getErrorMessage(){
		return error ? this.getJson("error").getString("message") : null;
	}
	public MaxCDNObject(String key,Object data) throws JSONException{
		super();
		this.put(key, data);
		//code = this.getInt("code");
	}
	public MaxCDNObject(Object json) throws JSONException{
		super(((JSONObject)json).toString() );
		
	}
	
	public MaxCDNObject append(String key, Object value){
		try {
			this.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	public MaxCDNObject getJson(String key){
		try {
			return new MaxCDNObject(this.get(key));
		} catch (JSONException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Number getNumber(String key){
			return (Number) this.get(key);	
	}
	public String getString(String key){
			return (String) this.get(key);	
	}
	
	public Object get(String key){
		try {
			return  super.get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public JSONArray getArray(String key){
		try {
			return  this.getJSONArray(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
