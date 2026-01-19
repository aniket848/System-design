package External;

import Model.Song;

public class WiredHeadsetAPI {

    public void playAudioViaHeadset(Song song){
        System.out.println("'" + song.getName() +"' song is played via headset... ");
    }
}
