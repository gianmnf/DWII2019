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
public class ModeloController {

	private Modelo modelo;
	//Salvar
	@EJB
	private IModeloEJB modeloEJB;
	
	@Inject
	private FacesContext context;
	
	public ModeloController() {
		this.modelo = new Modelo();
	}
	//Método para salvar
	public void salvar() {
		Mensagem msg = modeloEJB.salvar(modelo);
		
		if(msg.getStatus() == MensagemStatus.sucesso) { 
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					msg.getTexto(),null));		
			//Cria novo objeto
			this.modelo = new Modelo();
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					msg.getTexto(),null));	
		}
	}
	
	public List<Modelo> todos(){
		return modeloEJB.obterTodos();
	}
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
	
	
}
