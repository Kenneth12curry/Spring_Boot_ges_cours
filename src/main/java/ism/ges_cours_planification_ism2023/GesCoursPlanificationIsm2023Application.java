package ism.ges_cours_planification_ism2023;

import ism.ges_cours_planification_ism2023.repositories.*;
import ism.ges_cours_planification_ism2023.security.repositories.AppRoleRepository;
import ism.ges_cours_planification_ism2023.security.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class GesCoursPlanificationIsm2023Application implements CommandLineRunner {



	@Autowired
	ProfesseurRepository professeurRepository;

	@Autowired
	CoursRepository coursRepository;

	@Autowired
	SemestreRepository semestreRepository;

	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	SessionCoursRepository sessionCoursRepository;
	@Autowired
	EtudiantsRepository etudiantsRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	EmargementRepository emargementRepository;
	@Autowired
	RPRepository rpRepository;
	@Autowired
	ACRepository acRepository;
	@Autowired
	AppRoleRepository appRoleRepository;
	@Autowired
	SallesCoursRepository sallesCoursRepository;
	@Autowired
	SecurityService service;


	@Bean
	public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

	public static void main(String[] args) {
		SpringApplication.run(GesCoursPlanificationIsm2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
		/*AppRole role1=service.saveRole("Professeur");
		AppRole role2=service.saveRole("Etudiant");
		AppRole role3=service.saveRole("RP");
		AppRole role4=service.saveRole("AC");
		//Insertion des fixtures => fauses données
		List<Grade> grades=new ArrayList<>();
		List<Specialite> specialites= new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			Professeur cl=new Professeur();
			//Donnez des états aux attributs
			cl.setNom("Diop"+i);
			cl.setPrenom("Moustapha"+i);
			cl.setUsername("professeur"+i);
			cl.setPassword(passwordEncoder().encode("passer"));
			cl.getRoles().add(role1);
			Grade grade = null;
			Specialite specialite = null;
			if(i%1==0){
				//Création du grade du professeur
				grade= new Grade();
				grade.setLibelle("Docteur"+i);
				//grades.add(grade);
				//Affectation du professeur à un grade
				grade.setProfesseur(cl);
				//Création de la spécialité du professeur
				specialite= new Specialite();
				specialite.setLibelle("Informatique"+i);
				//specialites.add(specialite);
				//Affectation du professeur à une spécialité
				specialite.setProfesseur(cl);
			}

			//Appel de la méthode save qui se trouve dans professeurRepository
			professeurRepository.save(cl);
			//Appel de la méthode save
			gradeRepository.save(grade);
			//Appel de la méthode save
			specialiteRepository.save(specialite);
		}


		for (int i = 1; i < 6; i++) {
			Module module = new Module();
			module.setLibelle("FLUTTER" + i);
			//Appel de la méthode save qui se trouve dans ModuleRepository
			moduleRepository.save(module);
		}


		for (int i = 1; i < 13; i++) {
			SessionCours sc = new SessionCours();
			sc.setDate(new Date());
			sc.setEtat(EtatSessionCours.Planifier);
			sc.setLieu(EtatLieu.Enligne);
			sc.setHeureDebut(LocalTime.of(8,30,00));
			sc.setHeureFin(LocalTime.of(14,30,05));
			sc.setNbreHeure(2+i);
			//Recherche d'un professeur à partir de son nom
			//et d'un module à partir de son libellé
			Professeur professeur= professeurRepository.findByNom("Diop"+i);
			Module module = moduleRepository.findByLibelle("FLUTTER" + i);
			sc.setProfesseur(professeur);
			sc.setModule(module);
			if(i%2==0){
				sc.setLieu(EtatLieu.Présentiel);
			}
			//Appel de la méthode save qui se trouve dans SessionCoursRepository
			sessionCoursRepository.save(sc);
		}


		for(int i = 1; i < 7; i++) {
			Etudiant cl = new Etudiant();
			//Donner des états aux attributs
			cl.setNom("james" + i);
			cl.setPrenom("stéphane" + i);
			cl.setUsername("etudiant"+i);
			cl.setPassword(passwordEncoder().encode("passer"));
			cl.setMatricule("MAT_00"+i);
			cl.setTuteur("fall"+i);
			cl.getRoles().add(role2);
			//Appel à la méthode save
			etudiantsRepository.save(cl);
		}

		List<Semestre> semestres = new ArrayList<>();
		List<Cours> cour = new ArrayList<>();
		Semestre semestre = null;
		for (int i = 1; i < 10; i++) {
			Cours cours = new Cours();
			//Donner des états aux attributs
			cours.setNbreHeureGlobal(24+i);
			cours.setEtat(EtatCours.Planifier);
			Professeur professeur = professeurRepository.findByNom("Diop" + i);
			Module module = moduleRepository.findByLibelle("FLUTTER" + i);
			cours.setProfesseur(professeur);
			cours.setModule(module);
			if (i % 1 == 0) {
				//Création du semestre
				semestre = new Semestre();
				semestre.setLibelle("S" + i);

			}
			cour.add(cours);
			//Affectation de la liste des cours à un semestre donnée
			semestre.setCours(cour);
			coursRepository.save(cours);
			semestreRepository.save(semestre);
		}

		for(int i = 1; i < 10; i++){
			Classe classe=new Classe();
			classe.setNiveau("L"+i);
			classe.setFiliere("GLRS"+i);
			classe.setLibelle(classe.getNiveau()+classe.getFiliere());
			classeRepository.save(classe);
		}

		for(int i = 1; i <=10; i++){
			Emargement emargement=new Emargement();
			emargement.setDate(new Date(2023,04,23));
			emargement.setPresent(true);
			Etudiant etudiant = etudiantsRepository.findByNom("james"+i);
			emargement.setEtudiant(etudiant);
			if(i%2==0){
				emargement.setPresent(false);
			}
			emargementRepository.save(emargement);
		}*/

		/*for(int i = 1; i <=7; i++){
			SallesDeCours sallesDeCours=new SallesDeCours();
			sallesDeCours.setNbrePlaces(50+i);
			sallesDeCours.setNumero("SALLE_N°"+i);
			sallesDeCours.setNom("INCUB"+i);
			sallesCoursRepository.save(sallesDeCours);
		}*/

		/*AppRole role3=service.saveRole("RP");
		AppRole role4=service.saveRole("AC");
		for(int i=1;i<=2;i++){
			RP rp=new RP();
			rp.setNom("pierre" + i);
			rp.setPrenom("low" + i);
			rp.setUsername("rp"+i+"@gmail.com");
			AppRole role=appRoleRepository.findByRoleName("RP");
			rp.getRoles().add(role);
			rp.setPassword(passwordEncoder().encode("passer"));
			rpRepository.save(rp);
		}
		for(int i=1;i<=2;i++){
			AC ac=new AC();
			ac.setNom("james" + i);
			ac.setPrenom("harden" + i);
			ac.setUsername("ac"+i+"@gmail.com");
			ac.getRoles().add(role4);
			ac.setPassword(passwordEncoder().encode("passer"));
			acRepository.save(ac);
		}*/


		};

	}

}
