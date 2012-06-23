package my.guelph.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;



public class MyGuelph{
	
	private String userID;
	private String key;
	
	//Set the userid and key to access the server;
	public MyGuelph(String _userID, String _key){
		userID = _userID;
		key = _key;
	}
	//Action to retrieve a ArrayList of GuelphNews objects
	public ArrayList<GuelphNews> getGuelphNews(){
		URL news = null;
		BufferedReader in = null;
		String inputLine;
		String jString = new String();
		
		try {
			news = new URL("https://apiguelph-nickpresta.dotcloud.com/api/v1/news/?username="+userID+"&api_key="+key+"&format=json");
			in = new BufferedReader(new InputStreamReader(news.openStream()));
			//Store the JSON String
			while ((inputLine = in.readLine()) != null){
			    jString+= inputLine;  
			}
			System.out.println(jString);
			in.close();
			
			//Return an Arraylist containing GuelphNews objects with relative information
			return new GuelphNews().parseJSON(jString);
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1){
			e1.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

		//Failed to get values... deal with it!
		return null;
	}
	
	public GuelphMealPlan getGuelphMealPlan(String user, String password){
	
		DefaultHttpClient client = new DefaultHttpClient();
		
		//Set the request url
        HttpGet request = new HttpGet("https://apiguelph-nickpresta.dotcloud.com/api/v1/mealplan/"+user+"/?format=json&username="+userID+"&api_key="+key);
        
        //Set authentication request
        client.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, password));
       
        //Execute get request
        try {
        	HttpResponse response = client.execute(request);
        	HttpEntity entity = response.getEntity();
            String jString = convertStreamToString(entity.getContent());
            
            //Returns a GuelphMealPlan object containing important information regarding the current plan and balance
            return new GuelphMealPlan().parseJSON(jString);
            
        } catch (ClientProtocolException e) {
            // TODO: Log this
        } catch (IOException e) {
            // TODO: Log this
        }
		
      //Failed to get values... deal with it!
		return null;
	}
	
	//Returns Schedule object with specific user courses
	public ArrayList<GuelphSchedule> getGuelphSchedule(String user, String password){
		
		DefaultHttpClient client = new DefaultHttpClient();
	
		//Set the request url
        HttpGet request = new HttpGet("https://apiguelph-nickpresta.dotcloud.com/api/v1/schedule/"+user+"/?format=json&username="+userID+"&api_key="+key);
        //Set authentication request
        client.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, password));
        
        //Send get request to server for json list of user courses
        try{
        	HttpResponse response = client.execute(request);
        	String jString	= convertStreamToString(response.getEntity().getContent());
        	
        	//Return an arraylist of courses in the users current schedule
        	return new GuelphSchedule().parseJSON(jString);
        	
        }catch(IOException e){
        	
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Failed to get values... deal with it!
        return null;
	}
	
	//Checks for network connectivity.... implement eventually
	/*public boolean isNetworkAvailable() {
	    ConnectivityManager cm = (ConnectivityManager) 
	    	getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
	    // if no network is available networkInfo will be null
	    // otherwise check if we are connected
	    if (networkInfo != null && networkInfo.isConnected()) {
	        return true;
	    }
	    return false;
	}*/
	
	private String convertStreamToString(InputStream inputStream) {
        return new Scanner(inputStream).useDelimiter("\\A").next();
    }
}
