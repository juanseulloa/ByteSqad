package co.com.ustaempresarial.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.UstaEmpresarial.nomina.modelo.Nomina;

@Remote
public interface NominaFachada {

	/**
	 * obtenerNominas
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Nomina> obtenerNominas() throws Exception;

	/**
	 * crearNomina
	 * 
	 * @param nomina
	 * @throws Exception
	 */
	public void crearNomina(Nomina nomina) throws Exception;

	/**
	 * editarNomina
	 * 
	 * @param nomina
	 * @return
	 * @throws Exception
	 */
	public Nomina editarNomina(Nomina nomina) throws Exception;

	/**
	 * borrarNomina
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public boolean borrarNomina(int codigo) throws Exception;

	/**
	 * buscarNominaPorNombre
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */

	public List<Nomina> buscarNominaPorNombre(String nombre) throws Exception;

}
