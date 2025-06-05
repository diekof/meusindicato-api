package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.repository.criteria.GenericSpecification;
import br.com.meusindicato.sindicato.repository.criteria.SearchCriteria;
import br.com.meusindicato.sindicato.repository.criteria.SearchOperation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Map;

public abstract class AbstractSpecificationService<T> {

    protected Specification<T> buildSpecification(Map<String, String> filters) {
        Specification<T> spec = Specification.where(null);

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (StringUtils.hasText(entry.getValue())) {
                spec = spec.and(new GenericSpecification<>(
                        new SearchCriteria(entry.getKey(), entry.getValue(), SearchOperation.LIKE)
                ));
            }
        }

        return spec;
    }
}
