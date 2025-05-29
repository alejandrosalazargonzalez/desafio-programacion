package alejandrosalazargonzalez.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alejandrosalazargonzalez.proyecto.proyecto.model.Usuario;

public interface  UsuarioRepository extends  JpaRepository<Usuario, Integer> {

}
