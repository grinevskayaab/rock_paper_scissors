package com.githab.grinevskayaab;


public interface GetInfo {
    default int getRounds() {
        return 3;
    }

    default String getName() {
        return "";
    }

    default byte getMode() {
        return 2;
    }

    static boolean isNumber(String str) {
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
