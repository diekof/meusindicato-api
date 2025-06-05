package br.com.meusindicato.sindicato.model;

public enum Classe {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private String classe;

    Classe(String classe){
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public static Classe fromString(String texto){
        for (Classe classe: Classe.values()){
            if (classe.classe.equalsIgnoreCase(texto)){
                return classe;
            }
        }
        throw new IllegalArgumentException("Classe não diponível");
    }
}
