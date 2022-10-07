package br.com.senac.inicializacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;

@Component
public class InitAluno implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AlunoService alunoService;
	
	//@Autowired
	//AlunoRepository repo;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Curso c1 = new Curso();
		c1.setNome("Java");
		cursoService.salvar(c1);
		
		Curso c2 = new Curso();
		c2.setNome("NodeJS");
		cursoService.salvar(c2);
		
		Curso c3 = new Curso();
		c3.setNome("Python");
		cursoService.salvar(c3);
		
		Curso c4 = new Curso();
		c4.setNome("JavaScript");
		cursoService.salvar(c4);
		
		List<Curso> listaCursos1 = new ArrayList<>();
		listaCursos1.add(c1);
		listaCursos1.add(c4);
		
		List<Curso> listaCursos2 = new ArrayList<>();
		listaCursos2.add(c2);
		listaCursos2.add(c3);
		
		List<Curso> listaCursos3 = new ArrayList<>();
		listaCursos3.add(c2);
		listaCursos3.add(c3);
		
		
		Turma t1 = new Turma();
		t1.setNome("turma 1");
		t1.setCursos(listaCursos1);
		turmaService.salvar(t1);
		
		Turma t2 = new Turma();
		t2.setNome("turma 2");
		t2.setCursos(listaCursos2);
		turmaService.salvar(t2);
		
		Turma t3 = new Turma();
		t3.setNome("turma 3");
		t3.setCursos(listaCursos3);
		turmaService.salvar(t3);
		
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Bruno");
		aluno1.setTurma(t3);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Yuri");
		aluno2.setTurma(t3);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Josue");
		aluno3.setTurma(t1);
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		
		
		
		
		
//		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
//		
//		//repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
//		
//		for(Aluno aluno : listaAlunos) {
//			System.out.println(aluno.getNome());
//		}
		
//		//Busca por id
//		Aluno aluno4 = alunoService.buscarPorId(1);
//		
//		System.out.println(aluno4.getNome());
//		
//		//deleção por id
//		alunoService.deletarPorId(2);
//	
//		//Atualizar por id
//		//aluno1.setNome("Carlos");
//		//alunoService.atualizarPorId(1, aluno1);
//		//
//		//System.out.println("Teste Atualização: " + aluno1.getNome());
//		
//		Aluno alunoAlterado = new Aluno();
//		alunoAlterado.setId(1);
//		alunoAlterado.setNome("David");
//		
//		alunoService.salvarAlteracao(alunoAlterado);
		
		
	}

}
