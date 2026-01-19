package External;

import Model.Song;

public class BluetoothDeviceAPI {

    public void playAudioViaBluetooth(Song song){
        System.out.println("'"+ song.getName()+ "' song is played by bluetooth");
    }
}
