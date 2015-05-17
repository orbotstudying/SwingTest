package chapter03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by orbot on 17.05.15.
 */
public class ConsumingEvents extends JFrame {
    public ConsumingEvents() {
        super("ConsumingEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // слушатель, поглощающий печатание символов
        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }
        };
        // добавляем текстовые поля
        setLayout(new FlowLayout());
        JTextField swingField = new JTextField(10);
        swingField.addKeyListener(kl);
        add(swingField);
        TextField awtField = new TextField(10);
        add(awtField);
        awtField.addKeyListener(kl);
        // кнопка
        JButton button = new JButton("Жмите!");
        add(button);
        // слушатель пытается поглотить события от мыши
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();
            }
        });
        // выводим окно на экран
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new ConsumingEvents();
                    }
                }
        );
    }
}
