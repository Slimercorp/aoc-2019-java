package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		List<Integer> data = new ArrayList<>();
		
		while (scan.hasNextInt()) {
			data.add(scan.nextInt());
		}
		
		System.out.println(getAnswer(data));
		
		scan.close();
	}

	
	public static int getAnswer(List<Integer> data) {
		int fuel = 0;
		for (int i=0; i<data.size(); i++) {
			int fuelElem = data.get(i) / 3 - 2;
			fuel += fuelElem;
			int fuelForFuel = fuelElem;
			while (true) {
				fuelForFuel = fuelForFuel / 3 - 2;
				if (fuelForFuel <= 0) {
					break;
				}
				
				fuel += fuelForFuel;
			}
		}
		
		return fuel;
	}
}
