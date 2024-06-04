package al.infnet.edu.br.backend.repository;

import al.infnet.edu.br.backend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
