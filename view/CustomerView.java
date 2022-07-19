package com.liuchang.p2.view;

import com.liuchang.p2.bean.Customer;
import com.liuchang.p2.util.CMUUtility;
import com.liuchang.p2.service.CustomerList;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description 用来显示客户管理界面
 * @date 18/7/2022下午9:19
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("王涛", '男', 23, "13813601938", "64527207@qq.com");
        customerList.addCustomer(customer);
    }

    /**
     * @param
     * @return void
     * @Description 显示客户管理界面的方法
     * @author Cc
     * @date 18/7/2022 下午10:55
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n-----------------客户管理软件-----------------\n");
            System.out.println("                   1添加客户");
            System.out.println("                   2修改客户 ");
            System.out.println("                   3删除客户 ");
            System.out.println("                   4客户列表 ");
            System.out.println("                   5退   出\n");
            System.out.print("                   请选择（1-5):");
            char menu = CMUUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出Y/N:");
                    char isExit = CMUUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }

                    break;
            }
        }

    }

    /**
     * @param
     * @return void
     * @Description 添加客户的操作
     * @author Cc
     * @date 18/7/2022 下午10:55
     */
    private void addNewCustomer() {

        System.out.println("\n-----------------添加客户-----------------\n");
        System.out.print("姓名：");
        String name = CMUUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUUtility.readChar();
        System.out.print("年龄：");
        int age = CMUUtility.readInt();
        System.out.print("电话：");
        String phone = CMUUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("-----------------添加完成-----------------");
        } else {
            System.out.println("-----------------客户目录已满，添加失败-----------------");
        }
    }

    /**
     * @param
     * @return void
     * @Description 修改客户的操作
     * @author Cc
     * @date 18/7/2022 下午10:55
     */
    private void modifyCustomer() {
        System.out.println("-----------------修改客户-----------------");
        Customer cust;
        int index;
        while (true) {
            System.out.print("请输入需要修改的客户编号(-1退出)：");
            index = CMUUtility.readInt();
            if (index == -1) {
                return;
            }
            cust = customerList.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户");
                continue;
            }
            break;
        }
        System.out.print("姓名（" + cust.getName() + "）：");
        String name = CMUUtility.readString(10, cust.getName());

        System.out.print("性别（" + cust.getGender() + "）：");
        char gender = CMUUtility.readChar(cust.getGender());

        System.out.print("年龄（" + cust.getAge() + "）：");
        int age = CMUUtility.readInt(cust.getAge());

        System.out.print("电话（" + cust.getPhone() + "）：");
        String phone = CMUUtility.readString(13, cust.getPhone());

        System.out.print("邮箱（" + cust.getEmail() + "）：");
        String email = CMUUtility.readString(30, cust.getEmail());


        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.replaceCustomer(index - 1, newCust);
        if (isSuccess) {
            System.out.println("---------------修改成功---------------");
        } else
            System.out.println("----------------修改失败----------------");
    }

    /**
     * @param
     * @return void
     * @Description 删除客户的操作
     * @author Cc
     * @date 18/7/2022 下午10:55
     */
    private void deleteCustomer() {
        System.out.println("--------------删除客户-----------------");
        while (true) {
            System.out.print("请输入需要删除客户的编号（-1退出）：");
            int index = CMUUtility.readInt();
            if (index == -1) {
                return;
            }
            Customer cust = customerList.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("未找到客户！");
                continue;
            }
            System.out.println("是否删除（Y/N）");
            char isDelete = CMUUtility.readConfirmSelection();
            if (isDelete == 'Y') {
                customerList.deleteCustomer(index - 1);
                System.out.println("删除成功");
            }else{
                continue;
            }
            break;
        }

    }

    /**
     * @param
     * @return void
     * @Description 显示客户列表的操作
     * @author Cc
     * @date 18/7/2022 下午10:55
     */
    private void listAllCustomers() {
//System.out.println("显示客户列表的操作");
        System.out.println("\n-----------------客户列表-----------------\n");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                System.out.println((i + 1) + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
            }
        }

        System.out.println("\n-----------------客户列表完成-----------------\n");
    }

    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }
}
