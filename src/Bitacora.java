//Lalo_P
import java.sql.*;
public class Bitacora {
    
    String folio, tiempo, tipo, observaciones, infantes, responsables, educadores;
    
    static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";

    Bitacora() {
         
    }
    
     

    public Bitacora(String folio, String tiempo, String tipo, String observaciones, String infantes, String responsables, String educadores) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.infantes = infantes;
        this.responsables = responsables;
        this.educadores = educadores;
    }
    
        //INSERT
    public int insertar(Connection con){
        int resulato = 0;
        try {
            String sql = "INSERT INTO bitacora VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, tiempo);
            ps.setString(3, tipo);
            ps.setString(4, observaciones);
            ps.setString(5, infantes);
            ps.setString(6, responsables);
            ps.setString(7, educadores);
            
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
            String sql = "DELETE FROM bitacora WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            
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
            String sql = "UPDATE bitacora SET tiempo = ?, tipo = ?, observaciones = ?, infantes_curpi = ?, responsables_curpr = ?, educadores_curpe = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, infantes);
            ps.setString(5, responsables);
            ps.setString(6, educadores);
            ps.setString(7, folio);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    
}
