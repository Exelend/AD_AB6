import java.util.LinkedList;
import java.util.List;

import javax.swing.SortOrder;

public class QuickerSort {
	
	public long counter = 0;
	
	public List<Sortobject<?>> quickerSort(List<Sortobject<?>> list){
		int lowerValue = list.size()*700;
		int upperValue = list.size()*800;
		return quickerSort(list, lowerValue, upperValue);
	}
	
	public List<Sortobject<?>> quickerSort(List<Sortobject<?>> list, int lowerValue, int upperValue){
		List<Sortobject<?>> ergList = new LinkedList<Sortobject<?>>();
		int range = upperValue-lowerValue;
		if(list.size()>40){
			List<List<Sortobject<?>>> listList = new LinkedList<List<Sortobject<?>>>();
			for(int i = 0; i<10; i++){
				listList.add(new LinkedList<Sortobject<?>>());
				counter++;
			}
			for(Sortobject<?> i: list){
				int j = 1;
				do{
					j++;
					counter++;
				}while((i.getKey() > (range*j)+lowerValue) && i.getKey() < upperValue);
				listList.get(j-2).add(i);
			}
			for(int i = 0; i<listList.size(); i++){
				ergList.addAll(quickerSort(listList.get(i), lowerValue+(i*range), lowerValue+((i+1)*range)));
				counter++;
			}
		}else{
			for(Sortobject<?> d : list){
				if(d.getKey()<(lowerValue+(range/2))){
					int i = 0;
					while( !ergList.isEmpty() && d.getKey() > ergList.get(i).getKey() && i < ergList.size()-1){
						i++;
						counter++;
					}
					ergList.add(i, d);
				} else {
					int i = list.size()-1;
					while( !ergList.isEmpty() && d.getKey() < ergList.get(i).getKey() && i > 0){
						i++;
						counter++;
					}
					if(!ergList.isEmpty()){
						ergList.add(i, d);
					} else {
						ergList.add(d);
					}
				}
			}
		}
		return ergList;
	}
	
	public static void main(String[] args){
		
	}
}