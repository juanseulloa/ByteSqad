package co.com.ustaempresarial.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the usuario_log database table.
 * 
 */
@Entity
@Table(name="usuario_log")
@NamedQuery(name="UsuarioLog.findAll", query="SELECT u FROM UsuarioLog u")
public class UsuarioLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String dml;

	private Timestamp fecha;

	private String proceso;

	@Column(name="usuario_cod")
	private Integer usuarioCod;

	public UsuarioLog() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDml() {
		return this.dml;
	}

	public void setDml(String dml) {
		this.dml = dml;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getProceso() {
		return this.proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public Integer getUsuarioCod() {
		return this.usuarioCod;
	}

	public void setUsuarioCod(Integer usuarioCod) {
		this.usuarioCod = usuarioCod;
	}

}