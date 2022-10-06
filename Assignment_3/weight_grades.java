/*
 * Assignment 2
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */



public class weight_grades {
    private int tpoint;//point total
    private int epoint;//earned points
    private int _assignment;//assignment %
    private double ans=0;//answer||Total Weighted grade

    public void setTpoint(int tpoint)//set point total
    {
        this.tpoint=tpoint;
    }

    public void setEpoint(int epoint)//set earned ponts
    {
        this.epoint=epoint;
    }

    public void set_assignment(int _assignment)//set assignment%
    {
        this._assignment=_assignment;
    }
    

    public void myCaculate()//caculate the answer;add together;
    {
        ans+=(double)epoint/tpoint*_assignment;
    }
    
    public int getTpoint()
    {
        return tpoint;
    }
    public int getEpoint()
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