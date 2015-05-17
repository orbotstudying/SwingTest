package chapter02;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by orbot on 16.05.15.
 */
public class LowLevelEvents extends JFrame {
    //Сюда мы будем выводить информацию
    private JTextArea out;
    public LowLevelEvents() {
        //При закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Добавим текстовое поле
        add(new JScrollPane(out = new JTextArea()));
        //и кнопку
        JButton button = new JButton("Источник событий");
        add(button, "South");
        //Регистрируем нашего слушателя
        OurListener ol = new OurListener();
        button.addKeyListener(ol);
        button.addMouseListener(ol);
        button.addMouseMotionListener(ol);
        button.addMouseWheelListener(ol);
        button.addFocusListener(ol);
        // выводим окно на экран
        setSize(400, 400);
        setVisible(true);
    }


    class OurListener implements MouseListener, KeyListener, MouseMotionListener, MouseWheelListener, FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void focusLost(FocusEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            out.append(e.toString() + "\n");
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            out.append(e.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                 public void run() {
                     new LowLevelEvents();
                 }
                }
        );
    }
}

