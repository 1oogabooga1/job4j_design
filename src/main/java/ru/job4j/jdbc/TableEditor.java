package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        Class.forName(properties.getProperty("driver_class"));
        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    private void sqlRequest(String sql) throws Exception {
        initConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {
        sqlRequest(String.format("CREATE TABLE %s(id SERIAL PRIMARY KEY, name TEXT)", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        sqlRequest(String.format("drop table %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        sqlRequest(String.format("alter table %s add %s %s ", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        sqlRequest(String.format("alter table %s drop column %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        sqlRequest(String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName));
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        TableEditor te = new TableEditor(properties);
        te.createTable("test");
        System.out.println(te.getTableScheme("test"));
        te.addColumn("test", "Phone_number", "int");
        System.out.println(te.getTableScheme("test"));
        te.renameColumn("test", "Phone_number", "Address");
        System.out.println(te.getTableScheme("test"));
        te.dropColumn("test", "Address");
        System.out.println(te.getTableScheme("test"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}