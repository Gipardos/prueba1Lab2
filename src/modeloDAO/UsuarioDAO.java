
package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Mensaje;
import modelo.Usuario;
import vista.BandejaEntrada;



public class UsuarioDAO {
    Conexion con; 
    
    public UsuarioDAO() {
        this.con = new modeloDAO.Conexion();
    }
    
    
     public ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM usuario";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usuario = resultados.getInt("id_usuario");
                String nombre=resultados.getString("nombre");
                
                usuarios.add(new Usuario(id_usuario,nombre));
            }
            accesoBD.close();
            return usuarios;
            
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }  
     
    
      
     
}
