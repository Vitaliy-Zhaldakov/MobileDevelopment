import javax.swing.*;
import java.awt.*;

// Блок-кнопка игрового поля
public class Block extends JButton {

    Block(String number) {
        super(number);
        setFont(new Font("Comic Sans", Font.PLAIN, 30));
    }
}
