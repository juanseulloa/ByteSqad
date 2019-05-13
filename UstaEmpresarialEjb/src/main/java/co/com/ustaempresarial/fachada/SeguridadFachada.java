package co.com.ustaempresarial.fachada;

import java.util.List;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.seguridad.modelo.Usuario;

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
	
}
