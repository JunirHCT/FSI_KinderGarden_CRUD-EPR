//Lalo_P
import java.sql.*;
public class Educadores {
    
    String curp, nombre, sexo, telefono, direccion, estado;
    static String todos = "SELECT * FROM educadores ORDER BY nombree DESC";
    static String curps = "SELECT curpe From educadores ORDER BY curpe";

    Educadores() {
         
    }
    
 
    
    public Educadores(String curp, String nombre, String sexo, String telefono, String direccion, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    //INSERT
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO educadores VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, sexo);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, estado);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    //DELATE
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM educadores WHERE curpe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    //UPDATE
    public int actualizar(Connection con){
        int resultado = 0;
        try {
            String sql = "UPDATE educadores SET nombree = ?, sexoe = ?, telefonoe = ?, direccion = ?, estadoe = ? WHERE curpe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, telefono);
            ps.setString(4, direccion);
            ps.setString(5, estado);
            ps.setString(6, curp); // curp = ?
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
   
}
