package WorkSpace2.dataaccess;

import WorkSpace2.entities.Product;

public class JdbcProductDao implements ProductDao {
	public void add(Product product) {
		System.out.println("jdbc ile veri tabanına eklendi");
	}
}
