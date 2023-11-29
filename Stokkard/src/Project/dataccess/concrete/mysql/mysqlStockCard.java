package Project.dataccess.concrete.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Project.dataccess.abstraction.IStockCardDao;
import Project.dataccess.concrete.context.MysqlConnection;
import Project.entities.concrete.StockCard;

public class mysqlStockCard extends MysqlConnection implements IStockCardDao {

	public mysqlStockCard() {

	}

	@Override
	public List<StockCard> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(StockCard card) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {

			conn = getConnection();
			String sql = "INSERT INTO card(id,stockCode, stockName, stockType,unit,barcode,kdvType,description,creationTime) VALUES (?,?,?,?,?,?,?,?,?)";
			System.out.println("geldi");
			// SQL sorgusunu hazırlayın
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, card.getId());
			preparedStatement.setString(2, card.getStockCode()); // Sutun1 için değeri ayarlayın
			preparedStatement.setString(3, card.getStockName()); // Sutun2 için değeri ayarlayın
			preparedStatement.setInt(4, card.getStockType());
			preparedStatement.setString(5, card.getUnit());
			preparedStatement.setString(6, card.getBarcode());
			preparedStatement.setDouble(7, card.getKdvType());
			preparedStatement.setString(8, card.getDescription());
			preparedStatement.setDate(9, (Date) card.getCreationTime());

			// SQL sorgusunu çalıştırın
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			showErrorMessage(e);
			;
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void Delete(StockCard card) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		StockCard deleteCard = null;
		try {
			conn = getConnection();
			String sql = "DELETE FROM card WHERE stockCode = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, card.getStockCode());
			int result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			showErrorMessage(e);
			;
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void Update(StockCard card) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = getConnection();
			String sql = "UPDATE card SET stockName=?, stockType=?, Unit=?, barcode=?, kdvType=?, description=? WHERE stockCode=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, card.getStockName());
			preparedStatement.setInt(2, card.getStockType());
			preparedStatement.setString(3, card.getUnit());
			preparedStatement.setString(4, card.getBarcode());
			preparedStatement.setDouble(5, card.getKdvType());
			preparedStatement.setString(6, card.getDescription());
			preparedStatement.setString(7, card.getStockCode());
			int result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			showErrorMessage(e);
			// Hata işleme kodu
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public ResultSet Copy(String code) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StockCard deleteCard = null;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM card WHERE stockCode = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, code);
			resultSet= preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			showErrorMessage(e);
			
		}
		return resultSet; 
		
	}



}
