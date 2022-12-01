package Day4;



public class Part2 {

	public static void main(String[] args) {
		final int minValue = 138241;
		final int maxValue = 674034;
		
		int counter = 0;
		for (int pass=minValue; pass<=maxValue; pass++) {
			int[] pairs = new int[10];
			char[] digits = String.valueOf(pass).toCharArray();
			
			//rule 1 and 2 check
			boolean pairExist = false;
			boolean monotonIncrease = true;
			for (int i=0; i<5; i++) {
				if (digits[i] == digits[i+1]) {
					pairExist = true;
					pairs[Integer.parseInt(String.valueOf(digits[i]))]++;
				}
				
				if (Integer.parseInt(String.valueOf(digits[i+1])) < Integer.parseInt(String.valueOf(digits[i]))) {
					monotonIncrease = false;
					break;
				}
			}
			
			boolean pairOneExist = false;
			for (int pr : pairs) {
				if (pr == 1) {
					pairOneExist = true;
					break;
				}
			}
			
			if (!pairExist || !monotonIncrease || !pairOneExist) {
				continue;
			}
			
			counter++;
			
		}
		
		System.out.println(counter);
	}

}
