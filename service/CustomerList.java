package com.liuchang.p2.service;

import com.liuchang.p2.bean.Customer;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 18/7/2022下午9:17
 */
public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total; //记录已保存客户对象的数量

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @param customer
     * @return boolean  true：添加成功 false：添加失败
     * @Description 将指定客户添加到数组中
     * @author Cc
     * @date 18/7/2022 下午10:24
     */
    public boolean addCustomer(Customer customer) {
        //如果总数已满 不能继续添加了
        if (customer == null || total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     * @param index
     * @param cust
     * @return boolean
     * @Description 替换指定位置上的客户
     * @author Cc
     * @date 18/7/2022 下午10:34
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * @param index
     * @return boolean
     * @Description 删除指定位置上的客户
     * @author Cc
     * @date 18/7/2022 下午10:34
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        if (index == total - 1) {
            customers[index] = null;
            total--;
            return true;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        //最后一个数据的元素需要置空
        customers[--total] = null;
        return true;
    }

    /**
     * @param
     * @return com.liuchang.p2.bean.Customer[]
     * @Description 获取所有的客户信息
     * @author Cc
     * @date 18/7/2022 下午10:49
     */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     *@Description 获取指定位置上的客户
     *@author Cc
     *@param index
     *@return com.liuchang.p2.bean.Customer
     *@date 18/7/2022 下午10:51
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return this.customers[index];
    }
    /**
     *@Description 获取存储的客户的数量
     *@author Cc
     *@param
     *@return int
     *@date 18/7/2022 下午10:52
     */
    public int getTotal() {
        return this.total;
    }
}
