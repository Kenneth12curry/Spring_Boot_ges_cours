package ism.ges_cours_planification_ism2023.entities;

public enum EtatLieu {
    Enligne,Présentiel;

    public static EtatLieu toEnum(int valOrdinal) {
        for (EtatLieu enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }
}
