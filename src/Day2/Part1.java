package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();
		String[] strSep = str.split(",");
		
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i<strSep.length; i++) {
			data.add(Integer.parseInt(strSep[i]));
		}
		
		data.set(1, 12);
		data.set(2, 2);
		System.out.println(getAnswer(data));
		
		scan.close();
	}

	
	public static int getAnswer(List<Integer> data) {
		int pointer = 0;
		while (true) {
			int operand1 = 0;
			int operand2 = 0;
			
			if (data.get(pointer) != 99) {
				operand1 = data.get(data.get(pointer+1));
				operand2 = data.get(data.get(pointer+2));
			}
			
			switch (data.get(pointer)) {
				case 1:
					data.set(data.get(pointer+3), operand1 + operand2);
					break;
				case 2:
					data.set(data.get(pointer+3), operand1 * operand2);
					break;
				case 99:
					return data.get(0);
				default:
					System.out.println("Error!");
					return -1;
			}
			
			pointer += 4;
		}
	}
}
