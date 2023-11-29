package Project;
import java.sql.SQLException;

import Project.business.concrete.StockCardManager;
import Project.dataccess.concrete.context.MysqlConnection;
import Project.dataccess.concrete.mysql.mysqlStockCard;
import Project.dataccess.concrete.oracle.OracleConnect;
import Project.entities.concrete.StockCard;




public class Main {

	public static void main(String[] args) throws SQLException  {
		StockCardManager manager=new StockCardManager(new OracleConnect());
		StockCard card=new StockCard("dsds","sds",2,"as","as",2.0,"sdsds");
		manager.Add(card);

	}

}
