package my.guelph.api;

import java.util.ArrayList;

import android.util.Log;

public class Test_Cases {

	public void testGetSchedule(MyGuelph guelph){
		 //Test GuelphSchedule Results---------------------------------------
        ArrayList<GuelphSchedule> schedule = guelph.getGuelphSchedule("jbrobyn", "kloC9Dsh");
        if(schedule != null){
	        for(GuelphSchedule k: schedule){
	        	System.out.println(k.getName());
	        }
        }else{
        	System.out.println("Uh Oh, there was an issue gathering schedule");
        }
	}
	
	public void testGetCourses(MyGuelph guelph){
		//Test GuelphCourses Results----------------------------------------
        ArrayList<GuelphCourses> courses = guelph.getGuelphCourses(20);
        if(courses != null){
	        for(GuelphCourses k:courses){
	        	
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "Courses returned "+courses.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the courses!");
        }
	}
	
	public void testGetNextCourses(MyGuelph guelph){
		ArrayList<GuelphCourses> courses = guelph.getNextGuelphCourses(20);
        if(courses != null){
	        for(GuelphCourses k:courses){
	        	
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "Courses next returned"+courses.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the courses!");
        }
	}
	
	public void testGetEvents(MyGuelph guelph){
		 //Test GuelphEvents Results----------------------------------------
        ArrayList<GuelphEvents> events = guelph.getGuelphEvents(0);
        if(events != null){
	        for(GuelphEvents k:events){
	        	
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "Events returned "+events.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the events!");
        }
	}
	
	public void testGetNextEvents(MyGuelph guelph){
		 //Test nextEvents-------------------------------------------------
		ArrayList<GuelphEvents> events = guelph.getNextGuelphEvents(0);
        if(events != null){
	        for(GuelphEvents k:events){
	        	
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "Events next returned "+events.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the events!");
        }
	}
	
	public void testGetNews(MyGuelph guelph){     
        //Test GuelphNews results--------------------------------------------
        ArrayList<GuelphNews> news = guelph.getGuelphNews(20);
        if(news != null){
	        for(GuelphNews k:news){
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "News returned "+news.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the news!");
        }
	}
	
	public void testGetNextNews(MyGuelph guelph){
		//Test GuelphNews next results--------------------------------------------
        ArrayList<GuelphNews> news = guelph.getNextGuelphNews(20);
        if(news != null){
	        for(GuelphNews k:news){
	        	System.out.println(k.getTitle()+" ID = "+k.getId());
	        }
	        Log.e("Display Length", "News next returned "+news.size());
        }else{
        	System.out.println("Uh Oh, there was a problem retrieving the news!");
        }
        
	}
	
	public void testGetMealPlan(MyGuelph guelph){
		//Test GuelphMealPlan Results----------------------------------------
		GuelphMealPlan mealPlan = null;
        mealPlan = guelph.getGuelphMealPlan("jbrobyn","kloC9Dsh");
        if(mealPlan != null)
        	System.out.println("Balance = "+mealPlan.getBalance());
        else
        	System.out.println("Uh Oh, no mealplan info was found!");
	}
	
	public void runFullTest(MyGuelph guelph){
		//Quick way to test all functionality
		testGetSchedule(guelph);
		testGetEvents(guelph);
		testGetNextEvents(guelph);
		testGetCourses(guelph);
		testGetNextCourses(guelph);
		testGetNews(guelph);
		testGetNextNews(guelph);
		testGetMealPlan(guelph);
	}


}
