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

public class MapLocation {
    public float lat;
    public float lng;
    public String name;

    private MapLocation() {}

    public MapLocation(String name, float lat, float lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public MapLocation(String name, double lat, double lng) {
        this.name = name;
        this.lat = (float) lat;
        this.lng = (float) lng;
    }

    public static class Builder {
        private MapLocation item = new MapLocation();

        public Builder setName(String name) {
            item.name = name;
            return this;
        }

        public Builder setLat(float lat) {
            item.lat = lat;
            return this;
        }

        public Builder setLng(float lng) {
            item.lng = lng;
            return this;
        }

        public MapLocation build() {
            return item;
        }
    }
}
