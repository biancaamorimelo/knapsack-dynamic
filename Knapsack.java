package knapsackDynamic;
import java.util.ArrayList;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Knapsack {
	
	private int profit;
	private ArrayList<Object> usedObjects;
	private int[][] matrix;
	private String usedProducts = "";
	
	public Knapsack() {
		profit = 0;
		usedObjects = new ArrayList<>();
	}
	
	public void calculate(int capacity, Object[] obj) {
		int objQuantity = obj.length, aux, p1, p2;
		matrix = new int[objQuantity + 1][capacity + 1];
		Object o;
		
		//Matriz: uma linha (i) a mais de produtos e uma coluna (j) a mais de capacidade
		for (int i = 0; i <= objQuantity; i++) {
			for(int j = 0; j <= capacity; j++) {
				if(i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else {
					o = obj[i - 1];
					
					if(o.getWeight() <= j) {
						p1 = o.getValue() + matrix[i - 1][j - o.getWeight()];
						p2 = matrix[i - 1][j];
						//Escolhe o maior
						matrix[i][j] = Math.max(p1, p2);
					} else {
						matrix[i][j] = matrix[i - 1][j];
					}
				}
			}
		}
		
		profit = matrix[objQuantity][capacity];
		this.usedProducts(matrix, obj);
	}
	
	private void usedProducts(int[][] matrix, Object[] obj) {
		int i = matrix.length - 1; // Linha
		int j = matrix[0].length - 1; // Coluna
		
		for(int x = i - 1; x >= 0; x--) {
			if(matrix[i][j] - matrix[i - 1][j] > 0) {
				i--;
				j -= obj[x].getWeight();
				usedObjects.add(obj[x]);
			} else {
				i--;
			}
		}	
	}
	
	public int getProfit() {
		return profit;
	}
	
	public String getUsedProducts() {
		int k = 1;
		for (int i = usedObjects.size() - 1; i >= 0; i--, k++) {
			if (i > 0) {
				usedProducts += usedObjects.get(i).getName() + ", "; 
			} else {
				usedProducts += usedObjects.get(i).getName() + ".";
 			}
			
			if(k % 21 == 0) {
				usedProducts += "\n";
			}
		}
		
		return usedProducts;
	}
	
	private void print(int [][] v) {
		System.out.println("Vector Length = " + v.length);
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v[0].length; j++) {
				System.out.printf("%3d", v[i][j]);
			}
			System.out.println("");
		}
	}	
}
