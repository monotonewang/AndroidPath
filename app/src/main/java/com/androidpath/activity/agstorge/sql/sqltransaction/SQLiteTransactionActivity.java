package com.androidpath.activity.agstorge.sql.sqltransaction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidpath.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SQLiteTransactionActivity extends AppCompatActivity {

    private Context mContext;

    private static final String DB_NAME = "test.db";

    private static final String ASSETS_NAME = "test.db";

    private static final int BUFFER_SIZE = 1024;

    private static final String TABLE_NAME = "city";

    private static final String TABLE_NAME_VERSION = "version";


    String DB_PATH;
    private MySQLLiteOpenHelper mySQLLiteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        this.mContext = SQLiteTransactionActivity.this;

        DB_PATH = File.separator + "data"
                + Environment.getDataDirectory().getAbsolutePath() + File.separator
                + mContext.getPackageName() + File.separator + "databases" + File.separator;

        mySQLLiteOpenHelper = new MySQLLiteOpenHelper(mContext);

//        mySQLLiteOpenHelper.getWritableDatabase().insert();

        findViewById(R.id.tv_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<GetAllStationVersionBean.DataBean.StationDataBean> getAllStationVersionBean = mySQLLiteOpenHelper.getGetAllStationVersionBean();
                System.out.println("-----------" + getAllStationVersionBean);

            }
        });

        findViewById(R.id.tv_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取apk打包数据
//                GetAllStationVersionBean jsonFromLocal = getJsonFromLocal(mContext);
//                System.out.println(jsonFromLocal);

//                mySQLLiteOpenHelper.getReadableDatabase()
//                List<StationDataBean> allStationBean = getAllStationBean();
//
//                long version = getVersion();
//
//                for (int i = 0; i < allStationBean.size(); i++) {
//                    System.out.println("----------result==" + allStationBean.get(i));
//                }
//
//                System.out.println("----------" + version);
            }
        });

        findViewById(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<GetAllStationVersionBean.DataBean.StationDataBean> getAllStationVersionBean = mySQLLiteOpenHelper.getGetAllStationVersionBean();

                for(int i=0;i<getAllStationVersionBean.size();i++){
                    System.out.println(getAllStationVersionBean.get(i));
                }
//                int step = 10000;
//
//                int id = (int) (Math.random() * 10 + step);
//                int stationId = (int) (Math.random() * 10 + step);
//                double stationLng = (int) (Math.random() * 10 + step);
//                double stationLat = (int) (Math.random() * 10 + step);
//                int cityId = (int) (Math.random() * 10 + step);
//
//                GetAllStationVersionBean.DataBean.StationDataBean stationDataBean = new GetAllStationVersionBean.DataBean.StationDataBean(id, stationId, stationLng, stationLat, cityId);
//                mySQLLiteOpenHelper.insertStationBean(stationDataBean);
            }
        });


        findViewById(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            int i = 46;

            @Override
            public void onClick(View v) {
                long l = mySQLLiteOpenHelper.deleteStationBean(i);
                System.out.println("------tv_delete" + l+"i="+i);
                i++;
            }
        });

        findViewById(R.id.tv_delete_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.tv_alter).setOnClickListener(new View.OnClickListener() {

            int i = 29;

            @Override
            public void onClick(View v) {


                int step = 10000;

                int id = (int) (Math.random() * 10 + step);
                int stationId = i;
                double stationLng = (int) (Math.random() * 10 + step);
                double stationLat = (int) (Math.random() * 10 + step);
                int cityId = (int) (Math.random() * 10 + step);

                GetAllStationVersionBean.DataBean.StationDataBean stationDataBean = new GetAllStationVersionBean.DataBean.StationDataBean(id, stationId, stationLng, stationLat, cityId);
                long l = mySQLLiteOpenHelper.updateStationBean(stationDataBean);

                System.out.println("------------tv_alter" + l);

            }
        });

        findViewById(R.id.tv_tran).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<GetAllStationVersionBean.DataBean.StationDataBean> list=new ArrayList<>();

                list.add(new GetAllStationVersionBean.DataBean.StationDataBean(1,46,0.1,0.2,1,2));
                list.add(new GetAllStationVersionBean.DataBean.StationDataBean(1,100,0.1,0.2,1,1));
                list.add(new GetAllStationVersionBean.DataBean.StationDataBean(1,102,0.1,0.2,1,1));

                mySQLLiteOpenHelper.handleStationList(list);

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySQLLiteOpenHelper.onDestory();
    }

    private void getListFromJson() {

    }

    private long getVersion() {

        System.out.println("----begin==getVersion" + System.currentTimeMillis());
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH + DB_NAME, null);
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME_VERSION, null);

        long version = 0;
        while (cursor.moveToNext()) {
            version = cursor.getLong(cursor.getColumnIndex("version"));
        }
        cursor.close();
        db.close();
        System.out.println("----end==getVersion" + System.currentTimeMillis());
        return version;
    }


}
