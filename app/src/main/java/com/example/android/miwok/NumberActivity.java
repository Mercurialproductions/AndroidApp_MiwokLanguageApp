package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Sets the up button on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create an ArrayList of numbers

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));


        //Creates the custom array adapter

        WordAdapter adapter = new WordAdapter(this,R.layout.list_layout, numbers, R.color.category_numbers);

        //Configures the Custom adapter

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word number = numbers.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(NumberActivity.this,number.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        releaseMediaPlayer();
                    }
                });
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }


}
