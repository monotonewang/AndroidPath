package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.entity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ubuntu on 17-9-27.
 */

public class LanguageResponse {

    /**
     * lan : [{"abbr":"CN","language":null,"path":null},{"abbr":"EN","language":null,"path":"http://cdn.hifunki.com/language/funki/common-EN-1.json"},{"abbr":"FR","language":null,"path":null},{"abbr":"KO","language":null,"path":null}]
     * total : 4
     */

    public int total;

    public List<LanBean> lan;


    @Override
    public String toString() {
        return "LanguageResponse{" +
                "total=" + total +
                ", lan=" + lan +
                '}';
    }

    public static class LanBean {
        /**
         * abbr : CN
         * language : null
         * path : null
         */

        public String abbr;
        public String language;
        public String path;
        public String filename;

        public HashMap<Integer,String> fileContent;
        public boolean isSelect;//是否是用户选中的语言

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof LanBean)) return false;
            LanBean bean = (LanBean)obj;
            boolean isSame = (abbr==null && bean.abbr==null) || (abbr!=null && abbr.equals(bean.abbr));
            isSame =  isSame && ((language==null && bean.language==null) || (language!=null && language.equals(bean.language)));
            isSame =  isSame && ((path==null && bean.path==null) || (path!=null && path.equals(bean.path)));
            isSame =  isSame && ((filename==null && bean.filename==null) || (filename!=null && filename.equals(bean.filename)));
            return isSame;
        }

        @Override
        public String toString() {
            return "LanBean{" +
                    "abbr='" + abbr + '\'' +
                    ", language='" + language + '\'' +
                    ", path='" + path + '\'' +
                    ", filename='" + filename + '\'' +
                    ", fileContent=" + fileContent +
                    ", isSelect=" + isSelect +
                    '}';
        }
    }
}
