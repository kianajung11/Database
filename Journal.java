/** Journal.java
*This is a journal class that extends from Publication and implements Comparable<Publication> and Printable interfaces
*@version 1.0
*This program creates a journal  and contains a method to print information to a text file
*/

import java.io.*;
public class Journal extends Publication implements Comparable<Publication>, Printable{

  /**The editor of the Journal*/
  protected String m_editor;
  /**The Issue Number*/
  protected int m_issueNum;

  /**The default constructor
  */
  public Journal(){
    super();
    m_editor = "";
    m_issueNum = 0;
  }

  /**An overloaded constructor that creates a journal
  * @param t - the title of the book
  * @param y - the publication year
  * @param p - the publisher
  * @param i - the ISBN number
  * @param e - the editor
  * @param n - the issue number
  */
  public Journal(String t, int y, String p, int i, String e, int n){
    super(t, y, p, i);
    m_editor = e;
    m_issueNum = n;
  }

  /**The print method prints all information from journal to a text file
  * @param fileName - the name of the file you want to print information to
  */
  public void print(String fileName){
    try{
      PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
      super.print(fileName);
      pw.println("Editor: " + m_editor);
      pw.println("Issue Number: " + m_issueNum);
      pw.close();
    } catch(IOException e){
      e.printStackTrace();
    }
  }

}
