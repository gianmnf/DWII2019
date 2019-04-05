package locadora.diurno.controller;

import javax.enterprise.context.*;
import locadora.diurno.dal.entidade.*;
import javax.inject.*;

@Named
@RequestScoped
public class ModeloController {

	private Modelo modelo;
	
	public ModeloController() {
		this.modelo = new Modelo();
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
	
	
}
