package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the venta_detalle database table.
 * 
 */
@Embeddable
public class VentaDetallePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"VENTA_CODIGO\"", insertable=false, updatable=false)
	private Integer ventaCodigo;

	@Column(name="\"PROVEEDOR_CODIGO\"", insertable=false, updatable=false)
	private Integer proveedorCodigo;

	@Column(name="\"PRODUCTO_CODIGO\"", insertable=false, updatable=false)
	private Integer productoCodigo;

	public VentaDetallePK() {
	}
	public Integer getVentaCodigo() {
		return this.ventaCodigo;
	}
	public void setVentaCodigo(Integer ventaCodigo) {
		this.ventaCodigo = ventaCodigo;
	}
	public Integer getProveedorCodigo() {
		return this.proveedorCodigo;
	}
	public void setProveedorCodigo(Integer proveedorCodigo) {
		this.proveedorCodigo = proveedorCodigo;
	}
	public Integer getProductoCodigo() {
		return this.productoCodigo;
	}
	public void setProductoCodigo(Integer productoCodigo) {
		this.productoCodigo = productoCodigo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentaDetallePK)) {
			return false;
		}
		VentaDetallePK castOther = (VentaDetallePK)other;
		return 
			this.ventaCodigo.equals(castOther.ventaCodigo)
			&& this.proveedorCodigo.equals(castOther.proveedorCodigo)
			&& this.productoCodigo.equals(castOther.productoCodigo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ventaCodigo.hashCode();
		hash = hash * prime + this.proveedorCodigo.hashCode();
		hash = hash * prime + this.productoCodigo.hashCode();
		
		return hash;
	}
}