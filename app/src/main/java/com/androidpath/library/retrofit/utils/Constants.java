package com.androidpath.library.retrofit.utils;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/28 15:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface Constants {

    String Url = "http://192.168.1.105:8080/ServletMirror/ServletMyInterFace?num=9";
    String companyUrl = "http://192.168.3.31:8080/ServletMirror/";
//    String homeUrl = "http://192.168.1.105:8080/ServletMirror/";
    String homeUrl = "http://192.168.1.100:8081/SpringBoot/";
    String urlGet = "ServletMyInterFace?num=9";
    String urlGetnum = "ServletMyInterFace";//Query
    String urlHttpNum = "ServletMyInterFace{num}";//Http Path
    String API_URL = "https://api.github.com/";
    String gitUrl = "https://api.github.com/users/montotone/repos";

    String urlPost = "ServletMyInterFace?num=9";

    String insertPerson = "person/insert";
    String cardUrl = "person/getCard";
    String personUrl = "person/getPerson";

    String getByDown = "ServletDownLoad";

    //add in 2016:12:28 10:45
    String fileDownload = "http://192.168.3.31:8080/ServletMirror/ServletFileDownLoad/tk.mp3";

//    http://localhost:8080/ServletMirror/ServletMyInterFace?num=16
}
