package Device;

import External.WiredHeadsetAPI;
import Model.Song;

public class WiredDeviceAdapter implements IDeviceOutput{

    private WiredHeadsetAPI wiredHeadsetAPI;

    public WiredDeviceAdapter(WiredHeadsetAPI wiredHeadsetAPI){
        this.wiredHeadsetAPI = wiredHeadsetAPI;
    }

    @Override
    public void playMusic(Song song) {
        wiredHeadsetAPI.playAudioViaHeadset(song);
    }
}
