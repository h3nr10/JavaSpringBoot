package com.javaprojs.paises.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "paises")
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sigla", nullable = false, unique = true)
    private String sigla;

    @Column(name = "capital")
    private String capital;

    @Column(name = "area_km2")
    private Double areaKm2;

    @Column(name = "pib_ppc_bilhoes")
    private Double pibPpcBilhoes;

    @Column(name = "populacao")
    private Integer populacao;

    @Column(name = "indice_poder_militar")
    private Double indicePoderMilitar;
}