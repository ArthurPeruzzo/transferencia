package com.projeto.transferencia.usuario.comum;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioComumRepository extends CrudRepository<UsuarioComum, Long> {
}
