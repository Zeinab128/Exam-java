package Services;
import Entities.Cours;
import java.util.List;
import Repositories.CoursRepository;

public class CoursService {
    private CoursRepository coursRepository = new CoursRepository();

    public void ajouterCours(Cours cours) throws ClassNotFoundException {
        coursRepository.insert(cours);
    }

    public List<Cours> listerCours() {
        return coursRepository.selectAll();
    }

    public List<Cours> listerCoursParModuleEtProfesseur(int moduleId, int professeurId) {
        return coursRepository.selectByModuleAndProf(moduleId, professeurId);
    }
}
