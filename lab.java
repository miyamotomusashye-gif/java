import java.util.*;

class Book {
    private int Id;
    private String title;
    private String author;
    private Boolean isIssued;

    public Book(int Id, String title, String author ) {
        this.Id = Id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }
    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book -" +title+ " Issued Successfully !");
        } else {
            System.out.println("Book -"+ title+" already issued");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book -" +title+ " Returned Successfully !");
        } else {
            System.out.println("Book -"+title+ " not issued");
        }
    }

    public void displayBook() {
        System.out.println("ID : "+Id+ " | TITLE : "+title+ " by " +author+ " | STATUS : "+ (isIssued ? "Issued"  : "Available") );
    }
}

class Library {
    private static int totalBooks = 0;
    private static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
        totalBooks++;
        System.out.println("Book "+ book.getTitle()+ " added in lab");
    }

    public static void issueBook(int Id) {
        for( Book b : books)  {
            if (b.getId() == Id) {
                b.issueBook();
                return;
            }
        }
    }

    public static void returnBook(int Id) {
        for ( Book b : books) {
            if (b.getId() == Id) {
                b.returnBook();
                return;
            }    
        }System.out.println("invalid");
    }

    public static void viewBooks() {
        for ( Book b : books) {
            b.displayBook();
        }
    }

    public static void totalBooks() {
        System.out.println("Total " +totalBooks+ " Books in lab");
    }
}

public class lab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b1 = new Book(101, "Let's Learn with me", "Pratik Aher");
        Library.addBook(b1);
        Book b2 = new Book(102, "Let's Orchestatre with me", "Pratik Aher");
        Library.addBook(b2);

        int choice;

        do {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Library Management  System");
            System.out.println("1.Add 2.Issue 3.Return 4.View 5.Total 6.Exit lab");
            System.out.print("Select option : ");
            choice =  sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID : ");
                    int Id =  sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter title : ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name : ");
                    String name = sc.nextLine();
                    Book userBook = new Book(Id, title, name);
                    Library.addBook(userBook);
                    break;
                case 2:
                    System.out.print("Enter Book ID : ");
                    int issueId = sc.nextInt();
                    Library.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter Book ID : ");
                    int returnId =  sc.nextInt();
                    Library.returnBook(returnId);
                    break;
                case 4: 
                    Library.viewBooks();
                    break;
                case 5:
                    Library.totalBooks();
                    break;
                case 6: 
                    System.out.println("Exiting lab...");
                    break;
                default:
                    System.out.println("Enter valid choice !");
            }
        } while (choice != 6);
        sc.close();
    }
}
