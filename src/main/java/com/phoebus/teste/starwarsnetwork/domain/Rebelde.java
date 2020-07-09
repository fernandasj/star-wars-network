package com.phoebus.teste.starwarsnetwork.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rebelde {

    @Id
    @GeneratedValue
    private Long idRebelde;
    private String nome;
    private String genero;

    private Boolean traidor = Boolean.FALSE;

    @ManyToOne
    private Localizacao localizacao;

    @OneToMany(mappedBy = "rebelde", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemInventario> inventario = new ArrayList<>();

    @OneToMany(mappedBy = "rebeldeTraidor")
    @JsonManagedReference
    private List<Traicao> traicoes = new ArrayList<>();

    public Rebelde(String nome, String genero, Boolean traidor, Localizacao localizacao, List<ItemInventario> inventario) {
        this.nome = nome;
        this.genero = genero;
        this.traidor = traidor;
        this.localizacao = localizacao;
        this.inventario = inventario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rebelde rebelde = (Rebelde) o;
        return idRebelde.equals(rebelde.idRebelde) &&
                nome.equals(rebelde.nome) &&
                genero.equals(rebelde.genero) &&
                traidor.equals(rebelde.traidor) &&
                localizacao.equals(rebelde.localizacao) &&
                inventario.equals(rebelde.inventario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRebelde, nome, genero, traidor, localizacao, inventario);
    }

    @Override
    public String toString() {
        return "Rebelde{" +
                "idRebelde=" + idRebelde +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", traidor=" + traidor +
                ", localizacao=" + localizacao +
                ", inventario=" + inventario +
                '}';
    }
}
