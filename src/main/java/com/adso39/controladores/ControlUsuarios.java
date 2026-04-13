/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso39.controladores;

import com.adso39.modelos.Usuario;
import com.adso39.persistencia.Usuarios;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author SENA
 */
public class ControlUsuarios {
    private static Usuario elUsuario = new Usuario();
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    /*public ControlUsuarios(){
        this.elUsuario = new Usuario();
    }*/
    public static void RegistrarUsuario(
    String identificacion, String nombres, String apellidos, int indiceCargo, String textoCargo, boolean esAdministrador
    ){
         elUsuario.setIdentificacion(identificacion);
        elUsuario.setNombres(nombres);
        elUsuario.setApellidos(apellidos);
        elUsuario.setIndiceCargo(indiceCargo);
        elUsuario.setTextoCargo(textoCargo);
        elUsuario.setEsAdministrador(esAdministrador);
    }
    
    public static String ImprimirUsuario(){
    return elUsuario.toString();
    }
    public static void AgregarUsuario (String identificacion, String nombres, String apellidos, int indiceCargo, String textoCargo, boolean esAdministrador){
    Usuario elNuevo = new Usuario(identificacion,nombres,apellidos,indiceCargo,textoCargo,esAdministrador);
    
    try{
        Usuarios losUsuarios = new Usuarios();
        
        if(losUsuarios.registrarUsuario(elNuevo)) {
                System.out.println("El usuario fue insertado en BD");
        listaUsuarios.add(elNuevo);
        } else{
            System.out.println("El usuario no fue insertado en la BD");
        }

    }
    catch (Exception e){
            System.out.println(e.getMessage());
    }
    
}

    
    
    
    public static String ListarUsuarios() {
        String texto ="";
        for (int i=0; i<listaUsuarios.size();i++){
            texto += listaUsuarios.get(i).toString() + "\n";
        
        }
        return texto;
    }
    
    public static ArrayList<Usuario> MostrarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList ();
        
        try {
            Usuarios losUsuarios = new Usuarios();
            usuarios = losUsuarios.consultarUsuarios();
            
        }
        
        catch (Exception e ) {
            System.out.println(e.getMessage());
            
        }
        return usuarios;
        }
    }


