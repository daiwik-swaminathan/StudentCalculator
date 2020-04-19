import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/*
 * Creators: Saravana Polisetti and Daiwik Swaminathan
*/

public class StudentCalculator
{
    JFrame frame;
    int screenHeight, screenWidth;
    MainPanel mainPanel;

    public static void main(String[] args)
    {
        StudentCalculator program = new StudentCalculator();
    }

    public StudentCalculator()
    {
        screenWidth = 800;
        screenHeight = 500;
        frame = new JFrame("Student Calculator");
        frame.setLocation(50, 50);
        frame.setSize(screenWidth, screenHeight);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        mainPanel = new MainPanel(screenWidth, screenHeight);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

class MainPanel extends JPanel implements ActionListener, MenuListener, KeyListener
{
    JPanel openingPanel;
    JPanel chooseEnterOrViewGrades;
    JPanel middleOpeningPanel;
    JPanel lowerOpeningPanel;
    JLabel title;
    JTextArea gpaDescription;
    JTextArea gradeBookDescription;
    JTextArea calculatorDescription;
    JButton gpa;
    JButton gradeBook;
    JButton calculator;
    CardLayout cardLayout;
    JTextField a9, b9, c9, d9, f9, a10, b10, c10, d10, f10, a11, b11, c11, d11, f11, a12, b12, c12, d12, f12;
    boolean hasFile;
    boolean disable = true;
    JTextField currentGrade1;
    JTextField gradeWanted1;
    JTextField finalWeight;
    int required;

    public MainPanel(int widthInput, int heightInput)
    {
        setSize(widthInput, heightInput);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBackground(Color.BLUE);

        title = new JLabel("Student Calculator", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);

        gpaDescription = new JTextArea(" This is where you will be able to calculate your high school GPA!" +
                " We will calculate your UC, CSU, and Ivy League GPA too!");
        gpaDescription.setLineWrap(true);
        gpaDescription.setWrapStyleWord(true);
        gpaDescription.setEditable(false);
        gpaDescription.setFont(new Font("Arial", Font.BOLD, 20));
        gpaDescription.setBackground(Color.BLUE);
        gpaDescription.setForeground(Color.WHITE);

        gradeBookDescription = new JTextArea("This is where you will be able to calculate the grade you need on your final to receive your desired score!");
        gradeBookDescription.setLineWrap(true);
        gradeBookDescription.setWrapStyleWord(true);
        gradeBookDescription.setEditable(false);
        gradeBookDescription.setFont(new Font("Arial", Font.BOLD, 20));
        gradeBookDescription.setBackground(Color.BLUE);
        gradeBookDescription.setForeground(Color.WHITE);

        calculatorDescription = new JTextArea("This is a basic calculator which you can use for simple calculations.");
        calculatorDescription.setLineWrap(true);
        calculatorDescription.setWrapStyleWord(true);
        calculatorDescription.setEditable(false);
        calculatorDescription.setFont(new Font("Arial", Font.BOLD, 20));
        calculatorDescription.setBackground(Color.BLUE);
        calculatorDescription.setForeground(Color.WHITE);

        gpa = new JButton("GPA");
        gpa.setOpaque(false);
        gpa.setFont(new Font("Arial", Font.BOLD, 20));
        gpa.addActionListener(this);

        gradeBook = new JButton("Final Calculator");
        gradeBook.setOpaque(false);
        gradeBook.setFont(new Font("Arial", Font.BOLD, 20));
        gradeBook.addActionListener(this);

        calculator = new JButton("Calculator");
        calculator.setOpaque(false);
        calculator.setFont(new Font("Arial", Font.BOLD, 20));
        calculator.addActionListener(this);

        openingPanel = new JPanel();
        openingPanel.setLayout(new GridLayout(3, 1));
        openingPanel.setBackground(Color.BLUE);
        openingPanel.add(title);

        chooseEnterOrViewGrades = new JPanel();
        chooseEnterOrViewGrades.setLayout(new GridLayout (1,2));

        middleOpeningPanel = new JPanel();
        middleOpeningPanel.setLayout(new GridLayout(1, 3));
        middleOpeningPanel.add(gpa);
        middleOpeningPanel.add(gradeBook);
        middleOpeningPanel.add(calculator);
        middleOpeningPanel.setBackground(Color.BLUE);
        openingPanel.add(middleOpeningPanel);

        lowerOpeningPanel = new JPanel();
        lowerOpeningPanel.setLayout(new GridLayout(1,3));
        lowerOpeningPanel.add(gpaDescription);
        lowerOpeningPanel.add(gradeBookDescription);
        lowerOpeningPanel.add(calculatorDescription);
        lowerOpeningPanel.setBackground(Color.BLUE);
        openingPanel.add(lowerOpeningPanel);

        add(openingPanel);

        a9 = new JTextField();
        a9.setFont(new Font("Arial", Font.BOLD, 30));
        b9 = new JTextField();
        b9.setFont(new Font("Arial", Font.BOLD, 30));
        c9 = new JTextField();
        c9.setFont(new Font("Arial", Font.BOLD, 30));
        d9 = new JTextField();
        d9.setFont(new Font("Arial", Font.BOLD, 30));
        f9 = new JTextField();
        f9.setFont(new Font("Arial", Font.BOLD, 30));

        a10 = new JTextField();
        a10.setFont(new Font("Arial", Font.BOLD, 30));
        b10 = new JTextField();
        b10.setFont(new Font("Arial", Font.BOLD, 30));
        c10 = new JTextField();
        c10.setFont(new Font("Arial", Font.BOLD, 30));
        d10 = new JTextField();
        d10.setFont(new Font("Arial", Font.BOLD, 30));
        f10 = new JTextField();
        f10.setFont(new Font("Arial", Font.BOLD, 30));

        a11 = new JTextField();
        a11.setFont(new Font("Arial", Font.BOLD, 30));
        b11 = new JTextField();
        b11.setFont(new Font("Arial", Font.BOLD, 30));
        c11 = new JTextField();
        c11.setFont(new Font("Arial", Font.BOLD, 30));
        d11 = new JTextField();
        d11.setFont(new Font("Arial", Font.BOLD, 30));
        f11 = new JTextField();
        f11.setFont(new Font("Arial", Font.BOLD, 30));

        a12 = new JTextField();
        a12.setFont(new Font("Arial", Font.BOLD, 30));
        b12 = new JTextField();
        b12.setFont(new Font("Arial", Font.BOLD, 30));
        c12 = new JTextField();
        c12.setFont(new Font("Arial", Font.BOLD, 30));
        d12 = new JTextField();
        d12.setFont(new Font("Arial", Font.BOLD, 30));
        f12 = new JTextField();
        f12.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equalsIgnoreCase("GPA"))
        {
            goToGPAScreen();
        }
        else if (command.equalsIgnoreCase("Enter Grades Here"))
        {
            goToCalculateGPAScreen();
        }
        else if (command.equalsIgnoreCase("Final Calculator"))
        {
            finalCalculator();
        }
        else if(command.equalsIgnoreCase("Calculate Final"))
        {
            calculateGradeNeeded();
            ShowNecessaryFinal show = new ShowNecessaryFinal(required);
        }
        else if (command.equalsIgnoreCase("Calculate"))
        {
            calculateGPA();
        }
        else if(command.equalsIgnoreCase("CLEAR"))
        {
            clear();
        }
        else if(command.equalsIgnoreCase("Previous"))
        {
            goToGPAScreen();
        }
        else if (command.equalsIgnoreCase("View GPA's Here"))
        {
            calculateGPA();
        }
        else if (command.equalsIgnoreCase("Go Back Home"))
        {
            goBackHome();
        }
        else if (command.equalsIgnoreCase("Calculator"))
        {
            Calculator calculate = new Calculator();
        }
    }

    private void goToGPAScreen()
    {
        removeAll();
        setLayout(new GridLayout(2,3));

        JButton enterGradesHere = new JButton("Enter Grades Here");
        enterGradesHere.addActionListener(this);
        enterGradesHere.setFont(new Font("Arial", Font.BOLD, 20));
        add(enterGradesHere);

        JLabel empty3 = new JLabel("GPA Calculator", JLabel.CENTER);
        empty3.setFont(new Font("Arial", Font.BOLD, 30));
        empty3.setForeground(Color.WHITE);
        add(empty3);

        JButton viewGPA = new JButton("View GPA's Here");
        viewGPA.addActionListener(this);
        viewGPA.setFont(new Font("Arial", Font.BOLD, 20));

        if(disable)
        {
            viewGPA.setEnabled(false);
        }
        else
        {
            viewGPA.setEnabled(true);
        }

        add(viewGPA);

        JTextArea empty4 = new JTextArea("Instructions: Enter the number of total letter grades" +
                " received in both semesters for each grade. If you have not reached certain grade levels yet, leave the corresponding boxes blank.");
        empty4.setLineWrap(true);
        empty4.setWrapStyleWord(true);
        empty4.setEditable(false);
        empty4.setBackground(Color.BLUE);
        empty4.setForeground(Color.WHITE);
        empty4.setFont(new Font("Arial", Font.BOLD, 20));
        add(empty4);

        JButton home = new JButton("Go Back Home");
        home.addActionListener(this);
        home.setFont(new Font("Arial", Font.BOLD, 20));
        add(home);

        JTextArea empty6 = new JTextArea("Instructions: If you have already entered your grades, you can view your GPA here. You do not need to enter your grades again.");
        empty6.setLineWrap(true);
        empty6.setWrapStyleWord(true);
        empty6.setEditable(false);
        empty6.setBackground(Color.BLUE);
        empty6.setForeground(Color.WHITE);
        empty6.setFont(new Font("Arial", Font.BOLD, 20));
        add(empty6);

        repaint();
        revalidate();
    }

    private void finalCalculator()
    {
        removeAll();
        setLayout(new BorderLayout());

        JTextArea empty3 = new JTextArea("This calculator will give you the percentage you need on your final to get your desired percentage grade in that class.");
        empty3.setLineWrap(true);
        empty3.setWrapStyleWord(true);
        empty3.setEditable(false);
        empty3.setBackground(Color.BLUE);
        empty3.setForeground(Color.WHITE);
        empty3.setFont(new Font("Arial", Font.BOLD, 20));
        add(empty3, BorderLayout.NORTH);

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLUE);
        bottom.setLayout(new GridLayout(1,2));
        add(bottom, BorderLayout.SOUTH);

        JButton home = new JButton("Go Back Home");
        home.addActionListener(this);
        bottom.add(home);

        JButton emptyRight = new JButton("Calculate Final");
        emptyRight.addActionListener(this);
        bottom.add(emptyRight);

        JPanel mainCalcSection = new JPanel();
        mainCalcSection.setBackground(Color.BLUE);
        mainCalcSection.setLayout(new GridLayout(5,5));
        add(mainCalcSection, BorderLayout.CENTER);

        JLabel empty = new JLabel("");
        mainCalcSection.add(empty);

        JLabel empty1 = new JLabel("");
        mainCalcSection.add(empty1);

        JLabel empty2 = new JLabel("");
        mainCalcSection.add(empty2);

        JLabel empty6 = new JLabel("");
        mainCalcSection.add(empty6);

        JLabel empty4 = new JLabel("");
        mainCalcSection.add(empty4);

        JLabel empty8 = new JLabel("");
        mainCalcSection.add(empty8);

        JLabel currentGrade = new JLabel("Current Grade: ");
        currentGrade.setForeground(Color.WHITE);
        currentGrade.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(currentGrade);

        currentGrade1 = new JTextField("");
        currentGrade1.setEditable(true);
        currentGrade1.setFont(new Font("Arial", Font.BOLD, 30));
        mainCalcSection.add(currentGrade1);

        JLabel percentage = new JLabel("%");
        percentage.setForeground(Color.WHITE);
        percentage.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(percentage);

        JLabel empty9 = new JLabel("");
        mainCalcSection.add(empty9);

        JLabel empty10 = new JLabel("");
        mainCalcSection.add(empty10);

        JLabel gradeWanted = new JLabel("Grade Wanted: ");
        gradeWanted.setForeground(Color.WHITE);
        gradeWanted.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(gradeWanted);

        gradeWanted1 = new JTextField("");
        gradeWanted1.setEditable(true);
        gradeWanted1.setFont(new Font("Arial", Font.BOLD, 30));
        mainCalcSection.add(gradeWanted1);

        JLabel percentage1 = new JLabel("%");
        percentage1.setForeground(Color.WHITE);
        percentage1.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(percentage1);

        JLabel empty11 = new JLabel("");
        mainCalcSection.add(empty11);

        JLabel empty12 = new JLabel("");
        mainCalcSection.add(empty12);

        JLabel whatNeeded = new JLabel("Final Worth: ");
        whatNeeded.setForeground(Color.WHITE);
        whatNeeded.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(whatNeeded);

        finalWeight = new JTextField("");
        finalWeight.setEditable(true);
        finalWeight.setFont(new Font("Arial", Font.BOLD, 30));
        mainCalcSection.add(finalWeight);

        JLabel percentage2 = new JLabel("%");
        percentage2.setForeground(Color.WHITE);
        percentage2.setFont(new Font("Arial", Font.BOLD, 20));
        mainCalcSection.add(percentage2);

        JLabel empty13 = new JLabel("");
        mainCalcSection.add(empty13);

        JLabel empty14 = new JLabel("");
        mainCalcSection.add(empty14);

        JLabel empty15 = new JLabel("");
        mainCalcSection.add(empty15);

        JLabel empty16 = new JLabel("");
        mainCalcSection.add(empty16);

        JLabel empty17 = new JLabel("");
        mainCalcSection.add(empty17);

        JLabel empty18 = new JLabel("");
        mainCalcSection.add(empty18);

        repaint();
        revalidate();
    }

