package Device;

import External.HeadphoneAPI;

import Model.Song;

public class HeadPhoneDeviceAdapter implements IDeviceOutput{

    private HeadphoneAPI headphoneAPI;

    public HeadPhoneDeviceAdapter(HeadphoneAPI headphoneAPI){
        this.headphoneAPI = headphoneAPI;
    }

    @Override
    public void playMusic(Song song) {
         headphoneAPI.playAudioViaHeadphone(song);
    }
}
