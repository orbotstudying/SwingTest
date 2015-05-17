package chapter03;

import javax.swing.*;
import java.awt.*;

/**
 * Created by orbot on 17.05.15.
 */
public class MaskingEvents extends JFrame {
    public MaskingEvents() {
        super("MaskingEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // отключим событие от окна
        disableEvents(AWTEvent.WINDOW_EVENT_MASK);
        // добавим особую кнопку
        JPanel contents = new JPanel();
        contents.add(new CustomButton("Привет!"));
        setContentPane(contents);
        // выведем окно на экран
        setSize(400, 300);
        setVisible(true);

    }
    /**
     *  особая кнопка
     */
    class CustomButton extends JButton {
        public CustomButton(String label) {
            super(label);
            // отключаем события с клавиатуры и от мыши
            disableEvents(AWTEvent.KEY_EVENT_MASK);
            disableEvents(AWTEvent.MOUSE_EVENT_MASK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new MaskingEvents();
                    }
                }
        );
    }
}
