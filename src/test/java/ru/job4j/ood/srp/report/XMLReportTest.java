package ru.job4j.ood.srp.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Calendar;

class XMLReportTest {

    @Test
    void whenXML() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Report rsl = new XMLReport(store, context, context.createMarshaller());
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<Employee name=\"")
                .append(worker.getName())
                .append("\" salary=\"")
                .append(worker.getSalary())
                .append("\">")
                .append(System.lineSeparator())
                .append("    <hired>")
                .append(parser.parse(worker.getHired()))
                .append("</hired>")
                .append(System.lineSeparator())
                .append("    <fired>")
                .append(parser.parse(worker.getFired()))
                .append("</fired>")
                .append(System.lineSeparator())
                .append("</Employee>")
                .append(System.lineSeparator());
        assertThat(rsl.generate(employee -> true)).isEqualTo(expected.toString());
    }

}