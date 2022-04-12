package br.com.Mv.projetoAnderson.desafioMv.Exception;

public class AlimentoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public AlimentoException(String mensagem) {
		super(mensagem);
	}

	public AlimentoException(int id) {
		this(String.format("Não existe um cadastro de alimento com id %d", id));
	}


}
