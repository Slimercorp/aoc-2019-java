package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Part1 {

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
		Set<String> set = new HashSet<>();
		for (int i=0; i<str1Splitted.length; i++) {
			char command = str1Splitted[i].charAt(0);
			int value = Integer.parseInt(str1Splitted[i].substring(1, str1Splitted[i].length()));
			
			for (int j = 0; j < value; j++ ) {
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
				set.add(coord);
			}
		}
		
		
		String[] str2Splitted = str2.split(",");
		
		x = 0;
		y = 0;
		int min = Integer.MAX_VALUE;
		for (int i=0; i<str2Splitted.length; i++) {
			char command = str2Splitted[i].charAt(0);
			int value = Integer.parseInt(str2Splitted[i].substring(1, str2Splitted[i].length()));
			
			for (int j = 0; j < value; j++ ) {
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
				int distance = Math.abs(x) + Math.abs(y);
				if (set.contains(coord) && (distance < min)) {
					min = distance;
				}
			}
		}
		
		System.out.println("minimum = " + min);
	}
}
