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
        MyGuelph Guelph = new MyGuelph("jordan","e77e58cf77e78e718f5dc2eb2cc177c4ef708fd1");
        
        //Returns JSON string of Current Guelph news

       /* ArrayList<GuelphNews> news = Guelph.getGuelphNews("BLANK");
        
        //Test results
        for(GuelphNews k:news){
        	System.out.println(k.toString());
        }*/
        GuelphMealPlan mealPlan = null;
        mealPlan = Guelph.getGuelphMealPlan("jbrobyn","kloC9Dsh");
        
        System.out.println(mealPlan.toString());
        
    }
}