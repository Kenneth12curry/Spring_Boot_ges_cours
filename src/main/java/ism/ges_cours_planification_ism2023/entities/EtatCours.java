package ism.ges_cours_planification_ism2023.entities;

public enum EtatCours {
    Planifier,Terminer,Encours;

    public static EtatCours toEnum(int valOrdinal) {
        for (EtatCours enumValue:values()){
            if(enumValue.ordinal()==valOrdinal) {
                return enumValue;
            }
        }
        return null;
    }

    //Méthode pour convertir un string en une enumération de type EtatCours
    public static EtatCours convertStringToEtatCours(String etat) {
        return EtatCours.valueOf(etat);
    }
}
