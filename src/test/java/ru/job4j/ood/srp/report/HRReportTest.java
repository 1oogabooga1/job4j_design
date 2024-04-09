package ru.job4j.ood.srp.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

class HRReportTest {
    @Test
    void whenHRReport() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee secondWorker = new Employee("Dmitrii", now, now, 200);
        Employee thirdWorker = new Employee("Sergei", now, now, 300);
        store.add(worker);
        store.add(secondWorker);
        store.add(thirdWorker);
        Report engine = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(thirdWorker.getName()).append(" ")
                .append(thirdWorker.getSalary())
                .append(System.lineSeparator())
                .append(secondWorker.getName()).append(" ")
                .append(secondWorker.getSalary())
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }

}