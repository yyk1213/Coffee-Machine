import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFront extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();// ��ü �г�
	public static JPanel panel0 = new JPanel();// ���� �г�
	public static JPanel panel1 = new JPanel();// ���� �г�
	public static JPanel panel2 = new JPanel();// ���� ������ �г�
	// ���-����
	public static JLabel start = new JLabel("Coffee Machine");
	// ��������
	public static JButton LBTN = new JButton("ī���");// �� ��ư
	public static JButton ABTN = new JButton("�Ƹ޸�ī��");// �Ƹ޸�ī�� ��ư
	public static JButton HBTN = new JButton("������");// ������ ��ư
	// ���ᰡ�ݹ�ư
	public static JLabel LPrice = new JLabel("400��");// ��� ���� ��ư
	public static JLabel APrice = new JLabel("300��");// �Ƹ޸�ī�� ���� ��ư
	public static JLabel HPrice = new JLabel("350��");// ������ ���� ��ư
	// ���� LED
	public static JLabel LLED = new JLabel("��");
	public static JLabel ALED = new JLabel("��");
	public static JLabel HLED = new JLabel("��");
	// �� ��ư
	public static JButton CWBTN = new JButton(Integer.toString(1000));
	public static JButton OBBTN = new JButton(Integer.toString(500));
	public static JButton BBTN = new JButton(Integer.toString(100));
	public static JButton OSBTN = new JButton(Integer.toString(50));
	public static JButton SBTN = new JButton(Integer.toString(10));
	// ���� ����
	public static JLabel Coffee = new JLabel("Ŀ �� �� ��");
	// �����ڸ�� ��ȯ ��ư
	public static JButton ManagerMode = new JButton("�����ڸ��");
	// �ܵ���ȯ��ư
	public static JButton ChangeBTN = new JButton("�ܵ���ȯ");
	// ���� �� LEDǥ�õ�
	public static JTextPane moneyLED = new JTextPane();
	// �Ž����� ǥ�õ�
	public static JTextPane ChangeLED = new JTextPane();

	// ����ڰ� �Է��� ���� LED�� ǥ���ϴ� �޼���
	public static void Money() {

		class CalcHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String source = (String) e.getActionCommand();
				int value;

				if (source != null) {// �� ��ư�� ������ ��
					value = Integer.parseInt(source);// �� ��ư�� String���� int�� �ٲ㼭
														// value�� ����
					Stack.setMoneyStack(value);// ���� ���� stack�� ����
					Controller.InputMoney += value;// ���� ������ InputMoney�� ����
					moneyLED.setText(Integer.toString(Controller.InputMoney));// ����
																				// ���Ե�
																				// ����
																				// moneyLED��
																				// ǥ��
					LED();// ���� �°� LED�� ����
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

	// ���� ���� �ֹ������� LED�ѱ�
	public static void LED() {
		if (Controller.InputMoney >= 400) {
			LLED.setText("��");
			ALED.setText("��");
			HLED.setText("��");
		} else if (Controller.InputMoney < 400 && Controller.InputMoney >= 350) {
			LLED.setText("��");
			ALED.setText("��");
			HLED.setText("��");
		} else if (Controller.InputMoney >= 300 && Controller.InputMoney < 350) {
			ALED.setText("��");
			LLED.setText("��");
			HLED.setText("��");
		} else {
			ALED.setText("��");
			LLED.setText("��");
			HLED.setText("��");
		}
	}

	// ���ἱ�� ������ �Ͼ�� �޼ҵ�
	public static void Select() {

		class Select implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String source = e.getActionCommand();

				if (source == "ī���" || source == "�Ƹ޸�ī��" || source == "������") {
					if (source == "ī���" && LLED.getText() == "��")
						Controller.SelectMenu(source);
					else if (source == "�Ƹ޸�ī��" && ALED.getText() == "��")
						Controller.SelectMenu(source);
					else if (source == "������" && HLED.getText() == "��")
						Controller.SelectMenu(source);//�޴���ư�� ���� ��쿡�� Controller�� SelectMenu�Լ��� ����Ѵ�.
				} else if (source == "�ܵ���ȯ") {
					Controller.CalChange(source);//�Ž����� ���
					if (Controller.PossibleToChange()) {//�Ž����� �� �� ������
						Controller.usedChangeCoin(source);//�Ž������� ���Ǵ� ���� 
						ChangeLED.setText(Integer.toString(Controller.change));//�Ž������� LED�� ��ȯ
						moneyLED.setText("0");//���� ���Ե� ���� 0���� ǥ��
						Controller.setInput(0);//���� ���Ե� ���� 0���� ����
						LED();//LED����
					}
				}
			}
		}

		Select sh = new Select();//��ü�� ����
		
		//ī���,�Ƹ޸�ī��, ������, �ܵ���ȯ ��ư�� Ŭ�� �̺�Ʈ�� �ش�.
		LBTN.addActionListener(sh);
		ABTN.addActionListener(sh);
		HBTN.addActionListener(sh);
		ChangeBTN.addActionListener(sh);
	}

	public MyFront() {

		setSize(350, 350);// ȭ��ũ��
		setTitle("Coffee Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);// ȭ�� ���̰�

		// ȭ�� ����
		panel1.setLayout(new GridLayout(0, 3));
		ABTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		APrice.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		ALED.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		OBBTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		SBTN.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		// �гο� ��ư �߰�
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
				new ManagerMode();//�Ŵ������ ��ü ����
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