    private void calculateGradeNeeded()
    {
        double currentPercent = Double.parseDouble(currentGrade1.getText())/100.0;
        double percentWanted = Double.parseDouble(gradeWanted1.getText())/100.0;
        double weightage = Double.parseDouble(finalWeight.getText())/100.0;

        required = (int)((((percentWanted - (1.0 - weightage) * currentPercent) /  weightage) * 100) + 0.5);

        System.out.println(required + "%");

    }

    private void goToCalculateGPAScreen()
    {
        removeAll();
        repaint();
        revalidate();

        String nameOfFile = "GPA.txt";
        File inputFile = new File(nameOfFile);
        Scanner inFile = null;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try
        {
            inFile = new Scanner(inputFile);
            hasFile = true;
            while(inFile.hasNext())
            {
                numbers.add(Integer.parseInt(inFile.next()));
            }
        }
        catch (FileNotFoundException e)
        {
            hasFile = false;
        }

        setLayout(new GridLayout(6,7));

        JLabel gradeLevel = new JLabel("Grade Level", JLabel.CENTER);
        gradeLevel.setFont(new Font("Arial", Font.BOLD, 20));
        gradeLevel.setForeground(Color.WHITE);
        add(gradeLevel);
        JLabel numOfAs = new JLabel("# of As", JLabel.CENTER);
        numOfAs.setFont(new Font("Arial", Font.BOLD, 30));
        numOfAs.setForeground(Color.WHITE);
        add(numOfAs);
        JLabel numOfBs = new JLabel("# of Bs", JLabel.CENTER);
        numOfBs.setFont(new Font("Arial", Font.BOLD, 30));
        numOfBs.setForeground(Color.WHITE);
        add(numOfBs);
        JLabel numOfCs = new JLabel("# of Cs", JLabel.CENTER);
        numOfCs.setFont(new Font("Arial", Font.BOLD, 30));
        numOfCs.setForeground(Color.WHITE);
        add(numOfCs);
        JLabel numOfDs = new JLabel("# of Ds", JLabel.CENTER);
        numOfDs.setFont(new Font("Arial", Font.BOLD, 30));
        numOfDs.setForeground(Color.WHITE);
        add(numOfDs);
        JLabel numOfFs = new JLabel("# of Fs", JLabel.CENTER);
        numOfFs.setFont(new Font("Arial", Font.BOLD, 30));
        numOfFs.setForeground(Color.WHITE);
        add(numOfFs);
        JLabel empty7 = new JLabel("9", JLabel.CENTER);
        empty7.setFont(new Font("Arial", Font.BOLD, 30));
        empty7.setForeground(Color.WHITE);
        add(empty7);

        if(hasFile)
        {
            a9.setText(""+numbers.get(0));
            b9.setText(""+numbers.get(1));
            c9.setText(""+numbers.get(2));
            d9.setText(""+numbers.get(3));
            f9.setText(""+numbers.get(4));

            a10.setText(""+numbers.get(5));
            b10.setText(""+numbers.get(6));
            c10.setText(""+numbers.get(7));
            d10.setText(""+numbers.get(8));
            f10.setText(""+numbers.get(9));

            a11.setText(""+numbers.get(10));
            b11.setText(""+numbers.get(11));
            c11.setText(""+numbers.get(12));
            d11.setText(""+numbers.get(13));
            f11.setText(""+numbers.get(14));

            a12.setText(""+numbers.get(15));
            b12.setText(""+numbers.get(16));
            c12.setText(""+numbers.get(17));
            d12.setText(""+numbers.get(18));
            f12.setText(""+numbers.get(19));
        }

        add(a9);
        add(b9);
        add(c9);
        add(d9);
        add(f9);

        JLabel empty14 = new JLabel("10", JLabel.CENTER);
        empty14.setFont(new Font("Arial", Font.BOLD, 30));
        empty14.setForeground(Color.WHITE);
        add(empty14);

        add(a10);
        add(b10);
        add(c10);
        add(d10);
        add(f10);

        JLabel empty21 = new JLabel("11", JLabel.CENTER);
        empty21.setFont(new Font("Arial", Font.BOLD, 30));
        empty21.setForeground(Color.WHITE);
        add(empty21);

        add(a11);
        add(b11);
        add(c11);
        add(d11);
        add(f11);

        JLabel empty28 = new JLabel("12", JLabel.CENTER);
        empty28.setFont(new Font("Arial", Font.BOLD, 30));
        empty28.setForeground(Color.WHITE);
        add(empty28);

        add(a12);
        add(b12);
        add(c12);
        add(d12);
        add(f12);

        JLabel empty36 = new JLabel("");
        empty36.setFont(new Font("Arial", Font.BOLD, 30));
        add(empty36);
        JLabel empty37 = new JLabel("");
        empty36.setFont(new Font("Arial", Font.BOLD, 30));
        add(empty37);
        JButton empty38 = new JButton( "CLEAR");
        empty38.addActionListener(this);
        add(empty38);
        JButton previous = new JButton("Previous");
        previous.addActionListener(this);
        add(previous);
        JButton empty35 = new JButton("Go Back Home");
        empty35.addActionListener(this);
        add(empty35);
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        add(calculate);
    }

