package org.generation.naomdb.dto;

public class RegisterDTO {

    private String correo;
    private String contrasena;
    private String telefono;
    private String nombre;
    private String apellido;

    public RegisterDTO(String correo, String contrasena, String telefono, String nombre, String apellido) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public RegisterDTO() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
