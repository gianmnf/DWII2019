package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.*;	
import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.generics.*;

import javax.enterprise.context.*;

@RequestScoped
public class CorDAO 
	extends JPAGenericDAO<Cor, Short>
	implements ICorDAO{

}