    public void calculateGPA()
    {
        removeAll();
        repaint();

        disable = false;

        if(a9.getText().equals(""))
            a9.setText("0");
        if(b9.getText().equals(""))
            b9.setText("0");
        if(c9.getText().equals(""))
            c9.setText("0");
        if(d9.getText().equals(""))
            d9.setText("0");
        if(f9.getText().equals(""))
            f9.setText("0");
        if(a10.getText().equals(""))
            a10.setText("0");
        if(b10.getText().equals(""))
            b10.setText("0");
        if(c10.getText().equals(""))
            c10.setText("0");
        if(d10.getText().equals(""))
            d10.setText("0");
        if(f10.getText().equals(""))
            f10.setText("0");
        if(a11.getText().equals(""))
            a11.setText("0");
        if(b11.getText().equals(""))
            b11.setText("0");
        if(c11.getText().equals(""))
            c11.setText("0");
        if(d11.getText().equals(""))
            d11.setText("0");
        if(f11.getText().equals(""))
            f11.setText("0");
        if(a12.getText().equals(""))
            a12.setText("0");
        if(b12.getText().equals(""))
            b12.setText("0");
        if(c12.getText().equals(""))
            c12.setText("0");
        if(d12.getText().equals(""))
            d12.setText("0");
        if(f12.getText().equals(""))
            f12.setText("0");

        double ucGPA;
        double calPolyGPA;
        double hsGPA;

        ucGPA = ((4.0*Integer.parseInt(a10.getText()) + 3.0*Integer.parseInt(b10.getText()) +
                2.0*Integer.parseInt(c10.getText()) + 1.0*Integer.parseInt(d10.getText()) +

                4.0*Integer.parseInt(a11.getText()) + 3.0*Integer.parseInt(b11.getText()) +
                2.0*Integer.parseInt(c11.getText()) + 1.0*Integer.parseInt(d11.getText())) /

                ((Integer.parseInt(a10.getText()) + Integer.parseInt(b10.getText()) +
                        Integer.parseInt(c10.getText())  + Integer.parseInt(d10.getText())) +

                        Integer.parseInt(a11.getText()) + Integer.parseInt(b11.getText()) +
                        Integer.parseInt(c11.getText()) + Integer.parseInt(d11.getText()) +
                        Integer.parseInt(f9.getText())));

        calPolyGPA = (((4.0*Integer.parseInt(a9.getText()) + 3.0*Integer.parseInt(b9.getText()) +
                2.0*Integer.parseInt(c9.getText()) + 1.0*Integer.parseInt(d9.getText()) +

                4.0*Integer.parseInt(a10.getText()) + 3.0*Integer.parseInt(b10.getText()) +
                2.0*Integer.parseInt(c10.getText()) + 1.0*Integer.parseInt(d10.getText()) +

                4.0*Integer.parseInt(a11.getText()) + 3.0*Integer.parseInt(b11.getText()) +
                2.0*Integer.parseInt(c11.getText()) + 1.0*Integer.parseInt(d11.getText()))  /

                (Integer.parseInt(a9.getText())+ Integer.parseInt(b9.getText()) +
                        Integer.parseInt(c9.getText()) + Integer.parseInt(d9.getText()) +

                        Integer.parseInt(a10.getText()) + Integer.parseInt(b10.getText()) +
                        Integer.parseInt(c10.getText()) + Integer.parseInt(d10.getText()) +

                        Integer.parseInt(a11.getText())+ Integer.parseInt(b11.getText()) +
                        Integer.parseInt(c11.getText()) + Integer.parseInt(d11.getText()) +
                        Integer.parseInt(f9.getText()))));

        hsGPA = ((4.0*Integer.parseInt(a9.getText()) + 3.0*Integer.parseInt(b9.getText()) +
                2.0*Integer.parseInt(c9.getText()) + 1.0*Integer.parseInt(d9.getText()) +

                4.0*Integer.parseInt(a10.getText()) + 3.0*Integer.parseInt(b10.getText()) +
                2.0*Integer.parseInt(c10.getText()) + 1.0*Integer.parseInt(d10.getText()) +

                4.0*Integer.parseInt(a11.getText()) + 3.0*Integer.parseInt(b11.getText()) +
                2.0*Integer.parseInt(c11.getText()) + 1.0*Integer.parseInt(d11.getText()) +

                4.0*Integer.parseInt(a12.getText()) + 3.0*Integer.parseInt(b12.getText()) +
                2.0*Integer.parseInt(c12.getText()) + 1.0*Integer.parseInt(d12.getText())) /

                (Integer.parseInt(a9.getText())+ Integer.parseInt(b9.getText()) +
                        Integer.parseInt(c9.getText()) + Integer.parseInt(d9.getText()) +

                        Integer.parseInt(a10.getText()) + Integer.parseInt(b10.getText()) +
                        Integer.parseInt(c10.getText()) + Integer.parseInt(d10.getText()) +

                        Integer.parseInt(a11.getText())+ Integer.parseInt(b11.getText()) +
                        Integer.parseInt(c11.getText()) + Integer.parseInt(d11.getText()) +

                        Integer.parseInt(a12.getText())+ Integer.parseInt(b12.getText()) +
                        Integer.parseInt(c12.getText()) + Integer.parseInt(d12.getText()) +
                        Integer.parseInt(f9.getText())));


        String outFileName = "GPA.txt";
        File outFile = new File(outFileName);
        PrintWriter makesOutput = null;
        try
        {
            makesOutput = new PrintWriter(outFile);
        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }

        makesOutput.println("" + a9.getText() + " " + b9.getText() + " " + c9.getText()+ " " + d9.getText() + " " + f9.getText());
        makesOutput.println("" + a10.getText() + " " + b10.getText() + " " + c10.getText() + " " + d10.getText() + " " + f10.getText());
        makesOutput.println("" + a11.getText() + " " + b11.getText() + " " + c11.getText() + " " + d11.getText() + " " + f11.getText());
        makesOutput.println("" + a12.getText() + " " + b12.getText() + " " + c12.getText() + " " + d12.getText() + " " + f12.getText());
        makesOutput.println();

        makesOutput.close();

        setLayout(new GridLayout(5,4));

        JLabel empty1 = new JLabel("");
        add(empty1);

        JLabel empty2 = new JLabel("");
        add(empty2);

        JLabel empty3 = new JLabel("");
        add(empty3);

        JLabel empty4 = new JLabel("");
        add(empty4);

        JLabel empty5 = new JLabel("");
        add(empty5);

        JLabel UC_CSU = new JLabel("UC and CSU");
        UC_CSU.setFont(new Font("Arial", Font.BOLD, 20));
        UC_CSU.setBackground(Color.BLUE);
        UC_CSU.setForeground(Color.WHITE);
        add(UC_CSU);

        JTextArea UC_CSU_GPA = new JTextArea("\n\n" + Math.round(ucGPA * 100) / 100.0);
        UC_CSU_GPA.setFont(new Font("Arial", Font.BOLD, 20));
        UC_CSU_GPA.setOpaque(false);
        UC_CSU_GPA.setEditable(false);
        UC_CSU_GPA.setBackground(Color.BLUE);
        UC_CSU_GPA.setForeground(Color.WHITE);
        add(UC_CSU_GPA);

        JLabel empty6 = new JLabel("");
        add(empty6);

        JLabel empty7 = new JLabel("");
        add(empty7);

        JTextArea stanford = new JTextArea("Cal Poly SLO, Stanford, University of Michigan, Rice University");
        stanford.setFont(new Font("Arial", Font.BOLD, 20));
        stanford.setLineWrap(true);
        stanford.setWrapStyleWord(true);
        stanford.setEditable(false);
        stanford.setBackground(Color.BLUE);
        stanford.setForeground(Color.WHITE);
        stanford.setOpaque(false);
        add(stanford);

        JTextArea stanford_GPA = new JTextArea("\n\n" + Math.round(calPolyGPA * 100) / 100.0);
        stanford_GPA.setFont(new Font("Arial", Font.BOLD, 20));
        stanford_GPA.setOpaque(false);
        stanford_GPA.setEditable(false);
        stanford_GPA.setBackground(Color.BLUE);
        stanford_GPA.setForeground(Color.WHITE);
        add(stanford_GPA);

        JLabel empty8 = new JLabel("");
        add(empty8);

        JLabel empty9 = new JLabel("");
        add(empty9);

        JLabel high = new JLabel("High School GPA");
        high.setFont(new Font("Arial", Font.BOLD, 20));
        high.setBackground(Color.BLUE);
        high.setForeground(Color.WHITE);
        add(high);

        JTextArea high_school = new JTextArea("\n\n" + Math.round(hsGPA * 100) / 100.0);
        high_school.setFont(new Font("Arial", Font.BOLD, 20));
        high_school.setOpaque(false);
        high_school.setEditable(false);
        high_school.setBackground(Color.BLUE);
        high_school.setForeground(Color.WHITE);
        add(high_school);

        JLabel empty10 = new JLabel("");
        add(empty10);

        JLabel empty11 = new JLabel("");
        add(empty11);

        JLabel empty12 = new JLabel( "");
        add(empty12);

        JButton previous = new JButton( "Previous");
        previous.addActionListener(this);
        add(previous);

        JButton empty14 = new JButton( "Go Back Home");
        empty14.addActionListener(this);
        add(empty14);

        revalidate();
    }

