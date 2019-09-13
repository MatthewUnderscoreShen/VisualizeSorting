import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Visual extends JFrame {

    Canvas c;
    int x, y, width, height;
    int delta = 1;
    //25 pixels from the edge of the screen
    int[] cellArray;
    Random rand = new Random();

    int[] jankArray; //A jacky solution to a problem caused by bad framework

    String[] sortList = {"Bubble Sort", "Quicksort", "Merge Sort"};
    String[] typeList = {"Continuous", "Random"};

    JComboBox<String> sortBox;
    JComboBox<String> typeBox;

    JButton startButton;

    String sortType, arrayType;
    int size, lBound, rBound;

    boolean isListening = true;

    public Visual() {
        super("Sorting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1060, 725);

        //Canvas?
        c = new Canvas() {
            public void paint(Graphics g) {
                //g.setColor(Color.GREEN);
                //g.fillRect(50, 50, 200, 200);
            }
        };
        c.setBackground(Color.BLACK);

        //Setting part
        JPanel oPanel = new JPanel();

        JButton updateButton = new JButton("Apply");

        sortBox = new JComboBox<String>(sortList); //Select algorithm
        sortBox.setSelectedIndex(0);
    
        JLabel sizeLabel = new JLabel("Size"); //Textbox for array size
        JTextField sizeField = new JTextField(3); //3 Digits;
        JLabel leftBoundLabel = new JLabel("Left Bound"); //Left bound
        JTextField lBoundField = new JTextField(6);
        JLabel rightBoundLabel = new JLabel("Right Bound"); //Right bound
        JTextField rBoundField = new JTextField(6);

        ActionListener doUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isListening) {
                    size = Integer.parseInt(sizeField.getText());
                    lBound = Integer.parseInt(lBoundField.getText());
                    rBound = Integer.parseInt(rBoundField.getText());
                    sortType = sortBox.getItemAt(sortBox.getSelectedIndex());
                    arrayType = typeBox.getItemAt(typeBox.getSelectedIndex());

                    try {
                        initArray();
                    }
                    catch (NullPointerException | ArithmeticException ex) {
                        System.out.print("");
                    }
                }
            }
        };
        updateButton.addActionListener(doUpdate);

        typeBox = new JComboBox<String>(typeList);
        typeBox.setSelectedIndex(0);

        startButton = new JButton("Sort!");

        //Add
        oPanel.add(updateButton);
        oPanel.add(sortBox);
        oPanel.add(sizeLabel);
        oPanel.add(sizeField);
        oPanel.add(leftBoundLabel);
        oPanel.add(lBoundField);
        oPanel.add(rightBoundLabel);
        oPanel.add(rBoundField);
        oPanel.add(typeBox);
        oPanel.add(startButton);

        add(c);
        add(BorderLayout.SOUTH, oPanel);

        setVisible(true);
    }

    JLabel sizeLabel = new JLabel();

    public void prepare() {
        while (!startButton.isSelected()) {
            System.out.print("");
        }

        isListening = false;
    }

    public void updateVisual(int cell, int value) { //Updates 1 cell at a time
        Graphics g = c.getGraphics();
        x = 25 + (width + delta) * cell;
        height = 5 + (650 / (rBound - lBound)) * value;
        y = 625 - height;

        g.setColor(Color.BLACK);
        g.fillRect(x-1, 0, width+2, 725);

        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void initArray() throws NullPointerException, ArithmeticException {
        Graphics g = c.getGraphics();
        cellArray = new int[size];
        jankArray = new int[size];
        rBound = lBound + cellArray.length;
        width = (int)((1000 - delta * cellArray.length) / cellArray.length);

        if (arrayType.equals("Continuous")) {
            for (int i = 0; i < cellArray.length; i++) {
                //height = 25 + (int)((rBound - lBound)/600) * i;
                //x = 25 + (width + delta) * i;
                
                updateVisual(i, i);
            }
        }
        else {
            for (int i = 0; i < cellArray.length; i++) {
                jankArray[i] = rand.nextInt(rBound - lBound) + lBound;
                height = 25 + (int)((rBound - lBound)/600) * jankArray[i];
                x = 25 + (width + delta) * i;

                printComponents(g);
                System.out.println("kms");
            }
        }
    }

    public int getArraySize() {
        return size;
    }

    public int getLBound() {
        return lBound;
    }

    public int getRBound() {
        return rBound;
    }

    public boolean getRandom() {
        return arrayType.equals("Random");
    }

    public String getSort() {
        return sortType;
    }
}