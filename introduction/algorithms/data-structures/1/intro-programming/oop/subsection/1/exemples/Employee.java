class Employee 
{
  private String name;
  private String department;
  private double salaty;
  private String data;
  private String rg;
  private String fuction;
  
  public double getIncreased(Strig salaty, boolean evaluation) 
  {
    if (evaluation == true)
    {
    increased_salaty = salaty * 0.2;
    }
    else {
    incresed_salaty = salaty;
    }
    return incresed_salaty
  }
  
  public double calcAnnualGain() 
  {
    return annual_gain = salaty * 12;
  }
}
