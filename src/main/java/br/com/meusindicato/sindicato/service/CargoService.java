package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.CargoDTO;
import br.com.meusindicato.sindicato.dto.CidadeDTO;
import br.com.meusindicato.sindicato.model.*;
import br.com.meusindicato.sindicato.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepo;


    public Page<CargoDTO> listarTodos(Map<String, String> filtros, Pageable pageable) {
        Specification<Cargo> spec = SpecificationBuilder.build(filtros);
        Page<Cargo> cargos = cargoRepo.findAll(spec,pageable);
        return cargos.map(c -> new CargoDTO(c.getCargoId(), c.getCargoCodigo(), c.getCargoDescricao()));
    }

    public Optional<CargoDTO> buscarPorId(Long id) {
        Optional<Cargo> cargo = cargoRepo.findById(id);
        if (cargo.isPresent()){
            Cargo c = cargo.get();
            return Optional.of(new CargoDTO(c.getCargoId(),c.getCargoCodigo(),c.getCargoDescricao()));
        }else {
            return Optional.empty();
        }
    }

    public Cargo save(CargoDTO obj){
        Cargo cargo = new Cargo(obj.cargoCodigo(),
                obj.cargoDescricao());

        return cargoRepo.save(cargo);
    }

    public Cargo update(CargoDTO obj) {
        Optional<Cargo> cargoOptional = cargoRepo.findById(obj.cargoId());
        if (cargoOptional.isPresent()){
            Cargo c = cargoOptional.get();
            c.setCargoCodigo(obj.cargoCodigo());
            c.setCargoDescricao(obj.cargoDescricao());

            return cargoRepo.save(c);
        }
        return null;
    }

    public void delete(Long id) {cargoRepo.deleteById(id);}
}
