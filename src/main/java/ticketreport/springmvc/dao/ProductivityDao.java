package ticketreport.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ticketreport.springmvc.dto.ProductivityDto;

@Component
public class ProductivityDao 
{
	@Autowired
	EntityTransaction entityTransaction;
	@Autowired
	EntityManager entityManager;
	
	public ProductivityDto saveProdutivity(ProductivityDto productivity)
	{
		entityTransaction.begin();
		entityManager.persist(productivity);
		entityTransaction.commit();
		return productivity;
	}
	
	public ProductivityDto findById(long productivityId)
	{
		ProductivityDto p = entityManager.find(ProductivityDto.class, productivityId);
		if(p != null)
		{
			return p;
		}
		return null;
	}
	
	public ProductivityDto deleteById(long productivity_Id)
	{
		ProductivityDto p = entityManager.find(ProductivityDto.class, productivity_Id);
		if(p != null)
		{
			entityTransaction.begin();
			entityManager.remove(p);
			entityTransaction.commit();
			return p;
		}
		return null;
	}
	
	public ProductivityDto updateProductivity(ProductivityDto productivity, long productivityId)
	{
		ProductivityDto p = entityManager.find(ProductivityDto.class, productivityId);
		if(p != null)
		{
			entityTransaction.begin();
			productivity.setProductivityId(productivityId);
			ProductivityDto updatedProductivity = entityManager.merge(productivity);
			entityTransaction.commit();
			return updatedProductivity;
		}
		return null;
	}
	
	public List<ProductivityDto> getAll()
	{
		Query query = entityManager.createQuery("select p from ProductivityDto p");
		List<ProductivityDto> allProductivity = query.getResultList();
		return allProductivity;
	}
	
	public ProductivityDto findByDate(String currentDate)
	{
		Query query = entityManager.createQuery("select p from ProductivityDto p where p.currentDate = ?1");
		query.setParameter(1, currentDate);
		ProductivityDto productivity = (ProductivityDto) query.getSingleResult();
		return productivity;
	}
}
