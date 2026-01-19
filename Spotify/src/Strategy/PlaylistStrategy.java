package Strategy;

import Model.Playlist;
import Model.Song;

public abstract class PlaylistStrategy {

    public abstract void setPlaylist(Playlist playlist);
    public abstract Song playNext();
    public abstract Song playPrev();
    public abstract Boolean hasNext();
    public abstract Boolean hasPrev();
    public abstract String strategyName();
    public void addSongInQueue(Song song){}
}
