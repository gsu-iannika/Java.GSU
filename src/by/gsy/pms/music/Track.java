package by.gsy.pms.music;

public class Track {
    private String name;
    private Double duration;
    private MusicStyles style;


    public Track(String name, Double duration, MusicStyles style) {
        this.name = name;
        this.duration = duration;
        this.style = style;
    }

    public Double getDuration() {
        return duration;
    }

    public MusicStyles getStyle() {
        return style;
    }

    public String toString(){
        return name + "; " + duration + "; " + style;
    }
}
