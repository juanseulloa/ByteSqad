package co.com.ustaempresarial.fachada;

import java.util.List;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;

public interface SeguridadFachada {
	
	
	/**
	 * metodo para listar los usuarios
	 * @return List<CategoriaProducto>: listado de productos
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Usuario> traerUsuarios() throws Exception;
	
	/**
	 * metodo que crea los usuarios 
	 * @param User: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 */
	public void crearUsuario(Usuario user) throws Exception;
	
	/**
	 * metodo encargado de actualizar los usuarios 
	 * @param Usuario
	 * @return el usuario que se creo
	 * @throws Exception
	 */
	public Usuario editarUsuario(Usuario user) throws Exception;
	
	/**
	 * metodo que borra el Usuario seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 */
	public boolean borrarUsuario(int codigo) throws Exception;

	/**
	 * metodo que busca por el nombre de Usuario
	 * @param nombre: nombre de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 */
	public List<Usuario> buscarUsuarioPorNombre(String nombre) throws Exception;
	//************************Usuario_Log*********************************************
		public List<UsuarioLog> listarUsuarioLog() throws Exception;

		public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception;

		public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception;

		public boolean eliminarUsuarioLog(int codigo) throws Exception;
		
		public UsuarioLog buscarUsuarioLog(int codigo) throws Exception; 
	//********************************************************************************
		//--------------rol-----------------------------------------------------------
		public List<Rol> listarRol() throws Exception;

		public void crearRol(Rol rol) throws Exception;

		public Rol editarRol(Rol rol) throws Exception;

		public boolean eliminarRol(int codigo) throws Exception;
		
		public Rol buscarRol(int codigo) throws Exception; 
	//--------------------------------------------------------------------------------
	//******************************Permiso*******************************************
		public List<Permiso> listarPermiso() throws Exception;

		public void crearPermiso(Permiso permiso) throws Exception;

		public Permiso editarPermiso(Permiso permiso) throws Exception;

		public boolean eliminarPermiso(int codigo) throws Exception;
		
		public Permiso buscarPermiso(int codigo) throws Exception; 
	//*************************************************************************************
		
	
}
