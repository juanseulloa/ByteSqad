package co.com.ustaempresarial.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.UstaEmpresarial.familia.modelo.Pariente;

@Remote
public interface FamiliaFachada {
	
	/**
	 * crea el pariente
	 * @param pariente
	 * @throws Exception
	 */
	public void crearPariente(Pariente pariente) throws Exception;
	
	/**
	 * lista los parientes que estan en  la base
	 * @return
	 * @throws Exception
	 */
	public List<Pariente> listarParienes() throws Exception;
	
	/**
	 * tarer pariente por codigo
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public Pariente traerPariente(Long codigo) throws Exception;

	
	/**
	 * actualiza pariente
	 * @param p
	 * @throws Exception
	 */
	public void actualizarPariente(Pariente p) throws Exception;
	
	/**
	 * elimina pariente
	 * @param codigo
	 * @throws Exception
	 */
	public void eliminPariente(Long codigo) throws Exception;
}
