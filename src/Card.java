import java.util.Arrays;
import java.util.Random;        //导入Random类，实现随机数功能
import java.util.Scanner;       //导入Scanner类，实现输入功能
public class Card {
    public static void main(String[] args) {         //程序入口
        Scanner sc = new Scanner(System.in);    //实例化Scanner
        //for(int i=0; i<10000; i++){
        System.out.println("请输入人数和钱数");
            int person = sc.nextInt();              //从控制台获取人数
            double money = sc.nextDouble();         //从控制台获取钱数
            if(person ==0 && money == 0){               //人数与钱都不能为0
                System.out.println("人或钱不得为0");
                //钱的格式为保留两位小数的double类型
            }else if (String.valueOf(money).length()-1 - String.valueOf(money).indexOf('.') > 2){
                System.out.println("钱的格式不对");
            }else {
                //格式对了，将单位换算成分
                RedBag redBag = new RedBag(person,(int)(money*100));
                redBag.giveRedBag();
            }
       // }
       // System.out.println(Arrays.toString(RedBag.b));
    }
}
class RedBag{
    public static final int minMoney = 1;
    //public static double b[] = new double[4];
    private int person;
    private int money;
    private int[] bag;
    public RedBag(int person, int money) {
         this.person = person;
         this.money = money;
         bag = new int[person-1];
    }
    //根据人数,钱，每个人应最少分多少钱来判断这红包是否可以用
    //在红包可用的情况下。根据人数,钱，每个人应最少分多少钱 来得到还剩多少钱可分 返回值为整数，单位：分
    //返回-1说明钱不够
    public int isRedBagEnough(){
        if(money >= minMoney*person){//这样处理防止浮点型的运算精度问题
            return money - minMoney*person;
        }return -1;
    }
    public void giveRedBag(){
        if(isRedBagEnough() == -1){
            System.out.println("钱不够分");
        }
        else if(isRedBagEnough() == 0){
            for (int i=0; i<person; i++){
                System.out.println("红包金额：" + minMoney/100.0);
                System.out.println("恭喜你，抢到了这个红包");
            }
        }else if(isRedBagEnough() > 0){
            Random random = new Random();
            if(person==1){
                System.out.println("红包金额：" + money/100.0);
                System.out.println("恭喜你，抢到了这个红包");
            }else {
                for(int i=0; i<person-1; i++){          //创建比人数少一的坐标，将红包分成 person 份
                    bag[i] = random.nextInt(isRedBagEnough());
                }
                Arrays.sort(bag);
                int index = 0;
                for(int i=1; i<person; i++){
                    System.out.println("红包金额：" + (minMoney+bag[i-1]-index)/100.0);
                    //b[i-1] += (minMoney+bag[i-1]-index)/100.0;
                    index = bag[i-1];
                    System.out.println("恭喜你，抢到了这个红包");
                }
                System.out.println("红包金额：" + (isRedBagEnough()-bag[person-2]+minMoney)/100.0);
                //b[3] += (isRedBagEnough()-bag[person-2]+minMoney)/100.0;
                System.out.println("恭喜你，抢到了这个红包");
            }
        }
    }
}

