package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"CODIGO\"")
	private Integer codigo;

	@Column(name="\"CLIENTE_CODIGO\"")
	private Integer clienteCodigo;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA\"")
	private Date fecha;

	public Venta() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getClienteCodigo() {
		return this.clienteCodigo;
	}

	public void setClienteCodigo(Integer clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}