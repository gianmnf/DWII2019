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
public class OpcionalController {
private Opcional opcional;
	
	@EJB
	private IOpcionalEJB opcionalEJB;
	
	@Inject
	private FacesContext context;
	
	public OpcionalController() {
		this.opcional = new Opcional();
	}
	
	//Editar
	public void editar(Opcional opcional) {
		this.opcional = opcional;
	}
		
	//Excluir
	public void excluir(Short idOpcional) {
		Mensagem msg = opcionalEJB.excluir(idOpcional);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	
	public void salvar() {
		
		Mensagem msg = opcionalEJB.salvar(opcional);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.opcional = new Opcional();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Opcional> todos(){
		return opcionalEJB.obterTodos();
	}

	public Opcional getOpcional() {
		return opcional;
	}

	public void setOpcional(Opcional opcional) {
		this.opcional = opcional;
	}
}
