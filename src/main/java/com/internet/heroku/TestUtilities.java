package com.internet.heroku;

public class TestUtilities extends BaseTest{

    protected void sleep(long sec) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
