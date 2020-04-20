package br.edu.up.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.cadastro.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
