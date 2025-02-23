package In.NIT.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import In.NIT.Custom.CustomException;
import In.NIT.Models.User;
import In.NIT.Repo.ManagerRepository;
import In.NIT.Repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	public User createUser(User user) throws CustomException 
	{
		createUser(user);
        user.setFullName(user.getFullName().toUpperCase());
        user.setPanNum(user.getPanNum().toUpperCase());
        user.setCreatedAt("Created_Successfully");
        user.setUpdatedAt("Update_Successfully");
		return userRepository.save(user);
	}
	
	public List<User> getUsers(Long userId, String mobNum, Long managerId) {
        if (userId != null) 
        {
            return userRepository.findById(userId).map(List::of).orElse(List.of());
        } 
        else if (mobNum != null) 
        {
            User user = userRepository.findByMobNum(mobNum);
            return user  != null ? List.of(user) : List.of();
        } 
        else if (managerId != null) {
            return userRepository.findByManagerId(managerId);
        }
        return userRepository.findAll();
    }
	public void deleteUser(Long userId, String mobNum) throws CustomException {
        User user = null;
        if (userId != null) {
            user = userRepository.findById(userId).orElse(null);
        } else if (mobNum != null) {
            user = userRepository.findByMobNum(mobNum);
        }
        if (user == null) {
            throw new CustomException("User not found");
        }
        userRepository.delete(user);
    }
	public User updateUser(Long userId, User updateUser) throws CustomException {
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException("User not found"));
        if (updateUser.getFullName() != null) {
            user.setFullName(updateUser.getFullName());
        }
        if (updateUser.getMobNum() != null) {
            user.setMobNum(updateUser.getMobNum());
        }
        if (updateUser.getPanNum() != null) {
            user.setPanNum(updateUser.getPanNum());
        }
        if (updateUser.getManagerId() != null) {
            createManagerId(updateUser.getManagerId());
            user.setManagerId(updateUser.getManagerId());
        }
        user.setUpdatedAt("Created_Successfully");
        return userRepository.save(user);
    }
	
	private void validateUser(User user) throws CustomException {
        if (user.getFullName().isEmpty()) {
            throw new CustomException("Full name cannot be empty");
        }
        if (!isValidMobileNumber(user.getMobNum())) {
            throw new CustomException("Invalid mobile number");
        }
        if (!isValidPanNumber(user.getPanNum())) {
            throw new CustomException("Invalid PAN number");
        }
        if (user.getManagerId() != null && !managerRepository.existsByManagerIdAndIsActive(user.getManagerId(), true)) {
            throw new CustomException("Invalid manager ID");
        }
    }
	private boolean isValidMobileNumber(String mobNum) {
        return mobNum.matches("^\\+?\\d{10,12}$");
    }
	private boolean isValidPanNumber(String panNum) {
        return panNum.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    }
	private void createManagerId(Long managerId) throws CustomException {
	
		if (!managerRepository.existsByManagerIdAndIsActive(managerId, true)) {
            throw new CustomException("Invalid manager ID");
        }
	}
}
