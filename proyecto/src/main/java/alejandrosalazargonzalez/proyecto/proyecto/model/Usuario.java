package alejandrosalazargonzalez.proyecto.proyecto.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Entity
@Table(name="usuario")
public class Usuario {
    private String nombre;
    private int id;

    /**
     * constructor vacio
     */
    public Usuario(){

    }

    /**
     * Constructor con nombre
     * @param nombre del usuario
     */
    public Usuario(String nombre){
        if(nombre.isEmpty() || nombre == null){
            throw new RuntimeException("el nombre no puede ser vacio ni nulo");
        }
        this.nombre= nombre;
    }

    //getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.isEmpty() || nombre == null){
            throw new RuntimeException("el nombre no puede ser vacio ni nulo");
        }
        this.nombre= nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false)
    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Usuario id(int id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

    



}
