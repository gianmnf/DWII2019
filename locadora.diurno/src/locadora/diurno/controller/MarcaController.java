package locadora.diurno.controller;

import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.ejb.*;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.entidade.*;

import javax.inject.*;

import locadora.diurno.bll.util.*;
import java.util.*;
import javax.faces.context.*;
import javax.faces.application.*;

@Named
@RequestScoped
public class MarcaController {
	
	private Marca marca;

	@EJB
	private IMarcaEJB marcaEJB;
	
	@Inject
	private FacesContext context;
	
	public MarcaController() {
		this.marca = new Marca();
	}
	
	//Edição
	public void editar(Marca marca) {
		this.marca = marca;
	}
	
	//Exclusão
	public void excluir(Short idMarca) {
		Mensagem msg = marcaEJB.excluir(idMarca);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	//Criação
public void salvar() {
		
		Mensagem msg = marcaEJB.salvar(marca);
		
		if(msg.getStatus() == MensagemStatus.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(), null));
			
			this.marca = new Marca();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
	
	public List<Marca> todas(){
		return marcaEJB.obterTodos();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
