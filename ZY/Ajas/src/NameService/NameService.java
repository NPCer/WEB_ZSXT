package NameService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NameService {
	private List names;
	
	private NameService(List list){
		this.names = list;
	}
	
	public static NameService getInstance(List names){
		return new NameService(names);
	}
	
	public List findNames(String prefix){
		String prefix_upper = prefix.toUpperCase();
		System.out.println(prefix_upper);
		List matches = new ArrayList();
		Iterator iter = names.iterator();
		while(iter.hasNext()){
			String name = (String) iter.next();
			String name_upper_case = name.toUpperCase();
			if(name.startsWith(prefix_upper)){
				boolean result = matches.add(name);
			}
		}
		return matches;
	}
	
}
