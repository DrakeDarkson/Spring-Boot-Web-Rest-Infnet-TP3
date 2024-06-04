package al.infnet.edu.br.backend.controller;

import al.infnet.edu.br.backend.model.MaterialDidatico;
import al.infnet.edu.br.backend.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @PostMapping
    public ResponseEntity<MaterialDidatico> createMaterial(@RequestBody MaterialDidatico material) {
        MaterialDidatico createdMaterial = materialDidaticoService.save(material);
        return ResponseEntity.ok(createdMaterial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDidatico> getMaterialById(@PathVariable String id) {
        return materialDidaticoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<MaterialDidatico> getAllMateriais() {
        return materialDidaticoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDidatico> updateMaterial(@PathVariable String id, @RequestBody MaterialDidatico materialDetails) {
        return materialDidaticoService.findById(id)
                .map(material -> {
                    material.setTitulo(materialDetails.getTitulo());
                    material.setConteudo(materialDetails.getConteudo());
                    MaterialDidatico updatedMaterial = materialDidaticoService.save(material);
                    return ResponseEntity.ok(updatedMaterial);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String id) {
        return materialDidaticoService.findById(id)
                .map(material -> {
                    materialDidaticoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
