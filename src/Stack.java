
public class Stack {
	// 현재 스택에 들어있는 돈의 갯수
	private static int noteStack1000 = 10;
	private static int coinStack500 = 30;
	private static int coinStack100 = 30;
	private static int coinStack50 = 30;
	private static int coinStack10 = 30;

	private static int totalMoneyInMoneyStack;// 현재 스택에 있는 돈의 양

	public static int getNoteStack1000() {
		return noteStack1000;
	}

	public static int getCoinStack500() {
		return coinStack500;
	}

	public static int getCoinStack100() {
		return coinStack100;
	}

	public static int getCoinStack50() {
		return coinStack50;
	}

	public static int getCoinStack10() {
		return coinStack10;
	}

	public static void setMoneyStack(int value) {
		switch (value) {
		case 1000:
			noteStack1000++;
			break;
		case 500:
			coinStack500++;
			break;
		case 100:
			coinStack100++;
			break;
		case 50:
			coinStack50++;
			break;
		case 10:
			coinStack10++;
			break;
		}
	}

	// 관리자 모드에서 돈을 새로 넣을 때 사용하는 함수-들어온 돈 저장
	public static void saveMoney(int money, int count) {
		switch (money) {
		case 1000:
			noteStack1000 += count;
			break;
		case 500:
			coinStack500 += count;
			break;
		case 100:
			coinStack100 += count;
			break;
		case 50:
			coinStack50 += count;
			break;
		case 10:
			coinStack10 += count;
			break;
		}
	}

	// 거스름돈으로 동전을 사용할 경우
	public static void useCoin(int Coin, int CoinCount) {
		if (Coin == 10)
			coinStack10 -= CoinCount;
		else if (Coin == 50)
			coinStack50 -= CoinCount;
		else if (Coin == 100)
			coinStack100 -= CoinCount;
		else if (Coin == 500)
			coinStack500 -= CoinCount;
	}

	// 스택에 있는 돈-잔고 업데이트
	public static int getTotalMoneyInStack() {
		totalMoneyInMoneyStack = noteStack1000 * 1000 + coinStack10 * 10 + coinStack50 * 50 + coinStack100 * 100
				+ coinStack500 * 500;
		return totalMoneyInMoneyStack;
	}

}