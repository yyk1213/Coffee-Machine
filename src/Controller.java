
public class Controller {

	// 사용자 변수
	public static int InputMoney = 0;// 현재사용자가 투입한 총 돈
	public static String orderMenu;// 현재 사용자의 주문메뉴
	public static int change;// 현재 사용자의 거스름돈
	// 음료 가격 저장
	private static final int lattePrice = 400;
	private static final int HotPrice = 350;
	private static final int AmePrice = 300;

	// 현재 사용자가 투입한 돈 변경-들어온 돈 확인
	public static void setInput(int value) {
		InputMoney = value;
	}

	// 주문받기
	public static void setOrder(String order) {
		orderMenu = order;
	}

	// 주문확인
	public static String getOrder() {
		return orderMenu;
	}

	// 가격 접근
	public static int getLatteprice() {
		return lattePrice;
	}

	public static int getHotprice() {
		return HotPrice;
	}

	public static int getAmeprice() {
		return AmePrice;
	}

	// 고객이 주문한 음료를 만들 수 있는지 확인
	public static boolean possibleToMake(String orderMenu) {
		if (orderMenu == "아메리카노") {
			if (Container.getCountCoffeePowder() > 0 && Container.getCountWater() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else if (orderMenu == "카페라떼") {
			if (Container.getCountCoffeePowder() > 0 && Container.getCountMilk() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else if (orderMenu == "핫초코") {
			if (Container.getCountCocoaPowder() > 0 && Container.getCountMilk() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	// 거스름돈 계산
	public static void CalChange(String order) {

		switch (order) {
		case "카페라떼":
			change = InputMoney - lattePrice;
			break;
		case "아메리카노":
			change = InputMoney - AmePrice;
			break;
		case "핫초코":
			change = InputMoney - HotPrice;
			break;
		case "잔돈반환":
			change = InputMoney;
		}
	}

	//현재 Stack에 있는 돈으로 거스름돈을 줄 수 있는지 검사
	public static boolean PossibleToChange() {

		int countFirst;
		int countSecond;

		if (Stack.getTotalMoneyInStack() >= change) {

			countFirst = change / 500;// 필요한 500원짜리 개수
			if (Stack.getCoinStack500() >= countFirst) {
			} else if (Stack.getCoinStack100() >= countFirst * 5) {

			} else if (Stack.getCoinStack50() >= countFirst * 10) {

			} else if (Stack.getCoinStack10() >= countFirst * 50) {
			} else {
				change = InputMoney;// 거스름돈 줄 수 없음
				return false;
			}

			countSecond = change % 500;// 나머지 돈
			countFirst = countSecond / 100;// 필요한 100원짜리 개수
			if (Stack.getCoinStack100() >= countFirst) {

			} else if (Stack.getCoinStack50() >= countFirst * 2) {

			} else if (Stack.getCoinStack10() >= countFirst * 10) {

			} else {
				change = InputMoney;
				return false;
			}
			countFirst = countSecond % 100;//나머지 돈
			countSecond = countFirst / 50;//필요한 50원짜리 개수
			if (Stack.getCoinStack50() >= countSecond) {

			} else if (Stack.getCoinStack10() >= countSecond * 5) {

			} else {
				change = InputMoney;
				return false;
			}
			countFirst = countSecond % 50;//나머지 돈
			countSecond = countFirst / 10;//필요한 10원짜리 개수
			if (Stack.getCoinStack10() >= countSecond) {
			} else {
				change = InputMoney;
				return false;
			}
			return true;
		} else {
			change = InputMoney;
			return false;
		}

	}

	//거스름돈을 줄 때 사용하는 동전
	public static void usedChangeCoin(String changeOutput) {
		if (changeOutput == "잔돈반환") {
			//거스름돈에 반환에 사용되는 동전 갯수에 필요한 변수
			int countFirst;
			int countSecond;

			countFirst = change / 500;// 필요한 500원짜리 개수
			if (Stack.getCoinStack500() >= countFirst) {//거스름돈 반환에 필요한 500원짜리 갯수만큼 있으면
				Stack.useCoin(500, countFirst);//그 만큼 500원짜리를 사용한다.
			} else if (Stack.getCoinStack100() >= countFirst * 5) {//500원짜리가 그만큼 없으면
				Stack.useCoin(100, countFirst * 5);//대신 100원짜리를 필요한 500원짜리 갯수*5개만큼 사용한다.
			} else if (Stack.getCoinStack50() >= countFirst * 10) {//100원짜리가 그만큼 없으면
				Stack.useCoin(50, countFirst * 10);//대신 50원짜리를 필요한 500원짜리 갯수*10개 만큼 사용한다.
			} else if (Stack.getCoinStack10() >= countFirst * 50) {//50원짜리가 그만큼 없으면
				Stack.useCoin(10, countFirst * 50);//대신 10원짜리를 필요한 500원짜리 갯수*50개만큼 사용한다.
			}
			//위와 같은 논리로 나머지 거스름돈에 필요한 돈을 계산한다.
			countSecond = change % 500;// 나머지 돈
			countFirst = countSecond / 100;// 필요한 100원짜리 개수
			if (Stack.getCoinStack100() >= countFirst) {
				Stack.useCoin(100, countFirst);
			} else if (Stack.getCoinStack50() >= countFirst * 2) {
				Stack.useCoin(50, countFirst * 2);
			} else if (Stack.getCoinStack10() >= countFirst * 10) {
				Stack.useCoin(10, countFirst * 10);
			}
			countFirst = countSecond % 100;//나머지돈 
			countSecond = countFirst / 50;//필요한 50원짜리 개수
			if (Stack.getCoinStack50() >= countSecond) {
				Stack.useCoin(50, countSecond);
			} else if (Stack.getCoinStack10() >= countSecond * 5) {
				Stack.useCoin(10, countSecond * 5);
			}
			countFirst = countSecond % 50;//나머지 돈
			countSecond = countFirst / 10;//필요한 10원짜리 개수
			if (Stack.getCoinStack10() >= countSecond)
				Stack.useCoin(10, countSecond);

		}
	}

	// 주문을 받았을 때 일어나는 일들
	public static void SelectMenu(String order) {
		setOrder(order);// 주문받기
		CalChange(order);// 투입한 돈과 주문으로 거스름돈 계산
		if (PossibleToChange()) {// 거스름돈을 줄 수 있는 경우
			if (possibleToMake(order)) {// 재료가 있으면
				MixPipe.useIngredient(order);// 재료 사용
				MixPipe.makeDrink(order);// 음료만들기
				setInput(change);// 투입한 돈을 거스름돈을 변환
				MyFront.moneyLED.setText(Integer.toString(Controller.InputMoney));// 투입한
																					// 돈을
																					// 표시
				MyFront.LED();// 그 돈으로 가능한 LED불 켜기
			} else
				MyFront.Coffee.setText("음료를 만들 수 없습니다.");
		} else
			MyFront.Coffee.setText("거스름돈을 줄 수 없습니다.");
	}

}
