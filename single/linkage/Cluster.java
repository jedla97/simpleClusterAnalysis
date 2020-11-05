package jedla.project.simple.cluster.analysis.single.linkage;

import java.util.ArrayList;

import jedla.project.simple.cluster.analysis.*;

public class Cluster {

	private ArrayList<Cell> cells = new ArrayList<Cell>();
	public static int counter = 0; // cluster counter
	private int IDofCluster;

	public Cluster() {
		super();
		this.IDofCluster = counter;
		counter++;
	}

	public void addCell(Cell cell) {
		cells.add(cell);
		cell.setIDofCluster(this.IDofCluster);
	}

	public void removeCell(Cell cell) {
		cells.remove(cell);
	}
	public void printAllCells() {
		for (int i = 0; i < cells.size(); i++) {
			System.out.println(cells.get(i).toString());
		}
	}

	public double[] nearestSingeCluster(ArrayList<Cluster> arr, int ownId) {
		int x1;
		int y1;
		int x2;
		int y2;
		double nearestCell = Double.MAX_VALUE;
		double helpForEuclid;
		int idOfCell = 0;
		for (int i = 0; i < cells.size(); i++) {
			x1 = cells.get(i).getPositionX();
			y1 = cells.get(i).getPositionY();
			for (int j = 0; j < arr.size(); j++) {
				if (j != ownId) {
					for (int k = 0; k < arr.get(j).getCells().size(); k++) {
						x2 = arr.get(j).getCells().get(k).getPositionX();
						y2 = arr.get(j).getCells().get(k).getPositionY();
						helpForEuclid = this.euclideanDistance(x1, y1, x2, y2);
						if (helpForEuclid < nearestCell) {
							nearestCell = helpForEuclid;
							idOfCell = j;
						}
					}
				}
			}
		}
		double[] ret = {nearestCell, idOfCell};
		//System.out.println(ret[0] + " " + ret[1]);
		return ret;
	}

	public double euclideanDistance(int x1, int y1, int x2, int y2) {
		int x = x2 - x1;
		int y = y2 - y1;
		x = x * x;
		y = y * y;
		double result = Math.sqrt(x + y);
		return result;

	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public int getIDofCluster() {
		return IDofCluster;
	}

	public void setIDofCluster(int iDofCluster) {
		IDofCluster = iDofCluster;
	}

}
