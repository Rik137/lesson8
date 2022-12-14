# Домашнее задание к занятию. Массивы многомерные
### Задача. Поворот матрицы на 90 градусов по часовой стрелке
### Описание
Научимся поворачивать матрицу с равными сторонами. Этот алгоритм мог бы быть использован в графических редакторах вроде Photoshop для поворота изображений.

Дано: двумерная матрица 8 на 8 из случайных чисел от 0 до 255 (спектр цветов GrayScale). Напишите алгоритм "поворота" такой матрицы на 90 градусов по часовой стрелке.

#### Функционал программы
- Создание матрицы в программе;
- Вывод матрицы до поворота;
- Разворот матрицы;
- Вывод матрицы после поворота на 90 градусов.
- Вывод должен быть вынесен в отдельный метод, с помощью которого будут выведены и исходная, и перевёрнутая матрицы
___Пример___
~~~
Дана следующая матрица:

114 112 148  83 204  22 125  31
192 231 245 128  63 246 139  17
 61 128 224  45  91  57 239  34
219 237 167 191 236 146 144 117
 35 199 102 124 208 195  21 147
 52 229 126  32  24 145  19  39
107  43 190  43  47 172  18  19
 62 221   6 208 241 198 187  85
Вывод:

 62 107  52  35 219  61 192 114
221  43 229 199 237 128 231 112
  6 190 126 102 167 224 245 148
208  43  32 124 191  45 128  83
241  47  24 208 236  91  63 204
198 172 145 195 146  57 246  22
187  18  19  21 144 239 139 125
 85  19  39 147 117  34  17  31
 ~~~
#### реализация
1. Итак, у нас есть матрица с размерами 8x8, которую нужно повернуть на 90 градусов по часовой стрелке. Для начала создадим матрицу (размерность матрицы сохраним в переменной filedSize).
  `int SIZE = 8;`
  `int[][] colors = new int[SIZE][SIZE];`
2. Теперь заполним матрицу случайными значениями в диапазоне от 0 до 255:
~~~
    Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
~~~
3. Выводим матрицу на экран
~~~
 for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
~~~
4. Для повернутой матрицы создадим пустой массив той же размерности:
  `int[][] rotatedColors = new int[SIZE][SIZE];`
5. Новая матрица должна принять значения ячеек первой матрицы, но с поворотом на 90 градусов по часовой стрелке. Это значит, что значение первой ячейки `rotatedColors[0][0]` (первая строка, первое значение) новой матрицы должно быть равно первому значению ячейки последней строки матрицы `colors (colors[SIZE-1][0])`.
6. нужно:
- написать метод, при помощи которого можно пробежаться по матрицам и присвоить каждому элементу новой матрицы `rotatedColors` соответствующее значение из имеющейся `colors матрицы`.
- обеспечить в методе поворот матрицы на 90/180/270 градусов
- Добавить зможность вводить угол поворота (кратный 90) с клавиатуры.
~~~
 public static void i(int[][] rotatedColors, int SIZE, int[][] colors, int numb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (numb == 90) {
                    rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                } else if (numb == 180) {
                    rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                } else if (numb == 270) {
                    rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                } else {
                    System.out.println("не корректный ввод");
                    return;
                }
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
        System.out.println("поворот " + numb + " градусов");
    }
~~~ 
