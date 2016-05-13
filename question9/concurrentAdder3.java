package question9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class concurrentAdder3 {
	public static void main(String[] args) {
		System.out.println("parallel: 4" );
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

		try{
			FileReader fr = new FileReader("C:\\Users\\Momo\\Desktop\\data1G.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			int size = Integer.parseInt(br.readLine());
			System.out.println("Size is "+size);
			for(int i=0;i<size;i++){
				map.put(i, Integer.parseInt(br.readLine()));
				System.out.println(i+" of "+size+" : "+map);

			}

			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long sum = (long)map.reduceValuesToLong(4,
				(value)->{
					return value;
				},0,
				(s1,s2)->{
					return s1+s2;
				});
		System.out.println("Sum is "+sum);
	}
}
