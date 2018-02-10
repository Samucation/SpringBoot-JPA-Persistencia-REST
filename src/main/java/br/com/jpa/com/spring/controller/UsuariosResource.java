package br.com.jpa.com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.com.spring.dao.Usuarios;
import br.com.jpa.com.spring.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {

	@Autowired
	private Usuarios usuarios; //Repositório dos usuários.
	
	@GetMapping("/{id}")
	public Usuario buscarUsuarioPorID(@PathVariable Long id) {
		return usuarios.findOne(id);
	}
	
	@GetMapping
	public List<Usuario> buscaTodosUsuarios(){
		return usuarios.findAll();
	}
	
	@PostMapping
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarios.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		usuarios.delete(id);
	}
	
}
