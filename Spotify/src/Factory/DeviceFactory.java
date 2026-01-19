package Factory;

import Device.BluetoothDeviceAdapter;
import Device.HeadPhoneDeviceAdapter;
import Device.IDeviceOutput;
import Device.WiredDeviceAdapter;
import Enum.DeviceType;
import External.BluetoothDeviceAPI;
import External.HeadphoneAPI;
import External.WiredHeadsetAPI;

public class DeviceFactory {

    public IDeviceOutput createDevice(DeviceType deviceType){

        return switch (deviceType) {
            case BLUETOOTH -> new BluetoothDeviceAdapter(new BluetoothDeviceAPI());
            case WIRED_HEADSET -> new WiredDeviceAdapter(new WiredHeadsetAPI());
            default -> new HeadPhoneDeviceAdapter(new HeadphoneAPI());
        };
    }
}
