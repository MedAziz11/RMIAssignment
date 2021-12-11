import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    @Override
    public String reverse(String s){
        String ans ="";
        for (int i=0; i<s.length();i++){
            ans = s.charAt(i)+ ans;
        }
        return ans;
    }

    @Override
    public Character minChar(String s) throws RemoteException {
        char[] charArray = s.toCharArray();
        char min = 'z';
        for(char c : charArray){
            min = (char) Math.min(min, c);
        }
        return min;
    }

    @Override
    public String caseChanger(String s) throws RemoteException {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            }
            else{
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }



    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);

    }
}
