package locadora.diurno.controller;

import javax.enterprise.context.*;				
import javax.ejb.*;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.dal.entidade.*;

import javax.inject.*;

import java.util.*;

import locadora.diurno.bll.util.*;
import javax.faces.context.*;
import javax.faces.application.*;

@Named
@RequestScoped
public class AutomovelController {
private Automovel automovel;
	
	@EJB
	private IAutomovelEJB automovelEJB;
	
	@Inject
	private FacesContext context;
	
	public AutomovelController() {
		this.automovel = new Automovel();
	}
	
	//Editar
	public void editar(Automovel automovel) {
		this.automovel = automovel;
	}
		
	//Excluir
	public void excluir(Short idAutomovel) {
		Mensagem msg = automovelEJB.excluir(idAutomovel);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	
	public void salvar() {
		
		Mensagem msg = automovelEJB.salvar(automovel);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.automovel = new Automovel();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Automovel> todos(){
		return automovelEJB.obterTodos();
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
}
