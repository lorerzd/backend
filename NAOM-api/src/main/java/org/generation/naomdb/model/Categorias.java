package org.generation.naomdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String tipoDeProducto;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorias_id")
    private Collection<Producto> productos;


    public Categorias() {
    }

    public Categorias(Long id, String tipoDeProducto) {
        this.id = id;
        this.tipoDeProducto = tipoDeProducto;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", tipoDeProducto='" + tipoDeProducto + '\'' +
                '}';
    }
}
