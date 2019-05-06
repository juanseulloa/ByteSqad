package co.com.ustaempresarial.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_usuario database table.
 * 
 */
@Embeddable
public class RolUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="usuario_cod", insertable=false, updatable=false)
	private Integer usuarioCod;

	@Column(name="rol_cod", insertable=false, updatable=false)
	private Integer rolCod;

	public RolUsuarioPK() {
	}
	public Integer getUsuarioCod() {
		return this.usuarioCod;
	}
	public void setUsuarioCod(Integer usuarioCod) {
		this.usuarioCod = usuarioCod;
	}
	public Integer getRolCod() {
		return this.rolCod;
	}
	public void setRolCod(Integer rolCod) {
		this.rolCod = rolCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolUsuarioPK)) {
			return false;
		}
		RolUsuarioPK castOther = (RolUsuarioPK)other;
		return 
			this.usuarioCod.equals(castOther.usuarioCod)
			&& this.rolCod.equals(castOther.rolCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuarioCod.hashCode();
		hash = hash * prime + this.rolCod.hashCode();
		
		return hash;
	}
}