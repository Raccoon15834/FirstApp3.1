package das.anusha.firstapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //can find necessary parameters with Ctrl+P, and auto import/fix with Alt+Enter
        setContentView(R.layout.activity_main);
        //must register all activities in the manifest
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("incrementing: "+ ++count);
                Log.i("incrementing", ""+count);
                greetingDisplay.setText(count+"");
                //logging needs a tag and message
                //can filter the logs. As lower priority shows. At a higher priority, will not
            }
        });
    }
    public void decrement(View view) {
        System.out.println("incrementing: "+ --count);
        greetingDisplay.setText(count+"");
    }
    //doing onClick from xml without findingByID and storing in variable
}