/** Publication.java
*This is an abstract publication class and implements Comparable<Publication> and Printable interfaces
*@version 1.0
*This program creates a publication  and contains a method to print information to a text file
*/

import java.io.*;
public abstract class Publication implements Comparable<Publication>,Printable{

  /**The title of the publication*/
  protected String m_title;
  /**The year it was published*/
  protected int m_publicationYear;
  /**The name of the publisher*/
  protected String m_publisher;
  /**The ISBN number*/
  protected int m_ISBN;

  /**The default constructor
  */
  public Publication(){
    m_title = "";
    m_publicationYear = 0;
    m_publisher = "";
    m_ISBN = 0;
  }

  /**An overloaded constructor that creates a publication
  * @param t - the title of the book
  * @param y - the publication year
  * @param p - the publisher
  * @param i - the ISBN number
  */
  public Publication(String t, int y, String p, int i){
    m_title = t;
    m_publicationYear = y;
    m_publisher = p;
    m_ISBN = i;
  }

  /**The accessor for the publication title
  * @return a string representing the title
  */
  public String getTitle(){
    return m_title;
  }
  /**The accessor for the publication year
  * @return a string representing the year it was published
  */
  public int getPublicationYear(){
    return m_publicationYear;
  }
  /**The accessor for the ISBN number
  * @return a string representing the ISBN number
  */
  public int getISBN(){
    return m_ISBN;
  }

  /**The compareTo method compares publications by year
  * @param p - the publication you want to compare
  * @return an int
  */
  public int compareTo(Publication p){
    if (this.m_publicationYear == p.m_publicationYear){
      return 0;
    } else if (this.m_publicationYear < p.m_publicationYear){
      return -1;
    } else{
      return 1;
    }
  }

  /**The print method prints the information from publication to a text file
  * @param fileName - the name of the file you want to print information to
  */
  public void print(String fileName){
    try{
      PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
      pw.println("Title: " + m_title);
      pw.println("Publication Year: " + m_publicationYear);
      pw.println("Publisher: " + m_publisher);
      pw.println("ISBN Number: " + m_ISBN);
      pw.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }

}
