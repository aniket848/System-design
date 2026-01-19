package External;

import Model.Song;

public class HeadphoneAPI {

    public void playAudioViaHeadphone(Song song){
        System.out.println("'" + song.getName() + "' song is played by Headphone... ");
    }
}
