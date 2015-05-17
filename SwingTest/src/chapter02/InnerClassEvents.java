package chapter02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by orbot on 16.05.15.
 */
public class InnerClassEvents extends JFrame {
    private JTextField text;
    private JButton button;
    public InnerClassEvents() {
        super("InnerClassEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // последовательное расположение
        setLayout(new FlowLayout());
        // добавим текстовое поле
        add(text = new JTextField(10));
        // и кнопку
        add(button = new JButton("Нажмите"));
        // будем следить за нажатием кнопки
        button.addActionListener(new ButtonL());
        // выводим окно на экран
        pack();
        setVisible(true);
    }

    class ButtonL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(text.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new InnerClassEvents();
                    }
                }
        );
    }
}
