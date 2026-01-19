package Strategy;

import Model.Playlist;
import Model.Song;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CustomStrategy extends PlaylistStrategy {

    private Integer currentIndex;
    private Playlist selectedPlaylist;
    private Queue<Song> songQueue;
    private Stack<Song> history;

    public CustomStrategy(){
        songQueue = new LinkedList<>();
        history = new Stack<>();
        currentIndex = -1;
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        selectedPlaylist = playlist;
    }

    @Override
    public Song playNext() {

        if(!songQueue.isEmpty()){
            Song songToPlayed = songQueue.poll();
            for(int i=0;i< selectedPlaylist.getSize();i++){
                if(selectedPlaylist.getPlaylistSongs().get(i).equals(songToPlayed)){
                    currentIndex = i;
                    break;
                }
            }//for
            history.push(songToPlayed);
            //currentIndex = currentIndex+1;
            return songToPlayed;
        }

        return nextSequential();
    }

    public Song nextSequential(){

        if(currentIndex+1 < selectedPlaylist.getSize()){
            currentIndex = currentIndex+1;
            Song song = selectedPlaylist.getPlaylistSongs().get(currentIndex);
            return song;
        }
        else{
            System.out.println("All songs are played...");
            return null;
        }
    }

    @Override
    public Song playPrev() {
        if(!history.isEmpty()){
            Song songToPlayed = history.pop();
            for(int i=0;i< selectedPlaylist.getSize();i++){
                if(selectedPlaylist.getPlaylistSongs().get(i).equals(songToPlayed)){
                    currentIndex = i;
                    break;
                }
            }//for
            //currentIndex = currentIndex-1;
            return songToPlayed;
        }

        return prevSequential();
    }

    public Song prevSequential(){
        if(currentIndex-1 >= 0){
            currentIndex = currentIndex - 1;
            Song song = selectedPlaylist.getPlaylistSongs().get(currentIndex);
            return song;
        }
        else{
            System.out.println("All songs are played...");
            return null;
        }
    }

    @Override
    public Boolean hasNext() {
        return currentIndex+1 < selectedPlaylist.getSize();
    }

    @Override
    public Boolean hasPrev() {
        return currentIndex-1 >=0;
    }

    @Override
    public String strategyName() {
        return "CUSTOM";
    }

    public void addSongInQueue(Song song){
        songQueue.add(song);
    }
}
