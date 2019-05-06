package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the proveedor_producto database table.
 * 
 */
@Embeddable
public class ProveedorProductoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"PROVEEDOR_CODIGO\"", insertable=false, updatable=false)
	private Integer proveedorCodigo;

	@Column(name="\"PRODUCTO_CODIGO\"", insertable=false, updatable=false)
	private Integer productoCodigo;

	public ProveedorProductoPK() {
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
		if (!(other instanceof ProveedorProductoPK)) {
			return false;
		}
		ProveedorProductoPK castOther = (ProveedorProductoPK)other;
		return 
			this.proveedorCodigo.equals(castOther.proveedorCodigo)
			&& this.productoCodigo.equals(castOther.productoCodigo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.proveedorCodigo.hashCode();
		hash = hash * prime + this.productoCodigo.hashCode();
		
		return hash;
	}
}