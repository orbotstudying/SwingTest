package chapter02;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by orbot on 16.05.15.
 */
public class Adapters extends JFrame {
    public Adapters() {
        super("chapter02.Adapters");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // регистрируем слушателя
        addMouseListener(new MouseL());
        // выводим окно на экран
        setSize(200, 200);
        setVisible(true);
    }

    class MouseL extends MouseAdapter {
        // следим за щелчками мыши в окне
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new Adapters();
                    }
                }
        );
    }
}
