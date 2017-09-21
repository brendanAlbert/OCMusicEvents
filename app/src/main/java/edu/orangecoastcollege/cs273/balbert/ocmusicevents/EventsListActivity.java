package edu.orangecoastcollege.cs273.balbert.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * EventsListActivity is a class which represents one of the two Controllers.
 * This is the Controller for the first View the user sees, activity_events_list.xml.
 *
 *  It contains two methods, onCreate and onListItemClick.
 *
 *  onCreate(Bundle) remembers the previous state if the user minimizes our app.
 *  Inside we create a ListAdapter to display our event titles.
 *
 *  onListItemClick() is called when an item in the list is selected.
 */
public class EventsListActivity extends ListActivity {

    /**
     * We use onCreate to create a ListAdapter.
     * We are using a default built-in ListAdapter.
     * This populates the list with the titles of our music events.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Content has already been set for ListActivity
        //setContentView(R.layout.activity_events_list);

        // Define a built-in list adapter for this ListActivity:
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    /**
     * onListItemClick is a method we get for free by extending ListActivity. We have to
     * fill in the implementation details however.
     * @param l
     * @param v
     * @param position for our purposes, position is the only parameter used.
     *                 Position represents the element tapped.
     *                 We use this position to connect to the appropriate title and detail
     *                 from the Model.  These are set up as parallel String arrays.
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Use the position in the list to look up the position in the titles array.
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Create an Intent to go to DetailsActivity with the respective
        // title and details.
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);
        startActivity(detailsIntent);
    }
}
