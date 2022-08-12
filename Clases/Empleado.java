/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Modelo.DbDatajava;

/**
 *
 * @author HOME
 */
public class Empleado{  // AQUI TENEMOS LOS DATOS QUE TENEMOS EN LA BASE DE DATOS 
    
    private int id;
    private String nombre;
    private String apellido;
    private int horasExtra;
    private boolean auxilioTransporte;
    private int salario;
    // creamos constructor

    public Empleado() {
    }
    
    

    public Empleado(String nombre, int horasExtra, boolean auxilioTransporte, int salario) {  
        this.nombre = nombre;
        this.horasExtra = horasExtra;
        this.auxilioTransporte = auxilioTransporte;
        this.salario = salario;
    }

    public Empleado(String nombre, String apellido, int horasExtra, boolean auxilioTransporte, int salario) {   
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasExtra = horasExtra;
        this.auxilioTransporte = auxilioTransporte;
        this.salario = salario;
    }

    public Empleado(int id, String nombre, String apellido, int horasExtra, boolean auxilioTransporte, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasExtra = horasExtra;
        this.auxilioTransporte = auxilioTransporte;
        this.salario = salario;
    }
    
    
    
    

    
    
    // metodos set y get


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public boolean isAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(boolean auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
