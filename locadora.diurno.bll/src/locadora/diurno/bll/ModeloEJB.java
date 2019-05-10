package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IModeloEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.IModeloDAO;
import locadora.diurno.dal.entidade.Modelo;


@Stateless
public class ModeloEJB implements IModeloEJB {

	@Inject
	private IModeloDAO modeloDAO;
	
	@Override
	public Mensagem salvar(Modelo modelo) {

		try {
			modeloDAO.insertOrUpdate(modelo);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
	}

	@Override
	public Mensagem excluir(Short idModelo) {
		
		
		try {
			
			Modelo modelo = modeloDAO.findById(idModelo);
			
			if(modelo == null) {
				throw new Exception("Modelo inexistente.");
			}
			
			if(modelo.getAutomoveis().size() > 0) {
				throw new Exception("Existem automoveis vinculados a essa marca");
			}
			
			modeloDAO.delete(modelo);
			
		}catch(Exception ex) {
			return new Mensagem("N�o foi poss�vel excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
		return new Mensagem("Exclu�do com sucesso.",
				TipoMensagem.sucesso);
		
	}


	@Override
	public List<Modelo> listar() {
		return modeloDAO.findAll();
	}

}
