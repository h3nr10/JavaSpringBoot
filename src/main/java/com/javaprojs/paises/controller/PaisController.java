package com.javaprojs.paises.controller;

import com.javaprojs.paises.business.PaisService;
import com.javaprojs.paises.infrastructure.entitys.Pais;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    @PostMapping
    public ResponseEntity<Void> salvarPais(@RequestBody Pais pais) {
        paisService.salvarPais(pais);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pais> buscarPaisPorSigla(@RequestParam String sigla) {
        return ResponseEntity.ok(paisService.buscarPaisPorSigla(sigla));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPaisPorSigla(@RequestParam String sigla) {
        paisService.deletarPaisPorSigla(sigla);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPaisPorId(@RequestParam Long id,
                                                   @RequestBody Pais pais) {
        paisService.atualizarPaisPorId(id, pais);
        return ResponseEntity.ok().build();
    }
}