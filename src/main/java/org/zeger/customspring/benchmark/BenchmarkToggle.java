package org.zeger.customspring.benchmark;

import lombok.Data;
import lombok.SneakyThrows;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
@Data
public class BenchmarkToggle implements BenchmarkToggleMBean {

    private boolean enabled = true;

    @SneakyThrows
    public BenchmarkToggle() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(this, new ObjectName("myMbeans", "name", "benchmark"));
    }
}
