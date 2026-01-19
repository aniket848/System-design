import Core.MusicAppFacade;
import Managers.PlaylistManager;
import Model.Playlist;
import Model.Song;

import java.util.ArrayList;
import java.util.List;
import Enum.*;
import Strategy.PlaylistStrategy;


public class MyMusicApplication {

   private static MyMusicApplication instance = null;
   private PlaylistManager playlistManager;
   private MusicAppFacade musicAppFacade;
   private List<Song> songList;
   private Playlist selectedPlaylist;
   private PlaylistStrategy selectedPlayingStrategy;

   private  MyMusicApplication(){
       //new MyMusicApplication();
       playlistManager = PlaylistManager.getInstance();
       musicAppFacade = MusicAppFacade.getInstance();
       songList = new ArrayList<>();
   }

   public static MyMusicApplication getInstance(){
       if(instance==null){
            instance = new MyMusicApplication();
       }
       return instance;
   }

   public void addSong(Song song){
       songList.add(song);
   }

   public Song getSong(String name){
       Song searchedSong = null;
       for(Song song:songList){
           if(song.getName().equals(name)){
               searchedSong = song;
               break;
           }
       }
       if(searchedSong == null){
           System.out.println("No song exist with name: "+name);
           return null;
       }
       return searchedSong;
   }

    public void connectDevice(DeviceType deviceType){
        musicAppFacade.connectDevice(deviceType);
    }

   public void playMusic(String songName){
       Song song = getSong(songName);
       musicAppFacade.PlaySong(song);
   }

   public void pauseMusic(String songName){
       Song song = getSong(songName);
       musicAppFacade.pauseSong(song);
   }

    public void createPlaylist(String playlistName){
        playlistManager.createPlaylist(playlistName);
    }

    public void addSongInPlaylist(String playListName, String songName){
       Song song = getSong(songName);
       playlistManager.addSongInPlaylist(playListName, song);
    }

   public void setPlaylistStrategy(StrategyType strategyType){
       if(selectedPlaylist !=null){
           playlistManager.setPlayingStrategy(strategyType);
           selectedPlayingStrategy = playlistManager.getCurrentPlaylistStrategy();
           selectedPlayingStrategy.setPlaylist(selectedPlaylist);
       }
       else{
           System.out.println("Please load playlist first before choosing playlist strategy.");
       }

   }

    public void loadPlaylist(String name){
        selectedPlaylist = playlistManager.getPlaylistByName(name);
    }

   public void playAll(){
       if(selectedPlaylist == null){
           System.out.println("Please select playlist first to play all music..");
           return;
       }
       if(selectedPlayingStrategy == null){
           System.out.println("Please select playing strategy before playing all music");
           return;
       }

       System.out.println("Playing all songs of Playlist: "+selectedPlaylist.getName() + ", with strategy: "+ selectedPlayingStrategy.strategyName());

       while(selectedPlayingStrategy.hasNext()){
           Song song = selectedPlayingStrategy.playNext();
           playMusic(song.getName());
       }

       if(!selectedPlayingStrategy.hasNext()){
           System.out.println("All songs are played.");
       }
   }//playAll


   public void playNext(){
       if(selectedPlaylist == null){
           System.out.println("Please select playlist first to play all music..");
           return;
       }
       PlaylistStrategy selectedStrategy = PlaylistManager.getInstance().getCurrentPlaylistStrategy();
       if(selectedStrategy == null){
           System.out.println("Please select playing strategy before playing all music");
           return;
       }

       if(selectedStrategy.hasNext()){
           Song song = selectedStrategy.playNext();
           playMusic(song.getName());
       }
       else{
           System.out.println("Playlist didn't have any further songs. ");
       }
   }

   public void playPrev(){
       if(selectedPlaylist == null){
           System.out.println("Please select playlist first to play all music..");
           return;
       }
       PlaylistStrategy selectedStrategy = PlaylistManager.getInstance().getCurrentPlaylistStrategy();
       if(selectedStrategy == null){
           System.out.println("Please select playing strategy before playing all music");
           return;
       }

       if(selectedStrategy.hasPrev()){
           Song song = selectedStrategy.playPrev();
           playMusic(song.getName());
       }
       else{
           System.out.println("Playlist didn't have any previous songs. ");
       }
   }

   public void addSongsInCustomPlaylist(String songName){
       Song song = getSong(songName);
       selectedPlayingStrategy.addSongInQueue(song);
   }

}
