import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 Создать класс Notebook с полями (price(double), ram(int))
1. Сгенерировать список объектов типа Notebook с разными значениям price и ram
2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
3. Отсортировать тремя способами стандартными средствами (Collections#sort или List#sort)
 */
public class Task_Home_1 {

    public static void main(String[] args) throws Exception {
        System.out.print("\033\143");

        BufferedReader br = new BufferedReader(new FileReader("ListOfLapTop.txt"));
        String str;
        HashSet <NoutBook> listOfLapTop = new HashSet<>();
        while ((str = br.readLine()) != null) {
            ArrayList<String> myList = new ArrayList<String>(Arrays.asList(str.split(",")));
            NoutBook n1 = new NoutBook(Integer.parseInt(myList.get(0)), myList.get(1), myList.get(2), Integer.parseInt(myList.get(3)), Integer.parseInt(myList.get(4)), myList.get(5), Integer.parseInt(myList.get(6)), myList.get(7));
            listOfLapTop.add(n1);
            }
        br.close(); 
        int j = 0;
        for (var item:listOfLapTop){
            j++;
            System.out.println(j+") "+item);
        }

        System.out.println("Добро пожаловать в каталог ноутбуков!");
        System.out.println("Выберите действие:"+"\n"+"1 - Сортировка по цене  "+"\n"+"2 - Сортировка по памяти "+"\n"+"3 - Сортировка  по памяти затем по цене");
        
        List <NoutBook> arr = new ArrayList<>(listOfLapTop);
        int choice = InputNamber.InputN();
        switch (choice) {
            case 1:

            Comparator <NoutBook> priceComparator = new PriceComparator();
            
            Collections.sort(arr, priceComparator);

            j = 0;
            for (var item:arr){
            j++;
            System.out.println(j+") "+item);
            }

                  
            break;

            case 0: 

            break;

            case 2:
            Comparator <NoutBook> priceComparator2 = (o1, o2) -> o1.ram - o2.ram;
            Collections.sort(arr, priceComparator2);

            j = 0;
            for (var item:arr){
            j++;
            System.out.println(j+") "+item);
            }
            break;

            case 3:
            Comparator <NoutBook> priceComparator3 = (o1, o2) -> { 
                if (o1.ram<o2.ram) {return -1;}
                else if (o1.ram>o2.ram){ return +1;}
                else if (o1.ram==o2.ram) {
                    if (o1.price<o2.price) {return -1;}
                    else if (o1.price>o2.price){ return +1;}
                }
                return 0;
                
            };
            Collections.sort(arr, priceComparator3);

            j = 0;
            for (var item:arr){
            j++;
            System.out.println(j+") "+item);
            }
            

            break;

            default:
            if (0>choice||choice>3) {System.out.println("Ошибка ввода!!!");}
            }
    }

    
    public static class PriceComparator implements Comparator <NoutBook>{

        @Override
        public int compare( NoutBook o1,  NoutBook o2) {
            if (o1.price<o2.price) {return -1;}
            else if (o1.price>o2.price){ return +1;}
            return 0;
        }

    }
}