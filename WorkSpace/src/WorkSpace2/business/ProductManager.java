package WorkSpace2.business;

import java.util.List;

import WorkSpace2.core.logging.*;
import WorkSpace2.dataaccess.HibernateProductDao;
import WorkSpace2.dataaccess.JdbcProductDao;
import WorkSpace2.dataaccess.ProductDao;
import WorkSpace2.entities.Product;

public class ProductManager {
	private ProductDao dao;
	private List<Logger> loggers;
	public ProductManager(ProductDao dao,List<Logger> loggers) {
		this.dao=dao;
		this.loggers=loggers;
	}
	
	public void add(Product product) {
		// iş kuralları
		dao.add(product);
		for(Logger logger:loggers)
		{
			logger.log(product.getName());
		}
	}

	

}
