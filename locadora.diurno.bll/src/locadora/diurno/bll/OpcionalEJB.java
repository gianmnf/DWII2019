package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;			
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.IOpcionalDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OpcionalEJB {
	@Inject
	private IOpcionalDAO opcionalDAO;
	
	public Mensagem salvar(Opcional opcional) {

		try {
			opcionalDAO.insertOrUpdate(opcional);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	public Mensagem excluir(Short idOpcional) {
		
		
		try {
			
			Opcional opcional = obterPorId(idOpcional);
			
			if(opcional == null) {
				throw new Exception("Opcional inexistente.");
			}
			
			opcionalDAO.delete(opcional);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	public Opcional obterPorId(Short idOpcional) {
		return opcionalDAO.findById(idOpcional);
	}


	public List<Opcional> obterTodos() {
		return opcionalDAO.findAll();
	}
}
