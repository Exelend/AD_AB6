

public class Sortobject<T>  {

	private T load;
	
	private long key;
	
	private static long keycounter = 0;
	
	public Sortobject( T load, long key) {
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
	
	public void setKeycounter(long i){
		keycounter = 0;
	}
	
	public String toString(){
		return String.format("%5d", key);
	}
}
