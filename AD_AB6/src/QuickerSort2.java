import java.util.LinkedList;
import java.util.List;

public class QuickerSort2 {

	public long counter = 0;
	
	public List<Sortobject<?>> quickerSort2(List<Sortobject<?>> list){
		List<Sortobject<?>> ergList = new LinkedList<>();
		
		for(Sortobject<?> s : list){
			if(ergList.isEmpty()){
				// Wenn die Lise leer ist, ...
				ergList.add(s);
			} else {
				if(list.size() < 11){ // TODO auf ?6? setzen
					int i = 0;
					while(ergList.get(i).getKey() < s.getKey() && i< ergList.size()-1){
						i++;
						counter++;
					}
					if(i >= ergList.size()){
						// Wenn i das Element mit dem momentan Größten Key ist, füge es hinten an
						ergList.add(s);
					} else {
						// sonst, füge es an der passenden Stelle ein
						ergList.add(i, s);
					}
				}
			}
		}
		
		
		return ergList;
	}
}
