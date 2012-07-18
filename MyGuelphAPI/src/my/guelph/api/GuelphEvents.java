package my.guelph.api;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuelphEvents {
	private String id;
	private String advanced_registration;
	private String contact;
	private String date;
	private String description;
	private String eligibility;
	private String event_format;
	private String instructors;
	private String link;
	private String location;
	private String maximum_attendance;
	private String more_information;
	private String organization;
	private String resource_uri;
	private String qualifies_as;
	private String time;
	private String title;
	private String topic;
	
	public GuelphEvents(){
	}
	
	/**
	 * @return ArrayList of guelph events with relative information\n See get functions for return variables
	 */
	public ArrayList<GuelphEvents> parseJSON(String jString) throws JSONException{
		
		try {
		    JSONObject jsonObject = new JSONObject(jString);
		    JSONArray objects = jsonObject.getJSONArray("objects");
		    
		    ArrayList<GuelphEvents> events = new ArrayList<GuelphEvents>();
		    
		    for(int i=0; i< objects.length(); i++){
		    	JSONObject jeventsObj = objects.getJSONObject(i);
		    	GuelphEvents eventsObj = new GuelphEvents();
		    	eventsObj.setAdvanced_registration(jeventsObj.getString("advanced_registration"));
		    	eventsObj.setId(jeventsObj.getString("id"));
		    	eventsObj.setContact(jeventsObj.getString("contact"));
		    	eventsObj.setDate(jeventsObj.getString("date"));
		    	eventsObj.setDescription(jeventsObj.getString("description"));
		    	eventsObj.setEligibility(jeventsObj.getString("eligibility"));
		    	eventsObj.setEvent_format(jeventsObj.getString("event_format"));
		    	eventsObj.setInstructors(jeventsObj.getString("instructors"));
		    	eventsObj.setLink(jeventsObj.getString("link"));
		    	eventsObj.setLocation(jeventsObj.getString("location"));
		    	eventsObj.setMaximum_attendance(jeventsObj.getString("maximum_attendance"));
		    	eventsObj.setMore_information(jeventsObj.getString("more_information"));
		    	eventsObj.setOrganization(jeventsObj.getString("organization"));
		    	eventsObj.setQualifies_as(jeventsObj.getString("qualifies_as"));
		    	eventsObj.setResource_uri(jeventsObj.getString("resource_uri"));
		    	eventsObj.setTime(jeventsObj.getString("time"));
		    	eventsObj.setTitle(jeventsObj.getString("title"));
		    	eventsObj.setTopic(jeventsObj.getString("topic"));
		    	
		    	events.add(eventsObj);
		    }
		 
		    return events;
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @return the advanced_registration
	 */
	public String getAdvanced_registration() {
		return advanced_registration;
	}

	/**
	 * @param advanced_registration the advanced_registration to set
	 */
	public void setAdvanced_registration(String advanced_registration) {
		this.advanced_registration = advanced_registration;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
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
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * @return the eligibility
	 */
	public String getEligibility() {
		return eligibility;
	}

	/**
	 * @param eligibility the eligibility to set
	 */
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	/**
	 * @return the event_format
	 */
	public String getEvent_format() {
		return event_format;
	}

	/**
	 * @param event_format the event_format to set
	 */
	public void setEvent_format(String event_format) {
		this.event_format = event_format;
	}

	/**
	 * @return the instructors
	 */
	public String getInstructors() {
		return instructors;
	}

	/**
	 * @param instructors the instructors to set
	 */
	public void setInstructors(String instructors) {
		this.instructors = instructors;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the maximum_attendance
	 */
	public String getMaximum_attendance() {
		return maximum_attendance;
	}

	/**
	 * @param maximum_attendance the maximum_attendance to set
	 */
	public void setMaximum_attendance(String maximum_attendance) {
		this.maximum_attendance = maximum_attendance;
	}

	/**
	 * @return the more_information
	 */
	public String getMore_information() {
		return more_information;
	}

	/**
	 * @param more_information the more_information to set
	 */
	public void setMore_information(String more_information) {
		this.more_information = more_information;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
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
	 * @return the qualifies_as
	 */
	public String getQualifies_as() {
		return qualifies_as;
	}

	/**
	 * @param qualifies_as the qualifies_as to set
	 */
	public void setQualifies_as(String qualifies_as) {
		this.qualifies_as = qualifies_as;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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
		return "GuelphEvents ["
				+ (title != null ? "title=" + title + ", " : "")
				+ (date != null ? "date=" + date + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (time != null ? "time=" + time + ", " : "")
				+ (maximum_attendance != null ? "maximum_attendance="
						+ maximum_attendance + ", " : "")
				+ (more_information != null ? "more_information="
						+ more_information + ", " : "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (advanced_registration != null ? "advanced_registration="
						+ advanced_registration + ", " : "")
				+ (contact != null ? "contact=" + contact + ", " : "")
				+ (eligibility != null ? "eligibility=" + eligibility + ", "
						: "")
				+ (event_format != null ? "event_format=" + event_format + ", "
						: "")
				+ (instructors != null ? "instructors=" + instructors + ", "
						: "")
				+ (link != null ? "link=" + link + ", " : "")
				+ (organization != null ? "organization=" + organization + ", "
						: "")
				+ (resource_uri != null ? "resource_uri=" + resource_uri + ", "
						: "")
				+ (qualifies_as != null ? "qualifies_as=" + qualifies_as + ", "
						: "") + (topic != null ? "topic=" + topic : "") + "]";
	}
	
	
}
