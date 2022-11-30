import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Главное окно приложения
public class GameWindow extends JFrame {
    private Container container;

    public void setContainer(Container container) {
        this.container = container;
    }
    public Container getContainer() {
        return this.container;
    }

    GameWindow() {
        super("Пятнашки");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = new Container(createGameArray(), this);
        add(container);

        // Слушатель события нажатия на клавишу "]", быстрое завершение игры
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ']') {
                    endGameCheat();
                }
            }
        });
        setFocusable(true);
        setVisible(true);
    }

    // Создание исходного случайного массива
    public int[] createGameArray() {
        int[] numbers = new int[16];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            list.add(i + 1);

        int validationSum = 0;

        /* Проверка на разрешимость сгенерированной конфигурации
        Сумма (validationSum) пар блоков, в которых костяшка с большим номером идет перед костяшкой с меньшим номером (sumOfPairs)
        и номера ряда пустой клетки должна быть чётна, иначе решения не существует
        */
        do {
            Collections.shuffle(list);
            int[] sumOfPairs = new int[15];

            for (int i = 0; i < 15; i++) {
                int pairsNum = 0;
                for (int j = i + 1; j < 14; j++) {
                    if (list.get(i) > list.get(j))
                        pairsNum++;
                }
                sumOfPairs[i] = pairsNum;
            }

            for (int num : sumOfPairs)
                validationSum += num + 4;
        } while (validationSum % 2 != 0);

        list.add(0);
        for (int i = 0; i < 16; i++)
            numbers[i] = list.get(i);
        return numbers;
    }

    // Обновление представления окна игры после перестановки
    public void updateView(int[] numbers, Container container) {
        remove(container);
        this.container = new Container(numbers, this);
        add(this.container);
        validate();
        checkGameEnding(numbers);
    }

    // Проверка завершённости игры: если все элементы расположены в порядке возрастания, игра завершается
    public void checkGameEnding(int[] numbers) {
        int order = 0;
        for (int i = 0; i < 14; i++) {
            if (numbers[i] > numbers[i + 1])
                order = 1;
        }
        if (order == 0) {
            JOptionPane.showMessageDialog(null, "ПОБЕДКА", "Конец игры", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }

    // Досрочное завершение игры
    private void endGameCheat() {
        int[] numbers = new int[16];
        for (int i = 0; i < 15; i++)
            numbers[i] = i + 1;
        numbers[15] = 0;

        updateView(numbers, container);
    }
}
