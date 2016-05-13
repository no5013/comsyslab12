package question9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class concurrentAdder1 {


	public static void main(String[] args) {


		long sum = 0;

		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

		try{
			FileReader fr = new FileReader("C:\\Users\\Momo\\Desktop\\data1G.txt");
			BufferedReader br = new BufferedReader(fr);


			int size = Integer.parseInt(br.readLine());
			System.out.println("Size is "+size);
			for(int i=0;i<size;i++){
				
				sum+=executorService.submit(new Callable<Integer>() {
					public Integer call() throws NumberFormatException , IOException{
						return Integer.parseInt(br.readLine());
					}
				}).get();
				System.out.println(i+" of "+size+" : " + sum);

			}

			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Sum is "+sum);

	}


}