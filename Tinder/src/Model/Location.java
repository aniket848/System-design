package Model;

public class Location {
    private Double lat;
    private Double lon;


    public Location(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public Double getDistance(Location loc){
        Double x = loc.getLat() - this.lat;
        Double y = loc.getLon() - this.lon;
        return Math.sqrt(x*x + y*y);
    }
}
