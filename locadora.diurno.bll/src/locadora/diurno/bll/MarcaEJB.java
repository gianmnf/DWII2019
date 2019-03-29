package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.IMarcaDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class MarcaEJB implements IMarcaEJB {

	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {

		try {
			
			marcaDAO.insertOrUpdate(marca);
		
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}finally {
			//Fecha conex�o
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idMarca) {
		try {
		Marca marca = obterPorId(idMarca);
		marcaDAO.delete(marca);
		if(marca == null) {
			//Throw - cria exce��o
			throw new Exception("Marca Inexistente.");
		}
		//Checar se possui modelos
		if(marca.getModelos().size() > 0) {
			throw new Exception("Existem modelos vinculados a essa marca.");
		}
		}catch(Exception ex) {
			return new Mensagem("N�o foi poss�vel excluir: "
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Exclu�do com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Marca obterPorId(Short idMarca) {
		return marcaDAO.findById(idMarca);
	}

	@Override
	public List<Marca> obterTodos() {
		return marcaDAO.findAll();
	}

}
