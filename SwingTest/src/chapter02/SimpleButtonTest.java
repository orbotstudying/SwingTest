package chapter02;

import chapter02.event.ButtonPressEvent;
import chapter02.event.ButtonPressListener;

import javax.swing.*;

/**
 * Created by orbot on 17.05.15.
 */
public class SimpleButtonTest extends JFrame {
    public SimpleButtonTest() {
        super("SimpleButtonTest");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // создаём кнопку и присоединяем слушателей
        SimpleButton button = new SimpleButton();
        // анонимный класс
        button.addButtonPressListener(
                new ButtonPressListener() {
                    @Override
                    public void buttonPressed(ButtonPressEvent e) {
                        System.out.println("1!");
                    }
                }
        );
        // внутренний класс
        button.addButtonPressListener(new ButtonL());
        // добавим кнопку в окно
        JPanel contents = new JPanel();
        contents.add(button);
        setContentPane(contents);
        // выведем окно на экран
        setSize(400, 300);
        setVisible(true);
    }

    class ButtonL implements ButtonPressListener {
        @Override
        public void buttonPressed(ButtonPressEvent e) {
            System.out.println("2!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new SimpleButtonTest();
                    }
                }
        );
    }
}
