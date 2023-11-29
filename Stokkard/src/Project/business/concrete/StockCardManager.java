package Project.business.concrete;

import java.sql.ResultSet;
import java.util.List;

import Project.business.abstraction.StockCardService;
import Project.dataccess.abstraction.IStockCardDao;
import Project.entities.concrete.StockCard;

public class StockCardManager implements StockCardService{
	private IStockCardDao _dao;
	public StockCardManager(IStockCardDao dao) {
		this._dao=dao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StockCard> getAll() {
		// TODO Auto-generated method stub
		return _dao.getAll();
	}

	@Override
	public void Add(StockCard card) {
		_dao.Add(card);
		
	}

	@Override
	public void Delete(StockCard card) {
		_dao.Delete(card);
		
	}

	@Override
	public void Update(StockCard card) {
		_dao.Update(card);
		
	}

	@Override
	public ResultSet Copy(String code) {
		// TODO Auto-generated method stub
		return _dao.Copy(code);
	}



}
