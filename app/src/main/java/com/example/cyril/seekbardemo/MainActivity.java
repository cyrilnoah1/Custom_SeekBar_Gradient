package com.example.cyril.seekbardemo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.telly.mrvector.MrVector;

public class MainActivity extends AppCompatActivity
{
    SeekBar mSeekBar; // SeekBar which changes background color based on the progress.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar= (SeekBar)findViewById(R.id.seekBar_with_custom_gradient_background);

        // Changing the SeekBar's colors, based on the progress
        seekBarBackgroundChanger();
    }

    /**
     * Method to change the background color of the SeekBar based
     * on the changes in the SeekBar Progress' value.
     */
    private void seekBarBackgroundChanger()
    {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                // Changing the background color of the SeekBar Thumb to Blue
                // when the progress is below 50%.
                if(progress <= 50)
                {
                    seekBar.setThumb(MrVector.inflate(getResources(), R.drawable.blue_seekbar_thumb) /*BLUE*/);
                }
                // Changing the SeekBar Thumb color to Red when the progress
                // is above 50%.
                else
                {
                    seekBar.setThumb(MrVector.inflate(getResources(), R.drawable.red_seekbar_thumb) /*BLUE*/);
                }

                /*
                * MrVector makes vector drawables support API 7+
                *
                * MrVector library:
                * https://github.com/telly/MrVector
                *
                * (Vector drawables have not been used in this project, but, this library is useful if
                * your project uses Vector drawables.)
                * */
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // Do your stuff...
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // Do your stuff...
            }
        });

    }

}
