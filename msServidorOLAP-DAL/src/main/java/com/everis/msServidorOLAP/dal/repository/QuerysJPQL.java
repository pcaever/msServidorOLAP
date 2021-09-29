package com.everis.msdemo.dal.repository;

public class QuerysJPQL {
	private QuerysJPQL() {	}
	
	public static final String QUERY_UPDATE_PRINCIPALBYNOMBRE =
		"UPDATE Principal AS p "
		+ "SET p.activo = 0 "
		+ "WHERE p.nombre = :nombre "
		+ "AND p.activo = 1";
}
