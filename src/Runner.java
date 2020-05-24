import by.gsy.pms.music.Track;
import by.gsy.pms.service.MusicService;

import java.util.ArrayList;
import java.util.List;

import static by.gsy.pms.music.MusicStyles.*;
import static by.gsy.pms.music.MusicStyles.POP;

public class Runner {
    public static void main(String[] args) {
        List<Track> trackList = new ArrayList<>();
        trackList.add(new Track("Ceza - Beatcoin", 3.55, RAP));
        trackList.add(new Track("Bobina feat. Susana - The Grey", 3.17, ROCK));
        trackList.add(new Track("Shakira - Waka waka", 3.22, POP));
        trackList.add(new Track("Norah Jones - Until The End", 3.56, JAZZ));
        trackList.add(new Track("Dua Lipa - Break My Heart", 3.41, POP));
        trackList.add(new Track("Halsey - Experiment On Me", 3.34, ROCK));
        trackList.add(new Track("Kevin Gates - Always Be Gangsta Freestyle", 3.09, RAP));
        trackList.add(new Track("Shaun Frank feat. Alicia Moffet - On Your Mind", 3.37, POP));
        trackList.add(new Track("Jay Electronica feat. Travis Scott - The Blinding", 2.48, HIPHOP));



        MusicService service = new MusicService();
        service.getTotalDuration(trackList);
        service.getTrackList(trackList);
        service.sortingByStyle(trackList, POP);
        service.findByRange(2.43, 3.18, trackList);



    }
}
