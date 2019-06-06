package locadora.diurno.dal.dao;

import locadora.diurno.dal.generics.*;
import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import javax.enterprise.context.*;
import javax.persistence.*;

@RequestScoped
public class UsuarioDAO extends JPAGenericDAO<Usuario, Integer>
	implements IUsuarioDAO{

	@Override
	public Usuario porLoginSenha(String login, String senha) {
		TypedQuery<Usuario> query
		= em.createQuery("Select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		Usuario usuario = query.getSingleResult();
		return usuario;
	}

}
