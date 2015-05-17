package chapter02;

import javax.swing.*;
import java.awt.*;

/**
 * Created by orbot on 17.05.15.
 */
public class ContainsTest extends JFrame {
    public ContainsTest() {
        super("ContainsTest");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // добавим кнопку и переопределим метод
        JButton button = new JButton("Невидима") {
            @Override
            public boolean contains(int x, int y) {
                // не содержит ни одной точки
                return false;
            }
        };
        // настроим панель содержимого и выведем окно на экран
        setLayout(new FlowLayout());
        add(button);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new ContainsTest();
                    }
                }
        );
    }
}
