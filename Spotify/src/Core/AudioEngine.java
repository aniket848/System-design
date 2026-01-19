package Core;

import Device.IDeviceOutput;
import Model.Song;

public class AudioEngine {

    private Song currentSong;
    private Boolean isPaused;

    public AudioEngine(){
        currentSong = null;
        isPaused = false;
    }

    public void play(IDeviceOutput deviceOutput, Song song){

        if(currentSong!=null && currentSong.equals(song) && isPaused){
            System.out.println("Song resume. Playing: "+ song.getName());
            //deviceOutput.playMusic(song);
        }
        else{
            currentSong = song;
            deviceOutput.playMusic(song);
        }
        isPaused = false;

    }

    public void pause(Song song){
        if(currentSong!=null && currentSong.equals(song)){
            isPaused = true;
            System.out.println("Song paused. : "+song.getName());
        }
        else{
            System.out.println("No song is playing right now.");
        }
    }


}
