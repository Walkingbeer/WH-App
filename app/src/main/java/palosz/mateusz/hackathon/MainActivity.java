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
        custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/theboldfont.tff");
        //button1.setTypeface(Fonts);
    }
}
