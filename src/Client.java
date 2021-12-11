import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            Scanner obj = new Scanner(System.in);
            String s = obj.nextLine();

            System.out.println(service.caseChanger(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
