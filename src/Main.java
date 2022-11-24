import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Tank tank1=new Tank(500,500, 15,  0.00001);


        // Создаем окно
        JFrame frame = new JFrame();
        TankPanel tankPanel=new TankPanel(tank1);
        frame.add(tankPanel);        // добавляем в окно панель
        frame.setSize(1600, 1000);
        frame.setVisible(true);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();   // менеджер по трудоустройству слушателей клавиатуры
        manager.addKeyEventDispatcher(tankPanel);    // подключаем нашу панель к прослушиванию клавиатуры

        while (true) {
            frame.repaint();
        }

    }
}






// Поворот с корпусом + нормаьная стенка