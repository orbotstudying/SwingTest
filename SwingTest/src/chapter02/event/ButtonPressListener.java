package chapter02.event;

import java.util.EventListener;

/**
 * Created by orbot on 17.05.15.
 */
public interface ButtonPressListener extends EventListener {
    // данный метод будет вызываться при нажатии кнопки
    void buttonPressed(ButtonPressEvent e);
}
