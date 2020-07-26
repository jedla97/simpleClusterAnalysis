package jedla.project.simple.cluster.analysis;

public class Cell {
	private int positionX;
	private int positionY;
	private int IDofCluster;
	
	public Cell(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	
	@Override
	public String toString() {
		return "positionX=" + positionX + ", positionY=" + positionY + ", cluster=" + IDofCluster;
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
