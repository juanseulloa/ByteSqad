package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the proveedor_producto database table.
 * 
 */
@Entity
@Table(name="proveedor_producto")
@NamedQuery(name="ProveedorProducto.findAll", query="SELECT p FROM ProveedorProducto p")
public class ProveedorProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProveedorProductoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_VIGENCIA\"")
	private Date fechaVigencia;

	@Column(name="\"PESO\"")
	private BigDecimal peso;

	@Column(name="\"PRECIO_UNITARIO\"")
	private Integer precioUnitario;

	public ProveedorProducto() {
	}

	public ProveedorProductoPK getId() {
		return this.id;
	}

	public void setId(ProveedorProductoPK id) {
		this.id = id;
	}

	public Date getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}