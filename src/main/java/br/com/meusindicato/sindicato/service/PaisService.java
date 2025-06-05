package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.model.Pais;
import br.com.meusindicato.sindicato.repository.PaisRepository;
import br.com.meusindicato.sindicato.repository.criteria.GenericSpecification;
import br.com.meusindicato.sindicato.repository.criteria.SearchCriteria;
import br.com.meusindicato.sindicato.repository.criteria.SearchOperation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public ResponseEntity<Boolean> inserirPais(PaisDTO paisDTO) {
        Pais pais = new Pais(paisDTO.nome(),paisDTO.sigla());
        Pais paisSalvo = paisRepository.save(pais);

        System.out.println(paisSalvo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public List<PaisDTO> listaPaises() {

        return null;
    }
    public Page<PaisDTO> listarTodos(Map<String, String> filtros, Pageable pageable) {
        Specification<Pais> spec = SpecificationBuilder.build(filtros);
        Page<Pais> paises = paisRepository.findAll(spec,pageable);
        return paises.map(p -> new PaisDTO(p.getPaisId(), p.getNomePais(), p.getSiglaPais()));
    }

    public Optional<PaisDTO> buscarPorId(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            return Optional.of(new PaisDTO(pais.get().getPaisId(), pais.get().getNomePais(), pais.get().getSiglaPais()));
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public PaisDTO salvar(PaisDTO obj) {
        Pais pais = new Pais(obj.nome(),obj.sigla());
        pais.setPaisId(obj.paisId());
        var paisSalvo = paisRepository.save(pais);
        return new PaisDTO(paisSalvo.getPaisId(), paisSalvo.getNomePais(), paisSalvo.getSiglaPais());
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            paisRepository.delete(pais.get());
        } else {
            throw new RuntimeException("Pais com id " + id + " não encontrado.");
        }
    }
}