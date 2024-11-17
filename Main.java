import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class SmartHomeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light[] lights = {
                new Light(Status.ON,false,BrightnessLevel.LOW,LightColor.YELLOW),
                new Light(Status.ON,false,BrightnessLevel.LOW,LightColor.YELLOW),
                new Light(Status.ON,false,BrightnessLevel.LOW,LightColor.YELLOW),
                new Light(Status.ON,false,BrightnessLevel.LOW,LightColor.YELLOW)
        };
        Camera[] cameras = {
                new Camera(Status.ON,false,false,45),
                new Camera(Status.ON,false,false,45)
        };
        Heater[] heaters = {
                new Heater(Status.ON,20),
                new Heater(Status.ON,20),
                new Heater(Status.ON,20),
                new Heater(Status.ON,20)
        };
        lights[0].setDeviceId(0);
        lights[1].setDeviceId(1);
        lights[2].setDeviceId(2);
        lights[3].setDeviceId(3);
        cameras[0].setDeviceId(4);
        cameras[1].setDeviceId(5);
        heaters[0].setDeviceId(6);
        heaters[1].setDeviceId(7);
        heaters[2].setDeviceId(8);
        heaters[3].setDeviceId(9);
        String command;
        while (scanner.hasNextLine()) {
            command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if (tokens[0].equals("DisplayAllStatus")) {
                if (tokens.length == 1){
                    //Lights
                    System.out.println(lights[0].displayStatus());
                    System.out.println(lights[1].displayStatus());
                    System.out.println(lights[2].displayStatus());
                    System.out.println(lights[3].displayStatus());
                    //Cameras
                    System.out.println(cameras[0].displayStatus());
                    System.out.println(cameras[1].displayStatus());
                    //Heaters
                    System.out.println(heaters[0].displayStatus());
                    System.out.println(heaters[1].displayStatus());
                    System.out.println(heaters[2].displayStatus());
                    System.out.println(heaters[3].displayStatus());
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("TurnOn")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            lights[0].turnOn();
                        }else if (tokens[2].equals("1")){
                            lights[1].turnOn();
                        }else if (tokens[2].equals("2")){
                            lights[2].turnOn();
                        }else if (tokens[2].equals("3")){
                            lights[3].turnOn();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")){
                            cameras[0].turnOn();
                        }else if (tokens[2].equals("5")){
                            cameras[1].turnOn();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")){
                            heaters[0].turnOn();
                        }else if (tokens[2].equals("7")){
                            heaters[1].turnOn();
                        }else if (tokens[2].equals("8")){
                            heaters[2].turnOn();
                        }else if (tokens[2].equals("9")){
                            heaters[3].turnOn();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }
                else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("TurnOff")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")) {
                        if (tokens[2].equals("0")) {
                            lights[0].turnOff();
                        }else if (tokens[2].equals("1")) {
                            lights[1].turnOff();
                        }else if (tokens[2].equals("2")) {
                            lights[2].turnOff();
                        }else if (tokens[2].equals("3")) {
                            lights[3].turnOff();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")) {
                            cameras[0].turnOff();
                        }else if (tokens[2].equals("5")) {
                            cameras[1].turnOff();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")) {
                            heaters[0].turnOff();
                        }else if (tokens[2].equals("7")) {
                            heaters[1].turnOff();
                        }else if (tokens[2].equals("8")) {
                            heaters[2].turnOff();
                        }else if (tokens[2].equals("9")) {
                            heaters[3].turnOff();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("StartCharging")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            lights[0].startCharging();
                        }else if (tokens[2].equals("1")){
                            lights[1].startCharging();
                        }else if (tokens[2].equals("2")){
                            lights[2].startCharging();
                        }else if (tokens[2].equals("3")){
                            lights[3].startCharging();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")) {
                            cameras[0].startCharging();
                        }else if (tokens[2].equals("5")) {
                            cameras[1].startCharging();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")) {
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("7")) {
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("8")) {
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("9")) {
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not chargeable");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("StopCharging")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            lights[0].stopCharging();
                        }else if (tokens[2].equals("1")){
                            lights[1].stopCharging();
                        }else if (tokens[2].equals("2")){
                            lights[2].stopCharging();
                        }else if (tokens[2].equals("3")){
                            lights[3].stopCharging();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")) {
                            cameras[0].stopCharging();
                        }else if (tokens[2].equals("5")) {
                            cameras[1].stopCharging();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")) {
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("7")) {
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("8")) {
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not chargeable");
                        }else if (tokens[2].equals("9")) {
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not chargeable");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("SetTemperature")){
                if (tokens.length == 4 && tokens[3].matches("\\d+") && tokens[2].matches("\\d+")){
                    int temperature=Integer.parseInt(tokens[3]);
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            System.out.println("Light "+lights[0].getDeviceId()+" is not a heater");
                        }else if (tokens[2].equals("1")){
                            System.out.println("Light "+lights[1].getDeviceId()+" is not a heater");
                        }else if (tokens[2].equals("2")){
                            System.out.println("Light "+lights[2].getDeviceId()+" is not a heater");
                        }else if (tokens[2].equals("3")){
                            System.out.println("Light "+lights[3].getDeviceId()+" is not a heater");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")){
                            System.out.println("Camera "+cameras[0].getDeviceId()+" is not a heater");
                        }else if (tokens[2].equals("5")){
                            System.out.println("Camera "+cameras[1].getDeviceId()+" is not a heater");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")) {
                        if (tokens[2].equals("6")) {
                            heaters[0].setTemperature(temperature);
                        }else if (tokens[2].equals("7")) {
                            heaters[1].setTemperature(temperature);
                        }else if (tokens[2].equals("8")) {
                            heaters[2].setTemperature(temperature);
                        }else if (tokens[2].equals("9")) {
                            heaters[3].setTemperature(temperature);
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("SetBrightness")){
                if (tokens.length == 4 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            if (tokens[3].equals("LOW")){
                                lights[0].setBrightnessLevel(BrightnessLevel.LOW);
                            }else if (tokens[3].equals("MEDIUM")){
                                lights[0].setBrightnessLevel(BrightnessLevel.MEDIUM);
                            }else if (tokens[3].equals("HIGH")){
                                lights[0].setBrightnessLevel(BrightnessLevel.HIGH);
                            }else{
                                System.out.println("The brightness can only be one of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                            }
                        }else if (tokens[2].equals("1")){
                            if (tokens[3].equals("LOW")){
                                lights[1].setBrightnessLevel(BrightnessLevel.LOW);
                            }else if (tokens[3].equals("MEDIUM")){
                                lights[1].setBrightnessLevel(BrightnessLevel.MEDIUM);
                            }else if (tokens[3].equals("HIGH")){
                                lights[1].setBrightnessLevel(BrightnessLevel.HIGH);
                            }else{
                                System.out.println("The brightness can only be one of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                            }
                        }else if (tokens[2].equals("2")){
                            if (tokens[3].equals("LOW")){
                                lights[2].setBrightnessLevel(BrightnessLevel.LOW);
                            }else if (tokens[3].equals("MEDIUM")){
                                lights[2].setBrightnessLevel(BrightnessLevel.MEDIUM);
                            }else if (tokens[3].equals("HIGH")){
                                lights[2].setBrightnessLevel(BrightnessLevel.HIGH);
                            }else{
                                System.out.println("The brightness can only be one of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                            }
                        }else if (tokens[2].equals("3")){
                            if (tokens[3].equals("LOW")){
                                lights[3].setBrightnessLevel(BrightnessLevel.LOW);
                            }else if (tokens[3].equals("MEDIUM")){
                                lights[3].setBrightnessLevel(BrightnessLevel.MEDIUM);
                            }else if (tokens[3].equals("HIGH")){
                                lights[3].setBrightnessLevel(BrightnessLevel.HIGH);
                            }else{
                                System.out.println("The brightness can only be one of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                            }
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")){
                            System.out.println("Camera "+cameras[0].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("5")){
                            System.out.println("Camera "+cameras[1].getDeviceId()+" is not a light");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")) {
                        if (tokens[2].equals("6")){
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("7")){
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("8")){
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("9")){
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not a light");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("SetColor")){
                if (tokens.length == 4 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            if (tokens[3].equals("WHITE")){
                                lights[0].setLightColor(LightColor.WHITE);
                            }else if (tokens[3].equals("YELLOW")){
                                lights[0].setLightColor(LightColor.YELLOW);
                            }else{
                                System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                            }
                        }else if (tokens[2].equals("1")){
                            if (tokens[3].equals("WHITE")){
                                lights[1].setLightColor(LightColor.WHITE);
                            }else if (tokens[3].equals("YELLOW")){
                                lights[1].setLightColor(LightColor.YELLOW);
                            }else{
                                System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                            }
                        }else if (tokens[2].equals("2")){
                            if (tokens[3].equals("WHITE")){
                                lights[2].setLightColor(LightColor.WHITE);
                            }else if (tokens[3].equals("YELLOW")){
                                lights[2].setLightColor(LightColor.YELLOW);
                            }else{
                                System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                            }
                        }else if (tokens[2].equals("3")){
                            if (tokens[3].equals("WHITE")){
                                lights[3].setLightColor(LightColor.WHITE);
                            }else if (tokens[3].equals("YELLOW")){
                                lights[3].setLightColor(LightColor.YELLOW);
                            }else{
                                System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                            }
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")){
                            System.out.println("Camera "+cameras[0].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("5")){
                            System.out.println("Camera "+cameras[1].getDeviceId()+" is not a light");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")) {
                        if (tokens[2].equals("6")){
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("7")){
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("8")){
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not a light");
                        }else if (tokens[2].equals("9")){
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not a light");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("SetAngle")){
                if (tokens.length == 4 && tokens[2].matches("\\d+") && tokens[3].matches("^-?\\d+$")){
                    int angle=Integer.parseInt(tokens[3]);
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            System.out.println("Light "+lights[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("1")){
                            System.out.println("Light "+lights[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("2")){
                            System.out.println("Light "+lights[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("3")){
                            System.out.println("Light "+lights[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")){
                            cameras[0].setCameraAngle(angle);
                        }else if (tokens[2].equals("5")){
                            cameras[1].setCameraAngle(angle);
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")) {
                        if (tokens[2].equals("6")){
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("7")){
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("8")){
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("9")){
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("StartRecording")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            System.out.println("Light "+lights[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("1")){
                            System.out.println("Light "+lights[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("2")){
                            System.out.println("Light "+lights[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("3")){
                            System.out.println("Light "+lights[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")) {
                            cameras[0].startRecording();
                        }else if (tokens[2].equals("5")) {
                            cameras[1].startRecording();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")) {
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("7")) {
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("8")) {
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("9")) {
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if (tokens[0].equals("StopRecording")){
                if (tokens.length == 3 && tokens[2].matches("\\d+")){
                    if (tokens[1].equals("Light")){
                        if (tokens[2].equals("0")){
                            System.out.println("Light "+lights[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("1")){
                            System.out.println("Light "+lights[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("2")){
                            System.out.println("Light "+lights[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("3")){
                            System.out.println("Light "+lights[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Camera")){
                        if (tokens[2].equals("4")) {
                            cameras[0].stopRecording();
                        }else if (tokens[2].equals("5")) {
                            cameras[1].stopRecording();
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else if (tokens[1].equals("Heater")){
                        if (tokens[2].equals("6")) {
                            System.out.println("Heater "+heaters[0].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("7")) {
                            System.out.println("Heater "+heaters[1].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("8")) {
                            System.out.println("Heater "+heaters[2].getDeviceId()+" is not a camera");
                        }else if (tokens[2].equals("9")) {
                            System.out.println("Heater "+heaters[3].getDeviceId()+" is not a camera");
                        }else{
                            System.out.println("The smart device was not found");
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            }
            else if(command.equals("end")) {
                break;
            }
            else{
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}

enum Status {
    OFF, ON
}

enum BrightnessLevel {
    HIGH,MEDIUM,LOW
}

enum LightColor {
    WHITE, YELLOW
}

interface Controllable {
    boolean turnOff();
    boolean turnOn();
    boolean isOn();
}

interface Chargeable {
    boolean isCharging();
    boolean startCharging();
    boolean stopCharging();
}


abstract class SmartDevice implements Controllable{
    private Status status;
    private int deviceId;
    private static int numberOfDevices;


    public SmartDevice(Status status) {
        this.status = status;
    }

    public String displayStatus(){
        return "It is only abstract displayStatus";
    }
    public int getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(int deviceId){
        this.deviceId = deviceId;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    @Override
    public boolean turnOff(){
        if (status == Status.ON){
            status = Status.OFF;
            if (getDeviceId()<=3 && getDeviceId()>=0){
                System.out.println("Light " + getDeviceId() + " is off");
            }else if (getDeviceId()<=5 && getDeviceId()>=4){
                System.out.println("Camera " + getDeviceId() + " is off");
            }else if (getDeviceId()<=9 && getDeviceId()>=6){
                System.out.println("Heater " + getDeviceId() + " is off");
            }
            return true;
        }else{
            if (getDeviceId()<=3 && getDeviceId()>=0){
                System.out.println("Light " + getDeviceId() + " is already off");
            }else if (getDeviceId()<=5 && getDeviceId()>=4){
                System.out.println("Camera " + getDeviceId() + " is already off");
            }else if (getDeviceId()<=9 && getDeviceId()>=6){
                System.out.println("Heater " + getDeviceId() + " is already off");
            }
            return false;
        }
    }
    @Override
    public boolean turnOn(){
        if (status == Status.OFF){
            status = Status.ON;
            if (getDeviceId()<=3 && getDeviceId()>=0){
                System.out.println("Light " + getDeviceId() + " is on");
            }else if (getDeviceId()<=5 && getDeviceId()>=4){
                System.out.println("Camera " + getDeviceId() + " is on");
            }else if (getDeviceId()<=9 && getDeviceId()>=6){
                System.out.println("Heater " + getDeviceId() + " is on");
            }
            return true;
        }else{
            if (getDeviceId()<=3 && getDeviceId()>=0){
                System.out.println("Light " + getDeviceId() + " is already on");
            }else if (getDeviceId()<=5 && getDeviceId()>=4){
                System.out.println("Camera " + getDeviceId() + " is already on");
            }else if (getDeviceId()<=9 && getDeviceId()>=6){
                System.out.println("Heater " + getDeviceId() + " is already on");
            }
            return false;
        }
    }
    @Override
    public boolean isOn(){
        if(status == Status.ON){
            return turnOn();
        }else
            return turnOff();
    }
    public boolean checkStatusAccess(){
        return false;
    }
}

class Light extends SmartDevice implements Chargeable {
    private boolean charging;
    private BrightnessLevel brightnessLevel;
    private LightColor lightColor;

    public Light(Status status, boolean charging, BrightnessLevel brightnessLevel, LightColor lightColor) {
        super(status);
        this.charging = charging;
        this.brightnessLevel = brightnessLevel;
        this.lightColor = lightColor;
    }
    public LightColor getLightColor() {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        if (getStatus() == Status.ON) {
            this.lightColor = lightColor;
            System.out.println("Light "+getDeviceId()+" color is set to "+lightColor);
        }else{
            System.out.println("You can't change the status of the Light "+ getDeviceId()+" while it is off");
        }
    }

    public BrightnessLevel getBrightnessLevel() {
        return brightnessLevel;
    }

    public void setBrightnessLevel(BrightnessLevel brightnessLevel) {
        if (getStatus() == Status.ON) {
            this.brightnessLevel = brightnessLevel;
            System.out.println("Light " + getDeviceId() + " brightness level is set to " + brightnessLevel);
        }else{
            System.out.println("You can't change the status of the Light "+ getDeviceId()+" while it is off");
        }
    }

    @Override
    public boolean isCharging(){
        return charging;
    }
    @Override
    public boolean startCharging(){
        if (charging){
            System.out.println("Light " + getDeviceId() + " is already charging");
            return false;
        }
        else{
            charging = true;
            System.out.println("Light " + getDeviceId() + " is charging");
            return true;
        }
    }
    @Override
    public boolean stopCharging(){
        if (charging){
            charging = false;
            System.out.println("Light " + getDeviceId() + " stopped charging");
            return true;
        }
        else{
            System.out.println("Light " + getDeviceId() + " is not charging");
            return false;
        }
    }
    public String displayStatus() {
        return "Light "+ getDeviceId() +" is "+getStatus()+", the color is "+getLightColor()+", the charging status is "+isCharging()+", and the brightness level is "+getBrightnessLevel()+".";
    }
}

class Camera extends SmartDevice implements Chargeable {
    static final int MAX_CAMERA_ANGLE=60;
    static final int MIN_CAMERA_ANGLE=-60;
    private boolean charging;
    private boolean recording;
    private int angle;

    public Camera(Status status,  boolean charging, boolean recording, int angle) {
        super(status);
        this.charging = charging;
        this.recording = recording;
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
    public boolean setCameraAngle(int angle) {
        if (getStatus() == Status.ON) {
            if (angle >= MIN_CAMERA_ANGLE && angle <= MAX_CAMERA_ANGLE) {
                this.angle = angle;
                System.out.println("Camera " + getDeviceId() + " angle is set to " + angle);
                return true;
            } else {
                System.out.println("Camera " + getDeviceId() + " angle should be in the range [-60, 60]");
                return false;
            }
        } else {
            System.out.println("You can't change the status of the Camera " + getDeviceId() + " while it is off");
            return false;
        }
    }
    public boolean startRecording() {
        if (getStatus() == Status.ON) {
            if (recording) {
                System.out.println("Camera " + getDeviceId() + " is already recording");
                return false;
            }else {
                this.recording = true;
                System.out.println("Camera " + getDeviceId() + " started recording");
                return true;
            }
        }else{
            System.out.println("You can't change the status of the Camera " + getDeviceId() + " while it is off");
            return false;
        }
    }
    public boolean stopRecording(){
        if (getStatus() == Status.ON) {
            if (recording) {
                this.recording = false;
                System.out.println("Camera " + getDeviceId() + " stopped recording");
                return true;
            }else {
                System.out.println("Camera " + getDeviceId() + " is not recording");
                return false;
            }
        }else{
            System.out.println("You can't change the status of the Camera " + getDeviceId() + " while it is off");
            return false;
        }
    }
    public boolean isRecording(){
        return recording;
    }

    @Override
    public boolean isCharging(){
        return charging;
    }
    @Override
    public boolean startCharging(){
        if (charging){
            System.out.println("Camera " + getDeviceId() + " is already charging");
            return false;
        }
        else{
            charging = true;
            System.out.println("Camera " + getDeviceId() + " is charging");
            return true;
        }
    }
    @Override
    public boolean stopCharging(){
        if (charging){
            charging = false;
            System.out.println("Camera " + getDeviceId() + " stopped charging");
            return true;
        }
        else{
            System.out.println("Camera " + getDeviceId() + " is not charging");
            return false;
        }
    }

    public String displayStatus() {
        return "Camera "+getDeviceId()+" is "+getStatus()+", the angle is "+getAngle()+", the charging status is "+isCharging()+", and the recording status is "+isRecording()+".";
    }
}

class Heater extends SmartDevice{
    private int temperature;
    static final int MAX_HEATER_TEMP=30;
    static final int MIN_HEATER_TEMP=15;

    public Heater(Status status, int temperature) {
        super(status);
        this.temperature=temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean setTemperature(int temp) {
        if (getStatus() == Status.ON) {
            if (temp >= MIN_HEATER_TEMP && temp <= MAX_HEATER_TEMP) {
                this.temperature = temp;
                System.out.println("Heater " + getDeviceId() + " temperature is set to " + temp);
                return true;
            } else {
                System.out.println("Heater "+getDeviceId()+" temperature should be in the range [15, 30]");
                return false;
            }
        }else{
            System.out.println("You can't change the status of the Heater "+ getDeviceId()+" while it is off");
            return false;
        }
    }

    @Override
    public String displayStatus() {
        return "Heater "+getDeviceId()+" is "+getStatus()+" and the temperature is "+getTemperature()+".";
    }
}
