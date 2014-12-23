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

package com.example.google.map_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MapLocationAdapter extends RecyclerView.Adapter<MapLocationViewHolder> {
    private final HashSet<MapView> mMaps = new HashSet<>();

    private ArrayList<MapLocation> mMapActivities;

    public MapLocationAdapter(List<MapLocation> mapActivities) {
        // Create an ArrayList since need to retrieve by index
        mMapActivities = new ArrayList<>(mapActivities.size());
        mMapActivities.addAll(mapActivities);
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
        MapLocation mapActivity = mMapActivities.get(position);

        viewHolder.itemView.setTag(mapActivity);

        viewHolder.title.setText(mapActivity.name);
        viewHolder.description.setText(mapActivity.lat + " " + mapActivity.lng);

        // Since the map is re-used, need to remove pre-existing map features.
        viewHolder.googleMap.clear();

        // Update the map feature data.
        LatLng coords = new LatLng(mapActivity.lat, mapActivity.lng);
        viewHolder.googleMap.addMarker(new MarkerOptions().position(coords));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(coords, 10f);
        viewHolder.googleMap.moveCamera(cameraUpdate);
    }

    @Override
    public int getItemCount() {
        return mMapActivities == null ? 0 : mMapActivities.size();
    }

    public HashSet<MapView> getMaps() {
        return mMaps;
    }
}
