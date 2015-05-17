package chapter03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by orbot on 17.05.15.
 */
public class UsingSwingWorker extends JFrame {
    private JButton button;
    public UsingSwingWorker() {
        super("UsingSwingWorker");
        // при закрытии окна - выход
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // добавим кнопку со слушателем
        button = new JButton("Выполнить сложную работу");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // запустим отдельную долгую работу
                new ComplexJob().execute();
                button.setText("Подождите...");
            }
        });
        // настроим панель содержимого и выведем окно на экран
        setLayout(new FlowLayout());
        add(new JTextField(20));
        add(button);
        setSize(300, 200);
        setVisible(true);
    }
    /**
     *  класс, выполняющий "сложную работу
     */
    class ComplexJob extends SwingWorker<String, String> {
        /**
         * здесь выполняется работа. Это отдельный поток
         * @throws Exception
         */
        @Override
        protected String doInBackground() throws Exception {
            Thread.sleep(2000);
            //публикуем промежуточные результаты
            publish("Половина работы закончена...");
            Thread.sleep(2000);
            return "";
        }
        // обработка промежуточных результатов
        // это поток рассылки событий!
        protected void process(List<String> chunks) {
            button.setText(chunks.get(0));
        }
        // окончание работы - и вновь это поток рассылки
        public void done() {
            button.setText("Работа завершена");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new UsingSwingWorker();
                    }
                }
        );
    }
}
