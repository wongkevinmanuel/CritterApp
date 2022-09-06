package com.example.critterapp.helper;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.Objects;

public class InputHelper {
    public static final String ESPACIO = "\\u202F\\u202F";

    private static boolean isWhiteSpaces(@Nullable String str){
        return str != null && str.matches("\\s+");
    }

    public static boolean isEmpty(@Nullable String str){
        return Objects.isNull(str) || TextUtils.isEmpty(str)
                || isWhiteSpaces(str) || str.equalsIgnoreCase("null");
    }
}
