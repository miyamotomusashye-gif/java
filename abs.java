abstract class Vehicle {
	abstract void startEngine();
	abstract void speedLimit();
	void displayDetails(String name, int wheels) {
		System.out.println("Name : "+name+ " Wheel : "+wheels);
	}
}

class Car extends Vehicle {
	void startEngine() {
		System.out.println("Car starting...");
	}
	void speedLimit() {
		System.out.println("running at 240km/h");
	}
	void Ac() {
		System.out.println("Ac is on");
	}
}

class Bike extends Vehicle {
	void startEngine() {
		System.out.println("Bike Starting...");
	}
	void speedLimit() {
		System.out.println("running at180km/h");
	}
	void Helmet() {
		System.out.println("Helmet is compulsory");
	}
}

public class abs {
	public static void main(String[] args) {
		Car c = new Car();
		c.startEngine();
		c.speedLimit();
		c.displayDetails("340 li", 4);
		c.Ac();

		Bike b = new Bike();
		b.startEngine();
		b.speedLimit();
		b.displayDetails("CB350rs", 2);
		b.Helmet();
	}
}
