package ticketreport.springmvc.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long userId;
	String userMail;
	String userName;
	String userPassword;
	@OneToMany
	List<ProductivityDto> userTotalProductivity;
	public long getUserId() {
		return userId;
	}
	public String getUserMail() {
		return userMail;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public List<ProductivityDto> getUserTotalProductivity() {
		return userTotalProductivity;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserTotalProductivity(List<ProductivityDto> userTotalProductivity) {
		this.userTotalProductivity = userTotalProductivity;
	}
	
	
	
	
	
}
