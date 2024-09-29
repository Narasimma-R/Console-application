package Game;

import java.util.UUID;

public class Functions {
    public void login(){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("1]Login\t\t\t\t\t2]Create Account\t\t\t\t\t3]Exit");
        System.out.println("-------------------------------------------------------------------------");
    }
    public void successLogin(String userName, UUID UID,int points){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tWelcome Back!! "+userName+"\t\t\t\tPoints : "+points+"\nUID : "+ UID);
        System.out.println("-------------------------------------------------------------------------");
    }
    public void userAlreadyExist(){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tUser Name already exist try another");
        System.out.println("-------------------------------------------------------------------------");
    }
    public void accountCreationSuccessful (String name,UUID UID){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tAccount successfully created");
        System.out.println("Name : "+name+"\n"+"UID : "+UID+"\n");
        System.out.println("-------------------------------------------------------------------------");
    }
    public void accountNotFound (){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tAccount Not Found");
        System.out.println("-------------------------------------------------------------------------");
    }

    public void displayPoints(int points){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Points : " + points);
        System.out.println("-------------------------------------------------------------------------");
    }

    public void reTry(){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tRetry again");
        System.out.println("-------------------------------------------------------------------------");
    }

}
