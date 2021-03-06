    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Conexion.dbName;
import static Controlador.Conexion.driver;
import static Controlador.Conexion.login;
import static Controlador.Conexion.url;
import Modelo.Administrador;
import Modelo.Materia;
import Modelo.Perfil;
import Modelo.Salon;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author negro
 */
public class ControllerSql {//public 

    Connection conexion;
    Statement stm;
    ResultSet rs;
    Usuario Usario;
    Materia Materia;
    Salon Salon;
   

    
    private static ControllerSql cs = new ControllerSql();
    
      public static ControllerSql getInstancia(){
        return cs;
    }
    
    public ControllerSql() {  //class public
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost/" + Conexion.dbName;
            conexion = DriverManager.getConnection(db, Conexion.login, Conexion.password);
            stm = conexion.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    
 private static int Ingreso(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="select  idPerfil from usuario where login=? and contrasenia=?";
        
           
            Connection cn= Conexion.getConn();
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setString(1,p.getLogin());
            ps.setString(2,p.getContrasenia());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
                
        }
        System.out.println(r);
        return r;
        
    }

  public boolean AgregarCampoBackFrame(int idusuario,String nombreFrame, String txtCampo, String txtdato) {
      
      int estado = 1;
        try {
            String query = " insert into backframe(idUsuario,jframe,txtdato,dato,estado)"
                    + " values (?,?,?,?,?)";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            
            preparedStmt.setInt(1,idusuario);
            preparedStmt.setString(2,nombreFrame);
            preparedStmt.setString(3,txtCampo);
            preparedStmt.setString(4,txtdato);
            preparedStmt.setInt(5,estado);
            

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    } 
  
    public ResultSet ConsultarBackFrame() {
        try {

            String query = "select * from backframe where estado = 1";
            Statement st = conexion.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }

       public boolean deleteBackFrame(int idUsuario,String jframe) {
           
     try {
            String query = "delete from backframe where idUsuario = ? and jframe=? and estado =1";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
    /**************************************************************************/       
       /*
      String myTableName3 ="CREATE TABLE IF NOT EXISTS `mybd` (\n" +
"  `idbd` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `servidor` varchar(255) DEFAULT NULL,\n" +
"  `login` varchar(255) DEFAULT NULL,\n" +
"  `password` varchar(255) DEFAULT NULL,\n" +
"  `dbName` varchar(255) DEFAULT NULL,\n" +          
"  `estado` bit(1) DEFAULT NULL,\n" +
"  PRIMARY KEY (`idbd`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
   /***************************************************************************/
  
    public boolean AgregarBd(String servidor,String login , String password , String dbName) {

        
        try {
            String query = "INSERT INTO mybd (servidor,login,password,dbName,estado)"
                + " VALUES (?,?,?,?,1);";
        

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, servidor);
            preparedStmt.setString(2, login);
            preparedStmt.setString(3, password);
            preparedStmt.setString(4, dbName);

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    /*
    Metodo para consultar el empleado en la base de datos se realiza la 
    busqueda a traves de la cedula.
    */

    public ResultSet ConsultarBd() {
        try {

            String query = "SELECT * FROM mybd ORDER BY idbd DESC LIMIT 1;";
            Statement st = conexion.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }   
        
       
   /**************************************************************************/ 
 
       /*
    `1idusuario` INT(11) NOT NULL,
	2`nombre` VARCHAR(255) NULL DEFAULT NULL,
	3`idPerfil` INT(11) NOT NULL,
	4`login` VARCHAR(45) NULL DEFAULT NULL,
	5`contrasenia` VARCHAR(45) NULL DEFAULT NULL,
	6`estado` BIT(1) NULL DEFAULT NULL,
       */
  
  
/**************************************************************************/ 
    public boolean AgregarUsuario(int idusuario,String nombre,int idPerfil,String login,String contrasenia,
            String tipoContrato,String habilitadoEn, int estadoDispo, int estado) {

        
            Usuario Usuario = new Usuario(idusuario, idusuario, nombre, null, login, contrasenia, true);
        
        try {
         
            String query = "INSERT INTO usuario (identificacion,nombre, idPerfil, login,contrasenia,tipoContrato,habilitadoEn,estadoDispo,estado) "
                    + "     VALUES (?,?,?,?,?,?,?,?,?);";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1,Usuario.getIdUsuario());
            preparedStmt.setString(2, Usuario.getNombre());
            preparedStmt.setInt(3, idPerfil);
            preparedStmt.setString(4,Usuario.getLogin());
            preparedStmt.setString(5, Usuario.getContrasenia());
            preparedStmt.setString(6,tipoContrato);
            preparedStmt.setString(7, habilitadoEn);
            preparedStmt.setInt(8, 1);
            preparedStmt.setInt(9, 1);
        
            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    
        
    }   
    
    /*
    @Modifica los datos del usuario
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */       
public boolean actualizarUsuario(int identificacion, String nombre,int idPerfil,String login,String contrasenia,
            String tipoContrato,String habilitadoEn, int estadoDispo, int estado){
//    
        log("Controller ACTUALIZAR");
        log(String.valueOf(identificacion));
        log(nombre);
        try {
           
            String query = " update usuario set nombre = ? , idPerfil= ? , login = ? , contrasenia = ? ," 
                    + "tipoContrato= ? , habilitadoEn = ? , estadoDispo = ? , estado = ? where identificacion = ?";
            
            log(query);

            PreparedStatement preparedStmt = conexion.prepareStatement(query);            
            preparedStmt.setString(1, nombre);
            preparedStmt.setInt(2, idPerfil);
            preparedStmt.setString(3,login);
            preparedStmt.setString(4,contrasenia);
            preparedStmt.setString(5,tipoContrato);
            preparedStmt.setString(6, habilitadoEn);
            preparedStmt.setInt(7, 1);
            preparedStmt.setInt(8, 1);
            preparedStmt.setInt(9,identificacion);
            preparedStmt.execute();    
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
  /*
    @Modifica los datos del Materia
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */       
public boolean actualizarMateria(int codMateria, String nombreMateria,int tipo,int  creditos,int intHoraria,
            int semestre){

        log("Controller ACTUALIZAR");
        
        try {
           
            String query = " update materia set  nombreMateria = ? , tipo = ? , creditos = ?, intHoraria = ? , semestre = ? where codMateria = ?";
            
            log(query);

            PreparedStatement preparedStmt = conexion.prepareStatement(query);            
            preparedStmt.setString(1, nombreMateria);
            preparedStmt.setInt(2, tipo);
            preparedStmt.setInt(3, creditos);
            preparedStmt.setInt(4, intHoraria);
            preparedStmt.setInt(5, semestre);
            preparedStmt.setInt(6, codMateria);
            
            
            
           
            preparedStmt.execute();    
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    /*
    @retornar la listado de perfil a combobox en la vistaUsarios
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */
    public List<Usuario> listadoUsuarioProfesores(){
        List<Usuario> UsuarioProfesores = new Stack<Usuario>();
        Perfil Perfil = new Perfil(3, "Profesor", 1);
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement("select idusuario,identificacion,nombre,idPerfil,login,contrasenia,estado from usuario where idPerfil= 3");
            rs = ps.executeQuery();
            while(rs.next()){
                //Proveedor p = new Proveedor(rs.getInt(4),rs.getString(1), rs.getString(2), rs.getString(3));
                Usuario p = new Usuario(rs.getInt(1),rs.getInt(2),rs.getString(3),(Perfil) ,rs.getString(5),rs.getString(6),true);
                UsuarioProfesores.add(p);
                log(String.valueOf(p));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return UsuarioProfesores;
    }
    
    /*
    @retornar la listado de perfil a combobox en la vistaUsarios
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */
    public List<Perfil> listadoPerfil(){
        List<Perfil> Perfiles = new Stack<Perfil>();
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement("SELECT idperfil,nombre,estado  FROM perfil");
            rs = ps.executeQuery();
            while(rs.next()){
                //Proveedor p = new Proveedor(rs.getInt(4),rs.getString(1), rs.getString(2), rs.getString(3));
                Perfil p = new Perfil(rs.getInt(1),rs.getString(2),rs.getInt(3));
                Perfiles.add(p);
                log(String.valueOf(p));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Perfiles;
    }
    
    
    
    /*
    @retornar la listado de materia a vista la vistaGrupos
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */
    public List<Materia> listadoMaterias(){
        List<Materia> Materias = new Stack<Materia>();
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement("SELECT  idMateria,codMateria,nombreMateria,tipo,creditos,intHoraria,semestre,idAdministradorM  "
                    + " FROM materia");
            rs = ps.executeQuery();
            while(rs.next()){
                //Proveedor p = new Proveedor(rs.getInt(4),rs.getString(1), rs.getString(2), rs.getString(3));
                Materia p = new Materia(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),
                rs.getInt(6),rs.getInt(7),null);
                Materias.add(p);
                log(String.valueOf(p));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Materias;
    }
    
    
    /*
    @retornar la listado de materia a vista la vistaGrupos
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */
    public List<Salon> listadoSalones(){
        List<Salon> Salones = new Stack<Salon>();
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement("select idsalon,codigoSalon,nombreSalon,ubicacion,estado from salon");
            rs = ps.executeQuery();
            while(rs.next()){
                //Proveedor p = new Proveedor(rs.getInt(4),rs.getString(1), rs.getString(2), rs.getString(3));
                Salon p = new Salon(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),true);
                Salones.add(p);
                log(String.valueOf(p));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Salones;
    }
       
 /**************************************************************************/ 
  
  
  
  public boolean CrearMateria(int  codMateria,String nombreMateria,String  tipo, int creditos,int  intHoraria,int semestre
   
  ) {

        int estado=1;
      //  int p = Integer.parseInt(idPerfil);
        Materia Materia = new Materia(codMateria, codMateria, nombreMateria, tipo, creditos, intHoraria, semestre, null);
       
        try {
            String query = "INSERT INTO materia (codMateria,nombreMateria,tipo,creditos,intHoraria,semestre,idAdministradorM)"
                
                            + " VALUES (?,?,?,?,?,?,?);";
        

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
           
          
  
          preparedStmt.setInt(1, codMateria);
          preparedStmt.setString(2, nombreMateria);
          preparedStmt.setString(3, tipo);
          preparedStmt.setInt(4, creditos);
          preparedStmt.setInt(5, intHoraria);
          preparedStmt.setInt(6, semestre);
          preparedStmt.setInt(7, 1);
         
          
        
            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    } 
  
      public boolean EliminarMateria(int idMateria) {
           
     try {
            String query = "delete from materia where idMateria = ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
  
  
   /**************************************************************************/ 
  /*Funciones CRUD Salon*/
      
    /*
     @Crea los datos del salon
     @auto jose vanegas - jvanegasv@ucentral.edu.co
     */
    public boolean AgregarSalon(int idSalon ,String codigoSalon, String nombreSalon, String ubicacion, int estado) {

        Salon Salon = new Salon(idSalon,codigoSalon, nombreSalon, ubicacion, true);

        try {

            String query = "INSERT INTO salon (codigoSalon,nombreSalon,ubicacion,estado) "
                    + "VALUES (?,?,?,?);";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString(1, Salon.getCodigoSalonM());
            preparedStmt.setString(2, Salon.getNombreSalon());
            preparedStmt.setString(3, Salon.getUbicacion());
            preparedStmt.setInt(4, 1);

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
      
    
 
     /*
    @Modifica los datos del salon
    @auto jose vanegas - jvanegasv@ucentral.edu.co
    */       
public boolean actualizarSalon(String codigoSalon,String nombreSalon,String ubicacion,int  estado){
//    
        log("Controller ACTUALIZAR SALON");
        
    
        try {
           
  String query = " update salon set  nombreSalon = ? , ubicacion = ? ,estado= ?  where codigoSalon = ?";
            
            log(query);

            PreparedStatement preparedStmt = conexion.prepareStatement(query);            
           
            
            preparedStmt.setString(1,nombreSalon);
            preparedStmt.setString(2,ubicacion);
            preparedStmt.setInt(3,estado);
            preparedStmt.setString(4,codigoSalon);
            
            
            preparedStmt.execute();    
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
  
  /*******************************************************************************/
     /**************************************************************************/ 
  /*Funciones CRUD Grupo*/
      
    /*
     @Crea los datos del Grupo
     @auto jose vanegas - jvanegasv@ucentral.edu.co
     */
    public boolean AgregarGrupo(int materia ,int idbloque, String jornada,int estado) {

        

        try {

            String query = "INSERT INTO grupo (idMateria, idbloque, jornada, estado) VALUES (?,?,?,?);";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt(1, materia);
            preparedStmt.setInt(2, idbloque);
            preparedStmt.setString(3,jornada);
            preparedStmt.setInt(4, 1);

            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
    
     /*Funciones CRUD Bloque*/
      
    /*
     @Crea los datos del bloque
     @auto jose vanegas - jvanegasv@ucentral.edu.co
     */
    public boolean AgregarBloque(String codBloque,String dia,String hora,String horafinal,
            int estado,int idSalon) {

        try {

            String query = "INSERT INTO bloque (codBloque,dia,hora,horaFinal,estado,idsalon) VALUES (?,?,?,?,?,?);";

            // preparo la consulta para mi base de datos
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            
            preparedStmt.setString(1, codBloque);
            preparedStmt.setString(2, dia);
            preparedStmt.setString(3, hora);
            preparedStmt.setString(4, horafinal);
            preparedStmt.setInt(5,estado);
            preparedStmt.setInt(6, idSalon);
            
            // ejecuto mi query
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }


  public ResultSet ConsultarIdBloque() {
        try {

            String query = "select * from bloque";
            Statement st = conexion.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }  
    
  
  public static int IngresoLogin(Usuario p) throws ClassNotFoundException, SQLException
    {
        return Ingreso(p);
    }
  
      public void log(String a) {
        System.out.println("la valor  = " + " " + a);
    }  
}
