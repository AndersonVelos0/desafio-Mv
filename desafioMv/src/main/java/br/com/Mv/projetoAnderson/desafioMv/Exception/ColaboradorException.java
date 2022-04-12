package br.com.Mv.projetoAnderson.desafioMv.Exception;

public class ColaboradorException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ColaboradorException(String mensagem) {
		super(mensagem);
	}

	public ColaboradorException(int id) {
		this(String.format("Não existe um cadastro de colaborador com id %d", id));
	}

}
