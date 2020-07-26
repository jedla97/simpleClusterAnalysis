package jedla.project.simple.cluster.analysis.single.linkage;

import java.util.ArrayList;

public class ClusterDatabase {
	private ArrayList<Cluster> clusters = new ArrayList<Cluster>();

	public ClusterDatabase() {
		super();
	}

	public void addClusterToDatabase(Cluster cluster) {
		clusters.add(cluster);
	}
	
	public void removeClusterFromDatabase(int id) {
		clusters.remove(id);
	}
	
	public void printAllClusters() {
		for (int i = 0; i < clusters.size(); i++) {
			clusters.get(i).printAllCells();
		}
	}

	public void findClusters(int numberOfClusters) {
		if (numberOfClusters < clusters.size()) {
			double minDistance = Integer.MAX_VALUE;
			int idIfCluster = 0;
			int idOfMergedCluster = 0;
			double[] help;
			while (clusters.size() > numberOfClusters) {
				for (int i = 0; i < clusters.size(); i++) {
					help = clusters.get(i).nearestSingeCluster(clusters, i);
					if(help[0]< minDistance) {
						minDistance = help[0];
						idOfMergedCluster = (int)Math.round(help[1]);
						idIfCluster = i;
					}
				}
				this.mergeClusters(idIfCluster, idOfMergedCluster);
			}
			this.printAllClusters();
		}
		else if(numberOfClusters == clusters.size()) {
			this.printAllClusters();
		}
		else {
			System.out.println("you want more clusters then you have cells can't do that");
		}
	}
	
	public void mergeClusters(int idOfCluster1, int idOfCluster2) {
		Cluster c = clusters.get(idOfCluster1);
		for (int i = 0; i < clusters.get(idOfCluster2).getCells().size(); i++) {
			c.addCell(clusters.get(idOfCluster2).getCells().get(i));
			clusters.get(idOfCluster2).removeCell(clusters.get(idOfCluster2).getCells().get(i));			
		}
		this.removeClusterFromDatabase(idOfCluster2);
		
	}
	
	public ArrayList<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(ArrayList<Cluster> clusters) {
		this.clusters = clusters;
	}

}
