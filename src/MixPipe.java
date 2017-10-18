import java.util.concurrent.TimeUnit;

public class MixPipe {

	// 음료 재료 사용
	public static void useIngredient(String menu) {
		switch (menu) {
		case "카페라떼":
			Container.setCountCoffeePowder();
			Container.setCountMilk();
			Container.setCountCup();
			break;
		case "아메리카노":
			Container.setCountCoffeePowder();
			Container.setCountWater();
			Container.setCountCup();
			break;
		case "핫초코":
			Container.setCountCocoaPowder();
			Container.setCountMilk();
			Container.setCountCup();
			break;
		}
	}

	// 음료제작
	public static void makeDrink(String orderMenu) {
		try {
			TimeUnit.SECONDS.sleep(2);
			MyFront.Coffee.setText(orderMenu + " 나왔습니다.");
		} catch (InterruptedException e) {
		}
	}
}
