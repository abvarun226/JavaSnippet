package com.abvarun226.JavaLangDemo;


import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.Date;

/**
 * Created by bharghav on 1/22/15.
 */

public class GetJVMTime {
    public static void main(String... args) throws InterruptedException {
        System.out.println(new Date(System.currentTimeMillis()));
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        long startTime = runtimeBean.getStartTime();
        Date startDate = new Date(startTime);

        String jvmName = runtimeBean.getName();
        System.out.println("JVM Name = " + jvmName);
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("JVM PID = " + pid);

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        int peakThreadCount = bean.getPeakThreadCount();
        System.out.println("Peak Thread Count = " + peakThreadCount);

        Thread.sleep(5000);

        System.out.println(new Date(System.currentTimeMillis()));

        System.out.println();
        System.out.println("Start time in milliseconds = " + startTime);
        System.out.println("Start Date = " + startDate);
        System.out.println("UpTime = " + runtimeBean.getUptime() + " ms");
    }
}
