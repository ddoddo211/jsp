package sum;

public class CalculationLogic {
	
	public static void main(String[] args){
		CalculationLogic logic= new CalculationLogic();
		int start = 1;
		int end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		if(sumResult == 55){
			System.out.println("정답");
		} else {
			System.out.println("오답");
		}
	}

	public int sumBetweenTwoNumbers(int start, int end) {
		int max = Math.max(start, end);
		int min = Math.min(start, end);
		int sum = 0;
		for(int num = min; num<=max;num++){
			sum +=num;
		}
		return sum;
	}
	
	
	
}
