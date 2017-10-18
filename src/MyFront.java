import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFront extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();// 전체 패널
	public static JPanel panel0 = new JPanel();// 제목 패널
	public static JPanel panel1 = new JPanel();// 선택 패널
	public static JPanel panel2 = new JPanel();// 음료 나오는 패널
	// 상단-제목
	public static JLabel start = new JLabel("Coffee Machine");
	// 음료종류
	public static JButton LBTN = new JButton("카페라떼");// 라떼 버튼
	public static JButton ABTN = new JButton("아메리카노");// 아메리카노 버튼
	public static JButton HBTN = new JButton("핫초코");// 핫초코 버튼
	// 음료가격버튼
	public static JLabel LPrice = new JLabel("400원");// 라뗴 가격 버튼
	public static JLabel APrice = new JLabel("300원");// 아메리카노 가격 버튼
	public static JLabel HPrice = new JLabel("350원");// 핫초코 가격 버튼
	// 음료 LED
	public static JLabel LLED = new JLabel("○");
	public static JLabel ALED = new JLabel("○");
	public static JLabel HLED = new JLabel("○");
	// 돈 버튼
	public static JButton CWBTN = new JButton(Integer.toString(1000));
	public static JButton OBBTN = new JButton(Integer.toString(500));
	public static JButton BBTN = new JButton(Integer.toString(100));
	public static JButton OSBTN = new JButton(Integer.toString(50));
	public static JButton SBTN = new JButton(Integer.toString(10));
	// 음료 배출
	public static JLabel Coffee = new JLabel("커 피 배 출");
	// 관리자모드 전환 버튼
	public static JButton ManagerMode = new JButton("관리자모드");
	// 잔돈반환버튼
	public static JButton ChangeBTN = new JButton("잔돈반환");
	// 투입 돈 LED표시등
	public static JTextPane moneyLED = new JTextPane();
	// 거스름돈 표시등
	public static JTextPane ChangeLED = new JTextPane();

	// 사용자가 입력한 돈을 LED에 표시하는 메서드
	public static void Money() {

		class CalcHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String source = (String) e.getActionCommand();
				int value;

				if (source != null) {// 돈 버튼이 눌렸을 때
					value = Integer.parseInt(source);// 돈 버튼의 String값을 int로 바꿔서
														// value에 저장
					Stack.setMoneyStack(value);// 들어온 돈을 stack에 저장
					Controller.InputMoney += value;// 들어온 돈으로 InputMoney를 설정
					moneyLED.setText(Integer.toString(Controller.InputMoney));// 현재
																				// 투입된
																				// 돈을
																				// moneyLED에
																				// 표시
					LED();// 돈에 맞게 LED가 켜짐
				}
			}
		}
		CalcHandler ch = new CalcHandler();

		CWBTN.addActionListener(ch);
		OBBTN.addActionListener(ch);
		BBTN.addActionListener(ch);
		OSBTN.addActionListener(ch);
		SBTN.addActionListener(ch);
	}

	// 돈에 따라 주문가능한 LED켜기
	public static void LED() {
		if (Controller.InputMoney >= 400) {
			LLED.setText("●");
			ALED.setText("●");
			HLED.setText("●");
		} else if (Controller.InputMoney < 400 && Controller.InputMoney >= 350) {
			LLED.setText("○");
			ALED.setText("●");
			HLED.setText("●");
		} else if (Controller.InputMoney >= 300 && Controller.InputMoney < 350) {
			ALED.setText("●");
			LLED.setText("○");
			HLED.setText("○");
		} else {
			ALED.setText("○");
			LLED.setText("○");
			HLED.setText("○");
		}
	}

	// 음료선택 받으면 일어나는 메소드
	public static void Select() {

		class Select implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String source = e.getActionCommand();

				if (source == "카페라떼" || source == "아메리카노" || source == "핫초코") {
					if (source == "카페라떼" && LLED.getText() == "●")
						Controller.SelectMenu(source);
					else if (source == "아메리카노" && ALED.getText() == "●")
						Controller.SelectMenu(source);
					else if (source == "핫초코" && HLED.getText() == "●")
						Controller.SelectMenu(source);//메뉴버튼이 눌린 경우에는 Controller의 SelectMenu함수를 사용한다.
				} else if (source == "잔돈반환") {
					Controller.CalChange(source);//거스름돈 계산
					if (Controller.PossibleToChange()) {//거스름돈 줄 수 있으면
						Controller.usedChangeCoin(source);//거스름돈에 사용되는 동전 
						ChangeLED.setText(Integer.toString(Controller.change));//거스름돈을 LED에 반환
						moneyLED.setText("0");//현재 투입된 돈을 0으로 표시
						Controller.setInput(0);//현재 투입된 돈을 0으로 설정
						LED();//LED끄기
					}
				}
			}
		}

		Select sh = new Select();//객체를 만들어서
		
		//카페라떼,아메리카노, 핫초코, 잔돈반환 버튼의 클릭 이벤트로 준다.
		LBTN.addActionListener(sh);
		ABTN.addActionListener(sh);
		HBTN.addActionListener(sh);
		ChangeBTN.addActionListener(sh);
	}

	public MyFront() {

		setSize(350, 350);// 화면크기
		setTitle("Coffee Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);// 화면 보이게

		// 화면 조정
		panel1.setLayout(new GridLayout(0, 3));
		ABTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		APrice.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		ALED.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		OBBTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		SBTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		// 패널에 버튼 추가
		panel0.add(start);
		panel1.add(LBTN);
		panel1.add(ABTN);
		panel1.add(HBTN);
		panel1.add(LPrice);
		panel1.add(APrice);
		panel1.add(HPrice);
		panel1.add(LLED);
		panel1.add(ALED);
		panel1.add(HLED);
		panel1.add(CWBTN);
		panel1.add(OBBTN);
		panel1.add(BBTN);
		panel1.add(OSBTN);
		panel1.add(SBTN);
		panel1.add(moneyLED);
		panel1.add(ChangeBTN);
		panel1.add(ChangeLED);
		panel1.add(ManagerMode);
		panel2.add(Coffee);

		panel.add(panel0);
		panel.add(panel1);
		panel.add(panel2);

		add(panel);
		Money();
		Select();

		ManagerMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerMode();//매니저모드 객체 생성
			}
		});

		setVisible(true);
	}
}

class FrontMain {
	public static void main(String[] args) {
		new MyFront();
	}
}
