package al.infnet.edu.br.backend.service;

import al.infnet.edu.br.backend.model.Aluno;
import al.infnet.edu.br.backend.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}

