/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;
import static com.mysql.cj.conf.PropertyKey.USER;
import java.sql.*;
import java.util.ArrayList;
import model.PatientClass;
/**
 *
 * @author 91903
 */
public class DatabaseConnector {
    //datamembers
    private static final String DB_URL = "jdbc:mysql://localhost:3306/assignmentdb?useSSL=false";
    private static final String USERNAME = "root";
   // private static final String DB_PASSWORD = "my-secret-pw";
    private static final String PASSWORD = "my-secret-pw";
    //CRUD OPERATIONS
    //C-CREATE
    public static void addPatient(PatientClass p1) {
        String query="INSERT INTO patient(name, last_name, gender, pateint_type,age,email) VALUES ( ?, ?, ?, ?, ?, ?)";
        try{
            //create a connection
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, p1.getName());
        stmt.setString(2, p1.getLast_name());
        stmt.setString(3, p1.getGender());
        stmt.setString(4, p1.getPatientType());
        stmt.setInt(5, p1.getAge());
        stmt.setString(6, p1.getEmail());
        int rows = stmt.executeUpdate();
        System.out.println("Rows Inserted: " +rows);
        
        
        conn.close();
        }
        catch(SQLException sqle){
        System.out.println("SQL EXCEPTION OCCURED");
        System.out.println(sqle);
        }
        catch (Exception ex){
             System.out.println(ex);
        }
        }
  
    
    //R-READ
    
       
        public static ArrayList<PatientClass> getPatients(){
            
            
    ArrayList <PatientClass> patients = new ArrayList();
    String query= "SELECT * FROM patient";
    try{
        Connection conn= DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        while(rs.next()){
            PatientClass p1 = new PatientClass();
            p1.setId(rs.getInt("id"));
            p1.setName(rs.getString("name"));
            p1.setLast_name(rs.getString("last_name"));
            p1.setGender(rs.getString("gender"));
             p1.setPatientType(rs.getString("pateint_type"));
            p1.setAge(rs.getInt("age"));
            
            p1.setEmail(rs.getString("email"));
           
            patients.add(p1);
            
            
        }
        rs.close();
        
        conn.close();
        
        
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
        
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return patients;
}
      
        
    //U-UPDATE
    public static void updatepatient(PatientClass oldPatient,PatientClass updatedpatient){
        String query= "UPDATE patient SET name= ?,last_name=?, gender=?, pateint_type=? ,age=?, email=? WHERE id=?";
       

    try{

        Connection conn= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, updatedpatient.getName());
        stmt.setString(2, updatedpatient.getLast_name());
        stmt.setString(3, updatedpatient.getGender());
         stmt.setString(4, updatedpatient.getPatientType());
          stmt.setInt(5, updatedpatient.getAge());
        stmt.setString(6, updatedpatient.getEmail());
       
        
       
        int rows = stmt.executeUpdate();

        System.out.println("Rows Updated: "+rows);


        conn.close();

    }catch(SQLException sqle){

        System.out.println("SQL Exception Occured");

        System.out.println(sqle);

    }catch(Exception ex){

        System.out.println("SQL Exception Occured");

        System.out.println(ex);

    }

 
}

        //D-DELETE
    public static void deletePatient(PatientClass p1){
        
    String query= "DELETE FROM patient WHERE id= ?";
    try{
        Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,p1.getId());
        int rows = stmt.executeUpdate();
        System.out.println("Rows Deleted: "+rows);
        conn.close();
    }catch(SQLException sqle){
        System.out.println("SQL Exception Occured");
        System.out.println(sqle);
    }

 
}
        
    }
    
   
    
    

