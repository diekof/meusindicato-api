package br.com.meusindicato.sindicato.repository.criteria;

import java.util.List;

public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;

    private List<String> keys;
    private List<Object> values;
    private List<SearchOperation> operations;


    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public SearchCriteria(List<String> keys, List<Object> values, List<SearchOperation> operations, SearchOperation operation) {
        this.keys = keys;
        this.values = values;
        this.operations = operations;
        this.operation = operation;
    }

    public static SearchCriteria of(final String key, final Object value, final SearchOperation operation) {
        return new SearchCriteria(key, value, operation);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public List<SearchOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<SearchOperation> operations) {
        this.operations = operations;
    }
}

