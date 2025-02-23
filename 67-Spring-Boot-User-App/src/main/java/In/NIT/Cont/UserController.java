package In.NIT.Cont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import In.NIT.Custom.CustomException;
import In.NIT.Models.User;
import In.NIT.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    /*@PostMapping("/create_user")
    public User createUser(@RequestBody User user) throws CustomException {
        return userService.createUser(user);
    }*/
	
	@PostMapping("/create_user")
	public ResponseEntity<String> createUser(@RequestBody User user)
	{
		return ResponseEntity.ok("User created successfully");
	}

    @PostMapping("/get_users")
    public List<User> getUsers(@RequestParam(required = false) Long userId,
                               @RequestParam(required = false) String mobNum,
                               @RequestParam(required = false) Long managerId) {
        return userService.getUsers(userId, mobNum, managerId);
    }

    @PostMapping("/delete_user")
    public void deleteUser(@RequestBody User user) throws CustomException {
        userService.deleteUser(user.getUserId(), user.getMobNum());
    }

    @PostMapping("/update_user")
    public User updateUser(@RequestBody User updateUser) throws CustomException {
        return userService.updateUser(updateUser.getUserId(), updateUser);
    }
}
