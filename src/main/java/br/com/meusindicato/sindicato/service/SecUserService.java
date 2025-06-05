package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.model.SecUser;
import br.com.meusindicato.sindicato.repository.SecUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class SecUserService {

    private final SecUserRepository repository;

    public SecUserService(SecUserRepository userRepository) {
        super();
        this.repository = userRepository;
    }

    public Optional<SecUser> buscaUser(String login) {
        return repository.findByUsername(login);
    }

    public Page<SecUser> pesquisar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<SecUser> findAll(Map<String, String> filtros, Pageable pageable) {
        Specification<SecUser> spec = SpecificationBuilder.build(filtros);
        Page<SecUser> usuarios = repository.findAll(spec,pageable);
        return usuarios;
    }

    public Optional<SecUser> findById(Long id) {
        return repository.findById(id);
    }

    public SecUser save(SecUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
