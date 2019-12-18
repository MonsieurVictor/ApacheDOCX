package com.samosvat.diplom;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.awt.Component.CENTER_ALIGNMENT;

public class GUI {
    private JPanel rootPanel;
    private JPanel panelMain;
    private JButton buttonSetDocx;
    private JButton buttonSetChapters;
    private JButton buttonSetStyles;
    private JButton buttonSetOutput;
    String newFileName = "";

    private JFrame jFrameMain = new JFrame("DOCX analyzer");

    public void startDraw(){

        jFrameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label = new JLabel();
        label.setAlignmentX(CENTER_ALIGNMENT);


        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Выбрать документ");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    label.setText("Выбранный документ: " + file.getName());
                }
            }
        });

        final JLabel label2 = new JLabel();
        label2.setAlignmentX(CENTER_ALIGNMENT);


        JButton button2 = new JButton("Выбрать оформление");
        button2.setAlignmentX(CENTER_ALIGNMENT);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    label2.setText("Выбранный стиль: " + file.getName());
                }
            }
        });

        final JLabel label3 = new JLabel();
        label3.setAlignmentX(CENTER_ALIGNMENT);

        JButton button3 = new JButton("Выбрать структуру");
        button3.setAlignmentX(CENTER_ALIGNMENT);

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    label3.setText("Выбранная структура: " + file.getName());
                }
            }
        });

        final JLabel label4 = new JLabel();
        label4.setAlignmentX(CENTER_ALIGNMENT);

        JButton button4 = new JButton("Указать путь для нового файла");
        button4.setAlignmentX(CENTER_ALIGNMENT);

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    newFileName = file.getName();
                    label4.setText("Выбранный путь: " + file.getName());
                }
            }
        });

        final JLabel label5 = new JLabel();
        label5.setAlignmentX(CENTER_ALIGNMENT);

        JButton button5 = new JButton("Анализ");
        button5.setAlignmentX(CENTER_ALIGNMENT);

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel,
                        "<html><h2>Готово.</h2><i>файл </i>"+ newFileName +" успешно создан!");
            }
        });


        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.add(label3);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.add(label4);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(button4);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.add(label5);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(button5);
        panel.add(Box.createVerticalGlue());

        jFrameMain.getContentPane().add(panel);

        jFrameMain.setPreferredSize(new Dimension(460, 370));
        jFrameMain.pack();
        jFrameMain.setLocationRelativeTo(null);
        jFrameMain.setVisible(true);
//        buttonTopRx = new JButton(new ImageIcon(getClass().getResource("/main/resources/receivers3.png")));
//        buttonTopTx = new JButton(new ImageIcon(getClass().getResource("/main/resources/Tx.png")));
//        buttonTopProtocols = new JButton(new ImageIcon(getClass().getResource("/main/resources/protocols2.png")));
//        buttonTopApps = new JButton(new ImageIcon(getClass().getResource("/main/resources/apps.png")));
    }
}
