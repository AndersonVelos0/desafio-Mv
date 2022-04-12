package br.com.Mv.projetoAnderson.desafioMv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Mv.projetoAnderson.desafioMv.Model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento,Integer>{

}
