package al.infnet.edu.br.backend.repository;

import al.infnet.edu.br.backend.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}

