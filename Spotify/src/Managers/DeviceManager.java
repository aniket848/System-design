package Managers;

import Device.IDeviceOutput;
import Enum.DeviceType;
import Factory.DeviceFactory;

public class DeviceManager {

    private static DeviceManager instance = null;
    private IDeviceOutput currentConnectedDevice = null;
    private DeviceFactory deviceFactory;

    private DeviceManager(){
        //new DeviceManager();
        deviceFactory = new DeviceFactory();
    }

    public static DeviceManager getInstance(){
        if(instance == null){
            instance = new DeviceManager();
        }
        return instance;
    }

    public void connect(DeviceType deviceType){
        currentConnectedDevice = deviceFactory.createDevice(deviceType);
        System.out.println(deviceType.name() + " device connected successfully. ");
    }

    public IDeviceOutput getConnectedDevice(){
        if(currentConnectedDevice == null){
            System.out.println("Please connect device first. ");
            return null;
        }
        return currentConnectedDevice;
    }
}
