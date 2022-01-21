/** Book.java
*This is a book class that extends from Publication and implements Comparable<Publication> and Printable interfaces
*@version 1.0
*This program creates a book  and contains a method to print information to a text file
*/

import java.io.*;

public class Book extends Publication implements Comparable<Publication>, Printable{

  /**The author of the book*/
  protected String m_author;
  /**The number of pages in the book*/
  protected int m_numPages;
  /**The book cover type (Hardback or Paperback)*/
  protected String m_bookCover;

  /**The default constructor
  */
  public Book(){
    super();
    m_author = "";
    m_numPages = 0;
    m_bookCover = "";
  }

  /**An overloaded constructor that creates a book
  * @param t - the title of the book
  * @param y - the publication year
  * @param p - the publisher
  * @param i - the ISBN number
  * @param a - the author
  * @param pages - the number of pages
  * @param h - the cover type
  */
  public Book(String t, int y, String p, int i, String a, int pages, String h){
    super(t, y, p, i);
    m_author = a;
    m_numPages = pages;
    m_bookCover = h;
  }

  /**The print method prints all information from book to a text file
  * @param fileName - the name of the file you want to print information to
  */
  public void print(String fileName){
    try{
      PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
      super.print(fileName);
      pw.println("Author: " + m_author);
      pw.println("Number of Pages: " + m_numPages);
      pw.println("Cover Type: " + m_bookCover);
      pw.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }

}
