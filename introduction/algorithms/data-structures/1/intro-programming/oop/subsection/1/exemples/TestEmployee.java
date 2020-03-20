class TestEmployee 
{
  public static void main(String args) {
    Employee e1 = new Employee();
    Employee e2 = new Employee();

    e1.name = "Hugo";
    e1.salaty = 100.0;
    e1.getIncreased(100.0, true);

    Sytem.out.println("Salaty annual: " + e1.salaty);
    Sytem.out.println("Annual gain: " + e1.calcAnnualGain());
  }
  
}
