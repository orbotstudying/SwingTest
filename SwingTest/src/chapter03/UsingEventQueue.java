package chapter03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by orbot on 17.05.15.
 */
public class UsingEventQueue extends JFrame {
    public UsingEventQueue() {
        super("UsingEventQueue");
        // выход при закрытии окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //кнопка и ее слушатель
        JButton button = new JButton("Генерировать событие");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // генерируем событие закрытия окна
                getToolkit().getSystemEventQueue().postEvent(
                        new WindowEvent(UsingEventQueue.this,
                                WindowEvent.WINDOW_CLOSING)
                );
            }
        });
        // добавим кнопку в панель содержимого
        setLayout(new FlowLayout());
        add(button);
        // выведем окно на экран
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new UsingEventQueue();
                    }
                }
        );
    }
}
