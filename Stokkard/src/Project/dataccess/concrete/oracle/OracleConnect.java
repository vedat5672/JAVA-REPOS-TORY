package Project.dataccess.concrete.oracle;

import java.sql.ResultSet;
import java.util.List;

import Project.dataccess.abstraction.IStockCardDao;
import Project.dataccess.concrete.context.OracleConnection;
import Project.entities.concrete.StockCard;

public class OracleConnect extends OracleConnection implements IStockCardDao{

	@Override
	public List<StockCard> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(StockCard card) {
		System.out.println("eklendi");
		
	}

	@Override
	public void Delete(StockCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(StockCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet Copy(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
