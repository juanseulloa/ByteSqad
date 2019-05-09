package co.com.ustaempresarial.servicio;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.ustaempresarial.fachada.SeguridadFachada;



@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)

public class SeguridadSevicio {
	@EJB
	 SeguridadFachada seguridad;

}
