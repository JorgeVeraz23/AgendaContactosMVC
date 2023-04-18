/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Vista.*;
import Modelo.*;
import Controlador.*;
/**
 *
 * @author USER
 */
public class Principal {
     public static void main(String[] args){
        VistaPrincipal vista = new VistaPrincipal();
        Contactos contacto = new Contactos();
        ListaContactos lista = new ListaContactos();
        Controlador controlador = new Controlador(vista, contacto, lista);
        
        vista.setVisible(true);
    }
}
