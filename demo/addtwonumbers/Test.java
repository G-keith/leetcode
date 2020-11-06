package demo.addtwonumbers;

/**
 * @author keith
 * @version 1.0
 * @date 2020-11-06
 */
public class Test {

    public static void main(String[] args) {
        /**
         * todo 指针地址导致？具体不清楚，可以实现递归功能，在节点后面无限添加新节点
         */
        People people=new People("name1");
        People people2=people;
        for(int i=0;i<2;i++){
            People peo=new People("name-"+i);
            people2.setPeople(peo);
            people2=peo;
            System.out.println(people2);
            System.out.println(people);
        }
    }
}
