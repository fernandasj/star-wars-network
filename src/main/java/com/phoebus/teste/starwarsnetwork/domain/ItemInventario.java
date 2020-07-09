package com.phoebus.teste.starwarsnetwork.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemInventario {

    @Id
    @GeneratedValue()
    private Long idItemInventario;

    @ManyToOne
    private Item item;

    private Integer quantidade;

    @ManyToOne
    @JsonBackReference
    private Rebelde rebelde;

    public ItemInventario(Item item, Integer quantidade, Rebelde rebelde) {
        this.item = item;
        this.quantidade = quantidade;
        this.rebelde = rebelde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInventario that = (ItemInventario) o;
        return idItemInventario.equals(that.idItemInventario) &&
                item.equals(that.item) &&
                quantidade.equals(that.quantidade) &&
                rebelde.equals(that.rebelde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItemInventario, item, quantidade, rebelde);
    }

    @Override
    public String toString() {
        return "ItemInventario{" +
                "idItemInventario=" + idItemInventario +
                ", item=" + item +
                ", quantidade=" + quantidade +
                ", rebelde=" + rebelde +
                '}';
    }
}