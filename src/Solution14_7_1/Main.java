package Solution14_7_1;

/*
В текущем рабочем каталоге-файле есть список трат в строках, в формате «имя, сумма».

Шаблон balance.txt:

Дима, 510
Катя, 2800
Никита, 1500
Эмилия, 5000
Ярослав, 3000
Андрей
Что нужно сделать?

0. Скопировать текст из задания в файл balance.txt в текущий рабочий каталог.

1. Прочесть файл balance.txt в Map<String, Integer>.

2. Отсортировать строки файла в убывающем порядке.

3. Добавить в конце списка сумму всех трат: "Итого: n руб. (дата формирования файла в формате dd.MM.yyyy)", пример: "Итого: 100 руб. (01.03.2021)".

4. Сохранить файл как balance_total_ddMMyy.txt, где ddMMyy — это день, число и год слитно.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("ddMMyy"); //форматируем объект времени согласно ТЗ(п.4) - пока что таком виде будет выдан хешкод: java.text.SimpleDateFormat@b049fd40

    public static void main(String[] args) {
        Path fileSource = Paths.get("src/Solution14_7_1/balance.txt"); //создание объекта Path, который берет данные из файла и обозначает их ссылкой fileSource
        LocalDate now = LocalDate.now();    //создали переменную, которая берет время без учета часовых поясов
        String formattedDate = SIMPLE_DATE_FORMAT.format(now.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());  //130122
        //System.out.println(now.format(DateTimeFormatter.ofPattern("ddMMyy")));      //130122
        Path fileToWrite = Paths.get("src/Solution14_7_1/balance_total_" + formattedDate + ".txt");    //п.4 ТЗ

        //1 п. ТЗ
        try {
            List<String> strings = Files.readAllLines(fileSource, Charset.defaultCharset());    //Создаем коллекцию типа листа в которую считываем каждую строку файла "balance.txt"
            List<String[]> sortedNames = strings.stream()      //создаем массив листа, на котором вызываем стрим с его методами:
                    .map(s -> {                                 //сначала создаем объекты типа map коллекции лист, каждый элемент которого формируем со следующими условиями (лямбда-выражение)
                        String[] split = s.split(",");   //разделяем каждый элемент создаваемого массива, разделителем является запятая и заносим в переменную split
                        return new String[]{                   //возвращаем новые элементы строк массива,
                                split[0],                       //начиная с нулевого элемента.
                                split.length > 1 ? split[1].trim() : "0"  //длина разделяемого элемента больше единицы?если да, то создаем новый элемент в массиве, если нет, создаем строку с пустым содержанием
                        };
                    })
                    .sorted((o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1])).toList();

            try (BufferedWriter writer = Files.newBufferedWriter(fileToWrite, Charset.defaultCharset())) {  //записываем в файл, создаваемый согласно правилу, записанному в переменную fileToWrite
                for (String[] split : sortedNames) {                  //для каждого массива строк sortedNames
                    writer.write(String.format("%s\n", String.join(", ", split)));  //записываем в требуемом формате строки
                }
                writer.append(String.format(            // п.3 ТЗ. Добавляет указанную последовательность символов к этому средству записи.
                        "===\nИтого: %d руб. (%s)",
                        sortedNames.stream().mapToInt(split -> Integer.parseInt(split[1])).sum(),    //вызываем на sortedNames стрим, mapToInt() - Возвращает IntStream, состоящий из результатов применения заданной функции к элементам этого потока.
                        now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
            } catch (IOException e) {
                System.out.println("Невозможно записать в файл!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
