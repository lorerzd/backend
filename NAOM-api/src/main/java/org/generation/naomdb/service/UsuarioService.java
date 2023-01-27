package org.generation.naomdb.service;
import java.util.List;
import java.util.Optional;

import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    } // constructor
    
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	} // getAllUsuarios
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Usuario con el id " + id + " no existe.")
				);
		}// getUsuario
    
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	} // addUsuario
    
    public Usuario deleteUsuario(Long id) {
    	Usuario tmp=null;
    if (usuarioRepository.existsById(id)) {
    	tmp=usuarioRepository.findById(id).get();
    	usuarioRepository.deleteById(id);
    } // if
    return tmp;
    } // deleteUsuario
    
    public Usuario updateUsuario(Long id, String password, String newPassword) throws Exception {
    	Optional<Usuario> tmp=usuarioRepository.findById(id);
    	if (tmp.isPresent()) {
    		if (tmp.get().getContrasena() == password)
    		{ 
    			tmp.get().setContrasena(newPassword);
    			usuarioRepository.save(tmp.get());
    			return tmp.get();
    		}

	} else {
		System.out.println("Update - El Usuario con el id " + id + "no existe");
	} // if
	throw new Exception("Error al cambiar la contraseña");
	} // updateUsuario
    
}


