package br.com.meusindicato.sindicato.model;

public enum EstadoCivil {
    Solteiro("solteiro"),
    Casado("Casado"),
    Divorciado("Divorciado"),
    Viuvo("Viuvo");

    private String estadoCivil;

    EstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public static EstadoCivil fromString(String texto){
        for (EstadoCivil estadoCivil:EstadoCivil.values()){
            if (estadoCivil.estadoCivil.equalsIgnoreCase(texto)){
                return estadoCivil;
            }
        }
        throw new IllegalArgumentException("Estado Cívil não encontrado");
    }
}