package locadora.diurno.controller;

import javax.inject.*;
import javax.enterprise.context.*;
import locadora.diurno.dal.entidade.*;

@Named
@RequestScoped
public class AutenticacaoController {
	private Usuario usuario;
	private boolean usuarioAutenticado;
	
	public AutenticacaoController() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}
