/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaPrincipal; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import Modelo.Contactos;
import Modelo.ListaContactos;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    private VistaPrincipal vista; // Referencia a la vista principal
    private Contactos contacto;
    private ListaContactos lista;
    

    public Controlador(VistaPrincipal vista, Contactos contacto, ListaContactos lista) {
        this.vista = vista;
        this.contacto = contacto;
        this.lista = lista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnMostrar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            // Lógica para agregar un contacto
            try{
                String nombre = vista.txtnombre.getText();
                String email = vista.txtcorreo.getText();
                int numero = Integer.parseInt(vista.txtnumero.getText());
                
                if(nombre.isEmpty()){
                    throw new IllegalArgumentException("El campo 'Nombre' es obligatorio");
                }
                if(email.isEmpty()){
                    throw new IllegalArgumentException("El campo 'Email' es obligatorio");
                }
                if(String.valueOf(numero).isEmpty()){
                    throw new IllegalArgumentException("El campo 'Numero' es obligatorio");
                }
                Contactos contacto = new Contactos(nombre, numero, email);
                lista.agregarContacto(contacto);
            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
           
            // Agregar el contacto a la lista o base de datos
        } else if (e.getSource() == vista.btnEliminar) {
            // Lógica para eliminar un contacto
            try{
                String ContactoEliminado = vista.txtnombre.getText();
                for(Contactos contacto: lista.obtenerContactos()){
                    if(contacto.getNombre().equals(ContactoEliminado)){
                        lista.eliminarContacto(contacto);
                        JOptionPane.showMessageDialog(null, "Contacto elimimado correctamente");
                        break;
                    }
                }
            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(vista, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
            // Buscar y eliminar el contacto de la lista o base de datos
        } else if (e.getSource() == vista.btnBuscar) {
            // Lógica para buscar un contacto
            try{
                String NombreBusqueda = vista.txtnombre.getText();
                if(NombreBusqueda.isEmpty()){
                    throw new IllegalArgumentException("El campo 'Nombre' es obligatorio");
                }
                Contactos contactoEncontrado = lista.buscarContacto(NombreBusqueda);
                if(contactoEncontrado != null){
                    vista.txtnumero.setText(String.valueOf(contactoEncontrado.getNumero()));
                    vista.txtcorreo.setText(contactoEncontrado.getCorreo());
                }else{
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado");
                }
            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(vista, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
            // Buscar el contacto en la lista o base de datos y mostrar sus datos
        } else if (e.getSource() == vista.btnMostrar) {
            // Lógica para mostrar todos los contactos
            String listaContactos = "";
            for (Contactos contacto : lista.obtenerContactos()) {
        listaContactos += contacto.toString() + "\n";
    }
    JOptionPane.showMessageDialog(null, listaContactos);
    // Obtener la lista de contactos de la base de datos y mostrarlos en la interfaz gráfica
}
    }
}