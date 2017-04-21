package com.example.fc_app;

import android.graphics.Color;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.Polyline;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Polyline mMutablePolyline;
    private TextView textStatus;
    private LocationManager lms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng InSkyHotel = new LatLng(24.182847, 120.644943);
        LatLng iecs = new LatLng(24.179252, 120.649651);
        LatLng A = new LatLng(24.182310, 120.644913);
        LatLng B = new LatLng(24.182269, 120.638913);
        LatLng C = new LatLng(24.180529, 120.637776);
        LatLng D = new LatLng(24.179563, 120.637487);
        LatLng E = new LatLng(24.173840, 120.637428);
        LatLng F = new LatLng(24.170919, 120.636628);
        LatLng G = new LatLng(24.173603, 120.633101);


        mMap.addMarker(new MarkerOptions().position(InSkyHotel).title("InSky Hotel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(InSkyHotel));


        mMap.addMarker(new MarkerOptions().position(iecs).title("逢甲資電館"));

        mMutablePolyline = mMap.addPolyline(new PolylineOptions()
                .add(InSkyHotel,A,B,C,D,E,F,G)
                .width(12)
                .color(Color.BLUE)
                .clickable(true));
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18)); //放大地圖 18倍
    }
}
