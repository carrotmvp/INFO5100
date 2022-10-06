import java.util.LinkedList;

/*
 * Assignment 4
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */



public class weight_grades {
    private LinkedList<Integer> tpoint= new LinkedList<Integer>();//point total
    private LinkedList<Integer> epoint= new LinkedList<Integer>();//earned points\
    private LinkedList<Integer> assignment= new LinkedList<Integer>();//assignment %
    private double ans=0;//answer||Total Weighted grade

    public void setTpoint(int _tpoint)//set point total
    {
        tpoint.add(_tpoint);
    }

    public void setEpoint(int _epoint)//set earned ponts
    {
        epoint.add(_epoint);
    }

    public void set_assignment(int _assignment)//set assignment%
    {
        assignment.add(_assignment);
    }

    public void setTpoint_togather(LinkedList<Integer> _tpoint)//set point total
    {
        for(int i=0;i<_tpoint.size();i++)
        {
            tpoint.add(_tpoint.get(i));
        }
    }

    public void setEpoint_togather(LinkedList<Integer> _epoint)//set earned ponts
    {
        for(int i=0;i<_epoint.size();i++)
        {
            epoint.add(_epoint.get(i));
        }
    }

    public void set_assignment_togather(LinkedList<Integer> _assignment)//set assignment%
    {
        for(int i=0;i<_assignment.size();i++)
        {
            assignment.add(_assignment.get(i));
        }
    }
    

    public void myCaculate()//caculate the answer;add together;
    {
        ans=0;
        for(int i=0;i<epoint.size();i++)
        {
            ans+=(double)epoint.get(i)/tpoint.get(i)*assignment.get(i);
        }
    }
    
    public LinkedList<Integer> getTpoint()
    {
        return tpoint;
    }
    public LinkedList<Integer> getEpoint()
    {
        return epoint;
    }

    public double getAns()//get the answer
    {
        return ans;
    }

    public String getGrade()//get the grade
    {
        if(ans>100)return "Something Error";
        if(ans>=90)return "A";
        else if(ans>80)return "B";//because of else if, don't need to add &&ans<90;
        else if(ans>70)return "C";
        else if(ans>60)return "D";
        else if(ans>0)return "F";
        else return "Input must be Error";
    }
    
    
}