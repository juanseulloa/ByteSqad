package co.com.ustaempresarial.servicio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.facturacion.modelo.UsuarioLogin;
import co.com.ustaempresarial.fachada.AutenticacionFachada;


@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class AutenticacionServicio{

	@EJB
	AutenticacionFachada autenticacionBean;

	public AutenticacionServicio() {
		super();
	}
	
	public UsuarioLogin consultarUsuario(String us, String clave) throws Exception {
		return autenticacionBean.consultarUsuario(us, clave);
	}
}
