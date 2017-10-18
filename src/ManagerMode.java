import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel MPanel = new JPanel();// 전체패널
	public static JPanel MPanel1 = new JPanel();// 수량 패널

	// 돈 갯수
	public static JButton Stack1000 = new JButton("1000 stack");// 1000원 갯수 표현
	public static JTextField S1000 = new JTextField();// 1000원 스택 갯수
	public static JButton Stack500 = new JButton("500 stack");
	public static JTextField S500 = new JTextField();// 500원 스택 갯수
	public static JButton Stack100 = new JButton("100 stack");
	public static JTextField S100 = new JTextField();// 100원 스택 갯수
	public static JButton Stack50 = new JButton("50 stack");
	public static JTextField S50 = new JTextField();// 50원 스택 갯수
	public static JButton Stack10 = new JButton("10 stack");
	public static JTextField S10 = new JTextField();// 10원 스택 갯수
	// 재료 수량
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
	// 돈 또는 재료를 추가시킬 수량을 적는 TextField
	public static JTextField Count = new JTextField();
	// 수량을 sum에 저장하는 확인버튼
	public static JButton Okay = new JButton("확인");
	// 수량을 담는 변수
	public static int sum = 0;

	// 수량표현
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

		setSize(300, 400);// 화면크기
		setTitle("관리자모드");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);// 화면 보이게

		MPanel1.setLayout(new GridLayout(0, 2));

		// 패널에 버튼 추가
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
		
		// Okay 버튼을 누르면 Count에 적은 수량이 sum에 저장된다.
		Okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = Count.getText();
				sum = Integer.parseInt(source);
			}
		});

		// 각각 돈과 재료의 버튼을 누르면 sum에 넣은 값이 기존의 수량에 더해진다.
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
