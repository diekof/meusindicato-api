package br.com.meusindicato.sindicato.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import br.com.meusindicato.sindicato.repository.criteria.GenericSpecification;
import br.com.meusindicato.sindicato.repository.criteria.SearchCriteria;
import br.com.meusindicato.sindicato.repository.criteria.SearchOperation;

import java.util.Map;

public final class SpecificationBuilder {

    private SpecificationBuilder() {} // Impede instância

    public static <T> Specification<T> build(Map<String, String> filtros) {
        Specification<T> spec = Specification.where(null);

        for (Map.Entry<String, String> entry : filtros.entrySet()) {
            if (StringUtils.hasText(entry.getValue())) {
                spec = spec.and(new GenericSpecification<>(
                        new SearchCriteria(entry.getKey(), entry.getValue(), SearchOperation.LIKE)
                ));
            }
        }

        return spec;
    }
}
