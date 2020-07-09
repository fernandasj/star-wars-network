package com.phoebus.teste.starwarsnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalizacao;
    private String latitude;
    private String longitude;
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return idLocalizacao.equals(that.idLocalizacao) &&
                latitude.equals(that.latitude) &&
                longitude.equals(that.longitude) &&
                nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalizacao, latitude, longitude, nome);
    }

    @Override
    public String toString() {
        return "Localizacao{" +
                "idLocalizacao=" + idLocalizacao +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
