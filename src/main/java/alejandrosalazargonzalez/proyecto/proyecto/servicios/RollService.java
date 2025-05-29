package alejandrosalazargonzalez.proyecto.proyecto.servicios;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alejandrosalazargonzalez.proyecto.proyecto.model.Roll;
import alejandrosalazargonzalez.proyecto.proyecto.model.Usuario;
import alejandrosalazargonzalez.proyecto.proyecto.repository.RollRepository;
import alejandrosalazargonzalez.proyecto.proyecto.repository.UsuarioRepository;

@Service
public class RollService {
    
    private final RollRepository rollRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public RollService(RollRepository rollRepository, UsuarioRepository usuarioRepository) {
        this.rollRepository = rollRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Roll> getAllRoles() {
        return rollRepository.findAll();
    }

    public Roll getRoleById(int roleId){
        Roll roll = rollRepository.findById(roleId).orElse(null);
        if (roll == null) {
            throw  new RuntimeException("no existe un usuario con esa id");
        }
        return roll;
    }

    public Roll createRole(Roll roll) {
        return rollRepository.save(roll);
    }

    public Roll updateRole(int rollId, Roll rollDetails) {
        Roll roll = rollRepository.findById(rollId).orElse(null);
        if (roll==null) {
            throw  new RuntimeException("no existe el usuario");
        }
        roll.setName(rollDetails.getName());
        return rollRepository.save(roll);
    }

    public void deleteRole(int rollId) {
        Roll roll = rollRepository.findById(rollId)
                .orElse(null);

        Set<Usuario> usersWithRole = roll.getUsuarios();
        for (Usuario usuario : usersWithRole) {
            usuario.setRoll(null);
            usuarioRepository.save(usuario); 
        }
        rollRepository.delete(roll);
    }
}
