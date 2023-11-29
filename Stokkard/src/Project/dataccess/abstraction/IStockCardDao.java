package Project.dataccess.abstraction;

import java.sql.ResultSet;
import java.util.*;
import Project.entities.concrete.StockCard;

public interface IStockCardDao {

	List<StockCard> getAll();
	void Add(StockCard card);
	void Delete(StockCard card);
	void Update(StockCard card);
	ResultSet Copy(String code);
	

}
