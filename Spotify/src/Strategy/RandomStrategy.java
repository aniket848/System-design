package Strategy;

import Model.Playlist;
import Model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomStrategy extends PlaylistStrategy{

    private Playlist selectedPlaylist;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private Random random;

    public RandomStrategy(){
        random = new Random();
        selectedPlaylist = null;
        remainingSongs = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        selectedPlaylist = playlist;
        remainingSongs = selectedPlaylist.getPlaylistSongs();
    }

    @Override
    public Song playNext() {

        int ind = random.nextInt(remainingSongs.size());
        Song song = remainingSongs.get(ind);
        int lastInd = remainingSongs.size()-1;
        remainingSongs.set(ind,remainingSongs.get(lastInd));
        remainingSongs.remove(lastInd);
        history.push(song);
        return song;
    }

    @Override
    public Song playPrev() {
        return history.pop();
    }

    @Override
    public Boolean hasNext() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return false;
        }

        if(!remainingSongs.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public Boolean hasPrev() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return false;
        }

        if(history.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public String strategyName() {
        return "RANDOM";
    }
}
