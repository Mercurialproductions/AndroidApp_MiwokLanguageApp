package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A custom ArrayAdapter that can read the data in the word objects created by the word class.
 * The WordAdapter extends the ArrayAdapter
 */

public class WordAdapter extends ArrayAdapter<Word> {

 //WordAdapter Class field/s

    //mColorResourceId stores the background color resource id for each of the Activites as they each have different backgrounds that are set by the WordAdapter

        private int mColorResourceId;

//Constructor/s

    /**
     * A constructor that creates an WordAdapter object that is implemented in the Activity.java files of each Activity
     * @param context : the Activity context which in the activity will be defined as .this
     * @param list_layout: the list_layout resource id that will select the correct layout for the item view
     * @param arrayName : the name of the array in each activity
     * @param colorResourceId : the resource id for the specific background color to be stored in the Word object
     */

        public WordAdapter(Activity context, int list_layout, ArrayList<Word> arrayName, int colorResourceId) {
            super(context, 0, arrayName);// Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            mColorResourceId = colorResourceId;

        }

//Method's

    /**
     * A method that overrides the default getView method and gets the View by getting the row posstion, checking for a view if no view is found
     * if will inflate a new view. It also checks if the current view has an image view, and sets the image view in List_layout to gone
     * if no image view is found.
     * @param position : the row possition
     * @param convertView: the View in that row
     * @param parent : the parent of the view
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

     //finds or inflates a View

        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }

        // Get the object located at this position in the list
        Word currentWord = getItem(position);

     //Sets the Image for each row

        //Gets the id for the ImageView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        //Checks if the view has an image. if it doesn't it sets the ImageView to gone. if it does it sets the correct image to be displayed.
        if(currentWord.hasImage()) {

            imageView.setImageResource(currentWord.getImageResourceId()); //set the image in the image view

            imageView.setVisibility(View.VISIBLE); //set the image view to visible

        } else {

            imageView.setVisibility(View.GONE); //sets the image view to Gone so that it wont be visible as a space on the page
        }


    //Sets the Miwok text


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // set the text in the TextView to the Miwok word
        miwokTextView.setText(currentWord.getMiwokTranslation());

    //Sets the Default text

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // set the text in the TextView to the default translation
        defaultTextView.setText(currentWord.getDefaultTranslation());


    //sets the background color


        //sets the background colour for textContainer
        View textContainer = listItemView.findViewById(R.id.text_container);

        //finds the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //sets the background color to the textcontainer
        textContainer.setBackgroundColor(color);

        //sets the background color for playcontainer

        View playContainer = listItemView.findViewById(R.id.play_container);

        //sets the background color to the playcontainer

        playContainer.setBackgroundColor(color);

// Return statement

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}