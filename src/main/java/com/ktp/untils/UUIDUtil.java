package com.ktp.untils;

import java.util.UUID;

public class UUIDUtil {
    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
