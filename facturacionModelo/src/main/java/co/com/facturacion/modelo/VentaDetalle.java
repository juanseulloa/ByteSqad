package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the venta_detalle database table.
 * 
 */
@Entity
@Table(name="venta_detalle")
@NamedQuery(name="VentaDetalle.findAll", query="SELECT v FROM VentaDetalle v")
public class VentaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VentaDetallePK id;

	@Column(name="\"CANTIDAD\"")
	private Integer cantidad;

	@Column(name="\"DESCUENTO\"")
	private BigDecimal descuento;

	public VentaDetalle() {
	}

	public VentaDetallePK getId() {
		return this.id;
	}

	public void setId(VentaDetallePK id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

}