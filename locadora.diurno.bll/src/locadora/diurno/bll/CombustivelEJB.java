package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;			
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CombustivelEJB implements ICombustivelEJB{
	@Inject
	private ICombustivelDAO combustivelDAO;
	
	@Override
	public Mensagem salvar(Combustivel combustivel) {

		try {
			combustivelDAO.insertOrUpdate(combustivel);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idCombustivel) {
		
		
		try {
			
			Combustivel combustivel = obterPorId(idCombustivel);
			
			if(combustivel == null) {
				throw new Exception("Combustivel inexistente.");
			}
			
			combustivelDAO.delete(combustivel);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	@Override
	public Combustivel obterPorId(Short idCombustivel) {
		return combustivelDAO.findById(idCombustivel);
	}


	@Override
	public List<Combustivel> obterTodos() {
		return combustivelDAO.findAll();
	}
}
