package my.guelph.api;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuelphCourses {
	private String id;
	private String code;
	private String credit;
	private String department;
	private String description;
	private String number;
	private String prerequisites;
	private String resource_uri;
	private String restrictions;
	private String semesters;
	private String title;
	
	public GuelphCourses(){
	}
	
	//Gets GuelphNews Array instead of a hashmap, may be easier to understand
	public ArrayList<GuelphCourses> parseJSON(String jString) throws JSONException{
		
		try {
		    JSONObject jsonObject = new JSONObject(jString);
		    JSONArray objects = jsonObject.getJSONArray("objects");
		    
		    ArrayList<GuelphCourses> courses = new ArrayList<GuelphCourses>();
		    
		    for(int i=0; i< objects.length(); i++){
		    	JSONObject jcoursesObj = objects.getJSONObject(i);
		    	GuelphCourses coursesObj = new GuelphCourses();
		    	coursesObj.setCode(jcoursesObj.getString("code"));
		    	coursesObj.setCredit(jcoursesObj.getString("credit"));
		    	coursesObj.setDepartment(jcoursesObj.getString("department"));
		    	coursesObj.setDescription(jcoursesObj.getString("description"));
		    	coursesObj.setId(jcoursesObj.getString("id"));
		    	coursesObj.setNumber(jcoursesObj.getString("number"));
		    	coursesObj.setPrerequisites(jcoursesObj.getString("prerequisites"));
		    	coursesObj.setResource_uri(jcoursesObj.getString("resource_uri"));
		    	coursesObj.setRestrictions(jcoursesObj.getString("restrictions"));
		    	coursesObj.setSemesters(jcoursesObj.getString("semesters"));
		    	coursesObj.setTitle(jcoursesObj.getString("title"));
		    	courses.add(coursesObj);
		    }
		 
		    return courses;
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the credit
	 */
	public String getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the prerequisites
	 */
	public String getPrerequisites() {
		return prerequisites;
	}

	/**
	 * @param prerequisites the prerequisites to set
	 */
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	/**
	 * @return the resource_uri
	 */
	public String getResource_uri() {
		return resource_uri;
	}

	/**
	 * @param resource_uri the resource_uri to set
	 */
	public void setResource_uri(String resource_uri) {
		this.resource_uri = resource_uri;
	}

	/**
	 * @return the restrictions
	 */
	public String getRestrictions() {
		return restrictions;
	}

	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	/**
	 * @return the semesters
	 */
	public String getSemesters() {
		return semesters;
	}

	/**
	 * @param semesters the semesters to set
	 */
	public void setSemesters(String semesters) {
		this.semesters = semesters;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GuelphCourses ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (code != null ? "code=" + code + ", " : "")
				+ (credit != null ? "credit=" + credit + ", " : "")
				+ (department != null ? "department=" + department + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (number != null ? "number=" + number + ", " : "")
				+ (prerequisites != null ? "prerequisites=" + prerequisites
						+ ", " : "")
				+ (resource_uri != null ? "resource_uri=" + resource_uri + ", "
						: "")
				+ (restrictions != null ? "restrictions=" + restrictions + ", "
						: "")
				+ (semesters != null ? "semesters=" + semesters + ", " : "")
				+ (title != null ? "title=" + title : "") + "]";
	}
	
	
}
