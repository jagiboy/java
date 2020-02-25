
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {
 
    
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT AlbumId, title, ArtistId FROM albums";
        
        try (Connection conn = Connect.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("AlbumId") +  "\t" + 
                                   rs.getString("title") + "\t" +
                                   rs.getInt("ArtistId"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }
 
}