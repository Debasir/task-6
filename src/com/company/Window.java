package com.company;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Window extends JFrame {
    private JPanel panelMain;
    private JButton loadTextButton;
    private JButton saveToFileButton;
    private JButton startButton;
    private JTextArea textIn;
    private JTextArea textOut;
    private JPanel panelIn;
    private JScrollPane scrolIn;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Window() {
        this.setTitle("Кравцов Task 6");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(600, 330);

        setLocationRelativeTo(null); 

        textIn.setRows(1000);
        textIn.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textIn.setLineWrap(true);

        textOut.setRows(1000);
        textOut.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textOut.setLineWrap(true);

        final String[] text = {""};
        final String[] outText = {""};

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt", "windows-1251");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text[0] = "";
                text[0] = textIn.getText();

                MyCounter.countMeeting(text[0]);
                StandartCounter.countMeeting(text[0]);

                if (text[0].length() > 1 && StandartCounter.strOutStandart.length() > 2) {
                    outText[0] = ("Стандартная: " + StandartCounter.strOutStandart + "\n" + "Своя: " + MyMapImplements.outStr);
                    textOut.setText(outText[0]);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Пожалуйста, заполните поле вводи или введите корректный текст и повторите попытку", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }

                    textOut.setText(outText[0]);

                }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        FileWriter fw = new FileWriter(file);
                        fw.write(outText[0]);
                        fw.flush();
                        fw.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            }
        });

        loadTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {

                        FileReader fr = new FileReader(fileChooserOpen.getSelectedFile().getPath());
                        StringBuffer strBuffer = new StringBuffer();
                        int symbol;
                        while ((symbol = fr.read()) != -1) {
                            strBuffer.append((char) symbol);
                        }
                        textIn.setText(strBuffer.toString());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelIn = new JPanel();
        panelIn.setLayout(new GridLayoutManager(2, 1, new Insets(20, 20, 10, 20), -1, -1));
        panelMain.add(panelIn, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(550, 109), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Ввод:");
        panelIn.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(243, 16), null, 0, false));
        scrolIn = new JScrollPane();
        panelIn.add(scrolIn, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textIn = new JTextArea();
        scrolIn.setViewportView(textIn);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(20, 20, 20, 20), -1, -1));
        panelMain.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(260, 119), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Вывод:");
        panel1.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textOut = new JTextArea();
        textOut.setEditable(false);
        scrollPane1.setViewportView(textOut);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(3, 1, new Insets(20, 0, 0, 20), -1, -1));
        panel2.putClientProperty("html.disable", Boolean.FALSE);
        panelMain.add(panel2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(406, 104), null, 0, false));
        loadTextButton = new JButton();
        loadTextButton.setText("Загрузить текст из файла");
        panel2.add(loadTextButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Выполнить");
        panel2.add(startButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveToFileButton = new JButton();
        saveToFileButton.setText("Сохранить в текстовый файл");
        panel2.add(saveToFileButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
