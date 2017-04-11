package com.programacion.robertomtz.fragmentosapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Negocio negocio;
    private double lat;
    private double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        negocio = null;
        if (bundle != null)
            negocio = (Negocio) bundle.get("negocio");
        else{
            Intent intent = new Intent(this, ViewPagerActivity.class);
            startActivity(intent);
        }

        lat = negocio.getLatitud();
        lon = negocio.getLongitud();
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

        // Agraga un marcador en la ubicacion del negocio y mueve la camara a el

        LatLng ubicacion = new LatLng(lat, lon);
        MarkerOptions marcador = new MarkerOptions().position(ubicacion).title(negocio.getNombre());
        mMap.addMarker(marcador);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 16.5f));

        AlertDialog.Builder buider = new AlertDialog.Builder(this);
        buider.setTitle("Informacion del Negocio").setMessage("Nombre: "+ negocio.getNombre() + "\nLatitud: " + lat + "\nLongitud: " + lon).
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();


    }
}
