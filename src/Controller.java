
public class Controller {

	// ����� ����
	public static int InputMoney = 0;// �������ڰ� ������ �� ��
	public static String orderMenu;// ���� ������� �ֹ��޴�
	public static int change;// ���� ������� �Ž�����
	// ���� ���� ����
	private static final int lattePrice = 400;
	private static final int HotPrice = 350;
	private static final int AmePrice = 300;

	// ���� ����ڰ� ������ �� ����-���� �� Ȯ��
	public static void setInput(int value) {
		InputMoney = value;
	}

	// �ֹ��ޱ�
	public static void setOrder(String order) {
		orderMenu = order;
	}

	// �ֹ�Ȯ��
	public static String getOrder() {
		return orderMenu;
	}

	// ���� ����
	public static int getLatteprice() {
		return lattePrice;
	}

	public static int getHotprice() {
		return HotPrice;
	}

	public static int getAmeprice() {
		return AmePrice;
	}

	// ���� �ֹ��� ���Ḧ ���� �� �ִ��� Ȯ��
	public static boolean possibleToMake(String orderMenu) {
		if (orderMenu == "�Ƹ޸�ī��") {
			if (Container.getCountCoffeePowder() > 0 && Container.getCountWater() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else if (orderMenu == "ī���") {
			if (Container.getCountCoffeePowder() > 0 && Container.getCountMilk() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else if (orderMenu == "������") {
			if (Container.getCountCocoaPowder() > 0 && Container.getCountMilk() > 0 && Container.getCup() > 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	// �Ž����� ���
	public static void CalChange(String order) {

		switch (order) {
		case "ī���":
			change = InputMoney - lattePrice;
			break;
		case "�Ƹ޸�ī��":
			change = InputMoney - AmePrice;
			break;
		case "������":
			change = InputMoney - HotPrice;
			break;
		case "�ܵ���ȯ":
			change = InputMoney;
		}
	}

	//���� Stack�� �ִ� ������ �Ž������� �� �� �ִ��� �˻�
	public static boolean PossibleToChange() {

		int countFirst;
		int countSecond;

		if (Stack.getTotalMoneyInStack() >= change) {

			countFirst = change / 500;// �ʿ��� 500��¥�� ����
			if (Stack.getCoinStack500() >= countFirst) {
			} else if (Stack.getCoinStack100() >= countFirst * 5) {

			} else if (Stack.getCoinStack50() >= countFirst * 10) {

			} else if (Stack.getCoinStack10() >= countFirst * 50) {
			} else {
				change = InputMoney;// �Ž����� �� �� ����
				return false;
			}

			countSecond = change % 500;// ������ ��
			countFirst = countSecond / 100;// �ʿ��� 100��¥�� ����
			if (Stack.getCoinStack100() >= countFirst) {

			} else if (Stack.getCoinStack50() >= countFirst * 2) {

			} else if (Stack.getCoinStack10() >= countFirst * 10) {

			} else {
				change = InputMoney;
				return false;
			}
			countFirst = countSecond % 100;//������ ��
			countSecond = countFirst / 50;//�ʿ��� 50��¥�� ����
			if (Stack.getCoinStack50() >= countSecond) {

			} else if (Stack.getCoinStack10() >= countSecond * 5) {

			} else {
				change = InputMoney;
				return false;
			}
			countFirst = countSecond % 50;//������ ��
			countSecond = countFirst / 10;//�ʿ��� 10��¥�� ����
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

	//�Ž������� �� �� ����ϴ� ����
	public static void usedChangeCoin(String changeOutput) {
		if (changeOutput == "�ܵ���ȯ") {
			//�Ž������� ��ȯ�� ���Ǵ� ���� ������ �ʿ��� ����
			int countFirst;
			int countSecond;

			countFirst = change / 500;// �ʿ��� 500��¥�� ����
			if (Stack.getCoinStack500() >= countFirst) {//�Ž����� ��ȯ�� �ʿ��� 500��¥�� ������ŭ ������
				Stack.useCoin(500, countFirst);//�� ��ŭ 500��¥���� ����Ѵ�.
			} else if (Stack.getCoinStack100() >= countFirst * 5) {//500��¥���� �׸�ŭ ������
				Stack.useCoin(100, countFirst * 5);//��� 100��¥���� �ʿ��� 500��¥�� ����*5����ŭ ����Ѵ�.
			} else if (Stack.getCoinStack50() >= countFirst * 10) {//100��¥���� �׸�ŭ ������
				Stack.useCoin(50, countFirst * 10);//��� 50��¥���� �ʿ��� 500��¥�� ����*10�� ��ŭ ����Ѵ�.
			} else if (Stack.getCoinStack10() >= countFirst * 50) {//50��¥���� �׸�ŭ ������
				Stack.useCoin(10, countFirst * 50);//��� 10��¥���� �ʿ��� 500��¥�� ����*50����ŭ ����Ѵ�.
			}
			//���� ���� ���� ������ �Ž������� �ʿ��� ���� ����Ѵ�.
			countSecond = change % 500;// ������ ��
			countFirst = countSecond / 100;// �ʿ��� 100��¥�� ����
			if (Stack.getCoinStack100() >= countFirst) {
				Stack.useCoin(100, countFirst);
			} else if (Stack.getCoinStack50() >= countFirst * 2) {
				Stack.useCoin(50, countFirst * 2);
			} else if (Stack.getCoinStack10() >= countFirst * 10) {
				Stack.useCoin(10, countFirst * 10);
			}
			countFirst = countSecond % 100;//�������� 
			countSecond = countFirst / 50;//�ʿ��� 50��¥�� ����
			if (Stack.getCoinStack50() >= countSecond) {
				Stack.useCoin(50, countSecond);
			} else if (Stack.getCoinStack10() >= countSecond * 5) {
				Stack.useCoin(10, countSecond * 5);
			}
			countFirst = countSecond % 50;//������ ��
			countSecond = countFirst / 10;//�ʿ��� 10��¥�� ����
			if (Stack.getCoinStack10() >= countSecond)
				Stack.useCoin(10, countSecond);

		}
	}

	// �ֹ��� �޾��� �� �Ͼ�� �ϵ�
	public static void SelectMenu(String order) {
		setOrder(order);// �ֹ��ޱ�
		CalChange(order);// ������ ���� �ֹ����� �Ž����� ���
		if (PossibleToChange()) {// �Ž������� �� �� �ִ� ���
			if (possibleToMake(order)) {// ��ᰡ ������
				MixPipe.useIngredient(order);// ��� ���
				MixPipe.makeDrink(order);// ���Ḹ���
				setInput(change);// ������ ���� �Ž������� ��ȯ
				MyFront.moneyLED.setText(Integer.toString(Controller.InputMoney));// ������
																					// ����
																					// ǥ��
				MyFront.LED();// �� ������ ������ LED�� �ѱ�
			} else
				MyFront.Coffee.setText("���Ḧ ���� �� �����ϴ�.");
		} else
			MyFront.Coffee.setText("�Ž������� �� �� �����ϴ�.");
	}

}
