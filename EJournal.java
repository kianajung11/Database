/** EJournal.java
*This is an ejournal class that extends from Journal and implements Comparable<Publication> and Printable interfaces
*@version 1.0
*This program creates an ejournal and contains a method to print information to a text file
*/

import java.io.*;
public class EJournal extends Journal implements Comparable<Publication>, Printable{

  /**The URL for the EJournal*/
  protected String m_URL;
  /**The publication fee*/
  protected double m_fee;

  /**The default constructor
  */
  public EJournal(){
    super();
    m_URL = "";
    m_fee = 0.0;
  }

  /**An overloaded constructor that creates an ejournal
  * @param t - the title of the book
  * @param y - the publication year
  * @param p - the publisher
  * @param i - the ISBN number
  * @param u - the URL
  * @param f - the publication fee
  */
  public EJournal(String t, int y, String p, int i, String e, int n, String u, double f){
    super(t, y, p, i, e, n);
    m_URL = u;
    m_fee = f;
  }

  /**The print method prints all information from ejournal to a text file
  * @param fileName - the name of the file you want to print information to
  */
  public void print(String fileName){
    try{
      PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
      super.print(fileName);
      pw.println("URL: " + m_URL);
      pw.println("Publication Fee: " + m_fee);
      pw.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }

}
