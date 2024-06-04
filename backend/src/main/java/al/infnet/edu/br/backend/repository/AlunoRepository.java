package al.infnet.edu.br.backend.repository;

import al.infnet.edu.br.backend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
