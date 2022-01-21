/** Database.java
*This is a database (driver) class
*@version 1.0
*This program is the driver class for Publication.java, Book.java, Journal.java, EJournal.java, and Printable.java
*It prompts user to:
* Create a publication, which asks the user for the type of publication to create and then prompts for the appropriate attribute values, and stores it in the database
* Print information for a publication to a file given the ISBN and the desired file name.
* List all publications (year and title only) in increasing order of publication date.
* Delete a publication from the database given the ISBN.
* Exit
*/
import java.util.Scanner;
import java.util.*;

public class Database{

  /**The main method*/
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    HashMap<Integer, Publication> m_database = new HashMap<Integer, Publication>();
    Database database = new Database();
    boolean keepPrompting = true;

    while(keepPrompting == true){ //keep prompting until user wants to exit
      System.out.println("-------------------------");
      System.out.println("Would you like to: \n1) Create A Publication. \n2) Print Information. \n3) Sort Publications. \n4) Delete a Publication. \nExit. \nChoose 1-5 or '0' to exit, then click return.");
      int userInput = scnr.nextInt();
      scnr.nextLine();

//user choose option 1: create a publication
      if (userInput == 1){
        boolean isValid = false;

        System.out.println("What type of publication? \nEnter '1' for Book | '2' for Journal | '3' for EJournal");
        int type = scnr.nextInt();
        scnr.nextLine();

        if (type == 1 || type == 2 || type == 3){
          isValid = true;
        }

        //keep prompting for publication until it is valid
        while (isValid == false){
          System.out.println("Invalid Publication. ");
          System.out.println("What type of publication? \nEnter '1' for Book | '2' for Journal | '3' for EJournal");
          type = scnr.nextInt();
          scnr.nextLine();
          if (type == 1 || type == 2 || type == 3){
            break;
          }
        }

        System.out.println("What is the title? ");
        String title = scnr.nextLine();

        System.out.println("What is the publication year? ");
        int publicationYear = scnr.nextInt();
        scnr.nextLine();

        System.out.println("Who is the publisher? ");
        String publisher = scnr.nextLine();

        System.out.println("What is the ISBN number? ");
        int ISBNNum = scnr.nextInt();
        scnr.nextLine();

        //if it is a book, prompt for appropriate attributes
        if (type == 1){
          System.out.println("Who is the author? ");
          String author = scnr.nextLine();

          System.out.println("How many number of pages? ");
          int numPages = scnr.nextInt();
          scnr.nextLine();

          System.out.println("Is it a hardback or paperback? ");
          String hardback = scnr.nextLine();

          //create a Book with the user input's attributes
          Book book = new Book(title, publicationYear, publisher, ISBNNum, author, numPages, hardback);
          m_database.put(ISBNNum, book);
        }

        //if it is a journal, prompt for appropriate attributes
        else if (type == 2 || type == 3){
          System.out.println("Who is the editor? ");
          String editor = scnr.nextLine();

          System.out.println("What is the issue number? ");
          int issueNum = scnr.nextInt();
          scnr.nextLine();

          //create a Journal with the user input's attributes
          Journal journal = new Journal(title, publicationYear, publisher, ISBNNum, editor, issueNum);
          m_database.put(ISBNNum, journal);

          //if it is a ejournal, prompt for appropriate attributes
          if (type == 3){
            System.out.println("What is the URL? ");
            String url = scnr.nextLine();

            System.out.println("What is the publication fee? ");
            double fee = scnr.nextDouble();

            //create an EJournal with the user input's attributes
            EJournal eJournal = new EJournal(title, publicationYear, publisher, ISBNNum, editor, issueNum, url, fee);
            m_database.put(ISBNNum, eJournal);
          }
        }
        System.out.println("\n***Publication Created.***\n");
      }

//user chose option 2: print information
      else if (userInput == 2){
        System.out.println("Enter ISBN you would like to print: ");
        int userInput_ISBN = scnr.nextInt();
        scnr.nextLine();

        System.out.println("Enter file name:");
        String userInput_fileName = scnr.nextLine();

        Publication userPublication = m_database.get((Integer)userInput_ISBN);
        userPublication.print(userInput_fileName);

        System.out.println("\n***Information Printed to " + userInput_fileName + ".***\n");
      }

//user chose option 3: list publications by year
      else if (userInput == 3){
        ArrayList<Publication> publicationList = new ArrayList<Publication>();
        for (HashMap.Entry<Integer, Publication> hash : m_database.entrySet()) {
          publicationList.add(hash.getValue());
        }
        Collections.sort(publicationList);
        for (Publication pubs : publicationList){
          System.out.println(pubs.getPublicationYear() + ": " + pubs.getTitle());
        }
        System.out.println("\n***Database Sorted.***\n");
      }

//user chose option 4: delete a publication
      else if (userInput == 4){
        System.out.println("Enter ISBN you would like to delete: ");
        int ISBNToDelete = scnr.nextInt();
        scnr.nextLine();

        m_database.remove(ISBNToDelete);
        System.out.println("\n***Publication Deleted.***\n");
      }

//user chose to exit:
      else {
        keepPrompting = false;
      }
    }
  }

}
