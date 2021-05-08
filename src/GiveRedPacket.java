import java.util.Scanner;

public class GiveRedPacket {
    public static void main(String[] args) {         //程序入口
        Scanner sc = new Scanner(System.in);    //实例化Scanner
        //for(int i=0; i<10000; i++){
        System.out.println("请输入人数和钱数");
        String person = sc.next();              //从控制台获取人数
        String money = sc.next();         //从控制台获取钱数
        System.out.println(person.matches("[1-9]\\d*"));
        System.out.println(money.matches("[1-9]\\d*\\.?\\d{0,2}|0\\.\\d{0,2}"));
//        if(person !=0 && money != 0){               //人数与钱都不能为0
//            //钱的格式为保留两位小数的double类型
//            if (String.valueOf(money).length()-1 - String.valueOf(money).indexOf('.') <= 2){
//                //格式对了，将单位换算成分
//                RedBag redBag = new RedBag(person,(int)(money*100));
//                redBag.giveRedBag();
//            }else {
//                System.out.println("钱的格式不对");
//            }
//        }else{
//            System.out.println("人或钱不得为0");
//        }
        //}
        // System.out.println(Arrays.toString(RedBag.b));
    }
}