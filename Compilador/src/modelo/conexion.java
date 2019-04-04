/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class conexion {
    public static Connection cn = null;
    public static Statement statement;
    public static ResultSet resultset;
    private static PreparedStatement pstm;
    public static int psi_afectados;
    //Y ahora si queremos los valores del properties:
    private static String driver = "";
    private static String url = "";
    private static String usuario = "";
    private static String contrasena = "";
    
    private static int il_usu = 0;
    private static String is_usu = "";
    private static int il_grupo = 0;

    static FileInputStream inputStream = null;
    private static int ii_con = 0; //Cero si no se conecto o 1 si està conectado
    
    public static boolean Conectar(){
       boolean result = true;
        try{
            //Para acceder a los datos del .properties usaremos esta instruccion:
            inputStream =  new FileInputStream("syscar.properties"); 
            //Ahora inicializamos el properties:
            Properties properties = new Properties ();
            try{		
                properties.load(inputStream);
                inputStream.close();
                //Y ahora si queremos los valores del properties:
                driver = properties.getProperty("driver");
                url = properties.getProperty("url");
                usuario = properties.getProperty("usuario");
                contrasena = properties.getProperty("contrasena");
                ii_con = 1;
            } catch(IOException ex) {
                ii_con = 0;
                ex.printStackTrace();
            } 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (NullPointerException nulo){
            nulo.printStackTrace();
        } catch (Exception excep){
            excep.printStackTrace();
        }
        
        try{

        Class.forName(driver);
        cn = DriverManager.getConnection(url, usuario, contrasena);
        ii_con = 1;

          //  statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null, "Driver no localizado: "+Driver);
            result = false;
        }catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Error en la conexion con la BD: "+Fonte);
            result = false;
            ii_con = 0;
        }
        return result;
    }
    
    public static void desconecta(){
        boolean result = true;
        try{
            cn.close();
            JOptionPane.showMessageDialog(null, "BD cerrada");
            ii_con = 0;
        }catch(SQLException errorSQL){
            JOptionPane.showMessageDialog(null, "No fue posible cerrar la BD: "+errorSQL.getMessage());
            result = false;
        }
    }
    
    /* ResultSet executeQuery(String sql)
    * Devuelve un ResusltSet para su manipulación.
    */
    public static ResultSet ejecuteSQL(String sql){
	try{
            statement = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "No fue posible ejecutar la instrucción QUERY: \n\r"+
                    sqlex.getMessage()+", \n\rEl sql pasado fue: "+sql);
            return null;
        }
        return resultset;
    }   
    /* int executeUpdate(String sql)
     * Devuelve la cantidad de registros afectados
     */
    public static int ejecuteUPD(String sql){
        try{
            statement = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            psi_afectados = statement.executeUpdate(sql);
        }
        catch(SQLException sqlex)
        {
            psi_afectados = 0;
            JOptionPane.showMessageDialog(null, "No fue posible ejecutar la instrucción UPDATE: \n\r"+
                    sqlex.getMessage()+", \n\rEl sql pasado fue: "+sql);
        }
        return psi_afectados;
    }
	
    public static PreparedStatement prepStatement(String sql){
        try{
           pstm = cn.prepareStatement(sql);
        } catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, "No fue posible ejecutar la instrucción UPDATE: \n\r"+
            sqlex.getMessage()+", \n\rEl sql pasado fue: "+sql);
        }
        return pstm;
    }
    public static int getUserId(){
        return il_usu;
    }
    public static void setUserId(int aruser){
        il_usu = aruser;
    }

    public static String getUserName(){
        return is_usu;
    }
    public static void setUserName(String arname){
        is_usu = arname;
    }
    public static int getGrupoId(){
        return il_grupo;
    }
    public static void setGrupoId(int aruser){
        il_grupo = aruser;
    }
    public static int isConected(){
        return ii_con;
    }
}

