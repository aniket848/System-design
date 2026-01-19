package Strategy;

import Model.Playlist;
import Model.Song;

public class SequentialStrategy extends PlaylistStrategy{

    private Playlist selectedPlaylist;
    private Integer currentIndex;

    public SequentialStrategy(){
        selectedPlaylist = null;
        currentIndex = -1;
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        selectedPlaylist = playlist;
    }

    @Override
    public Song playNext() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return null;
        }

        currentIndex = currentIndex + 1;
        return selectedPlaylist.getPlaylistSongs().get(currentIndex);

    }

    @Override
    public Song playPrev() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return null;
        }

        currentIndex = currentIndex - 1;
        return selectedPlaylist.getPlaylistSongs().get(currentIndex);
    }

    @Override
    public Boolean hasNext() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return false;
        }
        if(currentIndex+1 >= selectedPlaylist.getSize())
            return false;
        else
            return true;
    }

    @Override
    public Boolean hasPrev() {
        if(selectedPlaylist == null){
            System.out.println("Please select playlist first");
            return false;
        }
        if(currentIndex-1 < 0)
            return false;
        else
            return true;
    }

    @Override
    public String strategyName() {
        return "SEQUENTIAL";
    }
}
