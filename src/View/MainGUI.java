package View;

import Core.AutoClick;
import Helper.Helper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JPanel pnl_mid;
    private JComboBox comboBox_buton;
    private JComboBox comboBox_clickType;
    private JButton başlatF6Button;
    private JButton durdurF6Button;
    private JRadioButton mevcutKonumRadioButton;
    private JRadioButton konumSeçRadioButton;
    private JTextField textField_xCoord;
    private JTextField textField_yCoord;
    private JSlider slider1;
    private JRadioButton benDurduranaKadarRadioButton;
    private JTextField textField_clickCount;
    private JLabel lbl_ms_slide;
    private JLabel lbl_yCoord;
    private JLabel lbl_xCood;

    public MainGUI() {
        add(wrapper);
        Helper.setLayout();
        setTitle("Auto Clicker");
        setSize(600, 250);
        setLocation(Helper.ScreenCoord("x", getSize()), Helper.ScreenCoord("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Helper.setLayout();
        setVisible(true);
        AutoClick autoClick = new AutoClick();
        lbl_ms_slide.setText(String.valueOf(slider1.getValue()) + " Ms.");

        textField_clickCount.setText("10");


        ButtonGroup G = new ButtonGroup();
        G.add(mevcutKonumRadioButton);
        G.add(konumSeçRadioButton);


        başlatF6Button.addActionListener(e -> {
            if (comboBox_buton.getSelectedIndex() == 0) {
                leftClick();
            } else if (comboBox_buton.getSelectedIndex() == 1) {
                rightClick();
            } else if (comboBox_buton.getSelectedIndex() == 0 && comboBox_clickType.getSelectedIndex() == 1) {
                leftDoubleClick();
            }else if (comboBox_buton.getSelectedIndex() == 1 && comboBox_clickType.getSelectedIndex() == 1){
                rightDoubleClick();
            }
            else {
                System.out.println("*******");
            }
        });
        durdurF6Button.addActionListener(e -> {

        });

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbl_ms_slide.setText(String.valueOf(slider1.getValue()) + " Ms.");
            }
        });


        comboBox_buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox_buton.getSelectedIndex());
            }
        });
        konumSeçRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seçildi");
                try {
                    Robot robot = new Robot();
                    robot.mouseMove(Integer.parseInt(textField_xCoord.getText()), Integer.parseInt(textField_yCoord.getText()));
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    public void leftClick() {
        AutoClick autoClick = new AutoClick();
        int delay = slider1.getValue();
        autoClick.setDelay(delay);
        int clicks = Integer.parseInt(textField_clickCount.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < clicks; i++) {
            autoClick.ClickMouse(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void rightClick() {
        AutoClick autoClick = new AutoClick();
        int delay = slider1.getValue();
        autoClick.setDelay(delay);
        int clicks = Integer.parseInt(textField_clickCount.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < clicks; i++) {
            autoClick.ClickMouse(InputEvent.BUTTON3_DOWN_MASK);
        }
    }

    public void leftDoubleClick() {
        AutoClick autoClick = new AutoClick();
        int delay = slider1.getValue();
        autoClick.setDelay(delay);
        int clicks = Integer.parseInt(textField_clickCount.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < clicks; i++) {
            autoClick.ClickDoubleMouse(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public void rightDoubleClick() {
        AutoClick autoClick = new AutoClick();
        int delay = slider1.getValue();
        autoClick.setDelay(delay);
        int clicks = Integer.parseInt(textField_clickCount.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < clicks; i++) {
            autoClick.ClickDoubleMouse(InputEvent.BUTTON3_DOWN_MASK);
        }
    }


}