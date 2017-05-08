package algo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Sortobject<T>  {

	private T load;
	
	private long key;
	
	public Sortobject(T load, long key) {
		this.key = key;
		this.load = load;
	}

	public T getLoad() {
		return load;
	}

	public void setLoad(T load) {
		this.load = load;
	}

	public long getKey() {
		return key;
	}
	
	public String toString(){
		return String.format("%5d", key);
	}
	
	
	public static List<Sortobject<?>> getRandomList(long N, 
			                                        long minKey, 
			                                        long maxKey)
	{
		List<Long> longList = 
				new Random().longs(N, minKey, maxKey+1).
				boxed().collect(Collectors.toList());
		ArrayList<Sortobject<?>> list = new ArrayList<Sortobject<?>>();
		for(Long l : longList){
			list.add(new Sortobject<String>(Long.toString(l), l));
		}
		return list;		
	}
}
