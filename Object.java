/**
 * 
 */
package knapsackDynamic;

/**
 * @author Bianca Amorim
 *
 *
 */
public class Object {
	
	private final String name;
	private final int value;
	private final int weight;
	
	public Object(String n, int v, int w) {
		this.name = n;
		this.value = v;
		this.weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return name + ": [" + weight + " - " + value + "]";
 	}

}
