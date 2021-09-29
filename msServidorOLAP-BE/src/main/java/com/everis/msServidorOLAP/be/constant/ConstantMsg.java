package com.everis.msdemo.be.constant;

public class ConstantMsg {

	private ConstantMsg() {
		throw new IllegalStateException("Utility class");
	}

	public static final String CODE_200 = "200";
	public static final String ERROR_200 = "La solicitud ha tenido éxito";
	public static final String CODE_201 = "201";
	public static final String CODE_400O = "400O";
	public static final String CODE_400L = "400L";
	public static final String CODE_400F = "400F";
	public static final String CODE_400J = "400J";
	public static final String CODE_401 = "401";
	public static final String CODE_403 = "403";
	public static final String CODE_440D = "440D";
	public static final String CODE_440G = "440G";
	public static final String CODE_440P = "440P";
	public static final String CODE_441P = "441P";
	public static final String CODE_452D = "452D";
	public static final String CODE_452P = "452P";
	public static final String CODE_452S = "452S";
	public static final String CODE_460 = "460";
	public static final String CODE_461 = "461";
	public static final String CODE_462 = "462";
	public static final String CODE_474 = "474";
	public static final String CODE_481 = "481";
	public static final String CODE_482 = "482";
	public static final String CODE_483 = "483";
	public static final String CODE_491 = "491";
	public static final String CODE_492 = "492";
	public static final String CODE_500 = "500";

	public static final String CODE_OFFLINE = "400";
	public static final String ERROR_OFFLINE = "No se pudo encontrar el código %s";
	public static final String ERROR_500_OFFLINE = "Ocurrió un error inesperado en el servidor. Contáctese con un administrador";
}