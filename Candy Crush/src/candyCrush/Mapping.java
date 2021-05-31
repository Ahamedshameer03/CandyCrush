package candyCrush;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
	int i,j;
	List<Integer> List_I = new ArrayList<Integer>();
	List<Integer> List_J = new ArrayList<Integer>();
	
	public Mapping() {}
	public void put(int i, int j) {
		this.i = i;
		this.j = j;
	}
	/*public Map<Integer, Integer> get(int i){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(List_I.get(i), List_J.get(i));
		return map;
	}*/
}
