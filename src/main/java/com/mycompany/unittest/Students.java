package com.mycompany.unittest;

public class Students 
{
    private int iUser =0;
    private String strUserName="";
    private String strUserSurname="";
    private String strCellNo="";
    
    public Students(int iUser, String Name,String Surname, String Cell)
    {
        this.iUser =iUser;
        this.strUserName=Name;
        this.strUserSurname=Surname;
        this.strCellNo =Cell;
    }
    
    public String Print()
    {
        return "Name is "+this.strUserName+" cell no:"+this.strCellNo;
    }
    public Boolean CheckCell()
    {
        if (this.strCellNo.matches("[0-9]+")==false)  
            {
                return false;
            }
        else
        {
            return true;
        }
        //https://stackoverflow.com/questions/10575624/java-string-see-if-a-string-contains-only-numbers-and-not-letters
    }
    
}
    
