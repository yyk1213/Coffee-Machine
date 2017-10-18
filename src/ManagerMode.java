import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel MPanel = new JPanel();// ��ü�г�
	public static JPanel MPanel1 = new JPanel();// ���� �г�

	// �� ����
	public static JButton Stack1000 = new JButton("1000 stack");// 1000�� ���� ǥ��
	public static JTextField S1000 = new JTextField();// 1000�� ���� ����
	public static JButton Stack500 = new JButton("500 stack");
	public static JTextField S500 = new JTextField();// 500�� ���� ����
	public static JButton Stack100 = new JButton("100 stack");
	public static JTextField S100 = new JTextField();// 100�� ���� ����
	public static JButton Stack50 = new JButton("50 stack");
	public static JTextField S50 = new JTextField();// 50�� ���� ����
	public static JButton Stack10 = new JButton("10 stack");
	public static JTextField S10 = new JTextField();// 10�� ���� ����
	// ��� ����
	public static JButton CoffeePowder = new JButton("Coffee Powder");
	public static JTextField CP = new JTextField();
	public static JButton Water = new JButton("Water");
	public static JTextField W = new JTextField();
	public static JButton Milk = new JButton("Milk");
	public static JTextField M = new JTextField();
	public static JButton Cocoa = new JButton("Cocoa Powder");
	public static JTextField CC = new JTextField();
	public static JButton Cup = new JButton("Cup");
	public static JTextField C = new JTextField();
	// �� �Ǵ� ��Ḧ �߰���ų ������ ���� TextField
	public static JTextField Count = new JTextField();
	// ������ sum�� �����ϴ� Ȯ�ι�ư
	public static JButton Okay = new JButton("Ȯ��");
	// ������ ��� ����
	public static int sum = 0;

	// ����ǥ��
	public static void Num() {
		S1000.setText(Integer.toString(Stack.getNoteStack1000()));
		S500.setText(Integer.toString(Stack.getCoinStack500()));
		S100.setText(Integer.toString(Stack.getCoinStack100()));
		S50.setText(Integer.toString(Stack.getCoinStack50()));
		S10.setText(Integer.toString(Stack.getCoinStack10()));

		CP.setText(Integer.toString(Container.getCountCoffeePowder()));
		W.setText(Integer.toString(Container.getCountWater()));
		M.setText(Integer.toString(Container.getCountMilk()));
		CC.setText(Integer.toString(Container.getCountCocoaPowder()));
		C.setText(Integer.toString(Container.getCup()));
	}

	public ManagerMode() {

		setSize(300, 400);// ȭ��ũ��
		setTitle("�����ڸ��");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);// ȭ�� ���̰�

		MPanel1.setLayout(new GridLayout(0, 2));

		// �гο� ��ư �߰�
		MPanel1.add(Stack1000);
		MPanel1.add(S1000);
		MPanel1.add(Stack500);
		MPanel1.add(S500);
		MPanel1.add(Stack100);
		MPanel1.add(S100);
		MPanel1.add(Stack50);
		MPanel1.add(S50);
		MPanel1.add(Stack10);
		MPanel1.add(S10);
		MPanel1.add(CoffeePowder);
		MPanel1.add(CP);
		MPanel1.add(Water);
		MPanel1.add(W);
		MPanel1.add(Milk);
		MPanel1.add(M);
		MPanel1.add(Cocoa);
		MPanel1.add(CC);
		MPanel1.add(Cup);
		MPanel1.add(C);
		MPanel1.add(Count);
		MPanel1.add(Okay);

		MPanel.add(MPanel1);

		add(MPanel);
		
		// Okay ��ư�� ������ Count�� ���� ������ sum�� ����ȴ�.
		Okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = Count.getText();
				sum = Integer.parseInt(source);
			}
		});

		// ���� ���� ����� ��ư�� ������ sum�� ���� ���� ������ ������ ��������.
		Stack1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.saveMoney(1000, sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Stack500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.saveMoney(500, sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Stack100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.saveMoney(100, sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Stack50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.saveMoney(50, sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Stack10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack.saveMoney(10, sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		CoffeePowder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container.setIngredient("CoffeePowder", sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Water.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container.setIngredient("Water", sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Milk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container.setIngredient("Milk", sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});
		Cocoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container.setIngredient("Cocoa", sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});
		Cup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container.setIngredient("Cup", sum);
				Num();
				sum = 0;
				Count.setText(Integer.toString(sum));
			}
		});

		Num();
		setVisible(true);
	}
}
