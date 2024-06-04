package al.infnet.edu.br.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import al.infnet.edu.br.backend.model.Curso;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CursoCacheService {
    @Autowired
    private RedisTemplate<String, Curso> redisTemplate;

    private static final String KEY = "CURSO";

    public void save(Curso curso) {
        redisTemplate.opsForValue().set(KEY + curso.getId(), curso, 10, TimeUnit.MINUTES);
    }

    public Curso findById(Long id) {
        return redisTemplate.opsForValue().get(KEY + id);
    }

    public void deleteById(Long id) {
        redisTemplate.delete(KEY + id);
    }

    public List<Curso> findAll() {
        return null;
    }
}

