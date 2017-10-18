
public class Container {
	// ��� ����
	private static int countCoffeePowder = 30;
	private static int countWater = 30;
	private static int countMilk = 30;
	private static int countCocoaPowder =30;
	private static int countCup = 30;

	// ���� ���Ȯ��
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

	// ���� ���ۿ� ���� �� ���� ����
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

	// ��� ������ �߰��� ���
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
