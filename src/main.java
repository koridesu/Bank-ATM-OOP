
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sun.net.www.content.audio.x_aiff;

public class main {
    public static void main(String[] args) {
        Frame Atm = new Frame();
        Atm.setTitle("Imaginary Bank ATM");
        Atm.setSize(1000,600);
        
        Atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Atm.setVisible(true);  
        Database database = new Database();
       
        
        File file = new File("D:\\Netbeans\\projects\\ATM\\database.txt");
                    FileReader fileReader;
                    String account = null;
                     try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] container = new String[5];
            while((account = bufferedReader.readLine())!= null)
            {   
                if(account.contains(":"))
                { container = account.split(":",5);
                  User user = new User(container[1],container[3],Double.parseDouble(container[4]));
                  database.addUsers(user);
                  
                }
            }
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        Atm.setDatabase(database);            
        //database.printUsers();
        
    }
    
}
