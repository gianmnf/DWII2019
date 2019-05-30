package locadora.diurno.bll;

import java.util.*;
import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import javax.ejb.*;
import javax.inject.*;

@Stateless
public class FuncionarioEJB implements IFuncionarioEJB{
	
	@Inject
	private IFuncionarioDAO funcionarioDAO;

	@Override
	public Mensagem salvar(Funcionario funcionario) {
		try {
			funcionarioDAO.insertOrUpdate(funcionario);
			return new Mensagem("Funcionário Salvo.",TipoMensagem.sucesso);
		} catch (Exception e) {
			return new Mensagem(e.getMessage(),TipoMensagem.erro);
		}
	}

	@Override
	public Mensagem excluir(Integer idPessoa) {
		try {
			Funcionario funcionario = funcionarioDAO.findById(idPessoa);
			if(funcionario == null) {
				return new Mensagem("Funcionário não existe.",TipoMensagem.erro);
			}
			
			if(funcionario.getLocacoes().size() > 0) {
				return new Mensagem("Funcionário já realizou locação.",TipoMensagem.erro);
			}
			
			funcionarioDAO.delete(funcionario);
			
			return new Mensagem("Funcionário Excluido.",TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem(ex.getMessage(),
					TipoMensagem.erro);
		}
	}

	@Override
	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
