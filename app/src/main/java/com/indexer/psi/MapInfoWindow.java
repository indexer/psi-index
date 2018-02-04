package com.indexer.psi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapInfoWindow implements GoogleMap.InfoWindowAdapter {
    Context context;
    LayoutInflater inflater;

    @BindView(R.id.info)
    TextView textView;

    public MapInfoWindow(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // R.layout.echo_info_window is a layout in my
        // res/layout folder. You can provide your own
        View v = inflater.inflate(R.layout.info_window, null);
        ButterKnife.bind(this, v);
        textView.setText(marker.getSnippet());
        return v;
    }
}