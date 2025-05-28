package org.example.service;

import junit.framework.Assert;
import junit.framework.TestCase;
public class UserServiceTest extends TestCase {



    public void testRandomNumber() {
        UserService service = new UserService();

        boolean flag = true;
        for (int i = 0; i < 10000; i++) {
            int num = service.randomNumber();
            if (!(num >= 100 && num <= 999)) {
                flag = false;
                System.out.println(num);
            }
        }

        Assert.assertTrue(flag);
    }
}