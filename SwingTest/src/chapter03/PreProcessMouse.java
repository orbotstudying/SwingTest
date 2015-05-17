package chapter03;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by orbot on 17.05.15.
 */
public class PreProcessMouse extends JFrame {
    PreProcessMouse() {
        super("PreProcessMouse");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // добавим слушателя событий от мыши
        addMouseListener(new MouseL());
        // выводим окно на экран
        setSize(200, 200);
        setVisible(true);
    }
    /**
     *  перехват событий от мыши
     */
    @Override
    public void processMouseEvent(MouseEvent e) {
        if (e.getClickCount() == 1) {
            // один щелчок не пропускаем к слушателям
            return;
        }
        // иначе вызываем метод базового класса
        else super.processMouseEvent(e);
    }

    /**
     *  в этом слушателе будем следить за щелчками мыши
     */
    class MouseL extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(
                    "ClickCount: " + e.getClickCount()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new PreProcessMouse();
                    }
                }
        );
    }
}
