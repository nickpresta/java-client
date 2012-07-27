package my.guelph.api;



import java.util.ArrayList;

import com.korovyansk.android.slideout.SlideoutActivity;
import android.annotation.TargetApi;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class GuelphHome extends Activity {
    /** Called when the activity is first created. */
	ArrayList<GuelphEvents>news;
	ListView list;
	@TargetApi(11)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Create guelph obsject to control primary API functions
        MyGuelph Guelph = new MyGuelph("jordan","e77e58cf77e78e718f5dc2eb2cc177c4ef708fd1");
        
        
        //Performs a full test of basic features. Messages are displayed in LogCat
        //Individual tests can be performed, see function list
        /*
        Test_Cases test = new Test_Cases();
        test.runFullTest(Guelph);
        */
        
        //Begin Display Setup
        list=(ListView)findViewById(R.id.NewsList);
        news = Guelph.getGuelphEvents(0);
        LazyAdapterNews adapter = new LazyAdapterNews(this,news);
        list.setAdapter(adapter);
        //End Display Setup
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
	    	getActionBar().hide();
	    }
		findViewById(R.id.sample_button).setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
						SlideoutActivity.prepare(GuelphHome.this, R.id.inner_content, width);
						startActivity(new Intent(GuelphHome.this,MenuActivity.class));
						overridePendingTransition(0, 0);
					}
				});
        
    }
	
	public void displayEvent(View v){

		TextView view = (TextView)v.findViewById(R.id.title);
		System.out.println("You Pressed "+view.getTag());
	}
	
}