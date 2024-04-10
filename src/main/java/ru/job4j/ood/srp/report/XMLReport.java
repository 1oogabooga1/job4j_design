package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;

public class XMLReport implements Report {

    private final Store store;

    private JAXBContext context;

    private Marshaller marshaller;

    public XMLReport(Store store, JAXBContext context,
                     Marshaller marshaller) {
        this.store = store;
        this.context = context;
        this.marshaller = marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = null;
        try {
            for (Employee employee : store.findBy(filter)) {
                context = JAXBContext.newInstance(Employee.class);
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                StringWriter writer = new StringWriter();
                marshaller.marshal(employee, writer);
                xml = writer.getBuffer().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public static void main(String[] args) throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        JAXBContext context1 = JAXBContext.newInstance(Employee.class);
        Report engine = new XMLReport(store, context1, context1.createMarshaller());
        System.out.println(engine.generate(employee -> true));
    }

    public static class CalendarAdapterXml extends XmlAdapter<String, Calendar> {
        private static final ThreadLocal<DateFormat> DATE_FORMAT
                = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd:MM:yyyy HH:mm"));

        @Override
        public Calendar unmarshal(String d) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DATE_FORMAT.get().parse(d));
            return cal;
        }

        @Override
        public String marshal(Calendar d) {
            return DATE_FORMAT.get().format(d.getTime());
        }
    }
}
