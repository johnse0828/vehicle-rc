package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.CommandFormatException;
import exceptions.InvalidCoordsException;
import model.Map;

public class Command {
	private Map map;
	private String command;
	private String[] commands;
	private boolean valid;
	private final List<String> validDirections = Arrays.asList("N", "E", "S", "O");
	
	public Command (Map map, String command) throws CommandFormatException {
		this.valid = true;
		this.map = map;
		this.command = command;
		this.commands = this.command.split(";");
		this.validate();
	}
	
	private void validate() throws CommandFormatException {
		if (this.commands.length <= 0) {
			throw new CommandFormatException();
		}
		
		for (String cmd : this.commands) {
			String[] separateCommand = cmd.split(",");
			if (separateCommand.length != 2) {
				valid = false;
				break;
			} else {
				String strMoveLength = separateCommand[0];
				String directionMove = separateCommand[1].trim().toUpperCase();
				if (!validDirections.contains(directionMove)) {
					valid = false;
					break;
				} else {
					int moveLength = -1;
					try {
						moveLength = Integer.parseInt(strMoveLength);
					} catch (Exception ex) {
						valid = false;
						break;
					}
					int mapLength = 0;
					if (("N".equals(directionMove) || "S".equals(directionMove))) {
						mapLength = this.map.getHeight();
					} else {
						mapLength = this.map.getWidth();
					}
					if (!moveLengthValid(moveLength, mapLength)) {
						valid = false;
						break;
					}
				}
			}
		}
	}
	
	public boolean isValid() {
		return valid;
	}
	
	private boolean moveLengthValid(int moveLength, int mapLength) {
		if (moveLength < 0 || moveLength >= mapLength) {
			return false;
		}
		return true;
	}
	
	public void execute() throws InvalidCoordsException {
		for (String cmd : this.commands) {
			String[] separateCommand = cmd.split(",");
			String strMoveLength = separateCommand[0];
			int moveLength = Integer.parseInt(strMoveLength);
			String directionMove = separateCommand[1].trim().toUpperCase();
			if (("N".equals(directionMove) || "S".equals(directionMove))) {
				int currentYPosition = this.map.getXVehiclePosition();
				int newXPosition = -1;
				if("N".equals(directionMove)) {
					newXPosition = currentYPosition + moveLength;
				} else {
					newXPosition = currentYPosition - moveLength;
				}
				
				if (moveLengthValid(newXPosition, this.map.getHeight())) {
					this.map.changeVehiclePosition(newXPosition, this.map.getYVehiclePosition());
				} else {
					throw new InvalidCoordsException();
				}
			} else {
				int currentXPosition = this.map.getYVehiclePosition();
				int newYPosition = -1;
				if("E".equals(directionMove)) {
					newYPosition = currentXPosition + moveLength;
				} else {
					newYPosition = currentXPosition - moveLength;
				}
				
				if (moveLengthValid(newYPosition, this.map.getWidth())) {
					this.map.changeVehiclePosition(this.map.getXVehiclePosition(), newYPosition);
				} else {
					throw new InvalidCoordsException();
				}
			}
			System.out.println(String.format("(%s, %s)", this.map.getXVehiclePosition(), this.map.getYVehiclePosition()));
		}
	}
}
