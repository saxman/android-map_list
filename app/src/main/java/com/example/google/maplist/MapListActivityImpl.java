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

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MapListActivityImpl extends MapListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected MapLocationAdapter createMapListAdapter() {
        ArrayList<MapLocation> mapLocations = new ArrayList<>(LIST_LOCATIONS.length);
        mapLocations.addAll(Arrays.asList(LIST_LOCATIONS));

        MapLocationAdapter adapter = new MapLocationAdapter();
        adapter.setMapLocations(mapLocations);

        return adapter;
    }

    private static final MapLocation[] LIST_LOCATIONS = new MapLocation[]{
            new MapLocation("Beijing", 39.937795, 116.387224),
            new MapLocation("Bern", 46.948020, 7.448206),
            new MapLocation("Breda", 51.589256, 4.774396),
            new MapLocation("Brussels", 50.854509, 4.376678),
            new MapLocation("Cape Town", -33.920455, 18.466941),
            new MapLocation("Copenhagen", 55.679423, 12.577114),
            new MapLocation("Hannover", 52.372026, 9.735672),
            new MapLocation("Helsinki", 60.169653, 24.939480),
            new MapLocation("Hong Kong", 22.325862, 114.165532),
            new MapLocation("Istanbul", 41.034435, 28.977556),
            new MapLocation("Johannesburg", -26.202886, 28.039753),
            new MapLocation("Lisbon", 38.707163, -9.135517),
            new MapLocation("London", 51.500208, -0.126729),
            new MapLocation("Madrid", 40.420006, -3.709924),
            new MapLocation("Mexico City", 19.427050, -99.127571),
            new MapLocation("Moscow", 55.750449, 37.621136),
            new MapLocation("New York", 40.750580, -73.993584),
            new MapLocation("Oslo", 59.910761, 10.749092),
            new MapLocation("Paris", 48.859972, 2.340260),
            new MapLocation("Prague", 50.087811, 14.420460),
            new MapLocation("Rio de Janeiro", -22.90187, -43.232437),
            new MapLocation("Rome", 41.889998, 12.500162),
            new MapLocation("Sao Paolo", -22.863878, -43.244097),
            new MapLocation("Seoul", 37.560908, 126.987705),
            new MapLocation("Stockholm", 59.330650, 18.067360),
            new MapLocation("Sydney", -33.873651, 151.2068896),
            new MapLocation("Taipei", 25.022112, 121.478019),
            new MapLocation("Tokyo", 35.670267, 139.769955),
            new MapLocation("Tulsa Oklahoma", 36.149777, -95.993398),
            new MapLocation("Vaduz", 47.141076, 9.521482),
            new MapLocation("Vienna", 48.209206, 16.372778),
            new MapLocation("Warsaw", 52.235474, 21.004057),
            new MapLocation("Wellington", -41.286480, 174.776217),
            new MapLocation("Winnipeg", 49.875832, -97.150726)
    };
}
