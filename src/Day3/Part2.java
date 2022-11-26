package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		scan.close();	
		
		String[] str1Splitted = str1.split(",");
		
		int x = 0;
		int y = 0;
		int steps = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<str1Splitted.length; i++) {
			char command = str1Splitted[i].charAt(0);
			int value = Integer.parseInt(str1Splitted[i].substring(1, str1Splitted[i].length()));
			
			for (int j = 0; j < value; j++ ) {
				steps++;
				switch (command) {
					case 'R':
						x++;
						break;
					case 'L':
						x--;
						break;
					case 'U':
						y++;
						break;
					case 'D':
						y--;
						break;
					default:
						System.out.println("Error!");
						return;
				}
				
				String coord = x + ";" + y;
				map.put(coord, steps);
			}
		}
		
		
		String[] str2Splitted = str2.split(",");
		
		x = 0;
		y = 0;
		steps = 0;
		int min = Integer.MAX_VALUE;
		for (int i=0; i<str2Splitted.length; i++) {
			char command = str2Splitted[i].charAt(0);
			int value = Integer.parseInt(str2Splitted[i].substring(1, str2Splitted[i].length()));
			
			for (int j = 0; j < value; j++ ) {
				steps++;
				switch (command) {
					case 'R':
						x++;
						break;
					case 'L':
						x--;
						break;
					case 'U':
						y++;
						break;
					case 'D':
						y--;
						break;
					default:
						System.out.println("Error!");
						return;
				}
			
				String coord = x + ";" + y;
				
				if (map.containsKey(coord)) {
					int stepSum = map.get(coord) + steps;
					if (stepSum < min) {
						min = stepSum;
					}
				}
			}
		}
		
		System.out.println(min);
	}
}
