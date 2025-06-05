package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping()
    public ResponseEntity<Boolean> cadastrarPais(@RequestBody PaisDTO paisDTO){

        return paisService.inserirPais(paisDTO);
    }
    @GetMapping
    public Page<PaisDTO> listar(
            @RequestParam Map<String, String> filtros,
            @PageableDefault(size = 10, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        filtros.remove("page");
        filtros.remove("size");
        filtros.remove("sort");
        return paisService.listarTodos(filtros,pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaisDTO> buscarPorId(@PathVariable Long id) {
        return paisService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<PaisDTO> atualizar(@PathVariable Long id, @RequestBody PaisDTO obj) {
        if (id==null) {
            return ResponseEntity.badRequest().build();
        }
        if (!paisService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(paisService.salvar(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!paisService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paisService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
