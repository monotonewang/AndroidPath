package com.androidpath.activity.adlistview.listviewjoke90;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.adlistview.listviewjoke90.bean.Joke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity90 extends BaseActivity {

    private ListView listView;
    //	private String urlString = "http://api.1-blog.com/biz/bizserver/xiaohua/list.do?size=10&page=";
    private String urlString = "http://api.laifudao.com/open/xiaohua.json";
    private List<Joke> list = new ArrayList<>();
    ;
    private JokeAdapter jokeAdapter;

    private int currentPage = 0;
    private LinearLayout nextPageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main90);

        listView = (ListView) findViewById(R.id.listView);
        nextPageLayout = (LinearLayout) findViewById(R.id.next_layout);


        //开启异步任务下载数据，进行解析，
        startDowloadDataAsyncTask();

        jokeAdapter = new JokeAdapter(this, list);
        listView.setAdapter(jokeAdapter);


        //如果listview滑动到最后一条记录，屏幕上要出现一个继续加载的控件，点击控件后就要继续加载数据
        listView.setOnScrollListener(new OnScrollListener() {
            private boolean isBottom = false;

            //在滚动状态发生改变的时候回调
            //参数一就是在滚动的listview对象
            //参数二是滚动的状态
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                nextPageLayout.setVisibility(View.INVISIBLE);

                if (scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    Log.e("滚动事件", "SCROLL_STATE_TOUCH_SCROLL正在滚动手指还在屏幕上");
                } else if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
                    Log.e("滚动事件", "SCROLL_STATE_IDLE 停止滚动");
                    //判断停止滚动的时候是不是已经显示了最后一条记录，如果是的话就继续加载数据
                    // 显示继续加载的按钮，点击按钮后再加载数据
                    if (isBottom) {
                        /*currentPage ++;
						startDowloadDataAsyncTask();*/
                        nextPageLayout.setVisibility(View.VISIBLE);
                    }


                } else if (scrollState == OnScrollListener.SCROLL_STATE_FLING) {
                    Log.e("滚动事件", "SCROLL_STATE_FLING 惯性滚动");
                }
            }

            //滚动时回调
            //参数一就是在滚动的listview对象
            //参数二是第一个可见的item的下标
            //参数三是可见的子视图的总数
            //参数四是总共的子视图的个数
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // TODO Auto-generated method stub
                Log.e("onScroll",
                        "firstVisibleItem:" + firstVisibleItem + " visibleItemCount:" + visibleItemCount
                                + " totalItemCount:" + totalItemCount);

                //如果为真就是滑动到了最后一个记录
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    //如果显示到最后一条记录就将isBottom设置为true，在停止滚动后利用isBottom判断是否出现”继续加载“的按钮
                    isBottom = true;
                } else {
                    isBottom = false;
                }
            }
        });
    }

    //点击”继续加载“的时候回调
    public void clickNext(View view) {
        nextPageLayout.setVisibility(View.INVISIBLE);
        currentPage++;
        startDowloadDataAsyncTask();
    }


    private void startDowloadDataAsyncTask() {
        DowloadDataAsyncTask task = new DowloadDataAsyncTask();

        //给异步任务注册监听器，用于监听下载和解析数据是否完成，完成的话将数据添加到list中，更新litview的数据
        task.setOnDownloadJokeCompleteListener(new DowloadDataAsyncTask.OnDownloadJokeCompleteListener() {
            public void OnDownloadJokeComplete(List<Joke> newList) {
                //更新数据集合
                list.addAll(newList);
                //通知适配器更新视图
                jokeAdapter.notifyDataSetChanged();
            }
        });
//		task.execute(urlString+currentPage);
//		task.execute(urlString);
    }
}
