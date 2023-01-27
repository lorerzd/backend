package org.generation.naomdb.model;

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

	@Column(name="total_orden", nullable=false)
	private BigDecimal totalOrden;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "ordenes_has_productos",
			joinColumns = @JoinColumn(name = "ordenes_id"),
			inverseJoinColumns = @JoinColumn(name = "productos_id")
	)
	private Collection<Producto> productos;

	@ManyToOne
	@JoinColumn(name = "usuario_id", insertable = false, updatable = false)
	private Usuario usuario;

	
	public Ordenes() {
	}

	public Ordenes(Long id, int cantidad, BigDecimal totalOrden, Collection<Producto> productos) {
		this.id = id;
		this.cantidad = cantidad;
		this.totalOrden = totalOrden;
		this.productos = productos;
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
