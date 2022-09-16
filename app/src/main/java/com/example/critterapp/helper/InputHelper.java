package com.example.critterapp.helper;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

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

    public static boolean isEmpty(@Nullable EditText editText){
        return Objects.isNull(editText) || isEmpty(editText.getText().toString());
    }

    public static boolean isEmpty(@Nullable TextView textView){
        return Objects.isNull(textView) || isEmpty(textView.getText().toString());
    }

    public static String isEmpty(@Nullable TextInputLayout textInputLayout){
        return textInputLayout != null ? textInputLayout.getEditText().toString() : "";
    }

    @Nullable
    public static toString(@Nullable Object object){
        return !isEmpty(object) ? object.toString() : "";
    }

}
