package co.com.ustaempresarial.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.UstaEmpresarial.familia.modelo.Pariente;
import co.com.ustaempresarial.fachada.FamiliaFachada;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FamiliaService {
	
	@EJB
	FamiliaFachada fachada;
	
	/**
	 * crea el pariente
	 * @param pariente
	 * @throws Exception
	 */
	public void crearPariente(Pariente pariente) throws Exception{
		fachada.crearPariente(pariente);
	}
	
	/**
	 * lista los parientes que estan en  la base
	 * @return
	 * @throws Exception
	 */
	public List<Pariente> listarParienes() throws Exception{
		return fachada.listarParienes();
	}
	
	/**
	 * tarer pariente por codigo
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public Pariente traerPariente(Long codigo) throws Exception{
		return fachada.traerPariente(codigo);
	}

	
	/**
	 * actualiza pariente
	 * @param p
	 * @throws Exception
	 */
	public void actualizarPariente(Pariente p) throws Exception{
		fachada.actualizarPariente(p);
	}
	
	/**
	 * elimina pariente
	 * @param codigo
	 * @throws Exception
	 */
	public void eliminPariente(Long codigo) throws Exception{
		fachada.eliminPariente(codigo);
	}

}
