package alejandrosalazargonzalez.proyecto.proyecto.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Entity
@Table(name="roll")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Roll {
    private int id;
    private String name;
    private Set<Usuario> usuarios; 

    public Roll() {}

    public Roll(String name) {
        this.name = name;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false, unique = true)   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "roll",fetch = FetchType.LAZY)
    @JsonBackReference
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", nombre=" + name + "]";
    }
}
