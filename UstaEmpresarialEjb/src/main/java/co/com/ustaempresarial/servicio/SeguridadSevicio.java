package co.com.ustaempresarial.servicio;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.fachada.SeguridadFachada;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;



@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)

public class SeguridadSevicio {
	@EJB
	 SeguridadFachada fachada;
	 SeguridadFachada objSeguridad;
	public List<Usuario> traerUsuarios() throws Exception {
		return fachada.traerUsuarios();
	}
	public void crearUsuario(Usuario user) throws Exception {
		fachada.crearUsuario(user);
	}
	
	public Usuario editarUsuario(Usuario user) throws Exception {
		return fachada.editarUsuario(user);
	}
	public boolean borrarUsuario(int codigo) throws Exception {
		return fachada.borrarUsuario(codigo);
	}
	
	public List<Usuario> buscarPorNombre(String nombre) throws Exception{
		return fachada.buscarUsuarioPorNombre(nombre);
	}
	//********************************************UsuarioLog***********************************
		public List<UsuarioLog> listarUsuarioLog() throws Exception {
			return objSeguridad.listarUsuarioLog();
		}

		public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception {
			objSeguridad.crearUsuarioLog(usuarioLog);
		}

		public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception {
			return objSeguridad.editarUsuarioLog(usuarioLog);
		}

		public boolean eliminarUsuarioLog(int codigo) throws Exception {
			return objSeguridad.eliminarUsuarioLog(codigo);
		}

		public UsuarioLog buscarUsuarioLog(int codigo) throws Exception {
			return objSeguridad.buscarUsuarioLog(codigo);
		}
	//******************************************************************************************
	
	
}
