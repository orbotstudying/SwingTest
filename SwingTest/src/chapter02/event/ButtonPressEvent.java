package chapter02.event;

import java.util.EventObject;

/**
 * Created by orbot on 17.05.15.
 */
public class ButtonPressEvent extends EventObject {
    // Конструктор. Требует задать источник события
    public ButtonPressEvent(Object source) {
        super(source);
    }
}
