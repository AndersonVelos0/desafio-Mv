package br.com.Mv.projetoAnderson.desafioMv.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.Mv.projetoAnderson.desafioMv.Model.Colaborador;
import br.com.Mv.projetoAnderson.desafioMv.Service.ColaboradorService;

@RestController
@RequestMapping(value= "/colaborador")
public class ColaboradorController {
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Colaborador> listarTodos() {
		return colaboradorService.listarTodos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador salvar(@RequestBody Colaborador colaborador) {
		return colaboradorService.salvar(colaborador);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador buscarPorId(@PathVariable int id) {
		return colaboradorService.buscarPorId(id);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable int id) {
		colaboradorService.excluir(id);
	}
	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador alterarColaborador(@RequestBody Colaborador colaborador, @PathVariable int id) {
		Colaborador c1Colaborador = colaborador;
		c1Colaborador.setId(id);
		return colaboradorService.salvar(c1Colaborador);
	}
}
