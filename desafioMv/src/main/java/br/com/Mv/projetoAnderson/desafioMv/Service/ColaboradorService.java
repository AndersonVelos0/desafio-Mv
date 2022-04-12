


package br.com.Mv.projetoAnderson.desafioMv.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Mv.projetoAnderson.desafioMv.Exception.ColaboradorException;
import br.com.Mv.projetoAnderson.desafioMv.Model.Alimento;
import br.com.Mv.projetoAnderson.desafioMv.Model.Colaborador;
import br.com.Mv.projetoAnderson.desafioMv.Repository.AlimentoRepository;
import br.com.Mv.projetoAnderson.desafioMv.Repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Autowired
	AlimentoRepository alimentoRepository;
	
	public Colaborador salvar(Colaborador colaborador) {
		List<Colaborador> listaColaboradores = listarTodos();
		List<Alimento> listaAlimentosTotais = alimentoRepository.findAll();
		List<Alimento> listaAlimentosColaboradorAtual = colaborador.getAlimentos();
		
//		for(Colaborador colaborador1: listaColaboradores) {
//			if(colaborador1.getCpf().equals(colaborador.getCpf())){
//				 throw new RuntimeException("CPF já existe");
//			}
//		}
//		for(int i = 0; i < listaAlimentosTotais.size(); i++) {
//			for(int j = 0; i < listaAlimentosColaboradorAtual.size(); i++) {
//				if(listaAlimentosTotais.get(i).getCodigoIndentificador() == listaAlimentosColaboradorAtual.get(j).getCodigoIndentificador()) {
//					throw new RuntimeException("Alimento já existe");
//				}
//			}
//		}
		Colaborador c1 = colaboradorRepository.save(colaborador);
		List<Alimento> alimentos = c1.getAlimentos();
		for (Alimento alimento : alimentos) {
			alimento.setIdColaborador(colaborador.getId());
			alimento = alimentoRepository.save(alimento);
		}
		return colaborador;
	}
	public List<Colaborador> listarTodos(){
		return colaboradorRepository.findAll();
	}
	public Colaborador buscarPorId(int id) {
		return colaboradorRepository.findById(id).orElseThrow( () -> new ColaboradorException(id));
	}
	public void excluir(int id) {
		colaboradorRepository.deleteById(id);
	}
}
