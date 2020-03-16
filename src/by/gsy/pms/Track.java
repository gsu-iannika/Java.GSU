package by.gsy.pms;

public class Track {
    private String name;
    private Double duration;
    private MusicStyles style;



    public Track(){
        this(null, 0.00, null);
    }

    public Track(String name, Double duration, MusicStyles style) {
        this.name = name;
        this.duration = duration;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public MusicStyles getStyle() {
        return style;
    }

    public void setStyle(MusicStyles style) {
        this.style = style;
    }

    public String toString(){
        return name + " ;" + duration + " ;" + style;
    }
}
