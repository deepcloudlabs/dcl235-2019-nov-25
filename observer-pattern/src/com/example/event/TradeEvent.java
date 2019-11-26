package com.example.event;

import java.math.BigDecimal;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class TradeEvent {
	private String symbol;
	private String quantity;
	private String price;

	public TradeEvent() {
	}

	public TradeEvent(String symbol, String quantity, String price) {
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TradeEvent [symbol=" + symbol + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public String getVolume() {
		BigDecimal bdPrice = new BigDecimal(price);
		BigDecimal bdQuantity = new BigDecimal(quantity);
		return bdPrice.multiply(bdQuantity).toString();
	}

}
