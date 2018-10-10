package palosz.mateusz.hackathon;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class Mapa extends AppCompatActivity {

    TextView location_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        location_check = findViewById(R.id.location_check);
        // sprawdzenie, czy jest lokalizacja
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // nie ma lokalizacji

            ActivityCompat.requestPermissions(this, // pytamy o lokalizacje
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);

        }else{ // jest lokalizacja
            location_check.setText("Już była lokalizacja!");
        }


        Objects.requireNonNull(getSupportActionBar()).hide();
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

                    location_check.setText("Mamy lokalizację!");

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    location_check.setText("Nie mamy lokalizacji!");

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
