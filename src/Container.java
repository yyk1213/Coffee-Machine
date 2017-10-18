
public class Container {
	// 재료 수량
	private static int countCoffeePowder = 30;
	private static int countWater = 30;
	private static int countMilk = 30;
	private static int countCocoaPowder =30;
	private static int countCup = 30;

	// 음료 재고확인
	public static int getCountCoffeePowder() {
		return countCoffeePowder;
	}

	public static int getCountWater() {
		return countWater;
	}

	public static int getCountMilk() {
		return countMilk;
	}

	public static int getCountCocoaPowder() {
		return countCocoaPowder;
	}

	public static int getCup() {
		return countCup;
	}

	// 음료 제작에 사용될 때 수량 감소
	public static void setCountCoffeePowder() {
		Container.countCoffeePowder--;
	}

	public static void setCountWater() {
		Container.countWater--;
	}

	public static void setCountMilk() {
		Container.countMilk--;
	}

	public static void setCountCocoaPowder() {
		Container.countCocoaPowder--;
	}

	public static void setCountCup() {
		Container.countCup--;
	}

	// 재료 수량을 추가할 경우
	public static void setIngredient(String Ingredient, int a) {
		switch (Ingredient) {
		case "CoffeePowder":
			countCoffeePowder += a;
			break;
		case "Water":
			countWater += a;
			break;
		case "Milk":
			countMilk += a;
			break;
		case "Cocoa":
			countCocoaPowder += a;
			break;
		case "Cup":
			countCup += a;
			break;
		}
	}

}
