package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELLED(5);
	
	//por conta do codigo de status passou a ser necessário o construtor
	private int code;
	
	private OrderStatus(int code ) {
		this.code = code;
	}
	
	//para que o código fique acessível ao "mundo exterior", será criado um código.
	public int getCode() {
		return code;	
	}
	
	//Metodo estatico para retornar um order status correspondente a esse código
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode()==code) {
				return value;
			}			
		}	
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}	
}
