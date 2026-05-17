interface Shape {
	void area();
}

class Circle implements Shape {
	double radius;

	Circle ( double radius)  {
		this.radius = radius;
	}

	public void area() {
		double result = 3.14 * radius * radius;
		System.out.println("Area : " +result);
	}
}

class Rectangle implements Shape {
	double length;
	double height;

	Rectangle( double length,  double height) {
		this.length = length;
		this.height = height;
	}

	public void area() {
		double result = length * height;
		System.out.println("Area : "+result);
	}
}

public class interface2 {
	public static void main(String[] args) {
		Shape s;

		s = new Circle(5);
		s.area();

		s = new Rectangle(10,5);
		s.area();

	}
}
