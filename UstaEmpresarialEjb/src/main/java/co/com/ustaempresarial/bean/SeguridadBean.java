package co.com.ustaempresarial.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.ustaempresarial.fachada.SeguridadFachada;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SeguridadBean implements SeguridadFachada{
	@PersistenceContext(unitName = "seguridad")
	private EntityManager em;
	
	public SeguridadBean() {
		super();
	}

}
