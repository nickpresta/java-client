package my.guelph.api;

import java.util.ArrayList;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class LazyAdapterNews extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<?> data;
    private static LayoutInflater inflater=null;
 
    public LazyAdapterNews(Activity a, ArrayList<?> _data) {
        activity = a;
        data=_data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.rowlayoutnews, null);
 
        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView description = (TextView)vi.findViewById(R.id.description); // artist name
        TextView date = (TextView)vi.findViewById(R.id.date); // duration
 
        //Check data type to display
        if(data.get(position).getClass() == new GuelphNews().getClass()){
        	// Setting all values in listview
        	GuelphNews event = (GuelphNews) data.get(position);
        	title.setText(event.getTitle());
        	title.setTag(event.getId());
            description.setText(event.getCategory());
            date.setText(fixDate(event.getDate()));
        }else if(data.get(position).getClass() == new GuelphEvents().getClass()){
        	GuelphEvents event = (GuelphEvents) data.get(position);
        	title.setText(event.getTitle());
        	title.setTag(event.getId());
            description.setText(event.getEvent_format());
            date.setText(event.getDate());
        }
        
        return vi;
    }
    
    public String fixDate(String date){
    	String newDate = date.substring(0, date.indexOf('T'));
    	return newDate;
    }
}