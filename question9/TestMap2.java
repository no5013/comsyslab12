package question9;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class TestMap2 {

	public static void main (String[] args)
	 {

	  System.out.println("parallel: "+ForkJoinPool.getCommonPoolParallelism());

	  ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	  map.put("foo", "bar");
	  map.put("han", "solo");
	  map.put("r2", "d2");
	  map.put("c3", "p0");
	String result = map.reduce(1,
	    (key, value) -> {
	        System.out.println("Transform: " + Thread.currentThread().getName());
	        return key + "=" + value;
	    },
	    (s1, s2) -> {
	        System.out.println("Reduce: " + Thread.currentThread().getName());
	        return s1 + ", " + s2;
	    });

	 }

}
