package locadora.diurno.controller;

import javax.enterprise.context.*;
import locadora.diurno.dal.entidade.*;
import javax.inject.*;

@Named
@RequestScoped
public class ModeloController {
	//Referência ao objeto modelo
	private Modelo modelo;
	
	//Ligação da View - BIND
	public ModeloController() {
		this.modelo = new Modelo();
	}

	//Getters & Setters
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
