package model;

public class Map {
	
	private int height;
	private int width;
	private Vehicle vehicle;
	private Vehicle[][] mVehicles;
	private int lastXPosition;
	private int lastYPosition;

	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.mVehicles = new Vehicle[height][width];
	}
	
	public void changeVehiclePosition(int xPosition, int yPosition) {
		this.mVehicles[lastXPosition][lastYPosition] = null;
		this.mVehicles[xPosition][yPosition] = this.vehicle;
		this.lastXPosition = xPosition;
		this.lastYPosition = yPosition;
	}
	
	public int getXVehiclePosition() {
		return this.lastXPosition;
	}
	
	public int getYVehiclePosition() {
		return this.lastYPosition;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
