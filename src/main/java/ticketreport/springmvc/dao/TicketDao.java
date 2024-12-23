package ticketreport.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import ticketreport.springmvc.dto.TicketDto;

@Component
public class TicketDao 
{
	EntityTransaction entityTransaction;
	EntityManager entityManager;
	
	public TicketDto saveTicket(TicketDto ticket)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(ticket);
		entityManager.getTransaction().commit();
		return ticket;
	}
	
	public TicketDto findById(long ticketNumber)
	{
		TicketDto t = entityManager.find(TicketDto.class, ticketNumber);
		if(t != null)
		{
			return t;
		}
		return null;
	}
	
	public TicketDto deleteById(long ticketNumber)
	{
		TicketDto t = entityManager.find(TicketDto.class, ticketNumber);
		if(t != null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(t);
			entityManager.getTransaction().commit();
			return t;
		}
		return null;
	}
	
	public TicketDto updateTicket(TicketDto ticket, int ticketNumber)
	{
		TicketDto t = entityManager.find(TicketDto.class, ticketNumber);
		if(t != null)
		{
			entityManager.getTransaction().begin();
			ticket.setTicketNumber(ticketNumber);
			TicketDto updatedTicket = entityManager.merge(ticket);
			entityManager.getTransaction().commit();
			return updatedTicket;
		}
		return null;
	}
	
	public List<TicketDto> getAll()
	{
		Query query = entityManager.createQuery("select t from TicketDto t");
		List<TicketDto> allTickets = query.getResultList();
		return allTickets;
	}
	
	

}
