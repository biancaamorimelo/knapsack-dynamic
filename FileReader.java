package knapsackDynamic;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Bianca Amorim
 *
 *
 */
public class FileReader {
	
	private final String address;
	private final Path path;
	private final Charset utf8;
	private final String token;
	private int n, capacity;
	private int[] value, weight;
	
	public FileReader(String end, String token) {
		this.address = end;
		path = Paths.get(address);
		utf8 = StandardCharsets.UTF_8;
		this.token = token;
	}
	
	public FileReader(String end) {
		this (end, " ");
	}
	
	public void readFile() {
		int k = -1;
		try(BufferedReader reader = Files.newBufferedReader(path, utf8)){
			String line;
			while ((line = reader.readLine()) != null) {
				String[] t = line.split(token);
				if (k == -1) {
					n = Integer.parseInt(t[0]);
					capacity = Integer.parseInt(t[1]);
					weight = new int[n];
					value = new int[n];
				} else {
					weight[k] = Integer.parseInt(t[0]);
					value[k] = Integer.parseInt(t[1]);
				} 
				
				k++;
			}
		} catch (IOException e) {
			System.err.println("Erro");
		}
	}
	
	public int getN() {
		return n;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int[] getValue() {
		return value;
	}
	
	public int[] getWeight() {
		return weight;
	}
}
