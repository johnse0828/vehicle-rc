package model;

import exceptions.CommandFormatException;
import exceptions.InvalidCoordsException;
import util.Command;

public class Vehicle {
	private Map map;
	
	public Vehicle(Map map) {
		this.map = map;
		this.map.setVehicle(this);
	}
	
	public void move(String command) throws CommandFormatException, InvalidCoordsException {
		Command cmd = new Command(this.map, command);
		if (cmd.isValid()) {
			cmd.execute();
		} else {
			throw new CommandFormatException();
		}
	}
}
