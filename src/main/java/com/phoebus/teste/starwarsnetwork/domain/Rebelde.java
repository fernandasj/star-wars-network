package com.phoebus.teste.starwarsnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @JsonIgnore
    private Boolean traidor = Boolean.FALSE;

    @ManyToOne
    private Localizacao localizacao;

    @OneToMany(mappedBy = "item")
    private List<ItemInventario> inventario = new ArrayList<>();

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
}
