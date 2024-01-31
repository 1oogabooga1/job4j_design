package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean boo = false;
        int i = 123;
        long l = 123343L;
        double d = 2133.234D;
        float f = 123.23F;
        byte b = 2;
        char c = 'c';
        short s = 124;
        LOG.debug("boolean = {}, int = {}, long = {}, double = {}, float = {}, byte = {}, char = {}, short = {}.", boo, i, l, d, f, b, c, s);
    }
}