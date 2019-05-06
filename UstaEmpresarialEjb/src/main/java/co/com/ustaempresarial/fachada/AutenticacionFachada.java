package co.com.ustaempresarial.fachada;

import javax.ejb.Remote;

import co.com.facturacion.modelo.UsuarioLogin;

@Remote
public interface AutenticacionFachada{

	/**
	 * metodo que busca si un usuario que esta registrado en el sistema
	 * @param us
	 * @param clave
	 * @return
	 * @throws Exception
	 */
	public UsuarioLogin consultarUsuario(String us,String clave) throws Exception;
	

}
