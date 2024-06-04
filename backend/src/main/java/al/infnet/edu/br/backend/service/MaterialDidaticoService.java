package al.infnet.edu.br.backend.service;

import al.infnet.edu.br.backend.model.MaterialDidatico;
import al.infnet.edu.br.backend.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository repository;

    public MaterialDidatico save(MaterialDidatico material) {
        return repository.save(material);
    }

    public Optional<MaterialDidatico> findById(String id) {
        return repository.findById(id);
    }

    public List<MaterialDidatico> findAll() {
        return repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

