package br.com.meusindicato.sindicato.repository.criteria;


import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenericSpecification<T> implements Specification<T>, Serializable {

    private final SearchCriteria criteria;

    public GenericSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }
    private Path<?> getPath(Root<T> root, String key) {
        Path<?> path = root;
        String[] keys = key.split("\\.");

        for (String k : keys) {
            path = path.get(k);
        }

        return path;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Path<?> path = getPath(root, criteria.getKey());

        SearchOperation operation = criteria.getOperation() != null ? criteria.getOperation() : SearchOperation.LIKE;

        switch (operation) {
            case GREATER_THAN:
                return cb.greaterThan(path.as(String.class), criteria.getValue().toString());
            case GREATER_THAN_EQUAL:
                return cb.greaterThanOrEqualTo(path.as(String.class), criteria.getValue().toString());
            case LESS_THAN:
                return cb.lessThan(path.as(String.class), criteria.getValue().toString());
            case LESS_THAN_EQUAL:
                return cb.lessThanOrEqualTo(path.as(String.class), criteria.getValue().toString());
            case NOT_EQUAL:
                return cb.notEqual(path, criteria.getValue());
            case EQUAL:
                return cb.equal(path, criteria.getValue());
            case STARTS_WITH:
                return cb.like(cb.lower(path.as(String.class)), criteria.getValue().toString().toLowerCase() + "%");
            case ENDS_WITH:
                return cb.like(cb.lower(path.as(String.class)), "%" + criteria.getValue().toString().toLowerCase());
            case ISNULL:
                return cb.isNull(path);
            case CONTAINS:
            case LIKE:
            default:
                return cb.like(cb.lower(path.as(String.class)), "%" + criteria.getValue().toString().toLowerCase() + "%");
        }
    }

}