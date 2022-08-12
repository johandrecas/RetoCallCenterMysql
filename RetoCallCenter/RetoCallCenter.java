/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoCallCenter;

import Clases.*;
import Modelo.modelEmpleado;
import java.util.ArrayList;

public class RetoCallCenter {
    
    public static void main(String[] args) {
        
       CallCenter liquidacion =  new CallCenter();
        
       ArrayList<Double> nominas = new ArrayList<>();
       ArrayList<Double> prestaciones = new ArrayList<>(); 
       ArrayList<Empleado> listEmpleado = new ArrayList<>();
       
       Empleado empleado = new Empleado();
       listEmpleado.add(empleado);
       
       Empleado empleado1 = new Empleado("claudia", 40, true, 160000);
       listEmpleado.add(empleado1);
       Empleado empleado2 = new Empleado("pablo", 25000, true, 190000);
       listEmpleado.add(empleado2);
       Empleado empleado3 = new Empleado("laura", 50000, false, 2000000);
       listEmpleado.add(empleado3);
       
       
       
       modelEmpleado empleado4 = new  modelEmpleado(); // instanciamos y consultamos 
       //empleado4.consultaEmpleadoId("2");  // aqui le digo que me traiga el empleado numero 1
       
       if (empleado4.consultaEmpleadoId("5") != null){
           listEmpleado.add(empleado4.consultaEmpleadoId("5"));
       }
       
       listEmpleado.add(empleado4.consultaEmpleadoId("4")); // y con este dato lleno lo puedo meter
                                                            // en esta lista de objetos hacerle sus procesos
       
       System.out.println("Liquidacion Nomina ");
       nominas = liquidacion.liquidarNomiaEmp(listEmpleado);// recibe la lista que creamos
                                                            // en las lineas anteriores 
                                                            
        for (int i = 0; i < nominas.size(); i++) {
            System.out.println("Nombre:  "+listEmpleado.get(i).getNombre()+"total A pagar"+Math.round(nominas.get(i)));
        }
        
        System.out.println("Prestaciones Sociales");
        prestaciones = liquidacion.liquidarPrestacionesEmp(listEmpleado);
        for (int i = 0; i < prestaciones.size(); i++) {
            System.out.println("Nombre"+listEmpleado.get(i).getNombre()+"total a pagar"+Math.round(prestaciones.get(i)));
        }
       
       
       
    } 
    
}
