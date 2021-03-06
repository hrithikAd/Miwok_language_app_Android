package com.example.helloworld;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import static android.view.View.GONE;

public class WordAdapter extends ArrayAdapter<Word> {

    public MediaPlayer mediaPlayer = new MediaPlayer();

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            if (mediaPlayer != null) {

                mediaPlayer.release();

                mediaPlayer = null;
            }
        }
        };


    public WordAdapter(Activity context, ArrayList<Word> wordArrayList){
        super(context, 0, wordArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwok_text_view = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwok_text_view.setText(currentWord.getMiwokTranslation());

        TextView default_text_view = (TextView)listItemView.findViewById(R.id.default_text_view);
        default_text_view.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image_view);

        if(currentWord.hasImage()){

            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceId());

        }

        else{
            imageView.setVisibility(GONE);
        }

            listItemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {


                if (mediaPlayer != null) {
                    // Regardless of the current state of the media player, release its resources
                    // because we no longer need it.
                    mediaPlayer.release();

                    // Set the media player back to null. For our code, we've decided that
                    // setting the media player to null is an easy way to tell that the media player
                    // is not configured to play an audio file at the moment.
                    mediaPlayer = null;
                }

                mediaPlayer = MediaPlayer.create(getContext(),currentWord.getAudio());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mCompletionListener);


            }
            });



        return listItemView;
    }


}
