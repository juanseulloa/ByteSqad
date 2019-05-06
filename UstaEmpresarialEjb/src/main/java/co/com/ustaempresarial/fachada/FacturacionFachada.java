package co.com.ustaempresarial.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.facturacion.modelo.VentaDetalle;
import co.com.facturacion.modelo.VentaDetallePK;


@Remote
public interface FacturacionFachada {
	
	/**
	 * en este metodo se va a listar las categorias correspondientes
	 * al los productos
	 * @return List<CategoriaProducto>: listado de productos
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<CategoriaProducto> traerProductos() throws Exception;
	
	/**
	 * metodo que crea la categoria correspodiente a un producto
	 * @param producto: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 */
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception;
	
	/**
	 * metodo encargado de actualizar la cagtegoria 
	 * @param categoriaProducto
	 * @return la Categoria de Producto que se creo
	 * @throws Exception
	 */
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception;
	
	/**
	 * metodo que borra la categoria del producto seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 */
	public boolean borrarCategoriaProducto(int codigo) throws Exception;

	/**
	 * metodo que busca por el nombre de la categoria del produco
	 * @param nombre: nombre de la categoria
	 * @return: la objeto categoria producto
	 * @throws Exception
	 */
	public List<CategoriaProducto> buscarCategoriaPorNombre(String nombre) throws Exception;
	
	/**
	 * metodo que actualiza la venta detalle de una compra
	 * @return
	 * @throws Exception
	 */
	public VentaDetalle actualizarVentaDetalle(VentaDetalle detalle) throws Exception;
	
	/**
	 * Crea un detalle de venta
	 * @param detalle Objeto VentaDetalle
	 * @throws Exception
	 */
	public void crearVentaDetalle(VentaDetalle detalle) throws Exception;
	/**
	 * Eliminar una venta detalle
	 * @param  **/
	public boolean borrarVentaDetalle(VentaDetallePK id) throws Exception;
}
