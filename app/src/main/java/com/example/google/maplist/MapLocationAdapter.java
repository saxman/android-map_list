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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;

public class MapLocationAdapter extends RecyclerView.Adapter<MapLocationViewHolder> {
    private HashSet<MapView> mMaps = new HashSet<>();
    protected ArrayList<MapLocation> mMapLocations;

    public void setMapLocations(ArrayList<MapLocation> mapLocations) {
        mMapLocations = mapLocations;
    }

    @Override
    public MapLocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_item, viewGroup, false);
        MapLocationViewHolder viewHolder = new MapLocationViewHolder(viewGroup.getContext(), view);

        mMaps.add(viewHolder.map);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MapLocationViewHolder viewHolder, int position) {
        MapLocation mapLocation = mMapLocations.get(position);

        viewHolder.itemView.setTag(mapLocation);

        viewHolder.title.setText(mapLocation.name);
        viewHolder.description.setText(mapLocation.center.latitude + " " + mapLocation.center.longitude);

        // Since the map is re-used, need to remove pre-existing map features.
        viewHolder.googleMap.clear();

        // Update the map feature data and camera position.
        viewHolder.googleMap.addMarker(new MarkerOptions().position(mapLocation.center));

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(mapLocation.center, 10f);
        viewHolder.googleMap.moveCamera(cameraUpdate);
    }

    @Override
    public int getItemCount() {
        return mMapLocations == null ? 0 : mMapLocations.size();
    }

    public HashSet<MapView> getMaps() {
        return mMaps;
    }
}
