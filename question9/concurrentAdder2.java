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

public class concurrentAdder2 {

	public static BufferedReader br;
	public static void main(String[] args) {


		long sum = 0;

		ForkJoinPool instance = new ForkJoinPool(Runtime.getRuntime().availableProcessors() + 1);
	
		try{
			FileReader fr = new FileReader("C:\\Users\\Momo\\Desktop\\data1G.txt");
			 br = new BufferedReader(fr);


			int size = Integer.parseInt(br.readLine());
			System.out.println("Size is "+size);
			 
			SummationTask st = new SummationTask(size);
			instance.invoke(st);
			sum = st.sum;
			
			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Sum is "+sum);

	}

static class SummationTask extends RecursiveTask<Long>{
	long sum;
	private int size;
	
	public SummationTask(int size){
		this.size = size;
	}
	
	@Override
	protected Long compute() {
		if(size<2){
			try {
				sum = Integer.parseInt(concurrentAdder2.br.readLine());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			SummationTask task1 = new SummationTask(size/2);
			SummationTask task2 = new SummationTask(size/2);
			task1.fork();
			sum = task2.compute()+task1.join();
		}
		System.out.println("Sum is "+sum);
		
		return sum;
	}
	
}
}