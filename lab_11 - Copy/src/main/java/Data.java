import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }


    private Map<String,String> loginData;

    private Data() {
        String username;
        String password;
        loginData = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\KevinJustice\\IdeaProjects\\lab_11\\src\\main\\resources\\data.txt"))){
            while ((username = br.readLine()) != null) {
                password = br.readLine();
                loginData.put(username,password);
            }
        } catch (IOException e){
            System.out.println("File Not Found");
        } catch (NullPointerException e){
            System.out.println("Error in Text File Odd Number Of Lines");
        }
    }
    public boolean isValidLogin(String username, String password){
        System.out.println("un: " + username + "\tpw: " + password);
        System.out.println("containsKEY: " + loginData.containsKey(username) + "\tgetReturns: " + loginData.get(username));
        if (loginData.containsKey(username)){
            if (loginData.get(username).equals(password)){
                System.out.println("returned true");
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
