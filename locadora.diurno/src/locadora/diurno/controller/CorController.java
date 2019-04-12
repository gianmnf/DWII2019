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
public class CorController {

	private Cor cor;
	
	@EJB
	private ICorEJB corEJB;
	
	@Inject
	private FacesContext context;
	
	public CorController() {
		this.cor = new Cor();
	}
	
	//Editar
	public void editar(Cor cor) {
		this.cor = cor;
	}
		
	//Excluir
	public void excluir(Short idCor) {
		Mensagem msg = corEJB.excluir(idCor);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	
	public void salvar() {
		
		Mensagem msg = corEJB.salvar(cor);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.cor = new Cor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Cor> todos(){
		return corEJB.obterTodos();
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

}
