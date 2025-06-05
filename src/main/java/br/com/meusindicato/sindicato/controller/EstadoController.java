package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.model.Estado;
import br.com.meusindicato.sindicato.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service){
        this.service = service;
    }

    @GetMapping
    public Page<EstadoDTO> listar(@RequestParam Map<String,String> filtros,
                                  @PageableDefault(size = 10, direction = Sort.Direction.ASC)Pageable pageable){
        filtros.remove("page");
        filtros.remove("size");
        filtros.remove("sort");
        return service.listarTodos(filtros,pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> getById(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstadoDTO> create(@Valid @RequestBody EstadoDTO estadoDTO){
        return ResponseEntity.ok(service.save(estadoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody EstadoDTO obj){
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
        if (service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(service.update(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
