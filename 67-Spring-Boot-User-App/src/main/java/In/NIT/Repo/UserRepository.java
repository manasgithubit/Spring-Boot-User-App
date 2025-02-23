package In.NIT.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import In.NIT.Models.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByMobNum(String mobNum);
	List<User> findByManagerId(Long managerId);
}
