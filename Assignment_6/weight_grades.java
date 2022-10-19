/*
 * Assignment 6
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */



public class weight_grades {
    private int tpoint;//point total
    private int epoint;//earned points
    private int _assignment;//assignment %
    private double ans;//answer||Total Weighted grade

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
    

    public void myCaculate()//caculate the answer
    {
        ans=(double)epoint/tpoint*_assignment;
    }

    public double getAns()//get the answer
    {
        return ans;
    }
    
    
}