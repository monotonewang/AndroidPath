package com.androidpath.view.viewpager.chabaike211.util;

/**
 * 常量的接口
 *
 * @author Ken
 */
public interface Contants {

    interface URL {

        //新闻消息
        String LZ_NEWS = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
        //首页头条数据的URL
        String TOUTIAO_URL = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines";

        //String url = String.format(Contants.URL.OTHER_URL, 16);
        //百科(16)、资讯(52)、数据(54)、经营(53)列表数据
        String OTHER_URL = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType&page=%d&rows=20&type=%d";

        //详情页数据URL
        String DESC_URL = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getNewsContent&id=%d";


//	    首页数据接口：
//      http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow
//      String txt= “给您分享一个不错的内容：title(http://www.baidu.com)”;
//	    Intent intent=new Intent(Intent.ACTION_SEND);
//      intent.setType(“text/*”);
//      intent.putExtra(Intent.EXTRA_TEXT,txt);
//      startActivity(intent);
    }
}
