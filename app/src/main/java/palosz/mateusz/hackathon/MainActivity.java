package palosz.mateusz.hackathon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    Typeface custom_fonts, title_custom_fonts;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button_start);
        button2=findViewById(R.id.button_kupony);
        button3=findViewById(R.id.button_info);
        button4=findViewById(R.id.button_end);
        custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/theboldfont.ttf");
        title_custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/yorkwhiteletter.ttf");
        button1.setTypeface(custom_fonts);
        button2.setTypeface(custom_fonts);
        button3.setTypeface(custom_fonts);
        button4.setTypeface(custom_fonts);

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

        title=findViewById(R.id.title);
        title.setTypeface(title_custom_fonts);
        getSupportActionBar().hide();

    }
}
