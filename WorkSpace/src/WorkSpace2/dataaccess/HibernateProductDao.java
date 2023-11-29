package WorkSpace2.dataaccess;

import WorkSpace2.entities.Product;

public class HibernateProductDao implements ProductDao {
	public void add(Product product) {
		System.out.println("Hibernate ile veri tabanına eklendi");
	}
}
