package connection;
import java.util.*;
import java.sql.*;

public class EmployeeManagement {

    static final String URL = "jdbc:mysql://localhost:3306/employee";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while(true) {
                System.out.println("==============EMPLOYEE MANAGEMENT=============");
                System.out.println("1.ADD   2.VIEW   3.UPDATE   4.DELETE   5.EXIT");
                System.out.println("Enter your choice : ");
                int choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        System.out.print("Enter id : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter salary : ");
                        double salary = sc.nextDouble();

                        String insert = "INSERT INTO emp VALUES(?,?,?)";
                        PreparedStatement ps1 = con.prepareStatement(insert);
                        ps1.setInt(1,id);
                        ps1.setString(2,name);
                        ps1.setDouble(3,salary);
                        ps1.executeUpdate();
                        System.out.println("Employee added");
                        break;
                    case 2:
                        String select = "SELECT *  FROM emp";
                        PreparedStatement ps2 = con.prepareStatement(select);
                        ResultSet rs = ps2.executeQuery();
                        while(rs.next()) {
                            System.out.println(rs.getInt(1) + " " + rs.getString(2) +" "+rs.getDouble(3) );
                        }
                        break;
                    case 3:
                        System.out.print("Enter id : ");
                        int Id = sc.nextInt();
                        System.out.println("Enter new name : ");
                        String uname = sc.nextLine();
                        System.out.print("Enter new salary : ");
                        double usalary = sc.nextDouble();
                        String update = "UPDATE emp SET name=?, salary=? WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(update);
                        ps3.setString(1,uname);
                        ps3.setDouble(2,usalary);
                        ps3.setInt(3,Id);
                        ps3.executeUpdate();
                        System.out.println("Employee Updated");
                        break;
                    case 4:
                        System.out.print("Enter id : ");
                        int did = sc.nextInt();
                        String delete = "DELETE FROM emp WHERE id=?";
                        PreparedStatement ps4 = con.prepareStatement(delete);
                        ps4.setInt(1,did);
                        ps4.executeUpdate();
                        System.out.println("Employee Deleted");
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice !");
                }
            }
        } catch(Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
    }
}
