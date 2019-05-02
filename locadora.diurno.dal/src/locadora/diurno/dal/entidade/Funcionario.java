package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Entity
//Herdando de pessoa
@Inheritance(strategy= InheritanceType.JOINED)
//Inserindo F no tipo
@DiscriminatorValue(value = "F")
//PFK
@PrimaryKeyJoinColumn(name="idPessoaFuncionario", referencedColumnName="idPessoa")
public class Funcionario extends Pessoa{
	private Double salario;
	
	//Sempre que excluir funcionario, excluir usuario
	@OneToOne(mappedBy = "funcionario",cascade = CascadeType.ALL)
	//Não tem Join Column pois não tem chave estrangeira
	private Usuario usuario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
	