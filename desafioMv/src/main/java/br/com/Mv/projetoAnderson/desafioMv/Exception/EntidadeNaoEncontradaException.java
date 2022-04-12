package br.com.Mv.projetoAnderson.desafioMv.Exception;

public class EntidadeNaoEncontradaException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
