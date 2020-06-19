package innerClassTest;

public class Aoo {
       private int id;
       private String name;

       public Aoo(){
              this(0, null);
       }

       public Aoo(int id, String name){
              this.id = id;
              this.name = name;
              System.out.println(this.toString() + " now create:" + System.currentTimeMillis());
       }
        /*
        * 省略get/set/toString
        */
       @Override
       protected void finalize() throws Throwable{
              super.finalize();
              System.out.println(this.toString() + " now finalize:" + System.currentTimeMillis());
       }

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getName() {
              return name;
       }

       public void setName(String name) {
              this.name = name;
       }
}