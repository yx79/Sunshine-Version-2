package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            ArrayList<String> weatherList = new ArrayList<>();
            weatherList.add("Today 10/3 - Sunny - 88 / 63");
            weatherList.add("Tomorrow 10/4 - Foggy - 70 / 46");
            weatherList.add("Weds 10/5 - Sunny - 88 / 63");
            weatherList.add("Thurs 10/6 - Sunny - 88 / 63");
            weatherList.add("Fri 10/7 - Sunny - 88 / 63");
            weatherList.add("Sat 10/8 - Sunny - 88 / 63");
            weatherList.add("Sun 10/9 - Sunny - 88 / 63");


            // Initialize a new ArrayAdapter
            mForecastAdapter = new ArrayAdapter<String>(
                    getActivity(),  // current context
                    R.layout.list_item_forecast,    // ID of list item layout
                    R.id.list_item_forecast_textview,   // ID of textview to populate
                    weatherList //  forecast dummy data
            );

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // get the reference of listview and attach the adapter
            ListView listview = (ListView) rootView.findViewById(R.id.listview_forecast);
            listview.setAdapter(mForecastAdapter);
            return rootView;
        }
    }
}
