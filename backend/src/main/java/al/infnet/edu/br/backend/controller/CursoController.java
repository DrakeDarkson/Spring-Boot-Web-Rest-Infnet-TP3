package al.infnet.edu.br.backend.controller;

import al.infnet.edu.br.backend.model.Curso;
import al.infnet.edu.br.backend.service.CursoService;
import al.infnet.edu.br.backend.service.CursoCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoCacheService cursoCacheService;

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso createdCurso = cursoService.save(curso);
        return ResponseEntity.ok(createdCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso cursoFromCache = cursoCacheService.findById(id);
        if (cursoFromCache != null) {
            return ResponseEntity.ok(cursoFromCache);
        }

        return cursoService.findById(id)
                .map(curso -> {
                    cursoCacheService.save(curso);
                    return ResponseEntity.ok(curso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        return cursoService.findById(id)
                .map(curso -> {
                    curso.setNome(cursoDetails.getNome());
                    curso.setAlunos(cursoDetails.getAlunos());
                    Curso updatedCurso = cursoService.save(curso);
                    cursoCacheService.save(updatedCurso);
                    return ResponseEntity.ok(updatedCurso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        return cursoService.findById(id)
                .map(curso -> {
                    cursoService.deleteById(id);
                    cursoCacheService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
