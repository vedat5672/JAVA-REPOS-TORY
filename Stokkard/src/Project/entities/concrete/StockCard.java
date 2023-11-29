package Project.entities.concrete;

import java.time.LocalDateTime;
import java.util.*;

import Project.entities.abstraction.IEntity;

public class StockCard implements IEntity{
	
	private int id;
	private String stockCode;
	private String stockName;
	private int stockType;
	private String unit;
	private String barcode;
	private double kdvType;
	private String description;
	private Date creationTime;
	
	
	public StockCard(String stockCode, String stockName, int stockType, String unit, String barcode,
			double kdvType, String description) {
	
		
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockType = stockType;
		this.unit = unit;
		this.barcode = barcode;
		this.kdvType = kdvType;
		this.description = description;
		
	}
	public StockCard(int id,String stockCode, String stockName, int stockType, String unit, String barcode,
			double kdvType, String description,Date creationTime) {
	
		this.id=id;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockType = stockType;
		this.unit = unit;
		this.barcode = barcode;
		this.kdvType = kdvType;
		this.description = description;
		this.creationTime=creationTime;
		
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockType() {
		return stockType;
	}
	public void setStockType(int stockType) {
		this.stockType = stockType;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getKdvType() {
		return kdvType;
	}
	public void setKdvType(double kdvType) {
		this.kdvType = kdvType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public int getId() {
		return id;
	}
	
}
