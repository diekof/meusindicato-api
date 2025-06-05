package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.CargoDTO;
import br.com.meusindicato.sindicato.dto.CidadeDTO;
import br.com.meusindicato.sindicato.model.Cargo;
import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cargo")
public class CargoController {


    private final CargoService service;

    public CargoController(CargoService cargoService){
        this.service = cargoService;
    }

    @GetMapping()
    public Page<CargoDTO> listar(@RequestParam Map<String,String> filtros,
                                 @PageableDefault(size = 10, direction = Sort.Direction.ASC) Pageable pageable){
        filtros.remove("page");
        filtros.remove("size");
        filtros.remove("sort");
        return service.listarTodos(filtros,pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> getById(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Cargo> create(@RequestBody CargoDTO cargo){
        return ResponseEntity.ok(service.save(cargo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> update(@PathVariable Long id, @RequestBody CargoDTO obj){
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
