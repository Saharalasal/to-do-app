
package meow;

import java.time.LocalDateTime;//import for a time package
import java.time.format.DateTimeFormatter;//import for a time formatter package
import java.util.Arrays;
import java.util.InputMismatchException;//import for telling the user that the what you've entered is wrong
import java.util.Scanner;//import to take values from the user


public class NewClass {

    public static void main(String[] args) {
        Scanner hello;//to change the saved value in memory

        String[] ListOfTasks = new String[10];//an array for the tasks
        String[] Priority = new String[10];//an array for the levels of Priority
        String[] Finish = new String[10];//an array for checking if the task is done or not
        Arrays.setAll(Finish, i -> "no");
        String[] TimeStamp = new String[10];//an array for the timestamp
        int i = 1;

        System.out.println("HI THIS A TO-DO LIST PROGRAM MADE BY SAHAR :D & Abdulwahab :(");
       
        while (true) {
            try{
                hello = new Scanner(System.in);
                System.out.println("options:");
                System.out.println("1- add");
                System.out.println("2- delete");
                System.out.println("3- change");
                System.out.println("4- done or not");
                System.out.println("5- show tasks");
                System.out.println("6- exit");

                System.out.print("type an option: ");
                
                String meoww = hello.nextLine();
                
                int choice = Integer.parseInt(meoww);

                 if (choice > 6){
                    System.out.println("thats not a number");
                    System.out.println("");//to make an empty line so it looks better for the eyes
                    continue;//to iqnore the rest of the braket (to } )
                }

                System.out.println("");
                
                if (choice == 1) {
                    System.out.print("enter task number " + (i) + " : ");
                    String Tasks = hello.nextLine();//takes the task from the user
                    if (Tasks.matches("[a-zA-Z\s]+")) {
                        ListOfTasks[i - 1] = Tasks;//putting the task in an array
                    } else {
                        System.out.println("thats not the right input");
                        System.out.println("");//to make an empty line so it looks better for the eyes
                        continue;//to iqnore the rest of the braket (to } )
                    }
                    System.out.print("enter level of Priority of the new task (1 = VERY IMPORTANT & 2 = IMPORTANT & 3 = NOT IMPORTANT) : ");
                    int LevelOfPriority = hello.nextInt();
                    switch (LevelOfPriority) {
                        case 1:
                            Priority[i - 1] = "very important";//putting the level of priority in an array
                            break;
                        case 2:
                            Priority[i - 1] = "important";
                            break;
                        case 3:
                            Priority[i - 1] = "not important";
                            break;
                        default:
                            System.out.println("no match. you have entered a wrong number");
                            System.out.println("");//to make an empty line so it looks better for the eyes
                            continue;//to iqnore the rest of the braket (to } )

                    }

                    LocalDateTime Time = LocalDateTime.now();//from java itself for the local time
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//from java itself to organize the time however you want
                    String Newdate = Time.format(formatter);//to change the time to the format you choose
                    System.out.println("you have entered this task at " + Newdate);//to display the time
                    TimeStamp[i - 1] = (Newdate);//putting the timestamp in an array
                    i++;
                    System.out.println("");//to make an empty line so it looks better for the eyes
                    //hello.close();//to avoid the "Enter in the buffer" issue
                }

                if (choice == 2) {
                    System.out.print("enter the number of the task you want to remove : ");
                    int remove = hello.nextInt();//take the number of the specific task thats going to be deleted
                    if (ListOfTasks[remove - 1] == null) {
                        System.out.println("there is no task with the number you have entered");
                        System.out.println("");
                        continue;//to iqnore the rest of the braket (to } )
                    } else {
                        System.out.println("are you sure you want to delete " + ListOfTasks[remove - 1] + "? (true or false)");
                        boolean validaty = hello.nextBoolean();
                        switch (validaty) {
                            case true:
                                //ListOfTasks[remove - 1] = null;//null because its not needed anymore
                                for (int g = remove; g < ListOfTasks.length; g++) {
                                    ListOfTasks[g - 1] = ListOfTasks[g];
                                    Priority[g - 1] = Priority[g];
                                    Finish[g - 1] = Finish[g];
                                    TimeStamp[g - 1] = TimeStamp[g];
                                }
                                i--;
                                System.out.println("now the task is removed !!");
                                break;//to leave the switch
                            default:
                                System.out.println("ok");
                        }
                        System.out.println("");//to make an empty line so it looks better for the eyes
                    }
                }
                if (choice == 3) {
                    System.out.print("enter the number of the task you want to change : ");
                    int change = hello.nextInt();//take from the user
                    if (ListOfTasks[change - 1] == null) {
                        System.out.println("there is no task with this number");
                        System.out.println("");//to make an empty line so it looks better for the eyes
                        continue;//to iqnore the rest of the braket (to } )
                    }
                    hello.nextLine();//its needed because the program will count the "ENTER" as an input for the next input line
                    System.out.print("enter the new task : ");
                    String newchange = hello.nextLine();//take the new task from the user
                    if (newchange.matches("[a-zA-Z\s]+")) {//checks if the input is only string
                        ListOfTasks[change - 1] = newchange;

                    } else {//if the user entered a wrong value
                        System.out.println("thats not the right input");
                        System.out.println("");//to make an empty line so it looks better for the eyes
                        continue;//to iqnore the rest of the braket (to } )
                    }
                    ListOfTasks[change - 1] = (newchange);//changes the old task to the new one
                    System.out.println("it is changed to (" + ListOfTasks[change - 1] + ") !!");
                    System.out.print("enter level of Priority of the new task (1 = VERY IMPORTANT & 2 = IMPORTANT & 3 = NOT IMPORTANT) : ");
                    int LevelOfPriority = hello.nextInt();//user input for the level of priority he wants
                    switch (LevelOfPriority) {
                        case 1://if the user entered 1
                            Priority[change - 1] = "very important";//putting the new level of priority in an array
                            break;//to leave the switch
                        case 2://if the usered entered 2
                            Priority[change - 1] = "important";//putting the new level of priority in an array
                            break;//to leave the switch
                        case 3://if the user entered 3
                            Priority[change - 1] = "not important";//putting the new level of priority in an array
                            break;//to leave the switch
                        default://if the user entered a diffrent number
                            System.out.println("no match. you have entered a wrong number");
                            System.out.println("");//to make an empty line so it looks better for the eyes
                        }

                    LocalDateTime Time = LocalDateTime.now();//from java itself for the local time
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");//from java itself to organize the time however you want
                    String Newdate = Time.format(formatter);//to change the time to the format you choose
                    System.out.println("you have entered this new task at " + Newdate);//to display the time
                    TimeStamp[change - 1] = (Newdate);//changes the time of the old task to the new one
                    System.out.println("");//to make an empty line so it looks better for the eyes
                }

                if (choice == 4) {//if the user entered 4 it will enter 

                    System.out.print("enter the number of the task you add its progress : ");
                    
                    String meowww = hello.nextLine();
                
                int done = Integer.parseInt(meowww);
                    
                    if (ListOfTasks[done - 1] == null) {
                        System.out.println("there is no task with the number you have entered");
                        System.out.println("");
                        continue;//to iqnore the rest of the braket (to } )
                    }
                    if (ListOfTasks[done - 1] != null) {
                        System.out.println("did you do >>>> " + ListOfTasks[done - 1] + "? (yes = 1 or no = 2)");
                        int doneity = hello.nextInt();//take from the user an answer to if he did finish the task or no
                        switch (doneity) {
                            case 1://if the user entered 1
                                Finish[done - 1] = "yes";//putting the answer in an array
                                System.out.println("");
                                break;//to leave the switch
                            case 2://if the usered entered 2
                                Finish[done - 1] = "no";//putting the answer in an array
                                System.out.println("");
                                break;//to leave the switch
                            default://if the user entered a diffrent number
                                System.out.println("no match. you have entered a wrong number");
                                System.out.println("");//to make an empty line so it looks better for the eyes
                                continue;//to iqnore the rest of the braket (to } )
                        }
                    }
                }

                if (choice == 5) {//if the user entered 5 it will enter here
                    if (ListOfTasks[0] == null) {//to make sure if the user entered a task first or no
                        System.out.println("there is no task yet");
                        System.out.println("");//to make an empty line so it looks better for the eyes
                        continue;
                    } else {//if the user did enter at least a task then it will enter here
                        print(ListOfTasks, Priority, TimeStamp, Finish);//it will print the tasks
                    }
                    System.out.println("");//to make an empty line so it looks better for the eyes
                }

                if (choice == 6) {//if the user entered 6 it will enter here
                    System.exit(0);//to exit the run
                }

}catch (Exception e) {//always comes with (try)
            System.out.println("wrong input");
                    }
}
    }      
        
    

    public static void print(String[] mListOfTasks, String[] mPriority, String[] mTimeStamp, String[] mFinish) {//method for printing 
        for (int x = 0; x < mListOfTasks.length; x++) {//loop to display all tasks infos
            if (mListOfTasks[x] == null) {//checks if the condition is true then enter the if body
                continue;//to iqnore the rest of the braket (to } )
            }
            if (mPriority[x] == null) {//checks if the condition is true then enter the if body
                continue;//to iqnore the rest of the braket (to } )
            }
            System.out.println("task number " + (x + 1) + " is : " + mListOfTasks[x]);
            System.out.println("the level of Priority is : " + mPriority[x]);
            System.out.println("the time of entering the task is : " + mTimeStamp[x]);
            System.out.println("is the task done? " + mFinish[x]);

        }
    }
}
