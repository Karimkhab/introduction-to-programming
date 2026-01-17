import java.util.Scanner;

/**
 * The main class through which the smart home is managed
 */
public class SmartHomeManagementSystem {
    /**
     * We implement the main method through which we will call other methods to validate our input data
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * We set initial values for our devices and assign them indices
         */
        Light[] lights = {
                new Light(Status.ON, false, BrightnessLevel.LOW, LightColor.YELLOW),
                new Light(Status.ON, false, BrightnessLevel.LOW, LightColor.YELLOW),
                new Light(Status.ON, false, BrightnessLevel.LOW, LightColor.YELLOW),
                new Light(Status.ON, false, BrightnessLevel.LOW, LightColor.YELLOW)
        };
        final int startAngleValue = 45;
        Camera[] cameras = {
                new Camera(Status.ON, false, false, startAngleValue),
                new Camera(Status.ON, false, false, startAngleValue)
        };
        final int startTempValue = 20;
        Heater[] heaters = {
                new Heater(Status.ON, startTempValue),
                new Heater(Status.ON, startTempValue),
                new Heater(Status.ON, startTempValue),
                new Heater(Status.ON, startTempValue)
        };
        for (int i = 0; i < lights.length; i++) {
            lights[i].setDeviceId(i);
        }
        final int firstIdCamera = 4;
        for (int i = 0; i < cameras.length; i++) {
            cameras[i].setDeviceId(i + firstIdCamera);
        }
        final int firstIdHeater = 6;
        for (int i = 0; i < heaters.length; i++) {
            heaters[i].setDeviceId(i + firstIdHeater);
        }
        /**
         * We initiate a while loop to read the input data,
         * call methods for each command, and perform the necessary checks
         */
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if (tokens[0].equals("DisplayAllStatus")) {
                displayAllStatus(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("TurnOn")) {
                turnOn(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("TurnOff")) {
                turnOff(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("StartCharging")) {
                startCharging(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("StopCharging")) {
                stopCharging(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("SetTemperature")) {
                setTemperature(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("SetBrightness")) {
                setBrightness(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("SetColor")) {
                setColor(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("SetAngle")) {
                setAngle(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("StartRecording")) {
                startRecording(tokens, lights, cameras, heaters);
            } else if (tokens[0].equals("StopRecording")) {
                stopRecording(tokens, lights, cameras, heaters);
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }

    /**
     * We display the current statuses of all devices
     *
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void displayAllStatus(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 1;
        if (tokens.length == countTokens) {
            //Lights
            for (int i = 0; i < lights.length; i++) {
                System.out.println(lights[i].displayStatus());
            }
            for (int i = 0; i < cameras.length; i++) {
                System.out.println(cameras[i].displayStatus());
            }
            for (int i = 0; i < heaters.length; i++) {
                System.out.println(heaters[i].displayStatus());
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if the device can be turned on and turn it on if possible
     *
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void turnOn(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    lights[0].turnOn();
                } else if (tokens[2].equals("1")) {
                    lights[1].turnOn();
                } else if (tokens[2].equals("2")) {
                    lights[2].turnOn();
                } else if (tokens[2].equals("3")) {
                    lights[2 + 1].turnOn();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].turnOn();
                } else if (tokens[2].equals("5")) {
                    cameras[1].turnOn();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    heaters[0].turnOn();
                } else if (tokens[2].equals("7")) {
                    heaters[1].turnOn();
                } else if (tokens[2].equals("8")) {
                    heaters[2].turnOn();
                } else if (tokens[2].equals("9")) {
                    heaters[2 + 1].turnOn();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if the device can be turned off and turn it off if possible
     *
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void turnOff(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    lights[0].turnOff();
                } else if (tokens[2].equals("1")) {
                    lights[1].turnOff();
                } else if (tokens[2].equals("2")) {
                    lights[2].turnOff();
                } else if (tokens[2].equals("3")) {
                    lights[2 + 1].turnOff();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].turnOff();
                } else if (tokens[2].equals("5")) {
                    cameras[1].turnOff();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    heaters[0].turnOff();
                } else if (tokens[2].equals("7")) {
                    heaters[1].turnOff();
                } else if (tokens[2].equals("8")) {
                    heaters[2].turnOff();
                } else if (tokens[2].equals("9")) {
                    heaters[2 + 1].turnOff();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can start charging and start it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void startCharging(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    lights[0].startCharging();
                } else if (tokens[2].equals("1")) {
                    lights[1].startCharging();
                } else if (tokens[2].equals("2")) {
                    lights[2].startCharging();
                } else if (tokens[2].equals("3")) {
                    lights[2 + 1].startCharging();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].startCharging();
                } else if (tokens[2].equals("5")) {
                    cameras[1].startCharging();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not chargeable");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can end the charging and end it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void stopCharging(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    lights[0].stopCharging();
                } else if (tokens[2].equals("1")) {
                    lights[1].stopCharging();
                } else if (tokens[2].equals("2")) {
                    lights[2].stopCharging();
                } else if (tokens[2].equals("3")) {
                    lights[2 + 1].stopCharging();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].stopCharging();
                } else if (tokens[2].equals("5")) {
                    cameras[1].stopCharging();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not chargeable");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not chargeable");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can reassign the temperature and reassign it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void setTemperature(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 4;
        if (tokens.length == countTokens && tokens[2 + 1].matches("\\d+") && tokens[2].matches("\\d+")) {
            int temperature = Integer.parseInt(tokens[2 + 1]);
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    System.out.println("Light " + lights[0].getDeviceId() + " is not a heater");
                } else if (tokens[2].equals("1")) {
                    System.out.println("Light " + lights[1].getDeviceId() + " is not a heater");
                } else if (tokens[2].equals("2")) {
                    System.out.println("Light " + lights[2].getDeviceId() + " is not a heater");
                } else if (tokens[2].equals("3")) {
                    System.out.println("Light " + lights[2 + 1].getDeviceId() + " is not a heater");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    System.out.println("Camera " + cameras[0].getDeviceId() + " is not a heater");
                } else if (tokens[2].equals("5")) {
                    System.out.println("Camera " + cameras[1].getDeviceId() + " is not a heater");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    heaters[0].setTemperature(temperature);
                } else if (tokens[2].equals("7")) {
                    heaters[1].setTemperature(temperature);
                } else if (tokens[2].equals("8")) {
                    heaters[2].setTemperature(temperature);
                } else if (tokens[2].equals("9")) {
                    heaters[2 + 1].setTemperature(temperature);
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can reassign the brightness level and reassign it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void setBrightness(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 4;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    if (tokens[2 + 1].equals("LOW")) {
                        lights[0].setBrightnessLevel(BrightnessLevel.LOW);
                    } else if (tokens[2 + 1].equals("MEDIUM")) {
                        lights[0].setBrightnessLevel(BrightnessLevel.MEDIUM);
                    } else if (tokens[2 + 1].equals("HIGH")) {
                        lights[0].setBrightnessLevel(BrightnessLevel.HIGH);
                    } else {
                        System.out.println("The brightness can only be one "
                                + "of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                    }
                } else if (tokens[2].equals("1")) {
                    if (tokens[2 + 1].equals("LOW")) {
                        lights[1].setBrightnessLevel(BrightnessLevel.LOW);
                    } else if (tokens[2 + 1].equals("MEDIUM")) {
                        lights[1].setBrightnessLevel(BrightnessLevel.MEDIUM);
                    } else if (tokens[2 + 1].equals("HIGH")) {
                        lights[1].setBrightnessLevel(BrightnessLevel.HIGH);
                    } else {
                        System.out.println("The brightness can only be one "
                                + "of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                    }
                } else if (tokens[2].equals("2")) {
                    if (tokens[2 + 1].equals("LOW")) {
                        lights[2].setBrightnessLevel(BrightnessLevel.LOW);
                    } else if (tokens[2 + 1].equals("MEDIUM")) {
                        lights[2].setBrightnessLevel(BrightnessLevel.MEDIUM);
                    } else if (tokens[2 + 1].equals("HIGH")) {
                        lights[2].setBrightnessLevel(BrightnessLevel.HIGH);
                    } else {
                        System.out.println("The brightness can only be one "
                                + "of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                    }
                } else if (tokens[2].equals("3")) {
                    if (tokens[2 + 1].equals("LOW")) {
                        lights[2 + 1].setBrightnessLevel(BrightnessLevel.LOW);
                    } else if (tokens[2 + 1].equals("MEDIUM")) {
                        lights[2 + 1].setBrightnessLevel(BrightnessLevel.MEDIUM);
                    } else if (tokens[2 + 1].equals("HIGH")) {
                        lights[2 + 1].setBrightnessLevel(BrightnessLevel.HIGH);
                    } else {
                        System.out.println("The brightness can only be one "
                                + "of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                    }
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    System.out.println("Camera " + cameras[0].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("5")) {
                    System.out.println("Camera " + cameras[1].getDeviceId() + " is not a light");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not a light");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can reassign the color and reassign it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void setColor(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 4;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    if (tokens[2 + 1].equals("WHITE")) {
                        lights[0].setLightColor(LightColor.WHITE);
                    } else if (tokens[2 + 1].equals("YELLOW")) {
                        lights[0].setLightColor(LightColor.YELLOW);
                    } else {
                        System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                    }
                } else if (tokens[2].equals("1")) {
                    if (tokens[2 + 1].equals("WHITE")) {
                        lights[1].setLightColor(LightColor.WHITE);
                    } else if (tokens[2 + 1].equals("YELLOW")) {
                        lights[1].setLightColor(LightColor.YELLOW);
                    } else {
                        System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                    }
                } else if (tokens[2].equals("2")) {
                    if (tokens[2 + 1].equals("WHITE")) {
                        lights[2].setLightColor(LightColor.WHITE);
                    } else if (tokens[2 + 1].equals("YELLOW")) {
                        lights[2].setLightColor(LightColor.YELLOW);
                    } else {
                        System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                    }
                } else if (tokens[2].equals("3")) {
                    if (tokens[2 + 1].equals("WHITE")) {
                        lights[2 + 1].setLightColor(LightColor.WHITE);
                    } else if (tokens[2 + 1].equals("YELLOW")) {
                        lights[2 + 1].setLightColor(LightColor.YELLOW);
                    } else {
                        System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                    }
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    System.out.println("Camera " + cameras[0].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("5")) {
                    System.out.println("Camera " + cameras[1].getDeviceId() + " is not a light");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not a light");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not a light");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }

    }

    /**
     * We check if we can reassign the angle and reassign it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void setAngle(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 4;
        if (tokens.length == countTokens && tokens[2].matches("\\d+") && tokens[2 + 1].matches("^-?\\d+$")) {
            int angle = Integer.parseInt(tokens[2 + 1]);
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    System.out.println("Light " + lights[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("1")) {
                    System.out.println("Light " + lights[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("2")) {
                    System.out.println("Light " + lights[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("3")) {
                    System.out.println("Light " + lights[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].setCameraAngle(angle);
                } else if (tokens[2].equals("5")) {
                    cameras[1].setCameraAngle(angle);
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can start the recording and start it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void startRecording(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    System.out.println("Light " + lights[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("1")) {
                    System.out.println("Light " + lights[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("2")) {
                    System.out.println("Light " + lights[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("3")) {
                    System.out.println("Light " + lights[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].startRecording();
                } else if (tokens[2].equals("5")) {
                    cameras[1].startRecording();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }

    /**
     * We check if we can end the recording and end it if possible
     * @param tokens
     * @param lights
     * @param cameras
     * @param heaters
     */
    public static void stopRecording(String[] tokens, Light[] lights, Camera[] cameras, Heater[] heaters) {
        final int countTokens = 3;
        if (tokens.length == countTokens && tokens[2].matches("\\d+")) {
            if (tokens[1].equals("Light")) {
                if (tokens[2].equals("0")) {
                    System.out.println("Light " + lights[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("1")) {
                    System.out.println("Light " + lights[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("2")) {
                    System.out.println("Light " + lights[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("3")) {
                    System.out.println("Light " + lights[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Camera")) {
                if (tokens[2].equals("4")) {
                    cameras[0].stopRecording();
                } else if (tokens[2].equals("5")) {
                    cameras[1].stopRecording();
                } else {
                    System.out.println("The smart device was not found");
                }
            } else if (tokens[1].equals("Heater")) {
                if (tokens[2].equals("6")) {
                    System.out.println("Heater " + heaters[0].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("7")) {
                    System.out.println("Heater " + heaters[1].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("8")) {
                    System.out.println("Heater " + heaters[2].getDeviceId() + " is not a camera");
                } else if (tokens[2].equals("9")) {
                    System.out.println("Heater " + heaters[2 + 1].getDeviceId() + " is not a camera");
                } else {
                    System.out.println("The smart device was not found");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }
}

/**
 * Enums for status, brightness level, and light color
 */
enum Status {
    OFF, ON
}

enum BrightnessLevel {
    HIGH, MEDIUM, LOW
}

enum LightColor {
    WHITE, YELLOW
}

/**
 * Interface with methods for turning on, turning off, and displaying the on/off status
 */
interface Controllable {
    boolean turnOff();

    boolean turnOn();

    boolean isOn();
}

/**
 * Interface with methods for starting charging, stopping charging, and displaying the charging
 */
interface Chargeable {
    boolean isCharging();

    boolean startCharging();

    boolean stopCharging();
}

/**
 * Abstract class that describes the common characteristics of all devices
 */
abstract class SmartDevice implements Controllable {
    /**
     * Field for status, device ID, and the number of devices of a specific type
     */
    private Status status;
    private int deviceId;
    private static int numberOfDevices;

    /**
     * Constructor that assigns the status
     * @param status
     */
    public SmartDevice(Status status) {
        this.status = status;
    }

    /**
     * Method for displaying the device status
     * @return Nothing
     */
    public String displayStatus() {
        return "It is only abstract displayStatus";
    }

    /**
     * Displays the device ID
     * @return device Id
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * Checks and records the device ID
     * @param deviceId
     */
    public void setDeviceId(int deviceId) {
        final int maxId = 9;
        final int minId = 0;
        if (deviceId <= maxId && deviceId >= minId) {
            this.deviceId = deviceId;
        }
    }

    /**
     * Displays the device status
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Records the device status
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Method that turns off the device if possible
     * @return true if executed, and false if not executed
     */
    @Override
    public boolean turnOff() {
        final int maxIdLight = 3;
        final int maxIdCamera = 5;
        final int maxIdHeater = 9;
        if (status == Status.ON) {
            status = Status.OFF;
            if (getDeviceId() <= maxIdLight && getDeviceId() >= 0) {
                System.out.println("Light " + getDeviceId() + " is off");
            } else if (getDeviceId() <= maxIdCamera && getDeviceId() >= (maxIdLight + 1)) {
                System.out.println("Camera " + getDeviceId() + " is off");
            } else if (getDeviceId() <= maxIdHeater && getDeviceId() >= (maxIdCamera + 1)) {
                System.out.println("Heater " + getDeviceId() + " is off");
            }
            return true;
        } else {
            if (getDeviceId() <= maxIdLight && getDeviceId() >= 0) {
                System.out.println("Light " + getDeviceId() + " is already off");
            } else if (getDeviceId() <= maxIdCamera && getDeviceId() >= (maxIdLight + 1)) {
                System.out.println("Camera " + getDeviceId() + " is already off");
            } else if (getDeviceId() <= maxIdHeater && getDeviceId() >= (maxIdCamera + 1)) {
                System.out.println("Heater " + getDeviceId() + " is already off");
            }
            return false;
        }
    }

    /**
     * Method that turns on the device if possible
     * @return true if executed, and false if not executed
     */
    @Override
    public boolean turnOn() {
        final int maxIdLight = 3;
        final int maxIdCamera = 5;
        final int maxIdHeater = 9;
        if (status == Status.OFF) {
            status = Status.ON;
            if (getDeviceId() <= maxIdLight && getDeviceId() >= 0) {
                System.out.println("Light " + getDeviceId() + " is on");
            } else if (getDeviceId() <= maxIdCamera && getDeviceId() >= (maxIdLight + 1)) {
                System.out.println("Camera " + getDeviceId() + " is on");
            } else if (getDeviceId() <= maxIdHeater && getDeviceId() >= (maxIdCamera + 1)) {
                System.out.println("Heater " + getDeviceId() + " is on");
            }
            return true;
        } else {
            if (getDeviceId() <= maxIdLight && getDeviceId() >= 0) {
                System.out.println("Light " + getDeviceId() + " is already on");
            } else if (getDeviceId() <= maxIdCamera && getDeviceId() >= (maxIdLight + 1)) {
                System.out.println("Camera " + getDeviceId() + " is already on");
            } else if (getDeviceId() <= maxIdHeater && getDeviceId() >= (maxIdCamera + 1)) {
                System.out.println("Heater " + getDeviceId() + " is already on");
            }
            return false;
        }
    }

    /**
     * Change the status of the device
     * @return true if on, and false if off
     */
    @Override
    public boolean isOn() {
        if (status == Status.ON) {
            return turnOn();
        }
        return turnOff();
    }

    /**
     * Shows the status of the device
     * @return true if on, and false if off
     */
    public boolean checkStatusAccess() {
        if (status == Status.ON) {
            return true;
        }
        return false;
    }
}

/**
 * Light class, which is a device and can be charged
 */
class Light extends SmartDevice implements Chargeable {
    /**
     * Field for charging, brightness level and light color
     */
    private boolean charging;
    private BrightnessLevel brightnessLevel;
    private LightColor lightColor;

    /**
     * Constructor that assigns the status, charging, brightness level, light color
     * @param status
     * @param charging
     * @param brightnessLevel
     * @param lightColor
     */
    public Light(Status status, boolean charging, BrightnessLevel brightnessLevel, LightColor lightColor) {
        super(status);
        this.charging = charging;
        this.brightnessLevel = brightnessLevel;
        this.lightColor = lightColor;
    }

    /**
     * Displays the light color
     * @return light color
     */
    public LightColor getLightColor() {
        return lightColor;
    }

    /**
     * Checks and records the light color
     * @param lightColor
     */
    public void setLightColor(LightColor lightColor) {
        if (getStatus() == Status.ON) {
            this.lightColor = lightColor;
            System.out.println("Light " + getDeviceId() + " color is set to " + lightColor);
        } else {
            System.out.println("You can't change the status of the Light " + getDeviceId() + " while it is off");
        }
    }

    /**
     * Displays the brightness level
     * @return brightness level
     */
    public BrightnessLevel getBrightnessLevel() {
        return brightnessLevel;
    }

    /**
     * Checks and records the brightness level
     * @param brightnessLevel
     */
    public void setBrightnessLevel(BrightnessLevel brightnessLevel) {
        if (getStatus() == Status.ON) {
            this.brightnessLevel = brightnessLevel;
            System.out.println("Light " + getDeviceId() + " brightness level is set to " + brightnessLevel);
        } else {
            System.out.println("You can't change the status of the Light " + getDeviceId() + " while it is off");
        }
    }

    /**
     * Displays the status of charging
     * @return true if charging and false if not charging
     */
    @Override
    public boolean isCharging() {
        return charging;
    }

    /**
     * Starts charging if possible
     * @return true if start charging and false if already charging
     */
    @Override
    public boolean startCharging() {
        if (charging) {
            System.out.println("Light " + getDeviceId() + " is already charging");
            return false;
        } else {
            charging = true;
            System.out.println("Light " + getDeviceId() + " is charging");
            return true;
        }
    }

    /**
     * Stops charging if possible
     * @return true if stop charging and false if already not charging
     */
    @Override
    public boolean stopCharging() {
        if (charging) {
            charging = false;
            System.out.println("Light " + getDeviceId() + " stopped charging");
            return true;
        } else {
            System.out.println("Light " + getDeviceId() + " is not charging");
            return false;
        }
    }

    /**
     * Displays the state of the light
     * @return message of state
     */
    public String displayStatus() {
        return "Light " + getDeviceId() + " is " + getStatus() + ", the color is "
                + getLightColor() + ", the charging status is "
                + isCharging() + ", and the brightness level is " + getBrightnessLevel() + ".";
    }
}

/**
 * Camera class, which is a device and can be charged
 */
class Camera extends SmartDevice implements Chargeable {
    /**
     * Field for maximum and minimum camera angle, charging, recording and angle
     */
    static final int MAX_CAMERA_ANGLE = 60;
    static final int MIN_CAMERA_ANGLE = -60;
    private boolean charging;
    private boolean recording;
    private int angle;

    /**
     * Constructor that assigns the status, charging, recording, angle
     * @param status
     * @param charging
     * @param recording
     * @param angle
     */
    public Camera(Status status, boolean charging, boolean recording, int angle) {
        super(status);
        this.charging = charging;
        this.recording = recording;
        this.angle = angle;
    }

    /**
     * Displays the angle
     * @return angle
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Checks and records the camera angle
     * @param angle
     * @return true if set and false if not set
     */
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

    /**
     * Start recording if it possible
     * @return true if started recording and false if already recording or camera is off
     */
    public boolean startRecording() {
        if (getStatus() == Status.ON) {
            if (recording) {
                System.out.println("Camera " + getDeviceId() + " is already recording");
                return false;
            } else {
                this.recording = true;
                System.out.println("Camera " + getDeviceId() + " started recording");
                return true;
            }
        } else {
            System.out.println("You can't change the status of the Camera " + getDeviceId() + " while it is off");
            return false;
        }
    }

    /**
     * Stop recording if it possible
     * @return true if stopped recording and false if not recording or camera is off
     */
    public boolean stopRecording() {
        if (getStatus() == Status.ON) {
            if (recording) {
                this.recording = false;
                System.out.println("Camera " + getDeviceId() + " stopped recording");
                return true;
            } else {
                System.out.println("Camera " + getDeviceId() + " is not recording");
                return false;
            }
        } else {
            System.out.println("You can't change the status of the Camera " + getDeviceId() + " while it is off");
            return false;
        }
    }

    /**
     * Displays the status of recording
     * @return true if recording and false if not recording
     */
    public boolean isRecording() {
        return recording;
    }

    /**
     * Displays the status of charging
     * @return true if charging and false if not charging
     */
    @Override
    public boolean isCharging() {
        return charging;
    }

    /**
     * Starts charging if possible
     * @return true if start charging and false if already charging
     */
    @Override
    public boolean startCharging() {
        if (charging) {
            System.out.println("Camera " + getDeviceId() + " is already charging");
            return false;
        } else {
            charging = true;
            System.out.println("Camera " + getDeviceId() + " is charging");
            return true;
        }
    }

    /**
     * Stops charging if possible
     * @return true if stop charging and false if already not charging
     */
    @Override
    public boolean stopCharging() {
        if (charging) {
            charging = false;
            System.out.println("Camera " + getDeviceId() + " stopped charging");
            return true;
        } else {
            System.out.println("Camera " + getDeviceId() + " is not charging");
            return false;
        }
    }

    /**
     * Displays the state of the camera
     * @return message of state
     */
    public String displayStatus() {
        return "Camera " + getDeviceId() + " is " + getStatus() + ", the angle is "
                + getAngle() + ", the charging status is " + isCharging()
                + ", and the recording status is " + isRecording() + ".";
    }
}

/**
 * Heater class, which is a device
 */
class Heater extends SmartDevice {
    /**
     * Field for temperature, maximum and minimum temperature of heater
     */
    private int temperature;
    static final int MAX_HEATER_TEMP = 30;
    static final int MIN_HEATER_TEMP = 15;

    /**
     * Constructor that assigns the status, temperature
     * @param status
     * @param temperature
     */
    public Heater(Status status, int temperature) {
        super(status);
        this.temperature = temperature;
    }

    /**
     * Displays the temperature
     * @return temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Checks and records the temperature
     * @param temp
     * @return true if temperature changed and false if temperature did not change
     */
    public boolean setTemperature(int temp) {
        if (getStatus() == Status.ON) {
            if (temp >= MIN_HEATER_TEMP && temp <= MAX_HEATER_TEMP) {
                this.temperature = temp;
                System.out.println("Heater " + getDeviceId() + " temperature is set to " + temp);
                return true;
            } else {
                System.out.println("Heater " + getDeviceId() + " temperature should be in the range [15, 30]");
                return false;
            }
        } else {
            System.out.println("You can't change the status of the Heater " + getDeviceId() + " while it is off");
            return false;
        }
    }

    /**
     * Displays the state of the heater
     * @return
     */
    @Override
    public String displayStatus() {
        return "Heater " + getDeviceId() + " is " + getStatus() + " and the temperature is " + getTemperature() + ".";
    }
}
