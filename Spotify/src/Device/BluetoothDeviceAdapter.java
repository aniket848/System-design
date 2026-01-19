package Device;

import External.BluetoothDeviceAPI;

import Model.Song;

public class BluetoothDeviceAdapter implements IDeviceOutput {

    private BluetoothDeviceAPI bluetoothDeviceAPI;

    public BluetoothDeviceAdapter(BluetoothDeviceAPI bluetoothDeviceAPI){
        this.bluetoothDeviceAPI = bluetoothDeviceAPI;
    }

    @Override
    public void playMusic(Song song) {
        bluetoothDeviceAPI.playAudioViaBluetooth(song);
    }
}
