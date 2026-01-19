import Model.Song;
import Enum.*;

public class Main {
    public static void main(String[] args) {

        // Create instance of music application
        MyMusicApplication application = MyMusicApplication.getInstance();

        // create songs
        application.addSong(new Song("Main hu hero tera","Salman khan"));
        application.addSong(new Song("Sandeshe aate hai","Sonu nigam"));
        application.addSong(new Song("Tujhe kitna chahane lage hum","Arjit singh"));
        application.addSong(new Song("Raatan lambiyan","Jubin nautiyal"));
        application.addSong(new Song("Tu hi meri shab hai","K.K Menon"));


        // Play music without connected device
        application.playMusic("Sandeshe aate hai");

        // connect Device
        application.connectDevice(DeviceType.HEADPHONE);

        // Play and pause song
        application.playMusic("Sandeshe aate hai");
        application.pauseMusic("Sandeshe aate hai");
        application.playMusic("Sandeshe aate hai");

        // create playlist
        application.createPlaylist("Romantic");

        // Add songs in playlist
        application.addSongInPlaylist("Romantic","Tujhe kitna chahane lage hum");
        application.addSongInPlaylist("Romantic","Raatan lambiyan");
        application.addSongInPlaylist("Romantic","Main hu hero tera");
        application.addSongInPlaylist("Romantic","Tu hi meri shab hai");

        // select playlist
        application.loadPlaylist("Romantic");

        // select playlist playing strategy
        application.setPlaylistStrategy(StrategyType.RANDOM);

        // If strategy is custom, add songs you would like to play
        application.addSongsInCustomPlaylist("Tujhe kitna chahane lage hum");
        application.addSongsInCustomPlaylist("Main hu hero tera");

        // playAll songs in playlist
        application.playAll();

        application.playPrev();
        application.playPrev();
        application.playNext();

    }
}