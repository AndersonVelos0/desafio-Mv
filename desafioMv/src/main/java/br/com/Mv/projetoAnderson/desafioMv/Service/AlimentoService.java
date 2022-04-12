package br.com.Mv.projetoAnderson.desafioMv.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.Mv.projetoAnderson.desafioMv.Exception.AlimentoException;
import br.com.Mv.projetoAnderson.desafioMv.Model.Alimento;
import br.com.Mv.projetoAnderson.desafioMv.Repository.AlimentoRepository;

@Service
public class AlimentoService {

	@Autowired
	AlimentoRepository alimentoRepository;
	
	public Alimento salvar(Alimento alimento) {
		return alimentoRepository.save(alimento);
	}
	public List<Alimento> listarTodos(){
		return ((JpaRepository<Alimento, Integer>) alimentoRepository).findAll();
	}
	public Alimento buscarPorId(int id) {
		return alimentoRepository.findById(id).orElseThrow( () -> new AlimentoException(id));
	}
	public void excluir(int id) {
		alimentoRepository.deleteById(id);
	}
}