    private void clear()
    {
        a9.setText("");
        b9.setText("");
        c9.setText("");
        d9.setText("");
        f9.setText("");
        a10.setText("");
        b10.setText("");
        c10.setText("");
        d10.setText("");
        f10.setText("");
        a11.setText("");
        b11.setText("");
        c11.setText("");
        d11.setText("");
        f11.setText("");
        a12.setText("");
        b12.setText("");
        c12.setText("");
        d12.setText("");
        f12.setText("");
    }

    private void goBackHome()
    {
        removeAll();
        repaint();
        setLayout(cardLayout);
        add(openingPanel);
        revalidate();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
    public void menuSelected(MenuEvent e) {}
    public void menuDeselected(MenuEvent e) {}
    public void menuCanceled(MenuEvent e) {}
}

class ShowNecessaryFinal implements ActionListener
{
    public ShowNecessaryFinal(int finalGradePercentage)
    {
        JFrame frame = new JFrame("Final Grade");
        frame.setBounds(100, 100, 450, 400);
        frame.setBackground(Color.BLUE);
        frame.setResizable(false);
        frame.setLayout(new CardLayout());
        frame.setFocusable(true);

        JPanel finalGrade = new JPanel();
        finalGrade.setLayout(new GridLayout(2,0));
        JTextArea percentFinal = new JTextArea("You need to score a " + finalGradePercentage + "% to get your desired score!");
        percentFinal.setLineWrap(true);
        percentFinal.setWrapStyleWord(true);
        percentFinal.setBackground(Color.BLUE);
        percentFinal.setForeground(Color.WHITE);
        percentFinal.setEditable(false);
        percentFinal.setFont(new Font("Arial", Font.BOLD, 30));
        finalGrade.add(percentFinal);
        frame.add(finalGrade);

        JTextArea positiveStatement = null;
        if(finalGradePercentage > 100)
        {
            positiveStatement = new JTextArea("Well, good luck with that!");
        }
        else if(finalGradePercentage >= 90 && finalGradePercentage < 100)
        {
            positiveStatement = new JTextArea("Good luck, you have a great chance!");
        }
        else if(finalGradePercentage >= 80 && finalGradePercentage < 90)
        {
            positiveStatement = new JTextArea("Hey, don't slack off now!");
        }
        else if(finalGradePercentage >= 70 && finalGradePercentage < 80)
        {
            positiveStatement = new JTextArea("Wow, your grade is high, keep up the good work!");
        }
        else if(finalGradePercentage >= 60 && finalGradePercentage < 70)
        {
            positiveStatement = new JTextArea("Wow, your grade is high, keep up the good work!");
        }
        else if(finalGradePercentage >= 50 && finalGradePercentage < 60)
        {
            positiveStatement = new JTextArea("Wow, your grade is high, keep up the good work!");
        }
        else if(finalGradePercentage >= 40 && finalGradePercentage < 50)
        {
            positiveStatement = new JTextArea("How this is possible, I don't know!");
        }
        else if(finalGradePercentage >= 30 && finalGradePercentage < 40)
        {
            positiveStatement = new JTextArea("How this is possible, I don't know!");
        }
        else if(finalGradePercentage >= 20 && finalGradePercentage < 30)
        {
            positiveStatement = new JTextArea("How this is possible, I don't know! :-) :-) :-)");
        }
        else if(finalGradePercentage >= 10 && finalGradePercentage < 20)
        {
            positiveStatement = new JTextArea("How this is possible, I don't know! :-) :-) :-)");
        }
        else if(finalGradePercentage >= 1 && finalGradePercentage < 10)
        {
            positiveStatement = new JTextArea("This has to be impossible!!! :-) :-) :-)");
        }
        else
            positiveStatement = new JTextArea("Explain to me why you want to do this? You might as well just not take the final! :-) :-) :-)");
        positiveStatement.setLineWrap(true);
        positiveStatement.setWrapStyleWord(true);
        positiveStatement.setBackground(Color.BLUE);
        positiveStatement.setForeground(Color.WHITE);
        positiveStatement.setEditable(false);
        positiveStatement.setFont(new Font("Arial", Font.BOLD, 30));
        finalGrade.add(positiveStatement);
        finalGrade.add(positiveStatement);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {}
}

class Calculator implements ActionListener
{
    private JTextField console;
    private String calcText = "0";
    private String equation = "";
    private JButton ac;
    private boolean isInt;
    private boolean veryFirst = true;
    private boolean firstSpot = true;
    private int firstSymbolIndex;
    private boolean first = true;
    private String holder;
    private double num1, num2;
    private JButton[] buttons = new JButton[16];
    private JButton[] buttons1 = new JButton[12];
    private String symbol = "";

