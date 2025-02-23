package In.NIT.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import In.NIT.Models.Manager;
import In.NIT.Repo.ManagerRepository;

@Service
public class ManagerService {

	private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager createManager(Manager manager) {
        manager.getManagerId();
        return managerRepository.save(manager);
    }

    public Optional<Manager> getManagerById(Long id) {
        return managerRepository.findById(id);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }
}
