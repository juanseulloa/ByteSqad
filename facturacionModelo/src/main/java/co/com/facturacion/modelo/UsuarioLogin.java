package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_login database table.
 * 
 */
@Entity
@Table(name="usuario_login", schema="facturacion")
public class UsuarioLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TRAER_USUARIO = "UsuarioLogin.TRAER_USUARIO";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String clave;

	private String usuario;

	public UsuarioLogin() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}