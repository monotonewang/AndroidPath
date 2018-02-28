package com.androidpath.activity.agstorge.sql.sqltransaction;//package com.example.administrator.testsqllite;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2018/2/2 0002.
// */
//
//@Dao
//public interface StationDao {
//
//    String table_name = "city";
//
//    @Query("SELECT * FROM city")
//    List<StationDataBean> loadAll();
//
//    @Query("SELECT * FROM city WHERE stationId IN (:stationId)")
//    List<StationDataBean> loadAllByUserId(int... userIds);
//
////    @Query("SELECT * FROM city where name LIKE :first AND last_name LIKE :last LIMIT 1")
////    User loadOneByNameAndLastName(String first, String last);
//
//    @Insert
//    void insertAll(StationDataBean... users);
//
//    @Delete
//    void delete(StationDataBean user);
//
//
//}
