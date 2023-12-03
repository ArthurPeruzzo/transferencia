package com.projeto.transferencia.usuario.lojista;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario-lojista")
public class UsuarioLojistaControllerImpl {

    private final UsuarioLojistaService service;

    @PostMapping("salvar")
    public ResponseEntity<UsuarioLojista> salvar(@RequestBody UsuarioLojista usuarioLojista) {
        return ResponseEntity.ok().body(service.salvar(usuarioLojista));
    }

    @PutMapping("atualizar")
    public ResponseEntity<UsuarioLojista> atualizar(@RequestBody UsuarioLojista usuarioLojista) {
        return ResponseEntity.ok().body(service.atualizar(usuarioLojista));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable(value = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
