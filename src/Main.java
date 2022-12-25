import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        GameObject gameObject=new GameObject();  // вообщем то бесполезно
        Tank tank1=new Tank(750,300, 1,  0.05, 900, 20, 5);
        Tank tank2=new Tank(100, 100, 1, 0.05, 900, 1000, 2);


        Wall wall=new Wall(700, 400, 200, 25);
        Gun gun=new Gun(0.2);
        KeyBoardGun keyBoardGun=new KeyBoardGun(0.2);

        // Создаем окно
        JFrame frame = new JFrame();
        TankPanel tankPanel=new TankPanel(tank1, tank2, wall, gun, keyBoardGun);
        frame.add(tankPanel);        // добавляем в окно панель
        frame.setSize(2000, 1000);
        frame.setVisible(true);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();   // менеджер по трудоустройству слушателей клавиатуры
        manager.addKeyEventDispatcher(tankPanel);    // подключаем нашу панель к прослушиванию клавиатуры

        while (true) {
            frame.repaint();
        }

    }
}






// Поворот с корпусом + нормаьная стенка