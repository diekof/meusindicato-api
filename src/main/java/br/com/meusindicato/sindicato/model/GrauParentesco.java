package br.com.meusindicato.sindicato.model;

public enum GrauParentesco {

    CONJUGE("CÔNJUGE"),FILHO("FILHO"),OUTROS("OUTROS");

    private String grau;

    GrauParentesco(String grau){
        this.grau = grau;
    }

    public static GrauParentesco fromString(String texto){

        for (GrauParentesco grau:GrauParentesco.values()){
            if (grau.grau.equalsIgnoreCase(texto)){
                return grau;
            }
        }
        throw new IllegalArgumentException("Grau não encontrado!");
    }
}
