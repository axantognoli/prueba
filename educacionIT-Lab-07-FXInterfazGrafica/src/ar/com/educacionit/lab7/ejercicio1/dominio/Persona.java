/*
 * Persona.java
 *
 *
 */
package ar.com.educacionit.lab7.ejercicio1.dominio;

/**
 *
 */
public abstract class Persona {

    public enum ESTADOCIVIL {

        Soltero, Casado, Divorciado
    }

    public enum SEXO {

        Masculino, Femenino
    }

    /**
     * Creates a new instance of Persona
     */
    public Persona() {
    }

    // Atributos
    private int id;
    private String nombre;
    private String apellido;
    private SEXO sexo;
    private ESTADOCIVIL estadoCivil;

    @Override
    public String toString() {
        return nombre;
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

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public ESTADOCIVIL getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(ESTADOCIVIL estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
