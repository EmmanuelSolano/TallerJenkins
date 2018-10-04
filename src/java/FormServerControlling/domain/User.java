/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormServerControlling.domain;

/**
 *
 * @author Oscar Luis
 */
public class User {
    
    public String correo;
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public String contrasena;
    public String roleEnLaApp;
    public int id;

    public User(String Correo, String Nombre, String PrimerApellido, String SegundoApellido, String RoleEnLaApp) {
        this.correo = Correo;
        this.nombre = Nombre;
        this.primerApellido = PrimerApellido;
        this.segundoApellido = SegundoApellido;
        this.roleEnLaApp = RoleEnLaApp;
        id=0;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRoleEnLaApp() {
        return roleEnLaApp;
    }

    public void setRoleEnLaApp(String roleEnLaApp) {
        this.roleEnLaApp = roleEnLaApp;
    }
    
    

    @Override
    public String toString() {
        return "Usuario: " + "Correo=" + correo + ", Nombre=" + nombre + ", PrimerApellido=" + primerApellido + ", SegundoApellido=" + segundoApellido 
                + ", RoleEnLaApp=" + roleEnLaApp;
    }
    
}
