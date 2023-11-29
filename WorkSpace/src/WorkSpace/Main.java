package WorkSpace;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();

		product1.setDiscount(2.0);
		product1.setName("kahve makinesi");
		product1.setUnitPrice(7500);
		product1.setUnitsInStock(2);
		product1.setImageUrl("df.jpg");

		product2.setDiscount(5.0);
		product2.setName("kahve makinesi");
		product2.setUnitPrice(9500);
		product2.setUnitsInStock(8);
		product2.setImageUrl("df.jpg");

		product3.setDiscount(3.0);
		product3.setName("kahve makinesi");
		product3.setUnitPrice(6500);
		product3.setUnitsInStock(7);
		product3.setImageUrl("df.jpg");
		
		Product[] products= {product1,product2,product3};
		ArrayList<Product> productss=new ArrayList<Product>();
		productss.add(product1);
		productss.add(product2);
		productss.add(product3);
		
		for(Product product: productss) {
			System.out.println(product.getDiscount());
		}
		CorporateCustomer customer1=new CorporateCustomer();
		IndividualCustomer customer2=new IndividualCustomer();
		
		Customer[]customers= {customer1,customer2};
		
		
	}

}
