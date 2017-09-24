package edu.orangecoastcollege.cs273.balbert.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * EventDetailsActivity is a class which represents the second Controller of OC Music Events.
 * This Controller establishes connections to the widgets of its View, activity_event_details.xml.
 *
 * We instantiate and link up the various TextViews and ImageView.
 * We get the Intent provided from EventsListActivity and populate the appropriate widgets.
 *
 * An AssetManager is utilized to provide links to the appropriate images in the assets folder.
 *
 * When the user wants to return to the list, a button is provided that calls goBackToList,
 * which cleans up the memory and returns to the prior activity, EventsListActivity.
 */
public class EventDetailsActivity extends AppCompatActivity {

    /**
     * onCreate() is the work horse of this Class.
     * We set the content view from the respective View, activity_event_details.xml.
     * We create connections to the ImageView, Button and TextViews.
     *
     * An AssetManager is used to load the appropriate image, from the assets folder,
     * for the list item that was tapped.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Get the data out of the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        // Create references to the text views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

        // Use the Asset Manager to retrieve a file (image)
        AssetManager am = this.getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";
        // Use AssetManager to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
    }

    /**
     *
     * @param v is the View that called goBackToList
     *
     *          goBackToList is the method called when the user taps BACK TO LIST.
     *          Inside we call finish() to clean up the memory and return to the previous activity.
     *
     */
    protected void goBackToList(View v)
    {
        // Terminates the current activity ( DetailsActivity )
        finish();
    }
}
