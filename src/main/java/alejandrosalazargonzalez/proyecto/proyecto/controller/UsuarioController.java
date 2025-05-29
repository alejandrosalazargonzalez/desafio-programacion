package alejandrosalazargonzalez.proyecto.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alejandrosalazargonzalez.proyecto.proyecto.model.Usuario;
import alejandrosalazargonzalez.proyecto.proyecto.servicios.UsuarioService;

/**
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    UsuarioService usuarioService;
    
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping("/usuarios/")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value="id")int userId) {
        Usuario usuario = usuarioService.getById(userId);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/add/usuario/")
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable(value = "id") int userId,
    @RequestBody Usuario userDetails) {
        final Usuario updatedUser = usuarioService.updateUsuario(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/user/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") int userId) {
        usuarioService.deleteUsuario(userId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
