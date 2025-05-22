package alejandrosalazargonzalez.proyecto.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alejandrosalazargonzalez.proyecto.proyecto.model.Usuario;
import alejandrosalazargonzalez.proyecto.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService( UsuarioRepository usuarioRepository) {
        this.usuarioRepository =usuarioRepository;
    }
    
    /**
     * saca todos los usuarios de la bbdd
     * @return List<Usuario>
     */
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /**
     * saca un usuario buscado por su id
     * @param id del usuario buscado
     * @return Usuario
     */
    public Usuario getById(int id){
        if (id < 0) {
            throw  new RuntimeException("id no valido");
        }
        Usuario usuarioGuardado =  usuarioRepository.findById(id).orElse(null);
        if (usuarioGuardado == null) {
            throw  new RuntimeException("usuario no encontrado");
        }
        return usuarioGuardado;
    }

    /**
     * agrega un usuario a la base de datos
     * @param usuario
     * @return Usuario
     */
    public Usuario createUsuario(Usuario usuario){
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty() || getById(usuario.getId())==usuario) {
            throw  new RuntimeException("usuario no valido");
        }
        return usuarioRepository.save(usuario);
    }

    /**
     * actualiza la informacion de un usuario
     * @param id del usuairo a actualizar
     * @param usuarioActualizado usuario con la 
     * @return
     */
    public Usuario updateUsuario(int id, Usuario usuarioActualizado){
        if (id <0) {
            throw  new RuntimeException("id no valido");
        }
        if (usuarioActualizado.getNombre() == null || usuarioActualizado.getNombre().isEmpty()) {
            throw  new RuntimeException("usuario no valido");
        }
        Usuario usuario = getById(id);
        if (usuario != usuarioActualizado) {
            throw  new RuntimeException("usuario no encontrado");
        }
        usuario.setNombre(usuarioActualizado.getNombre());
        return usuarioRepository.save(usuario);
    }

    public Usuario deleteUsuario(int id){
        if (id < 0) {
            throw  new RuntimeException("id no valido");
        }
        Usuario usuarioEliminar = getById(id);
        usuarioRepository.delete(usuarioEliminar);
        return usuarioEliminar;
    }
}
