package com.zehuang.utils;

public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentId(Integer empId) {
        CURRENT_LOCAL.set(empId);
    }
    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }
    public static void removeCurrentId() {
        CURRENT_LOCAL.remove();
    }
}
