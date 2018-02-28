package com.androidpath.activity.agstorge.sql.sqltransaction;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */

public class GetAllStationVersionBean {

    /**
     * code : 0
     * message : null
     * data : {"version":57,"stationData":[{"id":null,"stationId":46,"stationLng":121.488811,"stationLat":31.239794,"cityId":310100},{"id":null,"stationId":41,"stationLng":120.153576,"stationLat":30.287607,"cityId":330100},{"id":null,"stationId":35,"stationLng":121.499627,"stationLat":31.254214,"cityId":310100},{"id":null,"stationId":38,"stationLng":121.499627,"stationLat":31.238242,"cityId":310100},{"id":null,"stationId":48,"stationLng":113.711503,"stationLat":34.712812,"cityId":410100},{"id":null,"stationId":29,"stationLng":120.153576,"stationLat":30.287478,"cityId":330100},{"id":null,"stationId":42,"stationLng":118.245124,"stationLat":28.682055,"cityId":361100},{"id":null,"stationId":28,"stationLng":108.948024,"stationLat":34.263161,"cityId":610100},{"id":null,"stationId":8,"stationLng":120.183166,"stationLat":30.283531,"cityId":330100},{"id":null,"stationId":25,"stationLng":108.964801,"stationLat":34.220679,"cityId":610100},{"id":null,"stationId":39,"stationLng":121.64192,"stationLat":38.920935,"cityId":210200},{"id":null,"stationId":32,"stationLng":120.143105,"stationLat":30.291943,"cityId":330100},{"id":null,"stationId":37,"stationLng":120.153576,"stationLat":30.287478,"cityId":420600},{"id":null,"stationId":18,"stationLng":120.150704,"stationLat":30.226426,"cityId":330100},{"id":null,"stationId":23,"stationLng":116.397477,"stationLat":39.911963,"cityId":110100},{"id":null,"stationId":31,"stationLng":108.947001,"stationLat":34.259458,"cityId":610100},{"id":null,"stationId":3,"stationLng":120.119158,"stationLat":30.280659,"cityId":330100},{"id":null,"stationId":36,"stationLng":112.211899,"stationLat":32.087298,"cityId":420600},{"id":null,"stationId":34,"stationLng":113.258258,"stationLat":23.136504,"cityId":120100},{"id":null,"stationId":33,"stationLng":112.185986,"stationLat":32.081541,"cityId":420600},{"id":null,"stationId":15,"stationLng":116.397148,"stationLat":39.917692,"cityId":110100},{"id":null,"stationId":43,"stationLng":120.153576,"stationLat":30.287607,"cityId":330100},{"id":null,"stationId":4,"stationLng":113.694249,"stationLat":34.772716,"cityId":410100},{"id":null,"stationId":30,"stationLng":119.264779,"stationLat":26.071084,"cityId":350100},{"id":null,"stationId":2,"stationLng":119.296389,"stationLat":26.080456,"cityId":350100},{"id":null,"stationId":26,"stationLng":120.153576,"stationLat":30.287478,"cityId":330100},{"id":null,"stationId":45,"stationLng":113.726278,"stationLat":34.771666,"cityId":410100},{"id":null,"stationId":40,"stationLng":112.565659,"stationLat":37.736526,"cityId":140100},{"id":null,"stationId":24,"stationLng":120.134837,"stationLat":30.227072,"cityId":330100},{"id":null,"stationId":27,"stationLng":112.215253,"stationLat":32.088297,"cityId":420600},{"id":null,"stationId":47,"stationLng":121.473814,"stationLat":31.248357,"cityId":310100}]}
     */

    public int code;
    public Object message;
    public DataBean data;

