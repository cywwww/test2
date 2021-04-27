package W04006a;

import W04006a.bean.CardInfo;
import W04006a.bean.TransInfo;
import W04006a.bean.UserInfo;
import W04006a.dao.CardDao;
import W04006a.dao.OpenAccount;
import W04006a.dao.SelectCard;
import W04006a.dao.TransInfoDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/6 8:11 下午
 */
public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("欢迎使用ATM取款系统\n1、登录\n2、开户\n3、退出\n请选择功能序号:");

        int g = sc.nextInt();

            switch(g){
                case 1:
                    System.out.print("银行卡账号：");sc.nextLine();
                    String cId = sc.nextLine();
                    System.out.println(cId);
                    System.out.print("银行卡密码：");int pwd = Integer.parseInt(sc.nextLine());
                    if (new SelectCard().enter(cId,pwd)) {
                        boolean b = true;
                        while (b==true){
                            System.out.println();
                            System.out.println("请选择功能:\n1、存钱\n2、取钱\n3、转账\n4、个人信息维护\n5.查询余额\n6、查询交易记录\n7、返回上一级");
                            int gg = sc.nextInt();
                            switch(gg){
                                case 1:
                                    System.out.print("输入存入金额:");float money = sc.nextFloat();
                                    if (new CardDao().addMoney(cId,"存入",pwd,money)) {
                                        System.out.println("存入成功");
                                    }else{
                                        System.out.println("存入失败");
                                    }
                                    break;
                                    case 2:
                                        System.out.print("输入取出金额:");float money2 = sc.nextFloat();
                                        if (new CardDao().addMoney(cId,"支取",pwd,money2)) {
                                            System.out.println("存入成功");
                                        }else{
                                            System.out.println("存入失败");
                                        }
                                    break;
                                    case 3:
                                        System.out.print("请输入被转账用户卡号");sc.nextLine();
                                        String mid = sc.nextLine();
                                        System.out.print("请输入转账金额");
                                        float tMoney = sc.nextFloat();
                                        new CardDao().transferAccounts(cId,pwd,mid,tMoney);
                                    break;
                                    case 4:
                                        System.out.print("请输入修改后的密码：");int pwd31 = sc.nextInt();
                                        System.out.print("请再次输入修改后的密码：");int pwd32 = sc.nextInt();
                                        if (pwd31==pwd32){
                                            if (new CardDao().updateCard(cId,pwd31)) {
                                                System.out.println("修改成功");
                                            }
                                        }else{
                                            System.out.println("两次输入不一致");
                                        }
                                        break;
                                    case 5:
                                        System.out.println(new SelectCard().selectBalance(cId, pwd));
                                    break;
                                    case 6:
                                        ArrayList<TransInfo> a = new TransInfoDao().selctTrans(cId);
                                        a.forEach(System.out::println);
                                    break;
                                    case 7:
                                        b = false;
                                    break;
                            }

                        }
                    }else{
                        System.out.println("账户或密码错误");
                    }
                    break;
                case 2:
                    System.out.print("客户姓名:");String uName = sc.next();
                    System.out.print("身份证号:");String pId = sc.next();
                    System.out.print("联系电话:");String phone = sc.next();
                    System.out.print("开户金额:");float openMoney = sc.nextFloat();
                    System.out.print("存款类型:");String savingType = sc.next();
                    System.out.print("客户地址:");String address = sc.next();

                    UserInfo u = new UserInfo(0, uName, pId, phone, address);
                    CardInfo c = new CardInfo(null, null, savingType, null, openMoney, openMoney, 0, null, 0);
                    new OpenAccount().openAccount(u,c);
                    break;
                case 3:
                    return;
            }
        }
    }
}
