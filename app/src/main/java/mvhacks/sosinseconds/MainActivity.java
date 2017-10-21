package mvhacks.sosinseconds;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.Places;

public class MainActivity extends AppCompatActivity {
    private final int MY_PERMISSIONS_REQUEST_USE_LOCATION = 3;


    private GeoDataClient geoData;
    private PlaceDetectionClient placeDetection;
    private FusedLocationProviderClient fusedLocationProvider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct a GeoDataClient.
        geoData = Places.getGeoDataClient(this, null);

        // Construct a PlaceDetectionClient.
        placeDetection = Places.getPlaceDetectionClient(this, null);

        // Construct a FusedLocationProviderClient.
        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(this);

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_USE_LOCATION);

    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_USE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay!

                } else {

                    // permission denied, boo! (Does nothing because app doesn't install if permission denied Android < 6.0)
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
