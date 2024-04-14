package ism.ges_cours_planification_ism2023.services;

import ism.ges_cours_planification_ism2023.entities.Etudiant;
import ism.ges_cours_planification_ism2023.repositories.EtudiantsRepository;
import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import ism.ges_cours_planification_ism2023.security.repositories.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.io.InputStream;

@Service
public class InscriptionEtudiantsServiceImpl implements InscriptionEtudiantsService{

    @Autowired
    private EtudiantsRepository etudiantsRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public void importStudentsFromExcelFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Insérer l'étudiant dans la base de données
            for (Row row : sheet) {
                // Lire les cellules de chaque ligne
                String prenom = row.getCell(0).getStringCellValue();
                String nom = row.getCell(1).getStringCellValue();
                String matricule = row.getCell(2).getStringCellValue();
                String tuteur = row.getCell(3).getStringCellValue();
                String login = row.getCell(4).getStringCellValue();

                // Créer un objet de type étudiant à partir des données de la ligne
                Etudiant etudiant = new Etudiant();
                // Recherche du role dans la base de données
                AppRole appRole=appRoleRepository.findByRoleName("Etudiant");
                //Donner des états aux attributs
                etudiant.setPrenom(prenom);
                etudiant.setNom(nom);
                etudiant.setMatricule(matricule);
                etudiant.setTuteur(tuteur);
                etudiant.setUsername(login);
                // Ajout du rôle à l'étudiant créer à partir de chaque ligne du fichier excel
                etudiant.getRoles().add(appRole);
                // Insérer l'étudiant dans la base de données
                etudiantsRepository.save(etudiant);
            }
            // Fermer le workbook et le flux de données
            workbook.close();
            //inputStream.close();

        } catch (IOException e) {
            // Gérer les exceptions liées au fichier Excel
            e.printStackTrace();
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return null;
        }
    }

}
