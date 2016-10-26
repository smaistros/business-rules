package com.smaistros.business_rules.tradeStockModel;

public class Stock {
	
	private String id;
	private Number price;
	private TradingSignal tradingSignal;
	
	public Stock(String id, Number price) {
		super();
		this.id = id;
		this.price = price;
		this.tradingSignal = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public TradingSignal getTradingSignal() {
		return tradingSignal;
	}

	public void setTradingSignal(TradingSignal trade) {
		this.tradingSignal = trade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (price != null)
			builder.append("price=").append(price.toString());
		if (tradingSignal != null)
			builder.append("trade=").append(tradingSignal).append(", ");		
		builder.append("]");
		return builder.toString();
	}
	
	
}
