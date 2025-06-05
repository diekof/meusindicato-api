package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.model.Estado;
import br.com.meusindicato.sindicato.repository.EstadoRepository;
import br.com.meusindicato.sindicato.repository.PaisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    public Page<EstadoDTO> listarTodos(Map<String, String> filtros, Pageable pageable) {
        Specification<Estado> spec = SpecificationBuilder.build(filtros);
        Page<Estado> estados = estadoRepository.findAll(spec,pageable);
        return estados.map(e -> new EstadoDTO(e.getEstadoId(),e.getEstadoNome(),e.getUF(),e.getPais().getPaisId()));
    }

    public Optional<EstadoDTO> buscarPorId(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isPresent()){
            Estado e = estado.get();
            return Optional.of(new EstadoDTO(e.getEstadoId(),
                    e.getEstadoNome(),
                    e.getUF(),
                    e.getPais().getPaisId()));
        }else {
            return Optional.empty();
        }
    }

    @Transactional
    public EstadoDTO save(EstadoDTO obj) {
        Estado estado = new Estado(obj.estadoNome(),obj.UF(),
                paisRepository.findById(obj.paisId()).get());
        var savedEstado = estadoRepository.save(estado);
        return new EstadoDTO(savedEstado.getEstadoId(),
                savedEstado.getEstadoNome(),
                savedEstado.getUF(),
                savedEstado.getPais().getPaisId());
    }

    @Transactional
    public Estado update(EstadoDTO obj) {
        Optional<Estado> estadoOptional = estadoRepository.findById(obj.estadoId());
        if (estadoOptional.isPresent()){
            Estado estado = estadoOptional.get();
            estado.setEstadoNome(obj.estadoNome());
            estado.setUF(obj.UF());
            estado.setPais(paisRepository.findById(obj.paisId()).get());

            return estadoRepository.save(estado);
        }
        return null;
    }
    @Transactional
    public void delete(Long id) {estadoRepository.deleteById(id);}
}
