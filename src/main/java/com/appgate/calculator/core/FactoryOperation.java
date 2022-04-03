package com.appgate.calculator.core;

import java.lang.reflect.InvocationTargetException;

import com.appgate.calculator.exception.FactoryException;

/**
 * Clase aplica el patron metodo de fabrica para instanciar clases
 * que implementan y realizan la operacion matematica.  
 * Tambien utiliza el patron reflexion para obtener la instancia de forma dinamica. 
 * 
 * @author Jose Luis Caicedo Gonzalez. luix17@yahoo.com
 *
 */
public class FactoryOperation {
	private final static String PAKAGE = "com.appgate.calculator.core.operation.";

	public static IOperation creatOperation(String nameOperator) throws FactoryException{
		IOperation operation = null;
		try {
			String pathClass = PAKAGE + nameOperator;
			operation = (IOperation) Class.forName(pathClass).getDeclaredConstructor().newInstance();
		} 
		catch (InstantiationException e) {
			throw new FactoryException("Error instancia",e.getCause());
		} 
		catch (IllegalAccessException e) {
			throw new FactoryException("Acceso incorrecto",e.getCause());
		} 
		catch (ClassNotFoundException e) {
			throw new FactoryException("Clase no encontrada",e.getCause());
		} 
		catch (IllegalArgumentException e) {
			throw new FactoryException("Argumento invalido",e.getCause());
		} 
		catch (InvocationTargetException e) {
			throw new FactoryException("Invocacion invalida",e.getCause());
		} 
		catch (NoSuchMethodException e) {
			throw new FactoryException("Metodo no encontrado",e.getCause());
		} 
		catch (SecurityException e) {
			throw new FactoryException("Seguridad excepcion",e.getCause());
		}
		return operation;
	}
}
