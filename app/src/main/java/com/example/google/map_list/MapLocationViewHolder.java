package com.example.google.map_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

public class MapLocationViewHolder extends RecyclerView.ViewHolder {
    protected MapView map;
    protected TextView title;
    protected TextView description;

    protected GoogleMap googleMap;

    public MapLocationViewHolder(Context context, View view) {
        super(view);

        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        map = (MapView) view.findViewById(R.id.map);

        // Create the MapView and initialize the corresponding GoogleMap.
        // Should use MapView:getMapAsync() instead of MapView::getMap() (deprecated) to initialize
        // the GoogleMap; however, this ViewHolder can be bound to
        // (RecyclerView.Adapter::onBindViewHolder()) before the async onMapReady() callback
        // is called. onBindViewHolder() requires access to the GoogleMap for setting
        // map features, so there's a race condition.

        map.onCreate(null);

        MapsInitializer.initialize(context);

        googleMap = map.getMap();
        googleMap.getUiSettings().setMapToolbarEnabled(false);
    }
}