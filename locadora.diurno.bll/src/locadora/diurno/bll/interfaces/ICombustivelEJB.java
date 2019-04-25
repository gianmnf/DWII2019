package locadora.diurno.bll.interfaces;

import locadora.diurno.dal.entidade.*;			
import locadora.diurno.bll.util.*;
import java.util.*;

public interface ICombustivelEJB {
	
	public Mensagem salvar(Combustivel combustivel);
	
	public Mensagem excluir(Short idCombustivel);
	
	public Combustivel obterPorId(Short idCombustivel);
	
	public List<Combustivel> obterTodos();
}
