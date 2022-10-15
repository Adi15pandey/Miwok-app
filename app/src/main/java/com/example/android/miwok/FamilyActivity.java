package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaplayer;
    private MediaPlayer.OnCompletionListener mcompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
       final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "appa",R.raw.family_father));
        words.add(new Word("mother", "ata",R.raw.family_mother));
        words.add(new Word("son", "angsi",R.raw.family_son));
        words.add(new Word("daughter", "tune",R.raw.family_daughter));
        words.add(new Word(" older brother", "taachi",R.raw.family_older_brother));

        WordAdapter Adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaplayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceID());
                mMediaplayer.start();
                mMediaplayer.setOnCompletionListener(mcompletionListener);

            }
        });

    }
    private void releaseMediaPlayer() {
        if (mMediaplayer != null) {
            mMediaplayer.release();

            mMediaplayer = null;
        }
    }
}