import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static Scanner scanner;
    private static int days;
    private static float grassAmounts;
    private static List<Animal> animals;
    private static int animalAmount;

    private static List<Animal> readAnimals() throws InvalidNumberOfAnimalParametersException, InvalidInputsException, WeightOutOfBoundsException, SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        animals = new ArrayList<>();
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

    public static void checkFristThreeString(String[] tokensdayss, String[] tokensGrass, String[] tokensAnimals) throws GrassOutOfBoundsException, InvalidInputsException {
        tokensGrass[0] = tokensGrass[0].replace("F", "").replace("f", "");
        if (tokensGrass[0].matches("[-+]?\\d+(\\.\\d+)?") && tokensdayss.length == 1 && tokensGrass.length == 1 && tokensAnimals.length == 1) {
            grassAmounts = Float.parseFloat(tokensGrass[0]);
            if (0 <= grassAmounts && grassAmounts <= 100) {
                if (tokensdayss[0].matches("\\d+") && tokensAnimals[0].matches("\\d+")) {
                    days = Integer.parseInt(tokensdayss[0]);
                    animalAmount = Integer.parseInt(tokensAnimals[0]);
                    if (!(1 <= days && days <= 30 && 1 <= animalAmount && animalAmount <= 20)) {
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

    public static void endForDaySimulation() {
        grassAmounts = grassAmounts * 2;
        if (grassAmounts > 100) {
            grassAmounts = 100;
        }
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).decrementEnergy();
        }
        removeDeadAnimals(animals);
    }

    private static void runSimulation(int days, float grassAmount, List<Animal> animals) throws SelfHuntingException, CannibalismException, TooStrongPreyException {
        String checkCannibalism;
        for (int idAnimal = 0; idAnimal < animals.size(); idAnimal++) {
            try {
                int idAnimalIncr = (idAnimal + 1) % animals.size();
                switch (animals.get(idAnimal).getClass().getName()) {
                    case "Lion":
                        checkCannibalism = animals.get(idAnimalIncr).getClass().getName();
                        if (animals.get(idAnimalIncr).getEnergy()>0) {
                            if (idAnimal == idAnimalIncr) {
                                throw new SelfHuntingException();
                            } else if (checkCannibalism.equals("Lion")) {
                                throw new CannibalismException();
                            } else if (animals.get(idAnimalIncr).getSpeed() > animals.get(idAnimal).getSpeed() && animals.get(idAnimalIncr).getEnergy() > animals.get(idAnimal).getEnergy()) {
                                throw new TooStrongPreyException();
                            } else {
                                animals.get(idAnimal).setEnergy(animals.get(idAnimalIncr).getWeight());
                                animals.get(idAnimalIncr).setEnergy(0);
                                animals.remove(idAnimalIncr);
                            }
                        }else{
                            animals.remove(idAnimalIncr);
                        }
                        break;
                    case "Boar":
                        if (grassAmounts > (animals.get(idAnimal).getWeight()/10)) {
                            animals.get(idAnimal).setEnergy(animals.get(idAnimal).getWeight()/10);
                            grassAmounts = grassAmounts - animals.get(idAnimal).getWeight()/10;
                        }
                        checkCannibalism = animals.get(idAnimalIncr).getClass().getName();
                        if (animals.get(idAnimalIncr).getEnergy()>0) {
                            if (idAnimal == idAnimalIncr) {
                                throw new SelfHuntingException();
                            } else if (checkCannibalism.equals("Boar")) {
                                throw new CannibalismException();
                            } else if (!(animals.get(idAnimalIncr).getSpeed() < animals.get(idAnimal).getSpeed() &&
                                    animals.get(idAnimalIncr).getEnergy() < animals.get(idAnimal).getEnergy())) {
                                throw new TooStrongPreyException();
                            } else {
                                animals.get(idAnimal).setEnergy(animals.get(idAnimalIncr).getWeight());
                                animals.get(idAnimalIncr).setEnergy(0);
                                animals.remove(idAnimalIncr);
                            }
                        }else{
                            animals.remove(idAnimalIncr);
                        }
                        break;
                    case "Zebra":
                        if (grassAmounts > (animals.get(idAnimal).getWeight()/10)) {
                            animals.get(idAnimal).setEnergy(animals.get(idAnimal).getWeight()/10);
                            grassAmounts = grassAmounts - animals.get(idAnimal).getWeight()/10;
                        }
                        break;
                }
            } catch (SelfHuntingException e) {
                System.out.println(e.getMessage());
            } catch (CannibalismException e) {
                System.out.println(e.getMessage());
            } catch (TooStrongPreyException e) {
                System.out.println(e.getMessage());
            }
        }
        endForDaySimulation();
//            System.out.println(animals.get(i).getClass().getName());
//            animals.get(i);
    }

    private static void printAnimalsSec(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    
    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getClass().getName().equals("Lion")) {
                System.out.println("Roar");
            }else if (animal.getClass().getName().equals("Zebra")) {
                System.out.println("Ihoho");
            }else{
                System.out.println("Oink");
            }
        }
    }

    private static void removeDeadAnimals(List<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (animal.getEnergy() <= 0) {
                animals.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/karimkhabib/IdeaProjects/Assiga_4/src/input.txt");
        scanner = new Scanner(file);

        String command = scanner.nextLine();
        String[] tokensdayss = command.split(" ");
        command = scanner.nextLine();
        String[] tokensGrass = command.split(" ");
        command = scanner.nextLine();
        String[] tokensAnimals = command.split(" ");
        try {
            checkFristThreeString(tokensdayss, tokensGrass, tokensAnimals);
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
//        printAnimals1(animals);
//        printAnimals1(animals);
        removeDeadAnimals(animals);
        for (int i = 0; i < days; i++) {
            try {
                runSimulation(days, grassAmounts, animals);
            } catch (SelfHuntingException e) {
                System.out.println(e.getMessage());
            } catch (CannibalismException e) {
                System.out.println(e.getMessage());
            } catch (TooStrongPreyException e) {
                System.out.println(e.getMessage());
            }
        }
        printAnimals(animals);
        scanner.close();
    }
}

abstract class Animal {
    public static final float MIN_SPEED = 5;
    public static final float MAX_SPEED = 60;

    public static final float MIN_ENERGY = 0;
    public static final float MAX_ENERGY = 100;

    public static final float MIN_WEIGHT = 5;
    public static final float MAX_WEIGHT = 200;

    private float weight;
    private float speed;
    private float energy;

    protected Animal(float weight, float speed, float energy) {
        this.weight = weight;
        this.speed = speed;
        this.energy = energy;
    }

    public void makeSound(){

    }
    public void decrementEnergy(){
        this.energy--;
    }
    public void eat(List<Animal> animals, Field field){
        System.out.println("penis");
    }

    public boolean setAll(float weight, float speed, float energy) {
        if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT  &&  speed >= MIN_SPEED && speed <= MAX_SPEED && energy >= MIN_ENERGY && energy <= MAX_ENERGY) {
            return true;
        }
        return false;
    }

    public float getEnergy() {
        return energy;
    }

    public float getWeight() {
        return weight;
    }

    public void setEnergy(float energySmth) {
        if (energySmth!=0){
            this.energy = this.energy + energySmth;
            if (this.energy > MAX_ENERGY) {
                this.energy = MAX_ENERGY;
            }
        }else{
            this.energy = MIN_ENERGY;
        }
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Animal{weight='" + weight + "', speed=" + speed  + "', energy=" + energy + "}";
    }
}

class Boar<T> extends Animal implements Omnivore<T> {
    public Boar(float weight, float speed, float energy) {
        super(weight, speed, energy);
    }
    @Override
    public void grazeInTheField(Animal grazer, Field field){
        System.out.println("penis");
    }
    @Override
    public Animal choosePrey(List<Animal> animals, T hunter){
        System.out.println("penis");
        return null;
    }
    @Override
    public void huntPrey(Animal hunter,Animal prey){
        System.out.println("penis");
    }
}

class Lion<T> extends Animal implements Carnivore<T>{

    public Lion(float weight, float speed, float energy) {
        super(weight, speed, energy);
    }
    @Override
    public Animal choosePrey(List<Animal> animals, T hunter){
        System.out.println("penis");
        return null;
    }
    @Override
    public void huntPrey(Animal hunter,Animal prey){
        System.out.println("penis");
    }
}

class Zebra extends Animal implements Herbivore{
    public Zebra(float weight, float speed, float energy) {
        super(weight, speed, energy);
    }
    @Override
    public void grazeInTheField(Animal grazer, Field field){
        System.out.println("penis");
    }
}

class Field {
    private float grassAmounts;

    public Field(float grassAmounts) {
        this.grassAmounts = grassAmounts;
    }

    public void makeGrassGrow() {
        grassAmounts = grassAmounts*2;
        if (grassAmounts > 100) {
            grassAmounts = 100;
        }
        System.out.println(grassAmounts);
    }
}

interface Carnivore<T>{
    public Animal choosePrey(List<Animal> animals, T hunter);
    public void huntPrey(Animal hunter,Animal prey);
}

interface Omnivore<T> extends Herbivore,Carnivore<T>{}

interface Herbivore {
    public void grazeInTheField(Animal grazer, Field field);
}

enum AnimalSound {
    LION("Roar"),
    ZEBRA("Ihoho"),
    BOAR("Oink");

    private final String sound;

    AnimalSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
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
