/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Empleado; // importamos los datos de empleado 
import java.awt.Component;
import  java.sql.*;
import javax.swing.JOptionPane;
import java.util.LinkedList;


public class modelEmpleado extends DbDatajava {
    
    public void mostrarDatos(int empId,String nombre,String apellido,int horasExtra,String AuxilioTrasporte,int salario){
       System.out.println("ID empleado:            "+empId);  // imprimimos la variable 
                System.out.println("Nombre:                 "+nombre);
                System.out.println("Apellido:               "+apellido);
                System.out.println("Valor Horas Extra       "+horasExtra);  // tambien podemos cambiar el numero por el nombre de la columna
                System.out.println("Auxilio De Transporte   "+AuxilioTrasporte);
                System.out.println("Salario                 "+salario);
                
                System.out.println("");
                 
    }
    
    
    public Empleado consultaEmpleadoId(String id) { // este id remplazar el valor de = ?
        
        
        Empleado emp = null;  // incialisamos variable de tipo empleado
        
        
        /* en empleado ya tenemos estos datos para establecer la conexion
           por eso no tenemos que crearlos nuevamente solo los traemos con
           con el metodo get
        */
        
        // Connection permite la coneccion con mysql y con los datos de conexion que ya hicimos
        try (Connection connetion = DriverManager.getConnection(getUrl(), getUser(),getPassword())) {
          
           
            /*creamos un query o comando sql para ejecutar una accion 
              y lo guardamos en la variable query 
              este query lo podemos practicar igual en mysql y si sirve 
              lo ponemos aqui para evitar herrores 
            */
            
            String query = "SELECT * FROM empleados WHERE id = ?;"; // ? significa consulta preparada
            
            PreparedStatement stmt = connetion.prepareStatement(query); //ejecutador de sentencia
            
            stmt.setString(1, id);// y aqui le decimos donde ejecute la sentencia y ? es cambiado por id
                                  // entonces le digo que si en el campo 1 hay alguien con el id que le doy
                                  
                                  
            ResultSet resul = stmt.executeQuery(); // guarda lo qu hacemos en la consulta
                                                   // y ejecuta
                                                   
            while (resul.next()){// en result queda el dato guardado
                
                int empId = resul.getInt(1); // se utiliza un get int o String o boolean 
                                             // para estraer el valor de result dependiendo el 
                                             // si el valor de la fila msql es int o string etc
                                             // y lo guardamos en una variable
                                             
               
                String nombre = resul.getString(2);  // le debemos o decir el nombre o la posicion
                String apellido = resul.getString(6);
                int horasExtra = resul.getInt(3);
                String AuxilioTrasporte = resul.getString(4);
                int salario = resul.getInt(5);
                
                mostrarDatos(empId, nombre,apellido,horasExtra, AuxilioTrasporte, salario);
                
               
                switch (AuxilioTrasporte) {
                case "true":
                    emp = new Empleado(nombre,apellido,horasExtra,true,salario); // asignamos los valores aqui si 
                    break;                                              // auxilioTrasporte es true
                                                                        // por que este devuelve un char
                case "false":
                    emp = new Empleado(nombre,apellido,horasExtra,false,salario);
                    break;
                    
                default:
                    throw new AssertionError();
            }

                 
            }
            
            // ahora vamos a retornar el valor de la variable empleado que lla inicializamos en null
            // haremos una condicion por que auxTransporte viene como un booleano
            
           
           
                                
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
     
       return emp;
    }
    
    public boolean crearEmpleado(String nombre,int horasExtra,boolean AuxilioTransp,int salario,String apellido){
        
        try{
            
            String AuxilioTrans;
            
            if(AuxilioTransp){
                AuxilioTrans ="true";
                
            }else{
                AuxilioTrans="false";
            }
            
            Connection connetion; 
            connetion = DriverManager.getConnection(getUrl(), getUser(),getPassword());
            String query =  "INSERT INTO `empleados`(`nombre`, `horasExtra`, `auxTransporte`, `salario`,"
                          + " `apellido`) VALUES (?,?,?,?,?)";
            
            PreparedStatement stmt = connetion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setInt(2, horasExtra);
            stmt.setString(3, AuxilioTrans);
            stmt.setInt(4, salario);
            stmt.setString(5, apellido);
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("test");
            
            //JOptionPane.showMessageDialog(parentComponent, stmt);}
            return true;
           
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            
        }
    
        return false;
    }
    
    public boolean editarEmpleado(int id ,String nombre,int horasExtra,boolean AuxilioTransp,int salario,String apellido){
      
         
        try{
            
            String AuxilioTrans;
            
            if(AuxilioTransp){
                AuxilioTrans ="true";
                
            }else{
                AuxilioTrans="false";
            }
            
            Connection connetion; 
            connetion = DriverManager.getConnection(getUrl(), getUser(),getPassword());
            String query =  "UPDATE `empleados`\n " +
                            "SET `nombre`=?,"
                    + "`horasExtra`=?,"
                    + "`auxTransporte`=?,"
                    + "`salario`=?,"
                    + "`apellido`=? WHERE id=?";
            
            PreparedStatement stmt = connetion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setInt(2, horasExtra);
            stmt.setString(3, AuxilioTrans);
            stmt.setInt(4, salario);
            stmt.setString(5, apellido);
            stmt.setInt(6, id);
            
            stmt.executeUpdate();
            stmt.close();
            System.out.println("test");
            
            //JOptionPane.showMessageDialog(parentComponent, stmt);}
            return true;
           
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            
        }
    
   
    
        
  
        
        return false;
    }
    
    public boolean eliminarEmpleado(String id){
        
        Empleado empleado = consultaEmpleadoId(id);
        
        if (empleado != null){
            try (Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())) {
                String query = "DELETE \n"+
                               "FROM `empleados` \n"+
                               "WHERE id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                
                stmt.setString(1, id);
                
                stmt.executeUpdate();
                
                stmt.close();
                
                return true;
                
            } catch (Exception e) {
                
                System.out.println("Error"+e.getMessage());
            }
        }else{
            return false;
        }
        return false;
        
    }
    
    public LinkedList<Empleado> listaEmpleado(){
       LinkedList<Empleado> empleadoLista = new LinkedList<> ();
       Empleado empleado = null;
       
        try (Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){
            String query = "SELECT id ,nombre,horasExtra,auxTransporte,salario,apellido FROM `empleados`";
            Statement stmt = connection.createStatement();
            ResultSet resul = stmt.executeQuery(query);
            
            while(resul.next()){
                
                int empId = resul.getInt(1);
                String nombre = resul.getString(2);
                int vlrHoraExtra = resul.getInt(3);
                String auxTrans = resul.getNString(4);
                int salario = resul.getInt(5);
                String apellido = resul.getString(6);
                
                switch (auxTrans) {
                    case "true": 
                        empleado = new Empleado(empId, nombre, apellido, vlrHoraExtra, true, salario);
                        break;
                    case "false":
                        empleado = new Empleado(empId, nombre, apellido, vlrHoraExtra, true, salario);
                        break;         
                }
                empleadoLista.add(empleado);     
            }
            stmt.close();
            resul.close();
            return empleadoLista;
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
          return empleadoLista;
    }
    
    
}
