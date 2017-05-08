import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import algo.BetterQS;
import algo.RandomQS;
import algo.Sort;
import algo.Sortobject;

public class TestSort {
	
	Sort qs;
	
	List<Sortobject<?>> sortlist = new ArrayList<Sortobject<?>>();
	List<Sortobject<?>> unsortlist = new ArrayList<Sortobject<?>>();
	
	
	@Test
	public void testRandomQS() {
		qs = new RandomQS();
		this.fill();
		//this.printList(sortlist);
		//this.printList(unsortlist);
		qs.sort(unsortlist);
		//this.printList(unsortlist);
		for(int i = 0; i < sortlist.size(); i++ ){
		
			Assert.assertEquals(String.format("At i : %d \n", i),
					            sortlist.get(i).getKey(), 
				                unsortlist.get(i).getKey());
		}
		
	}
	
	@Test
	public void testBetterQS() {
		qs = new BetterQS(30);
		this.fill();
		//this.printList(sortlist);
		//this.printList(unsortlist);
		qs.sort(unsortlist);
		//this.printList(unsortlist);
		for(int i = 0; i < sortlist.size(); i++ ){
		
			Assert.assertEquals(String.format("At i : %d \n", i),
					            sortlist.get(i).getKey(), 
				                unsortlist.get(i).getKey());
		}
		
	}

	public void printList(List<Sortobject<?>> list){
		for (Sortobject<?> ob : list){
			System.err.format("%d ",ob.getKey() );
		}
		System.err.println();
	}
	
	
	
	public void fill() {
		fill(1000000);
	}
	
	public void fill(int N){
	    sortlist.clear();
	    for(int i = 0; i < N; i++){
	    	sortlist.add(new Sortobject<String>(null, i/2));
	    }
		
	    unsortlist.clear();
	    for(int i = N-1; i >= 0; i--){
	    	unsortlist.add(new Sortobject<String>(null, i/2));
	    }
	}

}
