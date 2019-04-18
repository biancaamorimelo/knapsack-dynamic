/**
 * 
 */
package knapsackDynamic;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Main {
	
	private static int n, capacity;
	private static int[] value, weight;
	
	public static void main(String[] args) {
		String end = "src/instancias/mochila01.txt";
		Main.getData(end);
		
		Object[] obj = new Object[n];
		for (int i = 0; i < n; i++) {
			obj[i] = new Object("" + (i + 1), value[i], weight[i]);
		}
		
		System.out.println("Knapsack Capacity is = " +  capacity);
		Knapsack k = new Knapsack();
		k.calculate(capacity, obj);
		System.out.println("Value: " + k.getProfit());
		System.out.println("Choosen products: " + k.getUsedProducts());
	}
	
	public static void getData(String end) {
		FileReader read = new FileReader(end);
		read.readFile();
		n = read.getN();
		capacity = read.getCapacity();
		value = read.getValue();
		weight = read.getWeight();
	}

}
