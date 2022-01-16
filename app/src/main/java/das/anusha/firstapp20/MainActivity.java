package das.anusha.firstapp20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //can find necessary parameters with Ctrl+P, and auto import/fix with Alt+Enter
        setContentView(R.layout.lesson1);
        //must register all activities in the manifest
//        incrementButton = findViewById(R.id.increment_button);
//        greetingDisplay = findViewById(R.id.greeting);
//        incrementButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("incrementing: "+ ++count);
//                Log.i("incrementing", ""+count);
//                greetingDisplay.setText(count+"");
//                //logging needs a tag and message
//                //can filter the logs. As lower priority shows. At a higher priority, will not
//            }
//        });
        //TODO generalize into method to make less redundant
        //get the views
        LinearLayout ln = (LinearLayout) findViewById(R.id.vid1_1);
        View myV = View.inflate(getApplicationContext(), R.layout.vidfrag, ln);
        VideoView mv1 = (VideoView) myV.findViewById(R.id.vid1);
        VideoView mv2 = (VideoView) myV.findViewById(R.id.vid2);
        AppCompatImageButton btn1 = (AppCompatImageButton) myV.findViewById(R.id.btn1);
        AppCompatImageButton btn2 = (AppCompatImageButton) myV.findViewById(R.id.btn2);
        //get the video and set to view
        String vidPath1 = "android.resource://" + getPackageName() + "/"+R.raw.bari;
        String vidPath2 = "android.resource://" + getPackageName() + "/"+R.raw.bhari;
        inflateVid(mv1, vidPath1, btn1);
        inflateVid(mv2, vidPath2, btn2);
    }

    private void inflateVid(VideoView mv1, String vidPath1, AppCompatImageButton btn1) {
        Uri uri = Uri.parse(vidPath1);
        mv1.setVideoURI(uri);
        //btn1.setZ(10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setVisibility(View.INVISIBLE);
                mv1.start();
            }
        });
        mv1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btn1.setVisibility(View.VISIBLE);
                mv1.resume();
            }
        });
        mv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) { //TODO fix audio
                //mv1.start();
                mp.setVolume(10, 10);
            }
        });
    }

    public void decrement(View view) {
        System.out.println("incrementing: "+ --count);
        greetingDisplay.setText(count+"");
    }
    //doing onClick from xml without findingByID and storing in variable

}