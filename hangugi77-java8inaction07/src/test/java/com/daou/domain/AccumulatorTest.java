package com.daou.domain;

import com.daou.Java8inaction07ApplicationTests;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.LongStream;

public class AccumulatorTest extends Java8inaction07ApplicationTests {
    @Test
    public void accumulatorTest() {
        // AtomicLong
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, 50000).parallel().forEach(accumulator::add);
        Assert.assertEquals((long) 1250025000, accumulator.total.get());
        System.out.println("AtomicLong: " + accumulator.total);

        // volatile long with serial
        Accumulator2 accumulator2 = new Accumulator2();
        LongStream.rangeClosed(1, 50000).forEach(accumulator2::add);
        Assert.assertEquals((long) 1250025000, accumulator2.total);
        System.out.println("volatile long with serial: " + accumulator2.total);

        // volatile long with parallel
        Accumulator2 accumulator21 = new Accumulator2();
        LongStream.rangeClosed(1, 50000).parallel().forEach(accumulator21::add);
        Assert.assertNotEquals((long) 1250025000, accumulator21.total);
        System.out.println("volatile long with parallel: " + accumulator21.total);

        // static long
        Accumulator3 accumulator3 = new Accumulator3();
        LongStream.rangeClosed(1, 50000).parallel().forEach(accumulator3::add);
        Assert.assertNotEquals(1250025000, accumulator3.total);
        System.out.println("static long: " + accumulator3.total);

        // static volatile long
        Accumulator4 accumulator4 = new Accumulator4();
        LongStream.rangeClosed(1, 50000).parallel().forEach(accumulator4::add);
        Assert.assertNotEquals(1250025000, accumulator4.total);
        System.out.println("static volatile long: " + accumulator4.total);
    }
}
