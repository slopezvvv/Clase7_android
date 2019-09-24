package cl.tuserver.clase7_android;

import java.io.Serializable;

/**
 *  Las clases deben implementar Serializacion para poder ser compartidas entre Actividades.
 */
public class Usuario implements Serializable {
    // VARS
    private final int id;
    private String nombre;
    private String direccion;
    private int telefono;

    // CTOR
    public Usuario(int id){
        this.id = id;
        nombre = new String();
        direccion = new String();
        telefono = new Integer(0);
    }

    // GET
    public final int getId(){
        return id;
    }

    public final String getNombre(){
        return nombre;
    }

    public final String getDireccion(){
        return direccion;
    }

    public final int getTelefono(){
        return telefono;
    }

    // SET
    public final void setNombre(String nombre){
        if(!nombre.isEmpty())
            this.nombre = nombre;
    }

    public final void setDireccion(String direccion){
        if(!direccion.isEmpty())
            this.direccion = direccion;
    }

    public final void setTelefono(int telefono){
        String sTelefono = String.valueOf(telefono);
        if(sTelefono.isEmpty()) return;
        this.telefono = telefono;
    }
}
