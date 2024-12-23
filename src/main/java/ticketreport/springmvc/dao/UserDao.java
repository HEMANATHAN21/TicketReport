package ticketreport.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ticketreport.springmvc.dto.UserDto;

@Component
public class UserDao 
{
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public UserDto saveUser(UserDto user)
	{
		entityManager.getTransaction().begin();
//		System.out.println(user.getUserId()+" "+user.getUserMail());
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return user;
		
	}
	
	public UserDto findById(long userId)
	{
		UserDto u = entityManager.find(UserDto.class, userId);
		if(u != null)
		{
			return u;
		}
		return null;
	}
	
	public UserDto deleteById(long userId)
	{
		UserDto u = entityManager.find(UserDto.class, userId);
		if(u != null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(u);
			entityManager.getTransaction().commit();
			return u;
		}
		return null;
	}
	
	public UserDto updateUser(UserDto user, long userId)
	{
		UserDto u = entityManager.find(UserDto.class, userId);
		if(u != null)
		{
			entityManager.getTransaction().begin();
			user.setUserId(userId);
			UserDto updatedUser = entityManager.merge(user);
			entityManager.getTransaction().commit();
			return updatedUser;
		}
		return null;
	}
	
	public List<UserDto> getAll()
	{
		Query query = entityManager.createQuery("select u from UserDto u");
		List<UserDto> allUsers = query.getResultList();
		return allUsers;
	}
	
	public UserDto findByMail(String userMail)
	{
		Query query = entityManager.createQuery("select u from UserDto u where u.userMail = ?1");
		query.setParameter(1, userMail);
		UserDto user = (UserDto) query.getSingleResult();
		return user;
	}
	
}
