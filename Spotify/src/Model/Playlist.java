package Model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String name;
    private List<Song> songList;

    public Playlist(String name){
        this.name = name;
        songList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void addSongs(Song song){
        songList.add(song);
    }

    public List<Song> getPlaylistSongs(){
        return songList;
    }

    public Integer getSize(){
        return songList.size();
    }
}
