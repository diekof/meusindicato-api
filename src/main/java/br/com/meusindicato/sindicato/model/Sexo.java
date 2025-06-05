package br.com.meusindicato.sindicato.model;

public enum Sexo {
    MASCULINO("Masculino","M"),
    FEMININO("Feminino","F");

    private String sexo;
    private String sexoSigla;

    Sexo(String sexo,String sexoSigla){
        this.sexo = sexo;
        this.sexoSigla = sexoSigla;
    }

    public static Sexo fromString(String genero) {

        for (Sexo sexo:Sexo.values()){
            if (sexo.sexo.equalsIgnoreCase(genero)){
            return sexo;
            }
        }
        throw new IllegalArgumentException("Gênero não encontrado");
    }

    public static Sexo fromSigla(String generoSigla){
        for (Sexo sexo:Sexo.values()){
            if (sexo.sexoSigla.equalsIgnoreCase(generoSigla)){
                return sexo;
            }
        }
        throw new IllegalArgumentException("Gênero não encontrado");
    }
}
