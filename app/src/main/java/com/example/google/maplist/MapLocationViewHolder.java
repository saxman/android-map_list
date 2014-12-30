/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.google.maplist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

public class MapLocationViewHolder extends RecyclerView.ViewHolder {
    public MapView map;
    public TextView title;
    public TextView description;

    public GoogleMap googleMap;

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