package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColourActivity extends AppCompatActivity {
    private MediaPlayer mMediaplayer;
    private MediaPlayer.OnCompletionListener mcompletionListener = new MediaPlayer.OnCompletionListener() {
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

        words.add(new Word("red", "weteti", R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiita", R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "topiisa", R.raw.color_dusty_yellow));
        words.add(new Word("black", "kululli", R.raw.color_black));
        words.add(new Word("white", "kelilli", R.raw.color_white));

        WordAdapter Adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaplayer = MediaPlayer.create(ColourActivity.this, word.getmAudioResourceID());
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