import dao.MobileDao;
import vo.Mobile;

import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/22 2:12 下午
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!false){
            System.out.println("*************手机品牌管理系统*****************");
            System.out.print("品牌名称:");String brand = sc.nextLine();
            if (brand.equals("")) {
                System.out.println("品牌名称必须输入");
                return;
            }
            System.out.print("厂商名称:");String manufacturer = sc.nextLine();
            if (manufacturer.equals("")) {
                System.out.println("厂商名称必须输入必须输入");
                return;
            }
            System.out.print("厂地:");String produce = sc.nextLine();
            if (produce.equals("")) {
                System.out.println("厂地必须输入");
                return;
            }


            MobileDao m = new MobileDao();
            if (m.selectBrand(brand)) {
                if (m.addMobile(new Mobile(brand,manufacturer,produce))) {
                    System.out.println("添加成功");
                }

            }else{
                System.out.println("该手机品牌已存在，不能添加");
                return;
            }
        }
    }
}
