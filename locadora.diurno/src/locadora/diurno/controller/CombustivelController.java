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
public class CombustivelController {
private Combustivel combustivel;
	
	@EJB
	private ICombustivelEJB combustivelEJB;
	
	@Inject
	private FacesContext context;
	
	public CombustivelController() {
		this.combustivel = new Combustivel();
	}
	
	//Editar
	public void editar(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
		
	//Excluir
	public void excluir(Short idCombustivel) {
		Mensagem msg = combustivelEJB.excluir(idCombustivel);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	
	public void salvar() {
		
		Mensagem msg = combustivelEJB.salvar(combustivel);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.combustivel = new Combustivel();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Combustivel> todos(){
		return combustivelEJB.obterTodos();
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
}
