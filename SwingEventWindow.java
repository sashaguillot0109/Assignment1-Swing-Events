package gui_swing_event;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

public class SwingEventWindow extends JFrame implements ActionListener, FocusListener {
  
  private int rdoChecked = 1;

  JPanel mainPanel = new JPanel();
  JPanel labPanel = new JPanel();
  JPanel requestPanel = new JPanel();
  JPanel txtNumPanel = new JPanel();
  JPanel rdoPanel = new JPanel();
  JPanel btnPanel = new JPanel();
  JPanel resultPanel = new JPanel();


  JLabel mainLabel = new JLabel("Excel Functions Window");
  JLabel requestLabel = new JLabel("Enter numbers separated by spaces");
  
  JTextArea txtNumLabel = new JTextArea();

  ButtonGroup operations = new ButtonGroup();
  JRadioButton sum = new JRadioButton("Sum", true);
  JRadioButton average = new JRadioButton("Average");
  JRadioButton min = new JRadioButton("Min");
  JRadioButton max = new JRadioButton("Max");

  JButton calculate = new JButton("Calculate");

  JTextArea resultLabel = new JTextArea();

  public SwingEventWindow() {
    super();
    setSize(250, 500);
    setVisible(true);
    setTitle("Swing Event Window");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    txtNumLabel.setPreferredSize(new DimensionUIResource(100, 20));
    resultLabel.setPreferredSize(new DimensionUIResource(100, 20));
    resultLabel.setEditable(false);
    
    operations.add(sum);
    operations.add(average);
    operations.add(min);
    operations.add(max);

    labPanel.add(mainLabel);
    requestPanel.add(requestLabel);
    txtNumPanel.add(txtNumLabel);
    rdoPanel.add(sum);
    rdoPanel.add(average);
    rdoPanel.add(min);
    rdoPanel.add(max);
    btnPanel.add(calculate);
    resultPanel.add(resultLabel);

    mainPanel.add(labPanel);
    mainPanel.add(requestPanel);
    mainPanel.add(txtNumPanel);
    mainPanel.add(rdoPanel);
    mainPanel.add(btnPanel);
    mainPanel.add(resultPanel);

    add(mainPanel);

    calculate.addActionListener(this);
    sum.addFocusListener(this);
    average.addFocusListener(this);
    min.addFocusListener(this);
    max.addFocusListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == calculate) {
      Excel excel = new Excel(txtNumLabel.getText());
      double result = 0;
      switch (rdoChecked) {
        case 1:
          result = excel.findTotal();
          break;
        case 2:
          result = excel.findAverage();
          break;
        case 3:
          result = excel.findMin();
          break;
        case 4:
          result = excel.findMax();
          break;
      }
      resultLabel.setText(String.valueOf(result));
    }
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(e.getSource() == sum) {
      rdoChecked = 1;
    } else if(e.getSource() == average) {
      rdoChecked = 2;
    } else if(e.getSource() == min) {
      rdoChecked = 3;
    } else if(e.getSource() == max) {
      rdoChecked = 4;
    }
  }

  @Override
  public void focusLost(FocusEvent e) {
    // TODO Auto-generated method stub 
  }
} 
