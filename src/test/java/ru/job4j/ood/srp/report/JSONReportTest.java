package ru.job4j.ood.srp.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

class JSONReportTest {
    @Test
    void whenJSON() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report rsl = new JSONReport(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("[{\"fired\":\"")
                .append(parser.parse(worker.getFired()))
                .append("\",\"name\":\"")
                .append(worker.getName())
                .append("\",\"hired\":\"")
                .append(parser.parse(worker.getHired()))
                .append("\",\"salary\":")
                .append("100")
                .append("}]");
        assertThat(rsl.generate(employee -> true)).isEqualTo(expected.toString());
    }
}