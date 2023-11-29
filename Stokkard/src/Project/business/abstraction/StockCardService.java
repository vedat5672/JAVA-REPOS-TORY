package Project.business.abstraction;

import java.sql.ResultSet;
import java.util.List;

import Project.entities.concrete.StockCard;

public interface StockCardService {
	
	List<StockCard> getAll();

	void Add(StockCard card);

	void Delete(StockCard card);

	void Update(StockCard card);

	ResultSet Copy(String code);

}
