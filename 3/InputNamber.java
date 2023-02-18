import java.util.Scanner;
public class InputNamber {
    public static int InputN() {
        Boolean check = true;
        int str = 0;
        while(check){
    try{
        Scanner  scan = new Scanner(System.in);
        //System.out.print("Введите целое число:");
        str = scan.nextInt();
        if (1 <=str && str <=3){
            check = false;
            return str;}
        else {System.out.println("Ошибка ввода! Попробуйте еще раз");}
        
        }
    catch (Exception ex){
        System.out.println("Ошибка ввода! Попробуйте еще раз");
        System.out.println(ex);
        }
        }
        return str;
    }
    
}
