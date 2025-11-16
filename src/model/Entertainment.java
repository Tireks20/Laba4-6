package model;

import model.Device;

public class Entertainment extends Device {
    private String mediaType; 

    public Entertainment(String name, int power, String mediaType) {
        super(name, power);
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Media Type: " + mediaType;
    }
}