    public Calculator()
    {
        JFrame frame = new JFrame("Calculator");
        frame.setBounds(50, 50, 710, 422);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setFocusable(true);

        console = new JTextField();
        console.setFont(new Font("Helvetica", Font.BOLD, 50));
        console.setText(calcText);
        console.setBounds(310, 5, 400, 50);
        console.setEditable(false);
        frame.add(console);

        JPanel panel = new JPanel();
        frame.getContentPane().setBackground(panel.getBackground());
        panel.setBounds(310, 55, 400, 291);
        panel.setLayout(new GridLayout(4, 4));

        ac = new JButton("C");
        ac.setBounds(310, 341, 400, 59);
        ac.setFont(new Font("Helvetica", Font.BOLD, 50));

        int count = 1;
        for (int i = 0; i < 16; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Helvetica", Font.BOLD, 50));
            if (i == 0)
                buttons[i].setText("+");
            else if (i == 4)
                buttons[i].setText("-");
            else if (i == 8)
                buttons[i].setText("x");
            else if (i == 12)
                buttons[i].setText("/");
            else if (i == 13)
                buttons[i].setText("0");
            else if (i == 14)
                buttons[i].setText(".");
            else if (i == 15)
                buttons[i].setText("=");
            else
            {
                buttons[i].setText("" + count);
                count++;
            }
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        ac.addActionListener(this);
        frame.add(ac);
        frame.add(panel);
        frame.setVisible(true);

        JPanel advancedFuncs = new JPanel();
        advancedFuncs.setBounds(0, 0, 310, 401);
        advancedFuncs.setLayout(new GridLayout(6, 2));
        frame.add(advancedFuncs);
        for (int i = 0; i < 12; i++)
        {
            buttons1[i] = new JButton();
            buttons1[i].setFont(new Font("Helvetica", Font.BOLD, 30));
            if (i == 0)
                buttons1[i].setText("log");
            else if (i == 1)
                buttons1[i].setText("ln");
            else if (i == 2)
                buttons1[i].setText("√");
            else if(i == 3)
                buttons1[i].setText("π");
            else if(i == 4)
                buttons1[i].setText("e");
            else if(i == 5)
                buttons1[i].setText("x^2");
            else if(i == 6)
                buttons1[i].setText("sin");
            else if(i == 7)
                buttons1[i].setText("cos");
            else if(i == 8)
                buttons1[i].setText("tan");
            else if(i == 9)
                buttons1[i].setText("asin");
            else if(i == 10)
                buttons1[i].setText("acos");
            else if(i == 11)
                buttons1[i].setText("atan");

            buttons1[i].addActionListener(this);
            advancedFuncs.add(buttons1[i]);
        }
        frame.add(advancedFuncs);
        frame.setVisible(true);
    }

    public boolean check()
    {
        int temp = 0;
        for(int i = 0; i < equation.length(); i++)
        {
            if(i!=0)
            {
                if(equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == 'x' || equation.charAt(i) == '/')
                {
                    temp++;
                    if(firstSpot)
                    {
                        firstSymbolIndex = i;
                        firstSpot = false;
                        symbol = "" + equation.charAt(i);
                    }
                }
            }
        }
        if(temp > 1)
            return true;
        return false;
    }

    public boolean checkEquals()
    {
        int temp = 0;
        for(int i=0; i < equation.length(); i++)
        {
            if(equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == 'x' || equation.charAt(i) == '/')
            {
                temp++;
                if(firstSpot)
                {
                    firstSymbolIndex = i;
                    firstSpot = false;
                    symbol = "" + equation.charAt(i);
                }
            }
        }
        if(temp > 0)
            return true;
        return false;
    }

    public int manualCheck()
    {
        if(equation.indexOf("+") != -1) return equation.indexOf("+");
        if(equation.indexOf("-") != -1) return equation.indexOf("-");
        if(equation.indexOf("x") != -1) return equation.indexOf("x");
        if(equation.indexOf("/") != -1) return equation.indexOf("/");
        return 0;

    }

    public void checkInt()
    {
        int toCheck = (int)num1;
        if(toCheck == num1) isInt = true;
        else isInt = false;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()=="." && veryFirst)
            return;
        if(e.getActionCommand()=="+" && veryFirst)
            return;
        if(e.getActionCommand()=="-" && veryFirst)
            return;
        if(e.getActionCommand()=="x" && veryFirst)
            return;
        if(e.getActionCommand()=="/" && veryFirst)
            return;
        if(e.getActionCommand() == "√" && veryFirst)
            return;
        if(e.getActionCommand() == "log" && veryFirst)
            return;
        if(e.getActionCommand() == "ln" && veryFirst)
            return;
        if(e.getActionCommand() == "x^2" && veryFirst)
            return;
        if(e.getActionCommand() == "sin" && veryFirst)
            return;
        if(e.getActionCommand() == "cos" && veryFirst)
            return;
        if(e.getActionCommand() == "tan" && veryFirst)
            return;
        if(e.getActionCommand() == "asin" && veryFirst)
            return;
        if(e.getActionCommand() == "acos" && veryFirst)
            return;
        if(e.getActionCommand() == "atan" && veryFirst)
            return;
        veryFirst = false;
        if(e.getActionCommand()=="." && equation.charAt(equation.length()-1)=='.')
            return;
        if(e.getActionCommand()=="+" && equation.charAt(equation.length()-1)=='+')
            return;
        if(e.getActionCommand()=="-" && equation.charAt(equation.length()-1)=='-')
            return;
        if(e.getActionCommand()=="x" && equation.charAt(equation.length()-1)=='x')
            return;
        if(e.getActionCommand()=="/" && equation.charAt(equation.length()-1)=='/')
            return;
        if(e.getActionCommand()=="√" && equation.charAt(equation.length()-1)=='√')
            return;
        if(e.getActionCommand()=="log" && equation.contains("log"))
            return;
        if(e.getActionCommand()=="ln" && equation.contains("ln"))
            return;
        if(e.getActionCommand()=="x^2" && equation.contains("x^2"))
            return;
        if(e.getActionCommand()=="sin" && equation.contains("sin"))
            return;
        if(e.getActionCommand()=="cos" && equation.contains("cos"))
            return;
        if(e.getActionCommand()=="tan" && equation.contains("tan"))
            return;
        if(e.getActionCommand()=="tan" && equation.contains("asin"))
            return;
        if(e.getActionCommand()=="tan" && equation.contains("acos"))
            return;
        if(e.getActionCommand()=="tan" && equation.contains("atan"))
            return;

        if((e.getActionCommand().equals("√") && checkConsole() == true))
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else num1 = Math.sqrt(Double.parseDouble(console.getText()));

            checkInt();
            System.out.println(isInt);
            if(isInt)
            {
                temp = (int)num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }
            System.out.println(temp);

            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("x^2") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else num1 = Math.pow(Double.parseDouble(console.getText()),2);
            checkInt();
            System.out.println(isInt);
            if(isInt)
            {
                temp = (int)num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }

            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("sin") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.sin(Math.toRadians(Double.parseDouble(console.getText())));
                if (Double.parseDouble(console.getText()) % 180 == 0)
                    console.setText("" + 0);
            }

