package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;				
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.IAutomovelDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AutomovelEJB implements IAutomovelEJB{
	@Inject
	private IAutomovelDAO automovelDAO;
	
	@Override
	public Mensagem salvar(Automovel automovel) {

		try {
			automovelDAO.insertOrUpdate(automovel);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idAutomovel) {
		
		
		try {
			
			Automovel automovel = obterPorId(idAutomovel);
			
			if(automovel == null) {
				throw new Exception("Automovel inexistente.");
			}
			
			automovelDAO.delete(automovel);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	@Override
	public Automovel obterPorId(Short idAutomovel) {
		return automovelDAO.findById(idAutomovel);
	}


	@Override
	public List<Automovel> obterTodos() {
		return automovelDAO.findAll();
	}
}
