/*
 * Assignment 3
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * main
 */


import java.util.Scanner;

public class grade {//the total input assignment % must be 100 to ensure the right answer
public static void main (String args[])
    {
        weight_grades weight_grades=new weight_grades();
        
        try (Scanner sc = new Scanner(System.in)) {//need to input 8 set of number,each set have three kinds of number
            for(int i=0;i<8;i++)
            {
                System.out.println(i+1);//to show How many have you reached
                System.out.print("Please input a Point Total: ");
                weight_grades.setTpoint(sc.nextInt());
                System.out.print("Please input a Earned Points: ");
                weight_grades.setEpoint(sc.nextInt());
                System.out.print("Please input a Assignment(%): ");
                weight_grades.set_assignment(sc.nextInt());
                if(weight_grades.getTpoint()<weight_grades.getEpoint())//if(Earned Points > Point Total),it must be a wrong input;
                {
                    System.out.println("Your Earned Points > Point Total, please input again!");
                    i--;continue;
                }
                weight_grades.myCaculate();//already added in this method
                //System.out.println(weight_grades.getAns());//to test the number is right or not
                

            }
        }
        

        System.out.print("Total Weighted grade:");
        System.out.print(weight_grades.getGrade());
        
        
    } 
}