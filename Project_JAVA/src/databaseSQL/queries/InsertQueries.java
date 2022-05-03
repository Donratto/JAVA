package databaseSQL.queries;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import databaseSQL.connection.DBConnection;



/**
 * 
 * @author Pavel �eda (154208)
 *
 */
public class InsertQueries {

  public InsertQueries() {}



  public static void insertNewStudent(Integer id, String name, String surname, String birthDate, String type) {
    if (id == null || name == null || surname == null || birthDate == null || type == null)
      throw new NullPointerException("ID, name, surname and birthdate must be set.");

    Connection conn = DBConnection.getDBConnection();

    String insertUser = "INSERT INTO students " + "(ID,name,surname,birthdate,type)" + "VALUES(?,?,?,?,?)";

    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
      prStmt.setInt(1, id);
      prStmt.setString(2, name);
      prStmt.setString(3, surname);
      prStmt.setString(4, birthDate);
      prStmt.setString(5, type);

      prStmt.executeUpdate();
      System.out.println("Insert was successful!");
    } catch (SQLException e) {
      System.out.println("Bad INSERT command!");
      // e.printStackTrace();
    }
  }

  public void insertNewGrade(Integer id, Integer grade) {
    if(id == null || grade == null)
      throw new NullPointerException("ID and grade must be set.");

    Connection conn = DBConnection.getDBConnection();

    String insertGrade = "INSERT INTO grades " + "(ID,grade)" + "VALUES(?,?)";

    try (PreparedStatement prStmt = conn.prepareStatement(insertGrade)) {
      prStmt.setInt(1, id);
      prStmt.setInt(2, grade);
      prStmt.executeUpdate();
      System.out.println("Insert was successful!");
    } catch (SQLException e) {
      System.out.println("Bad INSERT command!");
      // e.printStackTrace();
    }
  }
}




