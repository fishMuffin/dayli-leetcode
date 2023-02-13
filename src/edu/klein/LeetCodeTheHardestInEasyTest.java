package edu.klein;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeTheHardestInEasyTest {

    LeetCodeTheHardestInEasy hardestInEasy;

    @Before
    public void init() {
        hardestInEasy = new LeetCodeTheHardestInEasy();
    }


    @Test
    public void testEqualFrequency() {
        boolean abcc = hardestInEasy.equalFrequency("abbcc");
        System.out.println(abcc);
    }


}
