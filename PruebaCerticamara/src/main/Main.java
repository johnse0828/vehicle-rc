package main;

import java.util.Scanner;

import exceptions.CommandFormatException;
import exceptions.InvalidCoordsException;
import model.Map;
import model.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int height = 0;
		int width = 0;
		
		height = getInteger("Digite el largo del campo de desplazamiento: ");
		width = getInteger("Digite el ancho del campo de desplazamiento: ");
		
		Map map = new Map(height, width);
		Vehicle vehicle = new Vehicle(map);
		while(true) {
			System.out.print("Digite comando o la letra 'e' para salir: ");
			String command = s.nextLine();
			if (!"e".equals(command)) {
				try {
					vehicle.move(command);
				} catch (CommandFormatException | InvalidCoordsException e) {
					System.out.println(e.getMessage());
				}
			} else {
				break;
			}
		}
		System.out.println("Ha terminado la ejecución de la aplicación");
		s.close();
	}
	
	private static int getInteger(String message) {
		Scanner s = new Scanner(System.in);
		int number = 0;
		try {
			System.out.print(message);
			number = s.nextInt();
			if (number < 1) {
				System.out.println("Debe digitar únicamente números enteros positivos");
				return getInteger(message);
			}
		} catch (Exception ex) {
			System.out.println("Debe digitar únicamente números enteros positivos");
			return getInteger(message);
		}
		return number;
	}
}
