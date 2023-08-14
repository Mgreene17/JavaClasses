/*
CIS365Exam2.java
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CIS365Exam2 extends JFrame {
    JLabel lblPlus, lblEqual, lblResult, lblInfo;
    JTextField txtInput1, txtInput2;
    JButton btnCal, btnQuit;


    public CIS365Exam2() {
        super("Exam 2: My Calculator");
// *** part 1
        setSize(500,400);
// *** part 1 ends
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
  
    private void init() {
/// *** part 2
      lblInfo=new JLabel("Exam2: Mike Greene");
      lblInfo.setBounds(100, 50, 200, 100);
      add(lblInfo);
// *** part 2 ends
  
      lblPlus=new JLabel("+");
      lblPlus.setBounds(170,210,25,25);
      add(lblPlus);
  
      lblEqual=new JLabel("=");
      lblEqual.setBounds(320,210,25,25);
      add(lblEqual);
  
      txtInput1=new JTextField("");
      txtInput1.setBounds(50, 200, 100, 50);
      txtInput1.setFont(new Font(txtInput1.getName(), Font.PLAIN,19));
      txtInput1.setHorizontalAlignment(SwingConstants.CENTER);
      add(txtInput1);
  
      txtInput2=new JTextField("");
      txtInput2.setBounds(200, 200, 100, 50);
      txtInput2.setFont(new Font(txtInput2.getName(), Font.PLAIN,19));
      txtInput2.setHorizontalAlignment(SwingConstants.CENTER);
      add(txtInput2);
  
      lblResult=new JLabel("");
      lblResult.setBounds(350,200,100,50);
      lblResult.setFont(new Font(txtInput2.getName(), Font.PLAIN,19));
      lblResult.setHorizontalAlignment(SwingConstants.CENTER);
      add(lblResult);
  
      btnCal=new JButton("Calculate");
      btnCal.setBounds(250, 300, 100, 50);
      add(btnCal);
  
      btnQuit=new JButton("Exit");
      btnQuit.setBounds(350,300,100,50);
      add(btnQuit);
  
      btnCal.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
//**** Part 3: 3). When you enter two integers, click the
          String s = txtInput1.getText();
          String t = txtInput2.getText();
          String addedString = ("");

          int s_int = Integer.parseInt(s);
          int t_int = Integer.parseInt(t);

          int added = s_int + t_int;
          addedString = Integer.toString(added);
          lblResult.setText(addedString);
// *** part 3 ends
      }
    });

    btnQuit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
//**** part 4: When you click click [Exit] button. end this
        dispose();
// *** part 4 ends
      }
   });
    
}

public static void main(String[] args) {
//**** part 5:
  CIS365Exam2 test = new CIS365Exam2();
//*** part 5 ends
  }
}