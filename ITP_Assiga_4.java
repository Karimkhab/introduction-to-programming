import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static Scanner scanner;


    private static List<Animal> readAnimals() throws InvalidNumberOfAnimalParametersException, InvalidInputsException, WeightOutOfBoundsException, SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        List<Animal> animals = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if (tokens.length == 4) {
                tokens[1] = tokens[1].replace("F", "").replace("f", "");
                tokens[2] = tokens[2].replace("F", "").replace("f", "");
                tokens[3] = tokens[3].replace("F", "").replace("f", "");
                switch (tokens[0]) {
                    case "Lion":
                        if (tokens[1].matches("[-+]?\\d+(\\.\\d+)?") && tokens[2].matches("[-+]?\\d+(\\.\\d+)?") && tokens[3].matches("[-+]?\\d+(\\.\\d+)?")) {
                            float weight = Float.parseFloat(tokens[1]);
                            float speed = Float.parseFloat(tokens[2]);
                            float energy = Float.parseFloat(tokens[3]);
                            Animal lion = new Lion(0, 0, 0);
                            if (lion.setAll(weight, speed, energy)) {
                                lion = new Lion(weight, speed, energy);
                                animals.add(lion);
                            } else {
                                throw new InvalidInputsException();
                            }
                        } else {
                            throw new InvalidInputsException();
                        }
                        break;
                    case "Boar":
                        if (tokens[1].matches("[-+]?\\d+(\\.\\d+)?") && tokens[2].matches("[-+]?\\d+(\\.\\d+)?") && tokens[3].matches("[-+]?\\d+(\\.\\d+)?")) {
                            float weight = Float.parseFloat(tokens[1]);
                            float speed = Float.parseFloat(tokens[2]);
                            float energy = Float.parseFloat(tokens[3]);
                            Animal boar = new Boar(0, 0, 0);
                            if (boar.setAll(weight, speed, energy)) {
                                boar = new Boar(weight, speed, energy);
                                animals.add(boar);
                            } else {
                                throw new InvalidInputsException();
                            }
                        } else {
                            throw new InvalidInputsException();
                        }
                        break;
                    case "Zebra":
                        if (tokens[1].matches("[-+]?\\d+(\\.\\d+)?") && tokens[2].matches("[-+]?\\d+(\\.\\d+)?") && tokens[3].matches("[-+]?\\d+(\\.\\d+)?")) {
                            float weight = Float.parseFloat(tokens[1]);
                            float speed = Float.parseFloat(tokens[2]);
                            float energy = Float.parseFloat(tokens[3]);
                            Animal zebra = new Zebra(0, 0, 0);
                            if (zebra.setAll(weight, speed, energy)) {
                                zebra = new Zebra(weight, speed, energy);
                                animals.add(zebra);
                            } else {
                                throw new InvalidInputsException();
                            }
                        } else {
                            throw new InvalidInputsException();
                        }
                        break;
                    default:
                        throw new InvalidInputsException();
                }
            } else {
                throw new InvalidNumberOfAnimalParametersException();
            }
        }
        return animals;
    }

    public static void checkFristThreeString(String[] tokensDays, String[] tokensGrass, String[] tokensAnimals) throws GrassOutOfBoundsException, InvalidInputsException {
        tokensGrass[0] = tokensGrass[0].replace("F", "").replace("f", "");
        if (tokensGrass[0].matches("[-+]?\\d*\\.\\d+") && tokensDays.length == 1 && tokensGrass.length == 1 && tokensAnimals.length == 1) {
            float grassAmount = Float.parseFloat(tokensGrass[0]);
            if (0 <= grassAmount && grassAmount <= 100) {
                if (tokensDays[0].matches("\\d+") && tokensAnimals[0].matches("\\d+")) {
                    int day = Integer.parseInt(tokensDays[0]);
                    int animalAmount = Integer.parseInt(tokensAnimals[0]);
                    if (!(1 <= day && day <= 30 && 1 <= animalAmount && animalAmount <= 20)) {
                        throw new InvalidInputsException();
                    }
                } else {
                    throw new InvalidInputsException();
                }
            } else {
                throw new GrassOutOfBoundsException();
            }
        } else {
            throw new InvalidInputsException();
        }
    }

    private static void runSimulation(int days, float grassAmount, List<Animal> animals) {
    }

    private static void printAnimals(List<Animal> animals) {
    }

    private static void removeDeadAnimals(List<Animal> animals) {
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/karimkhabib/IdeaProjects/Assiga_4/src/input.txt");
        scanner = new Scanner(file);

        String command = scanner.nextLine();
        String[] tokensDays = command.split(" ");
        command = scanner.nextLine();
        String[] tokensGrass = command.split(" ");
        command = scanner.nextLine();
        String[] tokensAnimals = command.split(" ");
        try {
            checkFristThreeString(tokensDays, tokensGrass, tokensAnimals);
        } catch (GrassOutOfBoundsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        } catch (InvalidInputsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        }
        List<Animal> animals;
        try {
            animals = readAnimals();
        } catch (InvalidNumberOfAnimalParametersException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        } catch (InvalidInputsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        } catch (WeightOutOfBoundsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        } catch (SpeedOutOfBoundsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        } catch (EnergyOutOfBoundsException e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        scanner.close();
    }
}

class GrassOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The grass is out of bounds";
    }
}

class InvalidNumberOfAnimalParametersException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid number of animal parameters";
    }
}

class InvalidInputsException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid inputs";
    }
}

class WeightOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The weight is out of bounds";
    }
}

class SpeedOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The speed is out of bounds";
    }
}

class EnergyOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The energy is out of bounds";
    }
}

class SelfHuntingException extends Exception {
    @Override
    public String getMessage() {
        return "Self-hunting is not allowed";
    }
}

class CannibalismException extends Exception {
    @Override
    public String getMessage() {
        return "Cannibalism is not allowed";
    }
}

class TooStrongPreyException extends Exception {
    @Override
    public String getMessage() {
        return "The prey is too strong or too fast to attack";
    }
}
