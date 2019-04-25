package locadora.diurno.bll.interfaces;

import locadora.diurno.dal.entidade.*;			
import locadora.diurno.bll.util.*;
import java.util.*;

public interface IAutomovelEJB {
	public Mensagem salvar(Automovel automovel);
	
	public Mensagem excluir(Short idAutomovel);
	
	public Automovel obterPorId(Short idAutomovel);
	
	public List<Automovel> obterTodos();
}
