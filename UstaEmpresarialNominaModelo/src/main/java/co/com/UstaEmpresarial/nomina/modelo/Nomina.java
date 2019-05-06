package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nomina database table.
 * 
 */
@Entity
@Table(name = "nomina", schema="USTANOMINA")
@NamedQuery(name="Nomina.findAll", query="SELECT n FROM Nomina n")
public class Nomina implements Serializable {
	private static final long serialVersionUID = 1L;
	private NominaPK id;
	private Date fechaInsert;
	private String fechaUpdate;
	private String usuarioInsert;
	private String usuarioUpdate;
	private Integer valor;

	public Nomina() {
	}


	@EmbeddedId
	public NominaPK getId() {
		return this.id;
	}

	public void setId(NominaPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_insert")
	public Date getFechaInsert() {
		return this.fechaInsert;
	}

	public void setFechaInsert(Date fechaInsert) {
		this.fechaInsert = fechaInsert;
	}


	@Column(name="fecha_update")
	public String getFechaUpdate() {
		return this.fechaUpdate;
	}

	public void setFechaUpdate(String fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}


	@Column(name="usuario_insert")
	public String getUsuarioInsert() {
		return this.usuarioInsert;
	}

	public void setUsuarioInsert(String usuarioInsert) {
		this.usuarioInsert = usuarioInsert;
	}


	@Column(name="usuario_update")
	public String getUsuarioUpdate() {
		return this.usuarioUpdate;
	}

	public void setUsuarioUpdate(String usuarioUpdate) {
		this.usuarioUpdate = usuarioUpdate;
	}


	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}