package In.NIT.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

    private String fullName;
	
    private String mobNum;
	
    private String panNum;
	
    private Long managerId;
	
	private Boolean isActivity;
	private String createdAt;
	private String updatedAt;
	
	public User()
	{
		
	}
	public User(Long userId, String fullName, String mobNum, String panNum, Long managerId, Boolean isActivity,
			String createdAt, String updatedAt) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.mobNum = mobNum;
		this.panNum = panNum;
		this.managerId = managerId;
		this.isActivity = isActivity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	//private LocalDateTime createdAt;
	//private LocalDateTime updatedAt;
}
