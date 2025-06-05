package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.CidadeDTO;
import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.repository.CidadeRepository;
import br.com.meusindicato.sindicato.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepo;

    @Autowired
    private EstadoRepository estadoRepo;

    public Page<CidadeDTO> listarTodos(Map<String, String> filtros, Pageable pageable) {
        Specification<Cidade> spec = SpecificationBuilder.build(filtros);
        Page<Cidade> cidades = cidadeRepo.findAll(spec,pageable);
        return cidades.map(c -> new CidadeDTO(c.getCidadeId(),c.getCidadeNome(),c.getEstado().getEstadoId()));
    }

    public Optional<CidadeDTO> buscarPorId(Long id) {
        Optional<Cidade> cidade = cidadeRepo.findById(id);
        if (cidade.isPresent()){
            Cidade c = cidade.get();
            return Optional.of(new CidadeDTO(c.getCidadeId(),
                    c.getCidadeNome(),c.getEstado().getEstadoId()));
        }else {
            return Optional.empty();
        }
    }

    public Cidade save(CidadeDTO obj){
        Cidade cidade = new Cidade(obj.cidadeNome(),
                estadoRepo.findById(obj.estadoId()).get());

        return cidadeRepo.save(cidade);
    }

    public Cidade update(CidadeDTO obj) {
        Optional<Cidade> cidadeOptional = cidadeRepo.findById(obj.cidadeId());
        if (cidadeOptional.isPresent()){
            Cidade cidade = cidadeOptional.get();
            cidade.setCidadeNome(obj.cidadeNome());
            cidade.setEstado(estadoRepo.findById(obj.estadoId()).get());

            return cidadeRepo.save(cidade);
        }
        return null;
    }

    public void delete(Long id) {cidadeRepo.deleteById(id);}
}
