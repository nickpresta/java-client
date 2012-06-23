package my.guelph.api;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuelphNews {
	private String id;
	private String category;
	private String content;
	private String date;
	private String uri;
	private String link;
	private String title;
	
	public GuelphNews(){
	}
	
	private void setCategory(String _category){
		category = _category;
	}
	private void setContent(String _content){
		content = _content;
	}
	private void setDate(String _date){
		date = _date;
	}
	private void setUri(String _uri){
		uri = _uri;
	}
	private void setLink(String _link){
		link = _link;
	}
	private void setTitle(String _title){
		title = _title;
	}
	private void setId(String _id){
		id = _id;
	}
	
	public String getCategory(){
		return category;
	}
	public String getContent(){
		return content;
	}
	public String getDate(){
		return date;
	}
	public String getUri(){
		return uri;
	}
	public String getLink(){
		return link;
	}
	public String getTitle(){
		return title;
	}
	public String getId(){
		return id;
	}
	
	//Returns a presentable format of information regarding this news object
	public String toString(){
		if(title != null)
			return id +"\n"+link+"\n"+date+"\n"+category+"\n"+title+"\n"+content+"\n"+uri;
		return null;
	}
	
	//Gets GuelphNews Array instead of a hashmap, may be easier to understand
	public ArrayList<GuelphNews> parseJSON(String jString) throws JSONException{
		
		try {
		    JSONObject jsonObject = new JSONObject(jString);
		    JSONArray objects = jsonObject.getJSONArray("objects");
		    
		    ArrayList<GuelphNews> news = new ArrayList<GuelphNews>();
		    
		    for(int i=0; i< objects.length(); i++){
		    	JSONObject jnewsObj = objects.getJSONObject(i);
		    	GuelphNews newsObj = new GuelphNews();
		    	newsObj.setCategory(jnewsObj.getString("category"));
		    	newsObj.setContent(jnewsObj.getString("content"));
		    	newsObj.setDate(jnewsObj.getString("datetime_published"));
		    	newsObj.setId(jnewsObj.getString("id"));
		    	newsObj.setLink(jnewsObj.getString("link"));
		    	newsObj.setTitle(jnewsObj.getString("title"));
		    	newsObj.setUri(jnewsObj.getString("resource_uri"));
		    	news.add(newsObj);
		    }
		 
		    return news;
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		return null;
	}
	
	
}
