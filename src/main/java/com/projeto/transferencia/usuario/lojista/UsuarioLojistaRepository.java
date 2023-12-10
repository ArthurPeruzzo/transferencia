package com.projeto.transferencia.usuario.lojista;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioLojistaRepository extends CrudRepository<UsuarioLojista, Long> {
}
