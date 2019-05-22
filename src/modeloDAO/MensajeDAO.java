
package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Mensaje;
import modelo.Usuario;


public class MensajeDAO {
    Conexion con; 
    
     public ArrayList<Mensaje> getMensajesusuario(int id_receptor) {
        UsuarioDAO udao = new UsuarioDAO();
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje WHERE id_usr_receptor="+id_receptor;

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usr_emisor=resultados.getInt("emisor");
                Usuario ue=udao.getUsuariobyid(); 
                int id_mensaje=resultados.getInt("mensaje");
                
                String contenido=resultados.getString("contenido");
                
                mensajes.add(new Mensaje(id_usr_emisor,id_mensaje,contenido));

            }
            
            accesoBD.close();
            return mensajes;
            
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }  
     
     
     public void getUsuariobyid(){
         
     }
    
}