    public static class DataBean {
        /**
         * version : 57
         * stationData : [{"id":null,"stationId":46,"stationLng":121.488811,"stationLat":31.239794,"cityId":310100},{"id":null,"stationId":41,"stationLng":120.153576,"stationLat":30.287607,"cityId":330100},{"id":null,"stationId":35,"stationLng":121.499627,"stationLat":31.254214,"cityId":310100},{"id":null,"stationId":38,"stationLng":121.499627,"stationLat":31.238242,"cityId":310100},{"id":null,"stationId":48,"stationLng":113.711503,"stationLat":34.712812,"cityId":410100},{"id":null,"stationId":29,"stationLng":120.153576,"stationLat":30.287478,"cityId":330100},{"id":null,"stationId":42,"stationLng":118.245124,"stationLat":28.682055,"cityId":361100},{"id":null,"stationId":28,"stationLng":108.948024,"stationLat":34.263161,"cityId":610100},{"id":null,"stationId":8,"stationLng":120.183166,"stationLat":30.283531,"cityId":330100},{"id":null,"stationId":25,"stationLng":108.964801,"stationLat":34.220679,"cityId":610100},{"id":null,"stationId":39,"stationLng":121.64192,"stationLat":38.920935,"cityId":210200},{"id":null,"stationId":32,"stationLng":120.143105,"stationLat":30.291943,"cityId":330100},{"id":null,"stationId":37,"stationLng":120.153576,"stationLat":30.287478,"cityId":420600},{"id":null,"stationId":18,"stationLng":120.150704,"stationLat":30.226426,"cityId":330100},{"id":null,"stationId":23,"stationLng":116.397477,"stationLat":39.911963,"cityId":110100},{"id":null,"stationId":31,"stationLng":108.947001,"stationLat":34.259458,"cityId":610100},{"id":null,"stationId":3,"stationLng":120.119158,"stationLat":30.280659,"cityId":330100},{"id":null,"stationId":36,"stationLng":112.211899,"stationLat":32.087298,"cityId":420600},{"id":null,"stationId":34,"stationLng":113.258258,"stationLat":23.136504,"cityId":120100},{"id":null,"stationId":33,"stationLng":112.185986,"stationLat":32.081541,"cityId":420600},{"id":null,"stationId":15,"stationLng":116.397148,"stationLat":39.917692,"cityId":110100},{"id":null,"stationId":43,"stationLng":120.153576,"stationLat":30.287607,"cityId":330100},{"id":null,"stationId":4,"stationLng":113.694249,"stationLat":34.772716,"cityId":410100},{"id":null,"stationId":30,"stationLng":119.264779,"stationLat":26.071084,"cityId":350100},{"id":null,"stationId":2,"stationLng":119.296389,"stationLat":26.080456,"cityId":350100},{"id":null,"stationId":26,"stationLng":120.153576,"stationLat":30.287478,"cityId":330100},{"id":null,"stationId":45,"stationLng":113.726278,"stationLat":34.771666,"cityId":410100},{"id":null,"stationId":40,"stationLng":112.565659,"stationLat":37.736526,"cityId":140100},{"id":null,"stationId":24,"stationLng":120.134837,"stationLat":30.227072,"cityId":330100},{"id":null,"stationId":27,"stationLng":112.215253,"stationLat":32.088297,"cityId":420600},{"id":null,"stationId":47,"stationLng":121.473814,"stationLat":31.248357,"cityId":310100}]
         */

        public long version;
        public List<StationDataBean> stationData;

        public static class StationDataBean {
            /**
             * id : null
             * stationId : 46
             * stationLng : 121.488811
             * stationLat : 31.239794
             * cityId : 310100
             */

            public long id;
            public long stationId;
            public double stationLng;
            public double stationLat;
            public long cityId;

            public StationDataBean(long id, long stationId, double stationLng, double stationLat, long cityId) {
                this.id = id;
                this.stationId = stationId;
                this.stationLng = stationLng;
                this.stationLat = stationLat;
                this.cityId = cityId;
            }

            @Override
            public String toString() {
                return "StationDataBean{" +
                        "id=" + id +
                        ", stationId=" + stationId +
                        ", stationLng=" + stationLng +
                        ", stationLat=" + stationLat +
                        ", cityId=" + cityId +
                        '}';
            }
        }


        @Override
        public String toString() {
            return "DataBean{" +
                    "version=" + version +
                    ", stationData=" + stationData +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetAllStationVersionBean{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
