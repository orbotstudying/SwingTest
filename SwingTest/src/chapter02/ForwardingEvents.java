package chapter02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by orbot on 16.05.15.
 */
public class ForwardingEvents extends JFrame {
    public ForwardingEvents() {
        super("ForwardingEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // последовательное расположение
        getContentPane().setLayout(new FlowLayout());
        // добавим пару кнопок
        button1 = new JButton("OK");
        button2 = new JButton("Cancel");
        getContentPane().add(button1);
        getContentPane().add(button2);
        // будем следить за нажатиями кнопок
        Forwarder forwarder = new Forwarder();
        button1.addActionListener(forwarder);
        button2.addActionListener(forwarder);
        // выводим окно на экран
        pack();
        setVisible(true);
    }

    JButton button1, button2;
    // класс - слушатель нажатия на кнопку
    class Forwarder implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // рассылаем событие по методам
            if (e.getSource() == button1) onOk(e);
            if (e.getSource() == button2) onCancel(e);
        }
    }

    // обработка события от кнопки "OK"
    public void onOk(ActionEvent e) {
        System.out.println("onOk()");
    }
    // обработка события от кнопки "Cancel"
    public void onCancel(ActionEvent e) {
        System.out.println("onCancel()");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new ForwardingEvents();
                    }
                }
        );
    }
}
