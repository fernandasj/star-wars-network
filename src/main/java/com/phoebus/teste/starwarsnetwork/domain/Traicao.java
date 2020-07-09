package com.phoebus.teste.starwarsnetwork.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Traicao {

    @Id
    @GeneratedValue
    private Long idTraicao;

    @ManyToOne
    @JsonBackReference
    private Rebelde rebeldeTraidor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traicao traicao = (Traicao) o;
        return idTraicao.equals(traicao.idTraicao) &&
                rebeldeTraidor.equals(traicao.rebeldeTraidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTraicao, rebeldeTraidor);
    }

    @Override
    public String toString() {
        return "Traicao{" +
                "idTraicao=" + idTraicao +
                ", rebeldeTraidor=" + rebeldeTraidor +
                '}';
    }
}
