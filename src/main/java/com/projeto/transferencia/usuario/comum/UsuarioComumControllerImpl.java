package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario-comum")
public class UsuarioComumControllerImpl {

    private final UsuarioComumService service;

    @PostMapping("salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioComumRecord usuarioComumRecord) {
        service.salvar(usuarioComumRecord);
        return ResponseEntity.ok().build();
    }

    @PutMapping("atualizar")
    public ResponseEntity<?> atualizar(@RequestBody @Valid UsuarioComumRecord usuarioComumRecord) {
        service.atualizar(usuarioComumRecord);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable(value = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
