import java.util.concurrent.TimeUnit;

public class MixPipe {

	// ���� ��� ���
	public static void useIngredient(String menu) {
		switch (menu) {
		case "ī���":
			Container.setCountCoffeePowder();
			Container.setCountMilk();
			Container.setCountCup();
			break;
		case "�Ƹ޸�ī��":
			Container.setCountCoffeePowder();
			Container.setCountWater();
			Container.setCountCup();
			break;
		case "������":
			Container.setCountCocoaPowder();
			Container.setCountMilk();
			Container.setCountCup();
			break;
		}
	}

	// ��������
	public static void makeDrink(String orderMenu) {
		try {
			TimeUnit.SECONDS.sleep(2);
			MyFront.Coffee.setText(orderMenu + " ���Խ��ϴ�.");
		} catch (InterruptedException e) {
		}
	}
}
