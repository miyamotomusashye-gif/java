class Employee {
    int id;
    String name;

    Employee (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayEmployee () {
        System.out.println("Id : "+id+ " Name : "+name);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer (int id, String name, String programmingLanguage) {
        super (id, name);
        this.programmingLanguage = programmingLanguage;
    }

    void displayDevloper () {
        System.out.println("Expertise : "+ programmingLanguage);
    }
}

public class inheritance {
    public static void main(String[] args) {
        Developer dev = new Developer(101, "pratik", "python");

        dev.displayEmployee();
        dev.displayDevloper();

        Employee clark = new Employee(100, "alex");

        clark.displayEmployee();
    }
}
