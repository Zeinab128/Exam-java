package Services;
import Entities.Module;
import java.util.List;
import Repositories.ModuleRepository;

public class ModuleService {
    private ModuleRepository moduleRepository = new ModuleRepository();

    public void ajouterModule(Module module) throws ClassNotFoundException {
        moduleRepository.insert(module);
    }

    public List<Module> listerModules() {
        return moduleRepository.selectAll();
    }
}
