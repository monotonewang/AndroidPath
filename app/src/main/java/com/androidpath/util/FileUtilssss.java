package com.androidpath.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/16 11:18 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class FileUtilssss {
    /**
     * depend on txt - transform to Arraylist
     *
     * @param context
     * @return
     */
    public static ArrayList getArrayList(Context context,int res) {
        InputStream inputStream = context.getResources().openRawResource(res);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
