package locadora.diurno.bll.interfaces;

import locadora.diurno.dal.entidade.*;	
import locadora.diurno.bll.util.*;
import java.util.*;

public interface ICorEJB {
	
	public Mensagem salvar(Cor cor);
	
	public Mensagem excluir(Short idCor);
	
	public Cor obterPorId(Short idCor);
	
	public List<Cor> obterTodos();
	
}
