package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	//Cadastrar alunos
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	//Buscar todos alunos
	public List<Aluno> buscarTodosAlunos(){
		return alunoRepository.findAll();
	}
	//Buscar Aluno por id
	public Aluno buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(1L, "Aluno não encontrado"));
	}
	//Deletar Aluno
	public void deletarPorId(Integer id) {
        //Optional<Aluno> aluno = alunoRepository.findById(id);
        alunoRepository.deleteById(id);
    }
	
	//Atualizar Aluno
	public Aluno salvarAlteracao(Aluno alunoAlterado) {
		Aluno aluno = buscarPorId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		aluno.setTurma(alunoAlterado.getTurma());
		return salvar(aluno);
	}
		
}
