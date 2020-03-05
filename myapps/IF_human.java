interface Human{
  void setName(String name);
  void setHeight(int height);
  void setWeight(double weight);
  void show();
}

class Student implements Human{
  private String name;
  private int height;
  private double weight;
  private String studentID;

  public void setName(String n){
    name = n;
  }

  public void setHeight(int h){
    height = h;
  }

  public void setWeight(double w){
    weight = w;
  }

  public void setStudentID(String s){
    studentID = s;
  }

   public void show(){
    System.out.println(name + "の身長は" + height + "cmです");
    System.out.println(name + "の体重は" + weight + "kgです");
    System.out.println(name + "の学籍番号は" + studentID + "cmです");
  }
}

class Test{
    public static void main(String args[]){
      Student s1 = new Student();
      s1.setName("太郎");
      s1.setHeight(115);
      s1.setWeight(55.5);
      s1.setStudentID("1004");

      s1.show();
    }
}
