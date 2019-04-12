package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;	
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.ICorDAO;
import locadora.diurno.dal.dao.interfaces.IModeloDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CorEJB implements ICorEJB{

	@Inject
	private ICorDAO corDAO;
	
	@Override
	public Mensagem salvar(Cor cor) {

		try {
			corDAO.insertOrUpdate(cor);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idCor) {
		
		
		try {
			
			Cor cor = obterPorId(idCor);
			
			if(cor == null) {
				throw new Exception("Cor inexistente.");
			}
			
			corDAO.delete(cor);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	@Override
	public Cor obterPorId(Short idCor) {
		return corDAO.findById(idCor);
	}


	@Override
	public List<Cor> obterTodos() {
		return corDAO.findAll();
	}
}
