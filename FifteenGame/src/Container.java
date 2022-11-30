import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Container extends JPanel {
    private int[] numbers;
    private GameWindow gameWindow;

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    public int[] getNumbers() {
        return numbers;
    }
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    public GameWindow getGameWindow() {
        return gameWindow;
    }

    Container(int[] numbers, GameWindow gameWindow) {
        setNumbers(numbers);
        setGameWindow(gameWindow);

        // Установка схемы расположения элементов на панели
        setLayout(new GridLayout(4, 4, 5, 5));

        // Создание блоков игрового поля
        for (int number : numbers) {
            if (number != 0) {
                Block button = new Block(Integer.toString(number));
                button.setActionCommand(Integer.toString(number));

                // Задание события по нажатию на блок
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        moveSelectedBlock(Integer.parseInt(event.getActionCommand()));
                    }
                });
                add(button);
            } else
                add(new JPanel());
        }
    }

    // Передвижение выбранного блока
    public void moveSelectedBlock(int selectedNum) {
        int indexOfNum = indexOf(selectedNum, numbers);

        if (indexOfNum < 4) {
            // Если выбран блок в последнем столбце
            if ((indexOfNum + 1) % 4 == 0) {
                if (numbers[indexOfNum - 1] == 0)
                    swap(indexOfNum, indexOfNum - 1);
                else if (numbers[indexOfNum + 4] == 0)
                    swap(indexOfNum, indexOfNum + 4);
            }
            // Если выбран блок в первом столбце
            else if (indexOfNum % 4 == 0) {
                if (numbers[indexOfNum + 1] == 0)
                    swap(indexOfNum, indexOfNum + 1);
                else if (numbers[indexOfNum + 4] == 0)
                    swap(indexOfNum, indexOfNum + 4);
            }
            // В остальных случаях
            else if (numbers[indexOfNum + 1] == 0)
                swap(indexOfNum, indexOfNum + 1);
            else if (numbers[indexOfNum - 1] == 0)
                swap(indexOfNum, indexOfNum - 1);
            else if (numbers[indexOfNum + 4] == 0)
                swap(indexOfNum, indexOfNum + 4);
        }
        else if (indexOfNum > 11) {
            // Если выбран блок в последнем столбце
            if ((indexOfNum + 1) % 4 == 0) {
                if (numbers[indexOfNum - 1] == 0)
                    swap(indexOfNum, indexOfNum - 1);
                else if (numbers[indexOfNum - 4] == 0)
                    swap(indexOfNum, indexOfNum - 4);
            }
            // Если выбран блок в первом столбце
            else if (indexOfNum % 4 == 0) {
                if (numbers[indexOfNum + 1] == 0)
                    swap(indexOfNum, indexOfNum + 1);
                else if (numbers[indexOfNum - 4] == 0)
                    swap(indexOfNum, indexOfNum - 4);
            }
            // В остальных случаях
            else if (numbers[indexOfNum + 1] == 0)
                swap(indexOfNum, indexOfNum + 1);
            else if (numbers[indexOfNum - 1] == 0)
                swap(indexOfNum, indexOfNum - 1);
            else if (numbers[indexOfNum - 4] == 0)
                swap(indexOfNum, indexOfNum - 4);
        }
        else {
            // Если выбран блок в последнем столбце
            if ((indexOfNum + 1) % 4 == 0) {
                if (numbers[indexOfNum - 1] == 0)
                    swap(indexOfNum, indexOfNum - 1);
                else if (numbers[indexOfNum - 4] == 0)
                    swap(indexOfNum, indexOfNum - 4);
                else if (numbers[indexOfNum + 4] == 0)
                    swap(indexOfNum, indexOfNum + 4);
            }
            // Если выбран блок в первом столбце
            else if (indexOfNum % 4 == 0) {
                if (numbers[indexOfNum + 1] == 0)
                    swap(indexOfNum, indexOfNum + 1);
                else if (numbers[indexOfNum - 4] == 0)
                    swap(indexOfNum, indexOfNum - 4);
                else if (numbers[indexOfNum + 4] == 0)
                    swap(indexOfNum, indexOfNum + 4);
            }
            // В остальных случаях
            else if (numbers[indexOfNum + 1] == 0)
                swap(indexOfNum, indexOfNum + 1);
            else if (numbers[indexOfNum - 1] == 0)
                swap(indexOfNum, indexOfNum - 1);
            else if (numbers[indexOfNum - 4] == 0)
                swap(indexOfNum, indexOfNum - 4);
            else if (numbers[indexOfNum + 4] == 0)
                swap(indexOfNum, indexOfNum + 4);
        }
    }

    // Смена блоков местами
    public void swap(int indexSelectNum, int indexNull) {
        int swap = numbers[indexNull];
        numbers[indexNull] = numbers[indexSelectNum];
        numbers[indexSelectNum] = swap;

        // Вызов метода обновления поля текущего игрового окна
        gameWindow.updateView(numbers, this);
    }

    // Нахождение индекса элемента массива
    public static int indexOf(int num, int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                return i;
        return -1;
    }
}
