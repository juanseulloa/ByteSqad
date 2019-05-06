package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.UstaEmpresarial.familia.modelo.Pariente;
import co.com.ustaempresarial.fachada.FamiliaFachada;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FamiliaBean implements FamiliaFachada{
	
	@PersistenceContext(unitName = "UstaEmpresarialParientes")
	private EntityManager emp;
	

	public FamiliaBean() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ustaempresarial.fachada.FamiliaFachada#crearPariente(co.com.UstaEmpresarial.familia.modelo.Pariente)
	 */
	@Override
	public void crearPariente(Pariente pariente) throws Exception {
		if(pariente.getCodigo()>0) {
			emp.persist(pariente);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ustaempresarial.fachada.FamiliaFachada#listarParienes()
	 */
	@Override
	public List<Pariente> listarParienes() throws Exception {
		List<Pariente> parientes = new ArrayList<Pariente>();
		Query q = emp.createNamedQuery(Pariente.LISTAR_PARIENTES);
		
		parientes = q.getResultList();
		
		if(parientes.size()==0) {
			parientes = null;
		}
		
		return parientes;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ustaempresarial.fachada.FamiliaFachada#traerPariente(java.lang.Integer)
	 */
	@Override
	public Pariente traerPariente(Long codigo) throws Exception {
		Pariente p = new Pariente();
		if(codigo>0) {
			Query q = emp.createNamedQuery(Pariente.TRAER_PARIENTE_POR_CODIGO).setParameter("codigo", codigo);
			
			try {
				p = (Pariente) q.getSingleResult();
			} catch (NoResultException ex) {
				p = null;
			}
		}else {
			p = null;
		}
		
		return p;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ustaempresarial.fachada.FamiliaFachada#actualizarPariente(co.com.UstaEmpresarial.familia.modelo.Pariente)
	 */
	@Override
	public void actualizarPariente(Pariente p) throws Exception {
		Pariente ptemp = new Pariente();
		if(p.getCodigo()>0) {
			ptemp = emp.find(Pariente.class, p.getCodigo());
			if(ptemp.getCodigo()>0) {
				emp.merge(p);
			}
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.ustaempresarial.fachada.FamiliaFachada#eliminPariente(java.lang.Integer)
	 */
	@Override
	public void eliminPariente(Long codigo) throws Exception {
		Pariente ptemp = new Pariente();
		if(codigo>0) {
			ptemp = emp.find(Pariente.class, codigo);
			if(ptemp.getCodigo()>0) {
				emp.remove(ptemp);
			}
		}
	}

}
