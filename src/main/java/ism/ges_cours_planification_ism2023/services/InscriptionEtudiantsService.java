package ism.ges_cours_planification_ism2023.services;

import org.springframework.web.multipart.MultipartFile;

public interface InscriptionEtudiantsService {

    public void importStudentsFromExcelFile(MultipartFile file);
}
