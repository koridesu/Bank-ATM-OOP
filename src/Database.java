import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
 
    public void addUsers(User a) {
        getUsers().add(a);
    }
    
    public void printUsers()
    {
        if(getUsers()!=null){
            for(int i=0;i<getUsers().size();i++)
            {
                System.out.println(getUsers().get(i).getId()+ " " + getUsers().get(i).getPassword());   
            }
        }
    }
    
     public boolean login(String id, String pass){
       if(getUsers() == null) return false;
       for(int i=0;i<getUsers().size();i++)
       { if(getUsers().get(i).getId().equals(id)&& getUsers().get(i).getPassword().equals(pass) )
           return true;
       }
       return false;
       
}    

     public int searchId(String id, String pass)
     {  
         if(users == null) return 10;
       
         else{
            for(int i=0; i<users.size();i++)
            {
                if(users.get(i).getId().equals(id))
                { if(users.get(i).getPassword().equals(pass))
                    return i;
                }
            }
         }
         
     return 0;
     }
     
     
  
    /**
     * @return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}