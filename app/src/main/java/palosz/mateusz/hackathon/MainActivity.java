package palosz.mateusz.hackathon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    Typeface custom_fonts, title_custom_fonts;
    TextView title;

    public void permissionCheck(){
        // sprawdzenie, czy jest lokalizacja
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // nie ma lokalizacji

            ActivityCompat.requestPermissions(this, // pytamy o lokalizacje
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);

        }else{ // jest lokalizacja
            Intent googleMap = new Intent(this,MapaActivity.class);
            startActivity(googleMap);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay!

                    Intent googleMap = new Intent(this,MapaActivity.class);
                    startActivity(googleMap);

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.


                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button_start);    // rozpocznij
        button2=findViewById(R.id.button_kupony);
        button3=findViewById(R.id.button_info);
        button4=findViewById(R.id.button_end);
        custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/theboldfont.ttf");
        title_custom_fonts=Typeface.createFromAsset(this.getAssets(),"fonts/yorkwhiteletter.ttf");
        button1.setTypeface(custom_fonts);
        button2.setTypeface(custom_fonts);
        button3.setTypeface(custom_fonts);
        button4.setTypeface(custom_fonts);

        button1.setOnClickListener(new View.OnClickListener() { // rozpocznij
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                permissionCheck();
            }
        });



        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });


        //tytul i ukrycie paska aplikacji
        title=findViewById(R.id.title);
        title.setTypeface(title_custom_fonts);


    }
}
