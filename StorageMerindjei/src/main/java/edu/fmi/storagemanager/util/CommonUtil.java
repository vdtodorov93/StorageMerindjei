package edu.fmi.storagemanager.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	
	private CommonUtil(){ };
	
	public static <T> List<T> iterableToList(Iterable<? extends T> source) {
		List<T> result = new ArrayList<T>();
		for(T item: source) {
			result.add(item);
		}
		
		return result;
	}
}
