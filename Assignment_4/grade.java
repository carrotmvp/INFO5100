/*
 * Assignment 4
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
            System.out.print("Please input the Point Total(end with -1): ");
            while(true)
            {
                int x=sc.nextInt();
                if(x==-1)break;
                weight_grades.setTpoint(x);               
            }
            System.out.print("Please input the 8 Earned Total(end with -1): ");
            while(true)
            {
                int x=sc.nextInt();
                if(x==-1)break;
                weight_grades.setEpoint(x);               
            }
            System.out.print("Please input the 8 Assignment(%)(end with -1): ");
            while(true)
            {
                int x=sc.nextInt();
                if(x==-1)break;
                weight_grades.set_assignment(x);               
            }
            
            weight_grades.myCaculate();//already added in this method
        }
        

        System.out.print("Total Weighted grade:");
        System.out.print(weight_grades.getGrade());
        
        
    } 
}