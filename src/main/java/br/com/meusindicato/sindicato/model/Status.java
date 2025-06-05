package br.com.meusindicato.sindicato.model;

public enum Status {
    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Status fromString(String texto){
        for (Status status:Status.values()){
            if (status.getStatus().equalsIgnoreCase(texto)){
                return status;
            }
        }
        throw new IllegalArgumentException("Status não disponível");
    }
}
