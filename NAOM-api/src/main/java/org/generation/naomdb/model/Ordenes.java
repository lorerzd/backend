package org.generation.naomdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "ordenes")
public class Ordenes {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private int cantidad;

	@Column(name="total_orden")
	private BigDecimal totalOrden;

	@ManyToMany(mappedBy = "ordenes",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Producto> productos;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	
	public Ordenes() {
	}

	public Ordenes(int cantidad, BigDecimal totalOrden, Collection<Producto> productos) {
		this.cantidad = cantidad;
		this.totalOrden = totalOrden;
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotalOrden() {
		return totalOrden;
	}

	public void setTotalOrden(BigDecimal totalOrden) {
		this.totalOrden = totalOrden;
	}

	public Long getId() {
		return id;
	}




	@Override
	public String toString() {
		return "Ordenes{" +
				"id=" + id +
				", cantidad=" + cantidad +
				", totalOrden=" + totalOrden +
				", productos=" + productos +
				'}';
	}
}
