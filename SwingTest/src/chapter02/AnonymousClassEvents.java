package chapter02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by orbot on 16.05.15.
 */
public class AnonymousClassEvents extends JFrame {
    public AnonymousClassEvents() {
        super("AnonymousClassEvents");
        // анонимный класс присоединяется прямо на месте
        // выход из приложения при закрытии окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // добавим кнопку
        JButton button = new JButton("Нажмите меня");
        getContentPane().add(button);
        // слушатель создаётся в методе
        button.addActionListener(getButtonL());
        // выводим окно на экран
        pack();
        setVisible(true);
    }
    // этот метод создаёт слушателя кнопки
    public ActionListener getButtonL() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionListener");
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new AnonymousClassEvents();
                    }
                }
        );
    }
}
