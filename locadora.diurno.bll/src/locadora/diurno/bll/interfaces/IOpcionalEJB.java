package locadora.diurno.bll.interfaces;

import locadora.diurno.dal.entidade.*;			
import locadora.diurno.bll.util.*;
import java.util.*;

public interface IOpcionalEJB {
	public Mensagem salvar(Opcional opcional);
	
	public Mensagem excluir(Short idOpcional);
	
	public Opcional obterPorId(Short idOpcional);
	
	public List<Opcional> obterTodos();
}
