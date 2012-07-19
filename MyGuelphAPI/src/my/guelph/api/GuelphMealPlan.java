package my.guelph.api;

import org.json.JSONException;
import org.json.JSONObject;

public class GuelphMealPlan {

	private String type;
	private String balance;
	private String uri;
	
	public GuelphMealPlan() {
	}
	
	private void setType(String _type){
		type = _type;
	}
	
	private void setUri(String _uri){
		uri = _uri;
	}
	
	private void setBalance(String _balance){
		balance = _balance;
	}
	
	public String getType(){
		return type;
	}
	
	public String getUri(){
		return uri;
	}
	
	public String getBalance(){
		return balance;
	}
	
	public String toString(){
		return type+"\n"+balance+"\n"+uri;
	}
	
	//Create the and store the mealplan info
	public GuelphMealPlan parseJSON(String jString){
		
		try {
		    JSONObject jsonObject = new JSONObject(jString);
		    System.out.println(jsonObject.toString());
		    //Check for jsonString errors
		    
		    //Set and gather info from the jsonString
		    GuelphMealPlan mealInfo = new GuelphMealPlan();
		    mealInfo.setBalance(jsonObject.getString("balance"));
		    mealInfo.setType(jsonObject.getString("type"));
		    mealInfo.setUri(jsonObject.getString("resource_uri"));
		 
		    return mealInfo;
		    
		} catch (JSONException e) {
		    e.printStackTrace();
		    return null;
		}
	
	}
	
}
