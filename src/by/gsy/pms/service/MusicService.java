package by.gsy.pms.service;

import by.gsy.pms.music.MusicStyles;
import by.gsy.pms.music.Track;

import java.util.List;

public class MusicService {
    private static final String TOTAL_DURATION = "Total duration: ";
    public static final String MIN = " min";
    private Double duration = 0.0;

    public void getTrackList(List <Track> trackList){
        for (Track t : trackList){
            System.out.println(t.toString());
        }
        System.out.println();
    }

    public void getTotalDuration(List<Track> trackList) {
        for (Track track : trackList) {
            duration += track.getDuration();
        }
        System.out.println(TOTAL_DURATION + duration + MIN);
        System.out.println();
    }

    public void sortingByStyle(List<Track> trackList, MusicStyles styles){
        for (Track t : trackList){
            if (t.getStyle() == styles){
                System.out.println(t.toString());
            }
        }
        for (Track t : trackList){
            if (t.getStyle() != styles){
                System.out.println(t.toString());
            }
        }
        System.out.println();
    }

    public void findByRange(Double from, Double to, List<Track> trackList) {
        for (Track track : trackList) {
            if (track.getDuration() >= from && track.getDuration() <= to) {
                System.out.println(track.toString());
            }
        }
    }

}
