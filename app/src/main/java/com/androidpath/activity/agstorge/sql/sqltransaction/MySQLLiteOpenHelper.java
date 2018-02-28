package com.androidpath.activity.agstorge.sql.sqltransaction;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */

public class MySQLLiteOpenHelper extends SQLiteOpenHelper {

    private Context mContext;

    private final String STATION_TABLE_NAME = "station_table_name";

    private final String id = "id";
    private final String stationId = "stationId";
    private final String stationLng = "stationLng";
    private final String stationLat = "stationLat";
    private final String cityId = "cityId";

    private final String VERSION_TABLE_NAME = "version_table_name";

    private final String version = "version";

    public MySQLLiteOpenHelper(Context context) {
        this(context, "stationDb", null, 1);
        System.out.println("------------MySQLLiteOpenHelper context");
        mContext = context;
    }


    public MySQLLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("------------MySQLLiteOpenHelper onCreate");

        String sql = "create table if not exists " + STATION_TABLE_NAME + " (id bigint ,stationId bigint,stationLng double,stationLat double,cityId bigint)";
        db.execSQL(sql);
    }

    /**
     * 将assets数据copy到db
     */
    public void copyAssetsToDb() {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from " + STATION_TABLE_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        System.out.println("-------------------MySQLLiteOpenHelper" + count + "Thread=" + Thread.currentThread().getName());

        if (count <= 0) {
            System.out.println("------isEmpty");
            GetAllStationVersionBean getAllStationVersionBean = getJsonFromLocal(mContext);

            boolean isOk = getAllStationVersionBean != null &&getAllStationVersionBean.data!=null&& getAllStationVersionBean.data.stationData != null && !getAllStationVersionBean.data.stationData.isEmpty();
            if (isOk) {
                List<GetAllStationVersionBean.DataBean.StationDataBean> stationData = getAllStationVersionBean.data.stationData;
                for (int i = 0; i < stationData.size(); i++) {
                    ContentValues values = new ContentValues();
                    values.put(id, stationData.get(i).id);
                    values.put(stationId, stationData.get(i).stationId);
                    values.put(stationLng, stationData.get(i).stationLng);
                    values.put(stationLat, stationData.get(i).stationLat);
                    values.put(cityId, stationData.get(i).cityId);
                    database.insert(STATION_TABLE_NAME, null, values);
                }
            }
        }
        database.close();
    }

    public List<GetAllStationVersionBean.DataBean.StationDataBean> getGetAllStationVersionBean() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from " + STATION_TABLE_NAME, null);

        if (cursor.getCount() <= 0) {
            copyAssetsToDb();
        }

        SQLiteDatabase databaseReadData = getReadableDatabase();
        Cursor cursorReadData = databaseReadData.rawQuery("select * from " + STATION_TABLE_NAME, null);

        List<GetAllStationVersionBean.DataBean.StationDataBean> result = new ArrayList<>();
        GetAllStationVersionBean.DataBean.StationDataBean city;
        while (cursorReadData.moveToNext()) {
            long idx = cursorReadData.getLong(cursorReadData.getColumnIndex(id));
            long stationIdX = cursorReadData.getLong(cursorReadData.getColumnIndex(stationId));
            double stationLngX = cursorReadData.getDouble(cursorReadData.getColumnIndex(stationLng));
            double stationLatX = cursorReadData.getDouble(cursorReadData.getColumnIndex(stationLat));
            long cityIdX = cursorReadData.getLong(cursorReadData.getColumnIndex(cityId));
            city = new GetAllStationVersionBean.DataBean.StationDataBean(idx, stationIdX, stationLngX, stationLatX, cityIdX);
            result.add(city);
        }
        cursorReadData.close();
        cursor.close();
        database.close();
        databaseReadData.close();
        return result;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("---------+onUpgrade" + oldVersion + "newVersion=" + newVersion);
        try {
            db.execSQL("drop table if exists " + STATION_TABLE_NAME);

            onCreate(db);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long insertStationBean(GetAllStationVersionBean.DataBean.StationDataBean stationDataBean) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(id, stationDataBean.id);
        values.put(stationId, stationDataBean.stationId);
        values.put(stationLng, stationDataBean.stationLng);
        values.put(stationLat, stationDataBean.stationLat);
        values.put(cityId, stationDataBean.cityId);

        long insert = database.insert(STATION_TABLE_NAME, null, values);
        database.close();
        return insert;
    }

    public long deleteStationBean(long stationId) {
        SQLiteDatabase database = getWritableDatabase();


        String whereCause = stationId + "=?";

        String[] values = {String.valueOf(stationId)};

        long insert = database.delete(STATION_TABLE_NAME, whereCause, values);
        database.close();
        return insert;
    }

    public long updateStationBean(GetAllStationVersionBean.DataBean.StationDataBean stationDataBean) {
        SQLiteDatabase database = getWritableDatabase();

        String whereCause = stationId + "=?";

        ContentValues values = new ContentValues();
        values.put(id, stationDataBean.id);
        values.put(stationId, stationDataBean.stationId);
        values.put(stationLng, stationDataBean.stationLng);
        values.put(stationLat, stationDataBean.stationLat);
        values.put(cityId, stationDataBean.cityId);

        String[] args = {String.valueOf(stationDataBean.stationId)};

        long insert = database.update(STATION_TABLE_NAME, values, whereCause, args);

        database.close();
        return insert;
    }

    public void onDestory() {
        close();
    }


    public static GetAllStationVersionBean getJsonFromLocal(Context context) {
        String filePathTest = "json/station.json";
        AssetManager assets = context.getResources().getAssets();
        ByteArrayOutputStream out;
        byte[] buffer = null;
        InputStream in = null;
        try {
            in = assets.open(filePathTest);
            out = new ByteArrayOutputStream();
            int len;
            byte[] bs = new byte[1024];
            while ((len = in.read(bs)) != -1) {
                out.write(bs, 0, len);
            }
            buffer = out.toByteArray();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buffer != null) {
            String json = null;
            try {
                json = new String(buffer, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            GsonBuilder gsonBuilder = new GsonBuilder();
            return gsonBuilder.create().fromJson(json, GetAllStationVersionBean.class);
        }

        return null;
    }
}
