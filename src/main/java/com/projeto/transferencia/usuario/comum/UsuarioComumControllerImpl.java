package com.projeto.transferencia.usuario.comum;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario-comum")
public class UsuarioComumControllerImpl {

    private final UsuarioComumService service;

    @PostMapping("salvar")
    public ResponseEntity<UsuarioComum> salvar(@RequestBody UsuarioComum usuarioComum) {
        return ResponseEntity.ok().body(service.salvar(usuarioComum));
    }

    @PutMapping("atualizar")
    public ResponseEntity<UsuarioComum> atualizar(@RequestBody UsuarioComum usuarioComum) {
        return ResponseEntity.ok().body(service.atualizar(usuarioComum));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable(value = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
