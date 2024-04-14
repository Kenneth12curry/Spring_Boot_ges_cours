package ism.ges_cours_planification_ism2023.api.exceptions;

public class NoDataException extends RuntimeException{
    public NoDataException() {
        super("Pas de Donnees Disponibles");
    }

    public NoDataException(String message) {
        super(message);
    }
}
