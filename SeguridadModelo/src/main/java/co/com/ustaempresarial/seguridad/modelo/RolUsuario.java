package co.com.ustaempresarial.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rol_usuario database table.
 * 
 */
@Entity
@Table(name="rol_usuario")
@NamedQuery(name="RolUsuario.findAll", query="SELECT r FROM RolUsuario r")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolUsuarioPK id;

	private Timestamp fecha;

	public RolUsuario() {
	}

	public RolUsuarioPK getId() {
		return this.id;
	}

	public void setId(RolUsuarioPK id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}