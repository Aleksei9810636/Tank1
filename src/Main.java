import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        GameObject gameObject=new GameObject();
        Tank tank1=new Tank(750,300, 1,  0.05, 1000);
        Tank tank2=new Tank(100, 100, 1, 0.05, 1000);
        Wall wall=new Wall(700, 400, 200, 25);
        Gun gun=new Gun(0.2);

        // Создаем окно
        JFrame frame = new JFrame();
        TankPanel tankPanel=new TankPanel(tank1, tank2, wall, gun);
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