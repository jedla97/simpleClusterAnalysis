package jedla.project.simple.cluster.analysis;

public class Cell {
	private int positionX;
	private int positionY;
	private int IDofCluster;
	private static int counter = 1;
	private int id;
	
	public Cell(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.id = counter;
		counter++;
	}

	
	@Override
	public String toString() {
		return "ID = " + id + "	||||| positionX=" + positionX + ", positionY=" + positionY + ", cluster=" + IDofCluster;
	}

	
	public int getIDofCluster() {
		return IDofCluster;
	}


	public void setIDofCluster(int iDofCluster) {
		IDofCluster = iDofCluster;
	}


	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
