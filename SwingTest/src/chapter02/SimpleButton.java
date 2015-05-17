package chapter02;

import chapter02.event.ButtonPressEvent;
import chapter02.event.ButtonPressListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by orbot on 17.05.15.
 */
public class SimpleButton extends JComponent {
    // список слушателей
    private ArrayList<ButtonPressListener>
            listenerList = new ArrayList<>();
    // один объект - событие на все случаи жизни
    private ButtonPressEvent event =
            new ButtonPressEvent(this);

    // конструктор - присоединяет к кнопке слушателя
    // событий мыши
    public SimpleButton() {
        addMouseListener(new PressL());
        // зададим размеры компонента
        setPreferredSize(new Dimension(100, 100));
    }

    /**
     * Присоединяет слушателя нажатия кнопки
     */
    public void addButtonPressListener(ButtonPressListener l) {
        listenerList.add(l);
    }
    /**
     * Отсоединяет слушателя нажатия кнопки
     */
    public void removeButtonPressListener(ButtonPressListener l) {
        listenerList.remove(l);
    }
    /**
     * Прорисовывает кнопку
     */
    public void paintComponent(Graphics g) {
        // зальем зеленым цветом
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());
        // рамка
        g.setColor(Color.BLACK);
        g.draw3DRect(0, 0, getWidth(), getHeight(), true);
    }
    // оповещает слушателей о событии
    protected void fireButtonPressed() {
        for(ButtonPressListener l : listenerList) {
            l.buttonPressed(event);
        }
    }
    /**
     *  внутренний класс, следит за нажатиями мыши
     */
    class PressL extends MouseAdapter {
        /**
         * нажатие мыши в области кнопки
         */
        public void mousePressed(MouseEvent e) {
            // оповестим слушателей
            fireButtonPressed();
        }
    }
}
