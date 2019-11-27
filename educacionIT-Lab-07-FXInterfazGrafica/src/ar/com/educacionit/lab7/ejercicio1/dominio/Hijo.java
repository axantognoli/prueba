/*
 * Hijo.java
 *
 *
 */
package ar.com.educacionit.lab7.ejercicio1.dominio;

/**
 *
 */
public class Hijo extends Persona {

    // Atributos
    private LUGARDEESTUDIO lugarDeEstudio;

    public enum LUGARDEESTUDIO {
        JARDIN, PRIMARIO, SECUNDARIO
    }

    /**
     * Creates a new instance of Hijo
     */
    public Hijo() {
    }

    public Hijo(String unNombre, LUGARDEESTUDIO unLugarDeEstudio) {
        setNombre(unNombre);
        setLugarDeEstudio(unLugarDeEstudio);
    }

    public LUGARDEESTUDIO getLugarDeEstudio() {
        return lugarDeEstudio;
    }

    public void setLugarDeEstudio(LUGARDEESTUDIO lugarDeEstudio) {
        this.lugarDeEstudio = lugarDeEstudio;
    }

}
