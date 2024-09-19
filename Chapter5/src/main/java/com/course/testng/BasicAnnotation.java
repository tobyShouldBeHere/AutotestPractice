package com.course.testng;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class BasicAnnotation {

    @Test
    public void testCase01() {
        System.out.println("aaaaa");
    }

    @Test(enabled = false)
    public void ignoreCase(){
        System.out.println("ignoreClass");
    }

    @Test(groups = "student1")
    public void stu1(){
        System.out.println("stu1------");
    }

    @Test(groups = "student2")
    public void stu2(){
        System.out.println("stu2----------");
    }

    @Test
    public void decrepency01(){
        System.out.println("decrepency01");
    }

    @Test(dependsOnMethods = "decrepency01")
    public void decrepency02(){
        System.out.println("decrepency02");
    }


    @Test
    @Parameters({"name", "age"})
    public void paramCase(String name, int age  ){
        System.out.println("name---" + name + "age ---" + age);
    }


    @Test(dataProvider = "userData")
    public void paramsDependcyCase01(String user, int emp){
        System.out.println("name---" + user + ";  emp ---" + emp);
    }

    @Test(dataProvider = "userData")
    public void paramsDependcyCase02(String user, int emp){
        System.out.println("name---" + user + ";  emp ---" + emp);
    }


    @DataProvider(name = "userData")
    public Object[][] userDataProvider(Method metthod){
        Object[][] obj = null;

        if(metthod.getName().equals("paramsDependcyCase01")){
             obj = new Object[][] {
                    {"user1", 20},
                    {"user2", 21}
            };
        }
        else if(metthod.getName().equals("paramsDependcyCase02")){
            obj = new Object[][]{
                    {"newUser1", 1},
                    {"newUser2", 2}
            };
        }
        return obj;
    }

    @Test
    public void threadNum1() {
        System.out.printf("111this id: %s", Thread.currentThread().getId());
    }

    @Test
    public void threadNum2() {
        System.out.printf("222this id: %s", Thread.currentThread().getId());
    }

    @Test
    public void threadNum3() {
        System.out.printf("333this id: %s", Thread.currentThread().getId());
    }
}
