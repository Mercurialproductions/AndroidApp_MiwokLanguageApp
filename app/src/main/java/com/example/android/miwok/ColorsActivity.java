package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //Sets the up button on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create an ArrayList of numbers

        final ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("Red", "Wetetti", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("Green", "Chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("Brown", "Takaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("Black", "Kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("White", "Kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("Dusty yellow", "Topisse", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("Mustard yellow", "Chiwitte", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));



        //Creates the custom array adapter

        WordAdapter adapter = new WordAdapter(this,R.layout.list_layout, colors, R.color.category_colors);

        //Configures the Custom adapter

        ListView listView = (ListView) findViewById(R.id.color_List);

        listView.setAdapter(adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word col = colors.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this,col.getAudioResourceId());
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

