package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        //Sets the up button on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create an ArrayList of numbers

        final ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word("Where are you going?", "Minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?", "Tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...", "Oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?", "Michekses?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I'm feeling good!", "Kuchi achit.", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?", "Eenes'aa", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I'm coming.", "Hee'eenem", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I'm coming.", "Eenem", R.raw.phrase_im_coming));
        phrases.add(new Word("Let's go.", "Yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.", "Enni'nem", R.raw.phrase_come_here));


        //Creates the custom array adapter

        WordAdapter adapter = new WordAdapter(this,R.layout.list_layout, phrases, R.color.category_phrases);

        //Configures the Custom adapter

        ListView listView = (ListView) findViewById(R.id.phrases_List);

        listView.setAdapter(adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word ph = phrases.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this,ph.getAudioResourceId());
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

