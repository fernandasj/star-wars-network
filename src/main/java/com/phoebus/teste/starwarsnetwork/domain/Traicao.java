package com.phoebus.teste.starwarsnetwork.domain;

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
    private Rebelde rebeldeTraidor;

    @ManyToOne
    private Rebelde rebeldeTraido;

    public Traicao(Rebelde rebeldeTraidor, Rebelde rebeldeTraido) {
        this.rebeldeTraidor = rebeldeTraidor;
        this.rebeldeTraido = rebeldeTraido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traicao traicao = (Traicao) o;
        return idTraicao.equals(traicao.idTraicao) &&
                rebeldeTraidor.equals(traicao.rebeldeTraidor) &&
                rebeldeTraido.equals(traicao.rebeldeTraido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTraicao, rebeldeTraidor, rebeldeTraido);
    }

    @Override
    public String toString() {
        return "Traicao{" +
                "idTraicao=" + idTraicao +
                ", rebeldeTraidor=" + rebeldeTraidor +
                ", rebeldeTraido=" + rebeldeTraido +
                '}';
    }
}
