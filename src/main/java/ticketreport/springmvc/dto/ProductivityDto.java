package ticketreport.springmvc.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Entity
@Component
public class ProductivityDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long productivityId;
	String currentDate;
	@OneToMany
	List<TicketDto> closedTickets;

	@OneToMany
	List<TicketDto> pendingTickets;

	public long getProductivityId() {
		return productivityId;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public List<TicketDto> getClosedTickets() {
		return closedTickets;
	}

	public List<TicketDto> getPendingTickets() {
		return pendingTickets;
	}

	public void setProductivityId(long productivityId) {
		this.productivityId = productivityId;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public void setClosedTickets(List<TicketDto> closedTickets) {
		this.closedTickets = closedTickets;
	}

	public void setPendingTickets(List<TicketDto> pendingTickets) {
		this.pendingTickets = pendingTickets;
	}
	
	
	
}
