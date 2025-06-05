package br.com.meusindicato.sindicato.model;

public enum Nivel {
    NIVEL_1(1),
    NIVEL_2(2),
    NIVEL_3(3),
    NIVEL_4(4),
    NIVEL_5(5),
    NIVEL_6(6),
    NIVEL_7(7),
    NIVEL_8(8),
    NIVEL_9(9),
    NIVEL_10(10),
    NIVEL_11(11),
    NIVEL_12(12),
    NIVEL_13(13),
    NIVEL_14(14),
    NIVEL_15(15),
    NIVEL_16(16),
    NIVEL_17(17),
    NIVEL_18(18),
    NIVEL_19(19);

    private int nivel;

    Nivel(Integer nivel){
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public static Nivel fromInteger(Integer valor){
        for(Nivel nivel:Nivel.values()){
            if (nivel.getNivel() == valor){

                return nivel;
            }
        }
        throw new IllegalArgumentException("Nível não disponível");
    }
}
