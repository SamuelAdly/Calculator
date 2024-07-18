import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class GUI extends JFrame implements ActionListener {
    
    private JTextArea display;
    private JPanel textAreaPanel;
    private int cursorPosition = 1;
    private char operation = ' ';
    private boolean go = true;
    private boolean addWrite = true;
    private double val = 0;
    private JFrame frame;

    public GUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,741);
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("ca.png");
        frame.setIconImage(icon.getImage());

        textAreaPanel = new JPanel();
        textAreaPanel.setBounds(0, 60, 500, 70);
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        display = new JTextArea("0");
        display.setBounds(0, 60, 500, 70);
        display.setFont(new Font("Times New Roman", Font.PLAIN, 70));
        display.setEditable(false);
        textAreaPanel.add(display, BorderLayout.CENTER);
        frame.add(textAreaPanel);


        buttonCreator("<---", 1, 200, 100, 100);
        buttonCreator("--->", 101, 200, 100, 100);
        buttonCreator("Clear", 201, 200, 100, 100);
        buttonCreator("Erase", 301, 200, 100, 100);
        buttonCreator("+", 401, 200, 100, 100);
        buttonCreator("1", 1, 300, 100, 100);
        buttonCreator("2", 101, 300, 100, 100);
        buttonCreator("3", 201, 300, 100, 100);
        buttonCreator("4", 301, 300, 100, 100);
        buttonCreator("-", 401, 300, 100, 100);
        buttonCreator("5", 1, 400, 100, 100);
        buttonCreator("6", 101, 400, 100, 100);
        buttonCreator("7", 201, 400, 100, 100);
        buttonCreator("8", 301, 400, 100, 100);
        buttonCreator("/", 401, 400, 100, 100);
        buttonCreator("(", 1, 500, 100, 100);
        buttonCreator("9", 101, 500, 100, 100);
        buttonCreator("0", 201, 500, 100, 100);
        buttonCreator(")", 301, 500, 100, 100);
        buttonCreator("*", 401, 500, 100, 100);
        buttonCreator(".", 1, 600, 100, 100);
        buttonCreator("^", 101, 600, 100, 100);
        buttonCreator("%", 201, 600, 100, 100);
        buttonCreator("(-)", 301, 600, 100, 100);
        buttonCreator("=", 401, 600, 100, 100);

        frame.setVisible(true);  
    }

    public void buttonCreator (String name, int x, int y, int width, int height) {
        JButton buttonMade = new JButton(name);
        buttonMade.addActionListener(this);
        buttonMade.setBounds(x, y, width, height);
        frame.add(buttonMade);
    }
    
            // Calculate the maximum font size that fits within the button
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<---")) {
            display.append("Left");
        }
        if (e.getActionCommand().equals("--->")) {
            display.append("Right");
        }

        if (e.getActionCommand().equals("Clear")) {
            repaintFont();
            display.setText("0");
            operation = ' ';
            val = 0;
            }

        if (e.getActionCommand().equals("Erase")) {
            repaintFont();
            String str = display.getText();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                 display.setText("0");
            } else {
                display.setText(str2.toString());
            }

        }

        if (e.getActionCommand().equals("+")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        display.setText(String.valueOf((int) val));
                    } else {
                        display.setText(String.valueOf(val));
                    }
                    operation = '+';
                    go = false;
                    addWrite = false;
                } else {
                    operation = '+';
                }
        }
        if (e.getActionCommand().equals("-")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                            display.setText(String.valueOf((int) val));
                        } else {
                            display.setText(String.valueOf(val));
                        }
                        operation = '-';
                        go = false;
                        addWrite = false;
                        } else {
                            operation = '-';
                        }
        }

        if (e.getActionCommand().equals("*")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                            display.setText(String.valueOf((int) val));
                        } else {
                            display.setText(String.valueOf(val));
                        }
                        operation = '*';
                        go = false;
                        addWrite = false;
                    } else {
                        operation = '*';
                    }
        }

        if (e.getActionCommand().equals("/")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                        if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                            display.setText(String.valueOf((int) val));
                        } else {
                            display.setText(String.valueOf(val));
                        }
                        operation = '/';
                        go = false;
                        addWrite = false;
                    } else {
                        operation = '/';
                    }
        }

        if (e.getActionCommand().equals("1")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("1");
                } else {
                    display.setText(display.getText() + "1");
                }
            } else {
                display.setText("1");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("2")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("2");
                } else {
                    display.setText(display.getText() + "2");
                }
            } else {
                display.setText("2");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("3")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("3");
                } else {
                    display.setText(display.getText() + "3");
                }
            } else {
                display.setText("3");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("4")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("4");
                } else {
                    display.setText(display.getText() + "4");
                }
            } else {
                display.setText("4");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("5")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("5");
                } else {
                    display.setText(display.getText() + "5");
                }
            } else {
                display.setText("5");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("6")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("6");
                } else {
                    display.setText(display.getText() + "6");
                }
            } else {
                display.setText("6");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("7")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("7");
                } else {
                    display.setText(display.getText() + "7");
                }
            } else {
                display.setText("7");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("8")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("8");
                } else {
                    display.setText(display.getText() + "8");
                }
            } else {
                display.setText("8");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("9")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("9");
                } else {
                    display.setText(display.getText() + "9");
                }
            } else {
                display.setText("9");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("0")) {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", display.getText())) {
                    display.setText("0");
                } else {
                    display.setText(display.getText() + "0");
                }
            } else {
                display.setText("0");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("(")) {
            display.append("(");
            cursorPosition++;
        }
        if (e.getActionCommand().equals(")")) {
            display.append(")");
            cursorPosition++;
        }
        if (e.getActionCommand().equals("=")) {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        display.setText(String.valueOf((int) val));
                    } else {
                        display.setText(String.valueOf(val));
                    }
                    operation = '=';
                    addWrite = false;
                }
        }

        if (e.getActionCommand().equals(".")) {
            repaintFont();
            if (addWrite) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            } else {
                display.setText("0.");
                addWrite = true;
            }
            go = true;
        }

        if (e.getActionCommand().equals("^")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        display.setText(String.valueOf((int) val));
                    } else {
                        display.setText(String.valueOf(val));
                    }
                    operation = '^';
                    go = false;
                    addWrite = false;
                } else {
                    operation = '^';
                }
        }

        if (e.getActionCommand().equals("(-)")) {
            display.append("negative");
        }

        if (e.getActionCommand().equals("%")) {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", display.getText()))
                if (go) {
                    val = calculate(val, display.getText(), operation);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        display.setText(String.valueOf((int) val));
                    } else {
                        display.setText(String.valueOf(val));
                    }
                    operation = '%';
                    go = false;
                    addWrite = false;
                }
        }

                
                
    }

        public double calculate (double x, String input, char operation) {
            display.setFont(display.getFont().deriveFont(Font.PLAIN));
            double y = Double.parseDouble(input);
            switch (operation) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    return x / y;
                case '^':
                    return Math.pow(x, y);
                case '%':
                    return x % y;
                default:
                    display.setFont(display.getFont().deriveFont(Font.PLAIN));
                    return y;

            }
        }

        public void repaintFont () {
            display.setFont(display.getFont().deriveFont(Font.PLAIN));
        }           

            
        
        
}