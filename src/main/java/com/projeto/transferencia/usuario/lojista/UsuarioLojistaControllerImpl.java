package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario-lojista")
public class UsuarioLojistaControllerImpl {

    private final UsuarioLojistaService service;

    @PostMapping("salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioLojistaRecord usuarioLojistaRecord) {
        service.salvar(usuarioLojistaRecord);
        return ResponseEntity.ok().build();
    }

    @PutMapping("atualizar")
    public ResponseEntity<?> atualizar(@RequestBody @Valid UsuarioLojistaRecord usuarioLojistaRecord) {
        service.atualizar(usuarioLojistaRecord);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable(value = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
