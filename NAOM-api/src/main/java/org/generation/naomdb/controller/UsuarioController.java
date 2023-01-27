package org.generation.naomdb.controller;
import org.generation.naomdb.model.Usuario; 
import org.generation.naomdb.service.UsuarioService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	} // constructor

	@GetMapping
    public List<Usuario> findAll(){
        return usuarioService.getAllUsuarios();
	} 
	
	@GetMapping(path= "{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long id) {
		return usuarioService.getUsuario(id);
	} // getUsuario
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long id) {
		return usuarioService.deleteUsuario(id);
	} // deleteUsuario
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	} // addUsuario
	
	@PutMapping(path= "{userId}") // http://localhost:8080/api/usuarios/1
		public Usuario updateUsuario(@PathVariable("userId") Long id, @RequestBody ChangePassword changepassword) throws Exception {
		return usuarioService.updateUsuario(id, changepassword.getPassword(), changepassword.getNewPassword());
	} // updateUsuario
	
} // class

