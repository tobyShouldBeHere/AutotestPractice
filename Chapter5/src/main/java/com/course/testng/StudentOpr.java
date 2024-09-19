package com.course.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

interface Mymethod{
    void mymethod();
}


public class StudentOpr {

    @Test
    public void stuOpr1(){
        System.out.println("stuOpr1----------");
    }

    @BeforeMethod
    public void beaforeOpr(){
        System.out.println("beaforeOpr---");
    }

    @AfterMethod
    public void afterOpr(){
        System.out.println("afterOpr----");
    }

    @Test(threadPoolSize = 5, invocationCount = 10, dataProvider = "thread")
    public void threadRunMian(Object[][] obj) throws Exception {
        System.out.println("aaaaaaaaaa"+ obj);
//        obj[1].invoke();
    }


    @Test(dataProvider = "paramDataList")
    public void threadFuncs(Object... a){
        this.paramDataCase001();
        this.paramDataCase002(a);
    }

    public Mymethod paramDataCase001(){
        return new Mymethod(){
            public void mymethod() {
                System.out.printf("新的---stuThread: %s  ;", Thread.currentThread().getId());
            }
        };
    }

    @Test(dataProvider = "paramDataList")
    public void paramDataCase002(Object... a){
        System.out.printf("stuThread: %s ---a: %s ;", Thread.currentThread().getId(), a);
    }



    @DataProvider(name = "paramDataList" , parallel = true)
    public Object[][] dataProvideToCase001(Method method) {
        Object[][] obj = null;

        if(method.getName().equals("paramDataCase002")){
            obj = new Object[][]{
                    {"a", "b"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"},
                    {"b", "c"}
            };
        }
        return obj;
    }

}
