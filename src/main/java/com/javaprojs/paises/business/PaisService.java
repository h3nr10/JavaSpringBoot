package com.javaprojs.paises.business;

import com.javaprojs.paises.infrastructure.entitys.Pais;
import com.javaprojs.paises.infrastructure.repository.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    private final PaisRepository repository;

    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }

    public void salvarPais(Pais pais) {
        repository.saveAndFlush(pais);
    }

    public Pais buscarPaisPorSigla(String sigla) {
        return repository.findBySigla(sigla).orElseThrow(
                () -> new RuntimeException("País não encontrado para a sigla informada")
        );
    }

    public void deletarPaisPorSigla(String sigla) {
        repository.deleteBySigla(sigla);
    }

    public void atualizarPaisPorId(Long id, Pais pais) {
        Pais paisEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("País não encontrado"));

        Pais paisAtualizado = Pais.builder()
                .id(paisEntity.getId())
                .nome(pais.getNome() != null ? pais.getNome() : paisEntity.getNome())
                .sigla(pais.getSigla() != null ? pais.getSigla() : paisEntity.getSigla())
                .capital(pais.getCapital() != null ? pais.getCapital() : paisEntity.getCapital())
                .areaKm2(pais.getAreaKm2() != null ? pais.getAreaKm2() : paisEntity.getAreaKm2())
                .pibPpcBilhoes(pais.getPibPpcBilhoes() != null ? pais.getPibPpcBilhoes() : paisEntity.getPibPpcBilhoes())
                .populacao(pais.getPopulacao() != null ? pais.getPopulacao() : paisEntity.getPopulacao())
                .indicePoderMilitar(pais.getIndicePoderMilitar() != null ? pais.getIndicePoderMilitar() : paisEntity.getIndicePoderMilitar())
                .build();

        repository.saveAndFlush(paisAtualizado);
    }
}