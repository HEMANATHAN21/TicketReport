package ticketreport.springmvc.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Component
public class TicketDto 
{
	@Id
	long ticketNumber;
	String date;
	String time;
	Status ticketStatus;
	Category ticketCategory;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	ProductivityDto productivity;
	public long getTicketNumber() {
		return ticketNumber;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public Status getTicketStatus() {
		return ticketStatus;
	}
	public Category getTicketCategory() {
		return ticketCategory;
	}
	public ProductivityDto getProductivity() {
		return productivity;
	}
	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTicketStatus(Status ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public void setTicketCategory(Category ticketCategory) {
		this.ticketCategory = ticketCategory;
	}
	public void setProductivity(ProductivityDto productivity) {
		this.productivity = productivity;
	}
	@Override
	public String toString() {
		return "TicketDto [ticketNumber=" + ticketNumber + ", date=" + date + ", time=" + time + ", ticketStatus="
				+ ticketStatus + ", ticketCategory=" + ticketCategory + "]";
	}
	
	
	
}
