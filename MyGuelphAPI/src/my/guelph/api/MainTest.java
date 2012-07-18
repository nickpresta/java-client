package my.guelph.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainTest extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Create guelph object to control primary API functions
        MyGuelph Guelph = new MyGuelph("jordan","e77e58cf77e78e718f5dc2eb2cc177c4ef708fd1");
        
        //Returns JSON string of Current Guelph news
        
        //Test GuelphNews results--------------------------------------------
        ArrayList<GuelphNews> news = Guelph.getGuelphNews(20);
        if(news != null){
	        for(GuelphNews k:news){
	        	System.out.println(k.toString());
	        }
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the news!");
        }
        
        /*
        //Test GuelphMealPlan Results----------------------------------------
        GuelphMealPlan mealPlan = null;
        mealPlan = Guelph.getGuelphMealPlan("jbrobyn","kloC9Dsh");
        if(mealPlan != null)
        	System.out.println(mealPlan.toString());
        else
        	System.out.println("Uh Oh, no mealplan info was found!");
        	
        
        
        
        //Test GuelphSchedule Results---------------------------------------
        ArrayList<GuelphSchedule> schedule = Guelph.getGuelphSchedule("jbrobyn", "kloC9Dsh");
        if(schedule != null){
	        for(GuelphSchedule k: schedule){
	        	System.out.println(k.toString());
	        }
        }else{
        	System.out.println("Uh Oh, there was an issue gathering schedule");
        }
        */
        //Test GuelphEvents Results----------------------------------------
        ArrayList<GuelphEvents> events = Guelph.getGuelphEvents(0);
        if(events != null){
	        for(GuelphEvents k:events){
	        	
	        	System.out.println(k.toString());
	        }
	        Log.e("Display Length", ""+events.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the events!");
        }
        /*
      //Test GuelphCourses Results----------------------------------------
        ArrayList<GuelphCourses> courses = Guelph.getGuelphCourses(20);
        if(courses != null){
	        for(GuelphCourses k:courses){
	        	
	        	System.out.println(k.toString());
	        }
	        Log.e("Display Length", ""+events.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the courses!");
        }
        */
    }
}