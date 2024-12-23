package ticketreport.springmvc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ticketreport"})
public class Config 
{
	@Bean
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("Hema_DB_Persistence").createEntityManager();
	}
	
	@Bean
	public EntityTransaction getEntityTransaction()
	{
		return Persistence.createEntityManagerFactory("Hema_DB_Persistence").createEntityManager().getTransaction();
	}//not working
}
