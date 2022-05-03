package databaseSQL.queries;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Program.javaDatabase.Database;
import databaseSQL.connection.DBConnection;




public class SelectQueries {



  public SelectQueries() {}

  
  
  public static String getStudentsFromStudents() {
    String typeOfStudy;
    LocalDate birthDate;
    String selectQuery = "SELECT * FROM students";
    StringBuilder returnstring = new StringBuilder("");
    

    Connection conn = DBConnection.getDBConnection();
    try (Statement prStmt = conn.createStatement();
        ResultSet rs = prStmt.executeQuery(selectQuery)) {
      while (rs.next()) {
        if((rs.getInt("ID"))!= Database.nextStudentId) Database.nextStudentId++;
        typeOfStudy = rs.getString("type");
        birthDate = LocalDate.parse(rs.getString("birthdate"));
      returnstring.append((rs.getInt("ID")+" "+typeOfStudy+" "+rs.getString("name")+" "+rs.getString("surname")+" "+birthDate)+";");
      return returnstring.toString();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return returnstring.toString();
  }


  public static String getGradesFromGrades(){
    String selectQuery = "SELECT * FROM grades";
    var returnstring = new StringBuilder("");

    Connection conn = DBConnection.getDBConnection();
    try (Statement prStmt = conn.createStatement();
        ResultSet rs = prStmt.executeQuery(selectQuery)) {
      while (rs.next()) {
        
      returnstring.append(rs.getString("ID")+" "+rs.getString("grade")+";") ;
      return returnstring.toString();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return returnstring.toString();
  }

}

