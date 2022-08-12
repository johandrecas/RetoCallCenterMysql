/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
/*Esto es un comentario*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CallCenter {
    
    private ArrayList<Empleado> empleados= new ArrayList<>();  // creamos lista tipo private

    
// le creamos metodo get y set para obtener e ingresar valores  
    public ArrayList<Empleado> getEmpleados() { // devuelve un array tipo empleado
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
   /* Creamos Metodo
      se crea array que debuelve un array tipo double
      y recibe un array de empleados */
    
    public ArrayList<Double>liquidarNomiaEmp (ArrayList<Empleado>empleados){
       
        ArrayList<Double> nominas = new ArrayList();// se crea array tipo double 
        
        if ( empleados == null){
            return null;
        }else {
            
            // recorremos el array que me etra tipo empleado
            // que se guardo en la variable empleados array tambien
            
            for(Empleado empleado : empleados){
              double neto; // variable tipo double 
              
              
              // sacamos todos los valores del array ingresado y 
              // los guardamos en estas variables 
              
              double valorHoraExtra=empleado.getHorasExtra();
              double salario = empleado.getSalario();
              boolean auxTran = empleado.isAuxilioTransporte();
              double aportes = (salario+valorHoraExtra)*0.08;
              
              if (auxTran){// si esto es true
                  neto = (salario + valorHoraExtra*106454)-aportes;
              }else{
                  neto = (salario+valorHoraExtra)-aportes;
              }
              nominas.add(neto);// guardamos valor en el array definido al principio
            }
                
        }
        return nominas;// returnamos un array tipo double como se pide al inicio
    }
     
    
     public ArrayList<Double>liquidarPrestacionesEmp(ArrayList<Empleado>empleados){
            ArrayList<Double>prestaciones = new ArrayList<>();
         
          if ( empleados == null){
            return null;
            
          }else {
            
            // recorremos el array que me etra tipo empleado
            // que se guardo en la variable empleados array tambien
            
            for(Empleado empleado : empleados){
                
                
               // sacamos todos los valores del array ingresado y 
              // los guardamos en estas variables 
              double vlrPrestaciones,primas,cesantias,intCesantias,vacaciones; // variable tipo double 
              int vlrAuTrans = 106454;   
              double valorHoraExtra=empleado.getHorasExtra();
              double salario = empleado.getSalario();
              boolean auxTran = empleado.isAuxilioTransporte();
              
              if(auxTran){
                   primas = (salario + valorHoraExtra+vlrAuTrans) *0.0833;
                  cesantias = (salario+valorHoraExtra+vlrAuTrans) *0.0833;
                   intCesantias =(cesantias*0.12);
                   vacaciones = (salario*0.0416);
                  
                  
              }else{
                  
                   primas = (salario + valorHoraExtra) *0.0833;
                   cesantias = (salario+valorHoraExtra) *0.0833;
                   intCesantias =(cesantias*0.12);
                   vacaciones = (salario*0.0416);
              }
               vlrPrestaciones = (primas + cesantias + intCesantias + vacaciones);  
               prestaciones.add(vlrPrestaciones);
              }
            return prestaciones;
            }
              
              
     }
     
     
     //sobrecarga de metodos el mismo metodo con distintos parametros
    
     public ArrayList<Double>liquidarNomiaEmp (Empleado empleado){
       
        ArrayList<Double> nomina = new ArrayList();// se crea array tipo double 
        
        if ( empleado == null){
            return null;
        }else {
            
        
              double neto; // variable tipo double 
              double valorHoraExtra=empleado.getHorasExtra();
              double salario = empleado.getSalario();
              boolean auxTran = empleado.isAuxilioTransporte();
              double aportes = (salario+valorHoraExtra)*0.08;
              
              if (auxTran){// si esto es true
                  neto = (salario + valorHoraExtra*106454)-aportes;
              }else{
                  neto = (salario+valorHoraExtra)-aportes;
              }
              nomina.add(neto);// guardamos valor en el array definido al principio
            
                
        }
        return nomina;// returnamos un array tipo double como se pide al inicio
    }
     
     public ArrayList<Double>liquidarPrestacionesEmp(Empleado empleado){
            ArrayList<Double>prestacion = new ArrayList<>();
         
          if ( empleado == null){
            return null;
            
          }else {
        
              double vlrPrestaciones,primas,cesantias,intCesantias,vacaciones; // variable tipo double 
              int vlrAuTrans = 106454;   
              double valorHoraExtra=empleado.getHorasExtra();
              double salario = empleado.getSalario();
              boolean auxTran = empleado.isAuxilioTransporte();
              
              if(auxTran){
                   primas = (salario + valorHoraExtra+vlrAuTrans) *0.0833;
                  cesantias = (salario+valorHoraExtra+vlrAuTrans) *0.0833;
                   intCesantias =(cesantias*0.12);
                   vacaciones = (salario*0.0416);
                  
                  
              }else{
                  
                   primas = (salario + valorHoraExtra) *0.0833;
                   cesantias = (salario+valorHoraExtra) *0.0833;
                   intCesantias =(cesantias*0.12);
                   vacaciones = (salario*0.0416);
              }
               vlrPrestaciones = (primas + cesantias + intCesantias + vacaciones);  
               prestacion.add(vlrPrestaciones);
              
            return prestacion;
            }
              
              
     }
     
     
     public HashMap<Integer,ArrayList> procesoMasivoNominaPrestaciones(LinkedList<Empleado> empleadoLista){
           
        HashMap<Integer,ArrayList> listaNominas = new HashMap<Integer,ArrayList>();
            
         if (empleadoLista != null){
            
              for (Empleado empleado : empleadoLista) {
              ArrayList liquidarEmpleado = new ArrayList<>();
              ArrayList<Double> nomina = new ArrayList();
              ArrayList<Double>prestacion = new ArrayList<>();
             
              int id = empleado.getId();
              String nombre = empleado.getNombre()+"  "+empleado.getApellido();
              nomina = liquidarNomiaEmp(empleado);
              prestacion = liquidarNomiaEmp(empleado);
              
              liquidarEmpleado.add(id);
              liquidarEmpleado.add(nombre);
              liquidarEmpleado.add(Math.round(nomina.get(0)));
              liquidarEmpleado.add(Math.round(prestacion.get(0)));//
              prestacion.get(0);
              
              listaNominas.put(id, liquidarEmpleado);
              }
         }else{
             return null;
         }   
        
         
       return listaNominas;  
     }
    
}
