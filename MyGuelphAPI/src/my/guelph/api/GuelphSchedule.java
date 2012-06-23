package my.guelph.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuelphSchedule {

	private String days;
	private String end_date;
    private String location;
    private String name;
    private String start_date;
    private String times;
    private String type;
    
    public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return this.name+"\n"+this.start_date+"\n"+this.end_date+"\n"+this.location+"\n"+this.type+"\n"+this.days;
	}

    
    
    //Return the list of courses the schedule information
	public ArrayList<GuelphSchedule> parseJSON(String jString) throws JSONException{
			
		try {
		    JSONObject jsonObject = new JSONObject(jString);
		    JSONArray objects = jsonObject.getJSONArray("schedule");
		    
		    ArrayList<GuelphSchedule> courses = new ArrayList<GuelphSchedule>();
		    
		    //Populate ArrayList
		    for(int i=0; i< objects.length(); i++){
		    	JSONObject jCourseObj = objects.getJSONObject(i);
		    	GuelphSchedule course = new GuelphSchedule();
		    	course.setDays(jCourseObj.getString("days"));
		    	course.setEnd_date(jCourseObj.getString("end_date"));
		    	course.setLocation(jCourseObj.getString("location"));
		    	course.setName(jCourseObj.getString("name"));
		    	course.setStart_date(jCourseObj.getString("start_date"));
		    	course.setTimes(jCourseObj.getString("times"));
		    	course.setType(jCourseObj.getString("type"));
		    	
		    	courses.add(course);
		    }
		 
		    return courses;
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		return null;
	}
}
