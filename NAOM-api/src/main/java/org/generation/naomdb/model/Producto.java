package org.generation.naomdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @Column(nullable = false)
    private String foto;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal rating;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "ordenes_has_productos",
            joinColumns = @JoinColumn(name = "productos_id"),
            inverseJoinColumns = @JoinColumn(name = "ordenes_id"))
    private List<Ordenes> ordenes;

    @ManyToOne
    @JoinColumn(
            name = "categorias_id",
            referencedColumnName = "id")
    private Categorias categorias;


    public Producto() {
    }

    public Producto(
            String nombre,
            String descripcion,
            String foto,
            double precio,
            int stock,
            BigDecimal rating,
            List<Ordenes> ordenes,
            Categorias categorias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;
        this.stock = stock;
        this.rating = rating;
        this.ordenes = ordenes;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public List<Ordenes> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Ordenes> ordenes) {
        this.ordenes = ordenes;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto='" + foto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", rating=" + rating +
                ", categorias=" + categorias +
                '}';
    }
}
