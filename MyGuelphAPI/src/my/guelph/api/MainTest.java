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
        /* ArrayList<GuelphNews> news = Guelph.getGuelphNews();
        for(GuelphNews k:news){
        	System.out.println(k.toString());
        }*/
        
        //Test GuelphMealPlan Results----------------------------------------
        /*GuelphMealPlan mealPlan = null;
        mealPlan = Guelph.getGuelphMealPlan("jbrobyn","kloC9Dsh");
        System.out.println(mealPlan.toString());
        */
        
        //Test GuelphSchedule Results---------------------------------------
        ArrayList<GuelphSchedule> courses = Guelph.getGuelphSchedule("jbrobyn", "kloC9Dsh");
        for(GuelphSchedule k: courses){
        	System.out.println(k.toString());
        }
        
    }
}