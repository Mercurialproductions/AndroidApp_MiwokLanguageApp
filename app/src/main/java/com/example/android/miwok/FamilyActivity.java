package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        //Sets the up button on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create an ArrayList of numbers

        final ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("Father", "Epe", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("Mother", "Eta", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("Son", "Angsi", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("Daughter", "Tune", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("Older brother", "Taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("Younger brother", "Chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("Older sister", "Tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("Younger sister", "Kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("Grandmother", "Ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("Grandfather", "Paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        //Creates the custom array adapter

        WordAdapter adapter = new WordAdapter(this, R.layout.list_layout, family, R.color.category_family);

        //Configures the Custom adapter

        ListView listView = (ListView) findViewById(R.id.family_List);

        listView.setAdapter(adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word fam = family.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this,fam.getAudioResourceId());
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




