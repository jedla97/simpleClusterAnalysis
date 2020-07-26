package jedla.project.simple.cluster.analysis.single.linkage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import jedla.project.simple.cluster.analysis.*;

public class App {
	private static final String MAVEN_RESOURCES_PREFIX = "./src/jedla/project/simple/cluster/analysis/single/linkage/";
	Scanner sc = new Scanner(System.in);
	static App a = new App();

	public static void main(String[] args) {
		int operation;
		int x;
		int y;
		ClusterDatabase data = null;
		//ClusterDatabase cdb = new ClusterDatabase();
		/**
		Cluster c = new Cluster();
		Cluster c2 = new Cluster();
		Cluster c3 = new Cluster();
		Cell cell1 = new Cell(5, 5);
		Cell cell2 = new Cell(10, 10);
		Cell cell3 = new Cell(68, 5);
		c.addCell(cell1);
		c3.addCell(cell2);
		c2.addCell(cell3);
		cdb.addClusterToDatabase(c);
		cdb.addClusterToDatabase(c2);
		cdb.addClusterToDatabase(c3);
		cdb.printAllClusters();
		System.out.println(c.euclideanDistance(10, 10, 8, 8));
		System.out.println(c.euclideanDistance(8, 8, 10, 10));
		cdb.findClusters(2);
		**/
		while (true) {
			System.out.println(
					"input number 1 for add cell, 2 for load cells from file or number 3 for compute clusters "
					+ "and number 4 is for exit program");
			operation = a.numberInput(1, 4);
			if (operation == 1) {
				// TODO
				System.out.println("Input position x");
				x = a.numberInput(0, 1000);
				System.out.println("Input position y");
				y = a.numberInput(0, 1000);
			} else if (operation == 2) {
				// TODO load cells from file
				try {
					data = a.loadFromFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (operation == 3) {
				// TODO cluster compute and user input
				// TODO when findCluster is 2 indexOutOfBonds
				data.findClusters(10);
				//data.printAllClusters();
			} else if (operation == 4) {
				System.exit(0);
			}
		}

	}

	// for user number input
	public int numberInput(int minRange, int maxRange) {
		String help;
		Integer number = -1;
		// get input from user until all demands is fulfill
		while (number < 0) {
			help = sc.next();
			// testing if inputed number is in declared range
			if (a.numberIsInRange(minRange, maxRange, help) == true) {
				number = Integer.valueOf(help);
			} else {
				System.err.println("out of range");
			}
		}
		return number;
	}

	public boolean numberIsInRange(int minRange, int maxRange, String number) {
		try {
			if (Integer.valueOf(number) >= minRange && Integer.valueOf(number) <= maxRange) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("not positiv number");
		}
		return false;
	}

	// data loader from file
	public ClusterDatabase loadFromFile() throws IOException {

		File data = new File(MAVEN_RESOURCES_PREFIX + "data.txt");
		String line = "";
		String cvsSplitBy = ";";
		BufferedReader br = new BufferedReader(new FileReader(data));
		ClusterDatabase database = new ClusterDatabase();
		try {
			while ((line = br.readLine()) != null) {
				String[] position = line.split(cvsSplitBy);
				if (a.numberIsInRange(0, 1000, position[0]) == true
						&& (a.numberIsInRange(0, 1000, position[1]) == true)) {
					Cell c = new Cell(Integer.valueOf(position[0]), Integer.valueOf(position[1]));
					Cluster cl = new Cluster();
					cl.addCell(c);
					database.addClusterToDatabase(cl);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return database;
	}
}
