import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        GameObject gameObject=new GameObject(500,500, 1,  0.5);
        Tank tank1=new Tank(750,300, 1,  0.05);
        Wall wall=new Wall(700, 400, 200, 25);
        Gun gun=new Gun(500, 500, 1, 0.05);

        // Создаем окно
        JFrame frame = new JFrame();
        TankPanel tankPanel=new TankPanel(tank1, wall, gun);
        frame.add(tankPanel);        // добавляем в окно панель
        frame.setSize(1600, 500);
        frame.setVisible(true);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();   // менеджер по трудоустройству слушателей клавиатуры
        manager.addKeyEventDispatcher(tankPanel);    // подключаем нашу панель к прослушиванию клавиатуры

        while (true) {
            frame.repaint();
        }

    }
}






// Поворот с корпусом + нормаьная стенка