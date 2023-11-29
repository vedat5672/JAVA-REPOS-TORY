package WorkSpace2;

import java.util.ArrayList;

import WorkSpace2.business.ProductManager;
import WorkSpace2.core.logging.DatabaseLogger;
import WorkSpace2.core.logging.FileLogger;
import WorkSpace2.core.logging.Logger;
import WorkSpace2.core.logging.MailLoger;
import WorkSpace2.dataaccess.HibernateProductDao;
import WorkSpace2.dataaccess.JdbcProductDao;
import WorkSpace2.entities.Product;

public class Main {

	public static void main(String[] args) {
		Product product1=new Product(1,"Telefon",5000);
		ArrayList<Logger> loggers=new  ArrayList();
		loggers.add(new DatabaseLogger());
		loggers.add(new MailLoger());
		loggers.add(new FileLogger());
		ProductManager productManager=new ProductManager(new HibernateProductDao(),loggers);
		productManager.add(product1);

	}

}
 