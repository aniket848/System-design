package Managers;

import Factory.StrategyFactory;
import Model.Playlist;

import java.util.HashMap;
import java.util.List;

import Enum.StrategyType;
import Model.Song;
import Strategy.PlaylistStrategy;

public class PlaylistManager {

    private HashMap<String, Playlist> playlistHashMap;
    private static PlaylistManager instance = null;
    private PlaylistStrategy selectedStrategy;
    private StrategyFactory strategyFactory;

    private PlaylistManager(){
       // new PlaylistManager();
        selectedStrategy = null;
        playlistHashMap = new HashMap<>();
        strategyFactory = new StrategyFactory();
    }

    public static PlaylistManager getInstance(){
        if(instance == null){
            instance = new PlaylistManager();
        }
        return instance;
    }

    public void createPlaylist(String playlistName){
        if(!playlistHashMap.containsKey(playlistName)){
            playlistHashMap.put(playlistName,new Playlist(playlistName));
        }
    }

    public Playlist getPlaylistByName(String name){
        if(playlistHashMap.containsKey(name)){
            return playlistHashMap.get(name);
        }
        else{
            return null;
        }
    }

    public void addSongInPlaylist(String name, Song song){
        if(!playlistHashMap.containsKey(name)){
            System.out.println("No playlist exists with name: "+name);
            return;
        }
        playlistHashMap.get(name).addSongs(song);
    }

    public void setPlayingStrategy(StrategyType strategyType){
        selectedStrategy = strategyFactory.createStrategy(strategyType);
    }

    public PlaylistStrategy getCurrentPlaylistStrategy(){
        if(selectedStrategy == null){
            System.out.println("No playing strategy selected yet, please select one.");
            return null;
        }
        return selectedStrategy;
    }


}
