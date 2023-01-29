package org.generation.naomdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "ordenes_has_productos",
			joinColumns = @JoinColumn(name = "productos_id"),
			inverseJoinColumns = @JoinColumn(name = "ordenes_id"))
	private List<Producto> productos;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	
	public Ordenes() {
	}

	public Ordenes(
			int cantidad,
			BigDecimal totalOrden,
			List<Producto> productos,
			Usuario usuario) {
		this.id = id;
		this.cantidad = cantidad;
		this.totalOrden = totalOrden;
		this.productos = productos;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Ordenes{" +
				"id=" + id +
				", cantidad=" + cantidad +
				", totalOrden=" + totalOrden +
				", productos=" + productos +
				", usuario=" + usuario +
				'}';
	}
}
