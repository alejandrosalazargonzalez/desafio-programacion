package alejandrosalazargonzalez.proyecto.proyecto;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import alejandrosalazargonzalez.proyecto.proyecto.model.Usuario;
import alejandrosalazargonzalez.proyecto.proyecto.repository.UsuarioRepository;
import alejandrosalazargonzalez.proyecto.proyecto.servicios.UsuarioService;

@SpringBootTest
@MockitoBean
class UsuarioServiceTests {

	@Mock
	UsuarioRepository usuarioRepositoryMock;
	Usuario usuario;
	UsuarioService usuarioService;
	
	@BeforeEach
	void beforeEach(){
		usuarioRepositoryMock= mock(UsuarioRepository.class);
		usuario = new Usuario("miguel");
		usuarioService.setUsuarioRepository(usuarioRepositoryMock);
		when(usuarioRepositoryMock.save(any(Usuario.class))).thenReturn(usuario);
		when(usuarioRepositoryMock.findById(anyInt())).thenReturn(Optional.of(usuario));
	}

	
}
