/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adso39.persistencia;

import com.adso39.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SENA
 */
public class Usuarios {
    
    private Connection laConexion;
    
    public Usuarios () {
        
        try {
            this.laConexion = conexion.getConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean registrarUsuario(Usuario elUsuario){
        String sql = "INSERT INTO autorizaciones " +
                "(identificacion, nombres, apellidos,"+
                "indicecargo,textocargo, esAdministrador)" + "VALUES (?,?,?,?,?,?)";
        
        
        try{
            PreparedStatement pstmt = laConexion.prepareStatement(sql);
            
            pstmt.setString (1, elUsuario.getIdentificacion());
            pstmt.setString (2, elUsuario.getNombres());
            pstmt.setString(3,elUsuario.getApellidos());
            pstmt.setInt(4,elUsuario.getIndiceCargo());
            pstmt.setString(3,elUsuario.getTextoCargo());
            pstmt.setBoolean(3,elUsuario.isEsAdministrador());
            
            int affectedRows = pstmt.executeUpdate ();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al  registrar el usuario");
            return false;
        }
    }
    
    
    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> losUsuarios = new ArrayList();
        String sql = "SELECT * FROM usuario";
        try {
            PreparedStatement pstmt = laConexion.prepareStatement (sql);
                    ResultSet resultado = pstmt.executeQuery ();
                    while (resultado.next()) {
                        Usuario registrado = new Usuario ();
                        registrado.setIdentificacion(resultado.getString ("identificacion"));
                        registrado.setIdentificacion(resultado.getString("nombres"));
                        registrado.setIdentificacion(resultado.getString("apellidos"));
                        registrado.setIdentificacion(resultado.getString ("indiceCargo"));
                        registrado.setIdentificacion(resultado.getString("textoCargo"));
                        registrado.setIdentificacion(resultado.getString("esAdministrador"));
                        System.out.println(registrado.toString());
                        losUsuarios.add (registrado);
                        
                    }
                    return losUsuarios;
        }
        catch (SQLException e ){
            System.err.println("Error al consultar la BD: " +
                    e.getMessage ());
            return new ArrayList ();
        }
    }
}
