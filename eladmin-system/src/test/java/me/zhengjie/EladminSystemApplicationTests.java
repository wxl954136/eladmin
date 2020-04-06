package me.luke;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EladminSystemApplicationTests {

    @Test
    public void contextLoads() {

    }
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("" + uuid) ;
    }
}
