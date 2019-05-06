package co.com.ustaempresarial.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_permiso database table.
 * 
 */
@Embeddable
public class RolPermisoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="permiso_cod", insertable=false, updatable=false)
	private Integer permisoCod;

	@Column(name="rol_cod", insertable=false, updatable=false)
	private Integer rolCod;

	public RolPermisoPK() {
	}
	public Integer getPermisoCod() {
		return this.permisoCod;
	}
	public void setPermisoCod(Integer permisoCod) {
		this.permisoCod = permisoCod;
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
		if (!(other instanceof RolPermisoPK)) {
			return false;
		}
		RolPermisoPK castOther = (RolPermisoPK)other;
		return 
			this.permisoCod.equals(castOther.permisoCod)
			&& this.rolCod.equals(castOther.rolCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.permisoCod.hashCode();
		hash = hash * prime + this.rolCod.hashCode();
		
		return hash;
	}
}