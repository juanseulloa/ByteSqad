package co.com.ustaempresarial.servicio;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.fachada.SeguridadFachada;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
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
	//************************************Rol************************************************
		public List<Rol> listarRol() throws Exception {
			return objSeguridad.listarRol();
		}

		public void crearRol(Rol rol) throws Exception {
			objSeguridad.crearRol(rol);
		}

		public Rol editarRol(Rol rol) throws Exception {
			return objSeguridad.editarRol(rol);
		}

		public boolean eliminarRol(int codigo) throws Exception {
			return objSeguridad.eliminarRol(codigo);
		}

		public Rol buscarRol(int codigo) throws Exception {
			return objSeguridad.buscarRol(codigo);
		}
	//*****************************************************************************************
		//*************************************Permiso**********************************************

		public List<Permiso> listarPermiso() throws Exception {
			return objSeguridad.listarPermiso();
		}

		public void crearPermiso(Permiso permiso) throws Exception {
			objSeguridad.crearPermiso(permiso);
		}

		public Permiso editarPermiso(Permiso permiso) throws Exception {
			return objSeguridad.editarPermiso(permiso);
		}

		public boolean eliminarPermiso(int codigo) throws Exception {
			return objSeguridad.eliminarPermiso(codigo);
		}

		public Permiso buscarPermiso(int codigo) throws Exception {
			return objSeguridad.buscarPermiso(codigo);
		}
		
	//**************************************************************************************	

		
	
}
