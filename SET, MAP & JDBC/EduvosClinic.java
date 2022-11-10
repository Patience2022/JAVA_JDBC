//PATIENCE CELE - BE-2022-W7Y3D1
//JAVA BASIC PROJECT - VERSION A (QUESTION 2)

import java.sql.*; //importing sql package in Java so I can use classes and interfaces inside the package. 
import java.util.*; //importing util package in Java so I can use classes and interfaces inside the package. 

class Patient //creating a patient class which is a blue print of our objects
{
    private String studNo = " "; //from private String studNo to private id, I am declaring class variables. (to be continued in the next line)
    private String name; // They are private because I don't want anyone to have access to them.
    private String surname;
    private int cell;
    private int id;
    public void show() //creating a class method. This request user for input, validate user input, connect program to the database, ..continued on next line comment
    {                  //saves data to the database, prints various messages to the user.
        String input; //input is method variable, it is only going to be used inside the method
        boolean valid = false;//valid is method variable, it is only going to be used inside the method
        Scanner sc = new Scanner(System.in); //creating scanner object that will be used to get input from the user
        Connection con = null;
        Statement state = null;
        System.out.println("Enter patient student number"); //  System.out.println(); is used to print content to the user
        studNo = sc.next();
        while(!studNo.equals("0")) //while loop checks the condition to terminate the program 
        {
            System.out.println("Enter patient name");
            name = sc.next();
            System.out.println("Enter patient surname");
            surname = sc.next();
            while(valid == false) //while loop is used to validate user input for cell
            {
                System.out.println("Enter patient cellphone number");
                input = sc.next();                                          
                try
                    {
                        cell = Integer.parseInt(input); //the program will try to convert input value to integer.If successful,it will set valid to true
                        valid = true;
                    }
                    catch(Exception e) { System.out.println("Enter whole numbers");} //try & catch is to ensure program doen't terminate when user input incorrect datatype
            }
            while(valid == true)//while loop is used to validate user input for id
            {
                System.out.println("Enter patient ID");
                input = sc.next();
                try
                {
                    id = Integer.parseInt(input);//converts input to interger
                    valid = false;                                                                            
                }
                catch(Exception e) { System.out.println("Enter a valid number");}   //catches and error and requests user to re-enter          
            }
            String url = "jdbc:sqlserver://localhost:1433;databaseName = clinic"; //creating url variable for database connection
            String user = "JavaStudent"; //creating user variable for database connection
            String password = "1234"; //creating password variable for database connection
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //getting driver class to connect to database
                con = DriverManager.getConnection(url,user,password);//creating a connection
                state = con.createStatement(); //creating statement
                int result = state.executeUpdate("insert into patients values("+id+" ,'"+name+"' ,'"+surname+"'  ,"+cell+",'"+studNo+"')");//executing statement
                System.out.println("Connected to the database Eduvos Clinic");
                System.out.println("Patient information has been added to the database"+"\n"+"\n");
            }                  
            catch(ClassNotFoundException e) //catching an exceptiong so program doesn't termiante
            {
                System.out.println("Class is not found");
                e.printStackTrace();
            }                              
            catch(Exception e) //catching an exceptiong so program doesn't termiante
            {
                System.out.println(e.getMessage());
            }
  
            System.out.println("Enter patient student number");
            studNo = sc.next();
        }
        try //closing sql connections
        {
            if(state != null)
            {
                state.close();
            }
            if(con != null)
            {
                con.close();
            }
        }
         catch(Exception e)
        {
            System.out.println("Unable to close connection");
        } 
        System.out.println("Thank you for using the Eduvos Clinic App. Goodbye!");
   }
}
public class EduvosClinic //this is the public class. Every java program must have a public with the same name as the file name
{
    public static void main(String args []) //creating the main method needed for execution. Without main method, java program won't run
    {
        Patient obj = new Patient();//creating an object for Patience class so I can access methods inside the class. I used default constructor Patient();
        obj.show(); //calling or executing the method inside Patient class using the object created above
        
    }
}   