            checkInt();
            System.out.println(isInt);
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("cos") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.cos(Math.toRadians(Double.parseDouble(console.getText())));
                if (Double.parseDouble(console.getText()) == 0)
                    console.setText("" + 1);
                else if (Double.parseDouble(console.getText()) == 180)
                    console.setText("" + -1);
                else if (Double.parseDouble(console.getText()) == 360)
                    console.setText("" + 1);
                else if (Double.parseDouble(console.getText()) % 90 == 0)
                    console.setText("" + 0);
            }

            checkInt();
            System.out.println(isInt);
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("tan") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.tan(Math.toRadians(Double.parseDouble(console.getText())));
                if (Double.parseDouble(console.getText()) % 180 == 0)
                    num1 = 0;
                else if (Double.parseDouble(console.getText()) % 90 == 0)
                    console.setText("NaN");
            }
            checkInt();
            System.out.println(isInt);
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }

            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("asin") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
            {
                EPI(e.getActionCommand());
                return;
            }
            else
            {
                num1 = Math.asin((Double.parseDouble(console.getText())));
                checkInt();
                System.out.println(isInt);
            }
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + Math.toDegrees(num1));
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("acos") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
            {
                EPI(e.getActionCommand());
                return;
            }
            else
            {
                num1 = Math.acos(Double.parseDouble(console.getText()));
                checkInt();
                System.out.println(isInt);
            }
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + Math.toDegrees(num1));
            }

            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("atan") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.atan(Double.parseDouble(console.getText()));
                checkInt();
                System.out.println(isInt);
            }
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                if(console.getText().equals("π") || console.getText().equals("e"))
                    console.setText("" + num1);
                else
                    console.setText("" + Math.toDegrees(num1));
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("log") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.log10(Double.parseDouble(console.getText()));
                checkInt();
            }
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }
        if(e.getActionCommand().equals("ln") && checkConsole() == true)
        {
            int temp = 0;
            if(console.getText().equals("π") || console.getText().equals("e"))
                EPI(e.getActionCommand());
            else
            {
                num1 = Math.log(Double.parseDouble(console.getText()));
                checkInt();
            }
            if (isInt)
            {
                temp = (int) num1;
                console.setText("" + temp);
            }
            else
            {
                console.setText("" + num1);
            }
            calcText = console.getText();
            console.setCaretPosition(0);
            equation = console.getText();

            return;
        }

        if(e.getSource()==ac)
        {
            equation = "";
            calcText = "0";
            console.setText(calcText);
            first = true;
            veryFirst = true;
            return;
        }
        if(e.getSource()==buttons[15])
        {
            if(checkEquals() == true)
            {
                equation = equation.replace("e", "" + Math.exp(1));
                equation = equation.replace("π", "" + Math.PI);
                firstSymbolIndex = manualCheck();

                num1 = Double.parseDouble(equation.substring(0, firstSymbolIndex));
                num2 = Double.parseDouble(equation.substring(firstSymbolIndex+1));

                if(symbol.equals("+"))
                    num1 = num1+num2;
                else if(symbol.equals("-"))
                    num1 = num1-num2;
                else if(symbol.equals("x"))
                    num1 = num1*num2;
                else if(symbol.equals("/"))
                    num1 = num1/num2;
                checkInt();

                if(isInt)
                    calcText = "" + (int)num1;
                else
                    calcText = "" + num1;

                console.setText(calcText);
                console.setCaretPosition(0);
                first = true;
                firstSpot = true;
                return;
            }
        }
        else
        {
            equation += e.getActionCommand();
            if(check()==true)
            {
                equation = equation.replace("e", "" + Math.exp(1));
                equation = equation.replace("π", "" + Math.PI);
                firstSymbolIndex = manualCheck();
                holder = ""+equation.charAt(equation.length()-1);
                equation = equation.substring(0, equation.length()-1);
                num1 = Double.parseDouble(equation.substring(0, firstSymbolIndex));
                num2 = Double.parseDouble(equation.substring(firstSymbolIndex+1));

                if(symbol.equals("+"))
                    num1 = num1 + num2;
                else if(symbol.equals("-"))
                    num1 = num1 - num2;
                else if(symbol.equals("x"))
                    num1 = num1 * num2;
                else if(symbol.equals("/"))
                    num1 = num1 / num2;
                checkInt();
                if(isInt)
                    calcText = "" + (int)num1;
                else
                    calcText = "" + num1;

                console.setText(calcText);
                console.setCaretPosition(0);
                equation = calcText + holder;

                first = true;
                firstSpot = true;
                return;
            }

            if(first && e.getActionCommand().equals(".")==false)
            {
                calcText = e.getActionCommand();
                first = false;
                console.setText(calcText);
            }
            else
            {
                if(e.getActionCommand().equals("+")==false && e.getActionCommand().equals("-")==false && e.getActionCommand().equals("x")==false && e.getActionCommand().equals("/")==false)
                    calcText += e.getActionCommand();
                else
                    first = true;
                if(e.getActionCommand().equals("."))
                    first = false;
                console.setText(calcText);
            }
        }
    }
    private boolean checkConsole()
    {
        if(console.getText().equals("π") || console.getText().equals("e"))
            return true;

        try
        {
            Double.parseDouble(console.getText());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
        }

    public void EPI(String function)
    {
        if(console.getText().equals("π"))
        {
            if(function.equalsIgnoreCase("√"))
            {
                num1 = Math.sqrt(Math.PI);
            }
            if(function.equalsIgnoreCase("ln"))
            {
                num1 = Math.log(Math.PI);
            }
            if(function.equalsIgnoreCase("log"))
            {
                num1 = Math.log10(Math.PI);
            }
            if(function.equalsIgnoreCase("x^2"))
            {
                num1 = Math.pow(Math.PI,2);
            }
            if(function.equalsIgnoreCase("sin"))
            {
                num1 = 0;
            }
            if(function.equalsIgnoreCase("cos"))
            {
                num1 = -1;
            }
            if(function.equalsIgnoreCase("tan"))
            {
                num1 = 0;
            }
            if(function.equalsIgnoreCase("asin"))
            {
                console.setText("NaN");
            }
            if(function.equalsIgnoreCase("acos"))
            {
                console.setText("NaN");
            }
            if(function.equalsIgnoreCase("atan"))
            {
                num1 = 72.34321285;
            }
        }
        if(console.getText().equals("e"))
        {
            if(function.equalsIgnoreCase("√"))
            {
                num1 = Math.sqrt(Math.exp(1));
            }
            if(function.equalsIgnoreCase("ln"))
            {
                num1 = Math.log(Math.exp(1));
            }
            if(function.equalsIgnoreCase("log"))
            {
                num1 = Math.log10(Math.exp(1));
            }
            if(function.equalsIgnoreCase("x^2"))
            {
                num1 = Math.pow(Math.exp(1),2);
            }
            if(function.equalsIgnoreCase("sin"))
            {
                num1 = Math.sin(Math.toRadians(Math.exp(1)));
            }
            if(function.equalsIgnoreCase("cos"))
            {
                num1 = Math.cos(Math.toRadians(Math.exp(1)));
            }
            if(function.equalsIgnoreCase("tan"))
            {
                num1 = Math.tan(Math.toRadians(Math.exp(1)));
            }
            if(function.equalsIgnoreCase("asin"))
            {
                console.setText("NaN");
            }
            if(function.equalsIgnoreCase("acos"))
            {
                console.setText("NaN");
            }
            if(function.equalsIgnoreCase("atan"))
            {
                num1 = 69.80246871;
            }
        }
     }
}
