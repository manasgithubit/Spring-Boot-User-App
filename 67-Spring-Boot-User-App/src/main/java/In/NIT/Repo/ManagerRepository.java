package In.NIT.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import In.NIT.Models.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
	boolean existsByManagerIdAndIsActive(Long managerId, boolean isActive);
}
