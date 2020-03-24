package com.example.mycalc.utils

import java.text.SimpleDateFormat

class DateUtils {

    companion object {

        fun getDateStringFormat(): String {
            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return df.format(System.currentTimeMillis());
        }
    }
}