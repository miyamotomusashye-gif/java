abstract class Vehicle {
    abstract void StartEngine();
    abstract void SpeedLimit();

    void StopEngine() {
        System.out.println("Engine stopped !");
    }

    void displayVehicle(String name, int wheels) {
        System.out.println("Name : " + name);
        System.out.println("Wheel : " + wheels);
    }
}

class Car extends Vehicle {
    void StartEngine() {
        System.out.println("Car starting...");
    }
    void SpeedLimit() {
        System.out.println("Speed of car is 240km/h");
    }
    void AirConditioning() {
        System.out.println("AC is on...");
    }
}

class Bike extends Vehicle {
    void StartEngine() {
        System.out.println("Bike starting...");
    }
    void SpeedLimit() {
        System.out.println("Speed of bike is 180km/h");
    }
    void isHelmet() {
        System.out.println("Helmet is compulsory !");
    }
}

public class abstraction {
    public static void main(String args[]) {

        Car mycar = new Car();
        mycar.displayVehicle("BMW", 4);
        mycar.StartEngine();
        mycar.SpeedLimit();
        ((Car)mycar).AirConditioning();
        mycar.StopEngine();
        System.out.println(" ");
        Bike mybike = new Bike();
        mybike.displayVehicle("CBR 350 rs", 2);
        mybike.StartEngine();
        mybike.SpeedLimit();
        ((Bike)mybike).isHelmet();
        mybike.StopEngine();
    }
}
