package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.model.SecUser;
import br.com.meusindicato.sindicato.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final SecUserService service;

    public UsuarioController(SecUserService service) {
        this.service = service;
    }

    @GetMapping
    public Page<SecUser> getAll(
            @RequestParam Map<String, String> filtros,
            @PageableDefault(size = 10, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        filtros.remove("page");
        filtros.remove("size");
        filtros.remove("sort");
        return service.findAll(filtros,pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecUser> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SecUser> create(@RequestBody SecUser user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecUser> update(@PathVariable Long id, @RequestBody SecUser user) {
        return service.findById(id)
                .map(existing -> {
                    user.setId(existing.getId());
                    return ResponseEntity.ok(service.save(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

