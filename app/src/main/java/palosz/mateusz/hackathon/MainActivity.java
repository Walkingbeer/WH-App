package palosz.mateusz.hackathon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    Typeface custom_fonts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button_start);
        button2=findViewById(R.id.button_kupony);
        button3=findViewById(R.id.button_info);
        button4=findViewById(R.id.button_end);
        custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/theboldfont.ttf");
        button1.setTypeface(custom_fonts);
        button2.setTypeface(custom_fonts);
        button3.setTypeface(custom_fonts);
        button4.setTypeface(custom_fonts);
    }
}
