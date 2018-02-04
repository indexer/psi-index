package com.indexer.psi;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.indexer.psi.model.PsiReturnObject;
import com.indexer.psi.model.RegionMetadatum;
import com.indexer.psi.rest.RestClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener {

    @BindView(R.id.mToolbar)
    android.support.v7.widget.Toolbar mToolbar;


    @BindView(R.id.national_date)
    TextView national_data;

    @BindView(R.id.overall)
    TextView overall;

    ArrayList<RegionMetadatum> locationList = new ArrayList<>();
    LinkedHashMap westlhm = new LinkedHashMap<String, AtomicReference<StringBuilder>>();

    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.app_name);
        }

        mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.352083, 103.81983600000001), 12f));


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        Call<PsiReturnObject> callPsi = RestClient.getService(this).getPsiValueWithDate(dateFormat.format(date));
        callPsi.enqueue(new Callback<PsiReturnObject>() {
            @Override
            public void onResponse(@NonNull Call<PsiReturnObject> call, @NonNull Response<PsiReturnObject> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        locationList.addAll(response.body().getRegionMetadata());
                        Utils utils = new Utils();
                        Collections.sort(response.body().getItems());
                        //Assume that latest time stamp is update one
                        westlhm = utils.genereateSnippet(response.body().getItems().get(0));
                    }

                    overall.setText(R.string.nationwide);
                    national_data.setText(westlhm.get("national").toString());
                    national_data.setSelected(true);
                    for (int j = 0; j < locationList.size(); j++) {
                        {
                            switch (locationList.get(j).getName()) {
                                case "west":
                                    googleMap.addMarker(new MarkerOptions().position(new LatLng(locationList.get(j)
                                            .getLabelLocation().getLatitude(),
                                            locationList.get(j).getLabelLocation().getLongitude())).title
                                            (locationList.get(j).getName()).snippet(westlhm.get(locationList.get(j)
                                            .getName()).toString()));
                                case "central":
                                    googleMap.addMarker(new MarkerOptions().position(new LatLng(locationList.get(j)
                                            .getLabelLocation().getLatitude(),
                                            locationList.get(j).getLabelLocation().getLongitude())).title
                                            (locationList.get(j).getName()).snippet(westlhm.get(locationList.get(j)
                                            .getName()).toString()));
                                case "east":
                                    googleMap.addMarker(new MarkerOptions().position(new LatLng(locationList.get(j)
                                            .getLabelLocation().getLatitude(),
                                            locationList.get(j).getLabelLocation().getLongitude())).title
                                            (locationList.get(j).getName()).snippet(westlhm.get(locationList.get(j)
                                            .getName()).toString()));
                                case "south":
                                    googleMap.addMarker(new MarkerOptions().position(new LatLng(locationList.get(j)
                                            .getLabelLocation().getLatitude(),
                                            locationList.get(j).getLabelLocation().getLongitude())).title
                                            (locationList.get(j).getName()).snippet(westlhm.get(locationList.get(j)
                                            .getName()).toString()));
                                case "north":
                                    googleMap.addMarker(new MarkerOptions().position(new LatLng(locationList.get(j)
                                            .getLabelLocation().getLatitude(),
                                            locationList.get(j).getLabelLocation().getLongitude())).title
                                            (locationList.get(j).getName()).snippet(westlhm.get(locationList.get(j)
                                            .getName()).toString()));

                            }

                        }

                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<PsiReturnObject> call, @NonNull Throwable t) {

            }
        });


        googleMap.setInfoWindowAdapter(new MapInfoWindow(this));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowClickListener(this);

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        marker.hideInfoWindow();
    }
}
