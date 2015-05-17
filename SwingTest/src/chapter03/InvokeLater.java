package chapter03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by orbot on 17.05.15.
 */
public class InvokeLater extends JFrame {
    public InvokeLater() {
        super("InvokeLater");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // добавим кнопку со слушателем
        button = new JButton("Выполнить сложную работу");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // запустим отдельный поток
                new ComplexJobThread().start();
                button.setText("Подождите...");
            }
        });
        // настроим панель содержимого и выведем на экран
        setLayout(new FlowLayout());
        add(new JTextField(20));
        add(button);
        setSize(300, 200);
        setVisible(true);
    }

    private JButton button;

    // поток, выполняющий "сложную работу"
    class ComplexJobThread extends Thread {
        public void run() {
            try {
                // изображаем задержку
                sleep(3000);
                // работа закончена, нужно изменить интерфейс
                  EventQueue.invokeLater(
                      new Runnable() {
                            @Override
                            public void run() {
                                button.setText("Работа завершена");
                            }
                        }
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new InvokeLater();
                    }
                }
        );
    }
}
