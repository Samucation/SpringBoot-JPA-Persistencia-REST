package br.com.jpa.com.spring.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.com.spring.dao.Usuarios;
import br.com.jpa.com.spring.model.Usuario;


@RestController
@RequestMapping("usuarios")
public class UsuariosResource {
	
	@RequestMapping("buscar-pessoa-estatica")
	public String pessoa() {
		return "Pessoa estatica dados";
	}
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("pesquisar-usuarios")
	public List<Usuario> pesquisarusuarios(@RequestParam String nomeCompleto) {
		return usuarios.pesquisarUsuarios(nomeCompleto);
	}
	
	@RequestMapping("por-nome-completo")
	public Usuario porNome(@RequestHeader String nomeCompleto) {
		return usuarios.findByNomeCompleto(nomeCompleto);
	}
	
	@RequestMapping("por-nome-comecando-com")
	public List<Usuario> porNomeComecandoCom(@RequestHeader String inicioDoNome) {
		return usuarios.findByNomeCompletoStartingWithIgnoreCase(inicioDoNome);
	}
	
	@RequestMapping("sem-endereco")
	public List<Usuario> semEndereco() {
		return usuarios.findByEnderecoIsNull();
	}
	
	@RequestMapping("{id}")
	public Usuario buscar(@PathVariable Long id) {
		return usuarios.findOne(id);
	}
	
	@RequestMapping
	public Page<Usuario> pesquisar(
			@RequestParam(defaultValue = "0") int pagina, 
			@RequestParam(defaultValue = "10") int porPagina,
			@RequestParam(defaultValue = "nomeCompleto") String ordenacao,
			@RequestParam(defaultValue = "ASC") Sort.Direction direcao) {
		return usuarios.findAll(new PageRequest(
				pagina, porPagina, new Sort(direcao, ordenacao)));
	}
	
	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario, @RequestHeader boolean autoCurrentDate) {
		if(usuario.getDataDoCadastro() == null && autoCurrentDate)
			usuario.setDataDoCadastro(new Date(Calendar.getInstance().getTime().getTime()));
		return usuarios.save(usuario);
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable Long id) {
		usuarios.delete(id);
	}
	
}
