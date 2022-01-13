import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution14_6_PathTest {
    public static void main(String[] args) {
        //1
//        printPathInformation(Paths.get("\\zoo\\armadillo\\shells.txt"));    //абсолютный путь
//        System.out.println();
//        printPathInformation(Paths.get("armadillo\\shells.txt"));   //относительный путь



        //2  получить абсолютный путь для имеющегося относительного:
//        Path path1 = Paths.get("c:\\birds\\erget.txt");
//        System.out.println("path1 is absolute? " + path1.isAbsolute());
//        System.out.println("absolute from path1: " + path1.toAbsolutePath());
//
//        Path path2 = Paths.get("birds\\condor.txt");
//        System.out.println("path2 is absolute? " + path2.isAbsolute());
//        System.out.println("absolute from path2: " + path2.toAbsolutePath());



        //3 Создадим суб-пути:
//        Path path3 = Paths.get("\\mammal\\carnivore\\raccoon.image");
//        System.out.println("Path is: " + path3);
//
//        System.out.println("Subpath from 0 to 3 is: " + path3.subpath(0, 3));
//        System.out.println("Subpath from 1 to 3 is: " + path3.subpath(1, 3));
//        System.out.println("Subpath from 1 to 2 is: " + path3.subpath(1, 2));

        //4 Как перевести имя пути в реальный путь и проверить существование файла?
        try{
            System.out.println(Paths.get("\\zebra\\food.source").toRealPath());
            System.out.println(Paths.get("..\\.\\food.txt").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();    //обработка ошибки
        }

        //Представим, что наша текущая директория — /horse/schedule, и то, что оба файла существуют в системе.
        // При этом первый путь (/zebra/food.source) — это символическая ссылка на реальный файл /horse/food.txt.
        //Вот что выведется в консоль при запуске: (4)


    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println("Current parent is: " + currentPath);
        }
    }
}


/*
1.
Filename is: shells.txt
Root is: \
Current parent is: \zoo\armadillo
Current parent is: \zoo
Current parent is: \

Filename is: shells.txt
Root is: null
Current parent is: armadillo

2.
        path1 is absolute? true
        absolute from path1: c:\birds\erget.txt
        path2 is absolute? false
        absolute from path2: C:\\Users\\user\\IdeaProjects\\Module14\\birds\\condor.txt

3.- Первый параметр метода принимает индекс включительно, второй — исключая. Если передадим индексы вне фактического размера пути — получим Exception в Runtime
Path is: \mammal\carnivore\raccoon.image
Subpath from 0 to 3 is: mammal\carnivore\raccoon.image
Subpath from 1 to 3 is: carnivore\raccoon.image
Subpath from 1 to 2 is: carnivore

4.
/horse/food.txt
/horse/food.txt
Как видим, метод расшифровывает символические ссылки в реальные пути, а также символы . и ..
Если бы этих файлов не существовало, мы бы попали с ошибкой в catch-блок.
*/
