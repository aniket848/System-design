package Core;

import Device.IDeviceOutput;
import Managers.DeviceManager;
import Model.Song;
import Enum.DeviceType;

public class MusicAppFacade {

    private static MusicAppFacade instance = null;
    private AudioEngine audioEngine;
    private DeviceManager deviceManager;

    private MusicAppFacade(){
         //new MusicAppFacade();
         audioEngine = new AudioEngine();
         deviceManager = DeviceManager.getInstance();
    }

    public static MusicAppFacade getInstance(){
        if(instance == null){
            instance = new MusicAppFacade();
        }
        return instance;
    }

    public void PlaySong(Song song){
        IDeviceOutput deviceOutput = deviceManager.getConnectedDevice();
        if(deviceOutput == null){
            System.out.println("Please connect with device before playing music : "+song.getName());
            return;
        }
        audioEngine.play(deviceOutput,song);
    }

    public void pauseSong(Song song){
        audioEngine.pause(song);
    }

    public void connectDevice(DeviceType deviceType){
        deviceManager.connect(deviceType);
    }

}
