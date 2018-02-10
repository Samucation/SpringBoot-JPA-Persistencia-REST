package br.com.jpa.com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jpa.com.spring.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

}
