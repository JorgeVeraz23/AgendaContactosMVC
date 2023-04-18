/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import Vista.VistaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ListaContactos {
    private VistaPrincipal vista;
    private ArrayList<Contactos> contactos;
    
    public ListaContactos(){
        contactos = new ArrayList<Contactos>();
        this.vista = vista;
    }
    //Metodos para agregar, eliminar, buscar y mostrar contactos
    
    public void agregarContacto(Contactos contacto){
        contactos.add(contacto);
    }
    
    public void eliminarContacto(Contactos contacto){
        contactos.remove(contacto);
    }
    
public Contactos buscarContacto(String nombre){
    Iterator<Contactos> it = contactos.iterator();
    while(it.hasNext()){
        Contactos contacto = it.next();
        if(contacto.getNombre().equals(nombre)){
            return contacto;
        }
    }
    //Si no se encontro el contacto, mostrar un mensaje de error
    JOptionPane.showMessageDialog(null,"No se encontro el contacto.");
    return null; // Devuelve null si no se encontró ningún contacto
}
    
   public void mostrarContactos(){
        for(Contactos c : contactos){
            vista.txtnombre.setText(c.getNombre());
            vista.txtcorreo.setText(c.getCorreo());
            vista.txtnumero.setText(String.valueOf(c.getNumero()));
        }
    }
   
   public ArrayList<Contactos> obtenerContactos(){
       return contactos;
   }
    
    
    
    
}
