//Lalo_P
import java.sql.*;
public class Infante {
    
    String curp, nombre, sexo, fecha, estado;
    
    public Infante(){
        
    }

    public Infante(String curp, String nombre, String sexo, String fecha, String estado) {
        this.curp = curp;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    //INSERT
    public int insertar(Connection con){
        int resulato = 0;
        try {
            String sql = "INSERT INTO infantes VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curp);
            ps.setString(2, nombre);
            ps.setString(3, sexo);
            ps.setString(4, fecha);
            ps.setString(5, estado);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resulato;
        }
    }
    
    //DELATE
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELATE FROM infantes WHERE curpi = ?";
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
            String sql = "UPDATE infantes SET nombrei = ?, sexoi = ?, fecha_nac = ?, estadoi = ? WHERE curp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, fecha);
            ps.setString(4, estado);
            ps.setString(5, curp); // curp = ?
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
}
