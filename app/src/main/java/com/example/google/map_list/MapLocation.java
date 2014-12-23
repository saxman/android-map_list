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
