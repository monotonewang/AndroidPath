package com.androidpath.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.activityjump50.MainActivity50;
import com.androidpath.activity.activitypassvalue54.MainActivity54;
import com.androidpath.activity.applicationpassvalue55.MainActivity55;
import com.androidpath.activity.flagdemo74.MainActivity74;
import com.androidpath.activity.getresult60.MainActivity60;
import com.androidpath.activity.saveinstance76.MainActivity76;
import com.androidpath.activity.taskdemo61.MainActivity61;
import com.androidpath.async.demoone70.MainActivity70;
import com.androidpath.async.demotwo71.MainActivity71;
import com.androidpath.async.getimagestrong72.MainActivity72;
import com.androidpath.async.progresslow73.MainActivity73;
import com.androidpath.broadcast.localboradcastOne232.MainActivity232;
import com.androidpath.broadcast.localboradcastTwo233.MainActivity233;
import com.androidpath.broadcast.sendbroadcast231.MainActivity231;
import com.androidpath.broadcast.serverclient234.client.MainActivity235;
import com.androidpath.broadcast.serverclient234.server.MainActivity234;
import com.androidpath.broadcast.staticdymic230.MainActivity230;
import com.androidpath.fragment.dialogframgment.MainActivity120;
import com.androidpath.fragment.dynicaddfragment123.MainActivity123;
import com.androidpath.fragment.fragmentpassvalue122.MainActivity122;
import com.androidpath.fragment.radiofragment124.MainActivity124;
import com.androidpath.fragment.staticfragment121.MainActivity121;
import com.androidpath.handler.handercycleiamge181.MainActivity181;
import com.androidpath.handler.handerimage180.MainActivity180;
import com.androidpath.handler.handlerlightcycle182.MainActivity182;
import com.androidpath.handler.handlerlopper184.MainActivity184;
import com.androidpath.handler.updateui183.MainActivity183;
import com.androidpath.service.intentservice248.MainActivity248;
import com.androidpath.service.localbroadservice242.MainActivity242;
import com.androidpath.service.mediaservice.mediaservice243.MainActivity243;
import com.androidpath.service.mediaservice246.MainActivity246;
import com.androidpath.service.servicedemo241.MainActivity241;
import com.androidpath.service.stickservice247.MainActivity247;
import com.androidpath.storge.contentResolverContacts161.MainActivity161;
import com.androidpath.storge.contentobserver160.MainActivity160;
import com.androidpath.storge.fileStorgetwo132.MainActivity132;
import com.androidpath.storge.filestorge131.MainActivity131;
import com.androidpath.storge.loadimage172.MainActivity172;
import com.androidpath.storge.loadmanagercontact171.MainActivity171;
import com.androidpath.storge.loadmanger170.MainActivity170;
import com.androidpath.storge.sharedproference130.MainActivity130;
import com.androidpath.storge.sql.simplecusoradapter155.MainActivity155;
import com.androidpath.storge.sql.sql140.MainActivity140;
import com.androidpath.storge.sql.sqlclientone150.MainActivity150;
import com.androidpath.storge.sql.sqlclienttwo152.MainActivity152;
import com.androidpath.storge.sql.sqldemo154.MainActivity154;
import com.androidpath.storge.sql.sqlserverone151.MainActivity151;
import com.androidpath.storge.sql.sqlservertwo153.MainActivity153;
import com.androidpath.util.language.LanguageActivity;
import com.androidpath.view.cbk.chabaike211.MainActivity211;
import com.androidpath.view.cbk.chabaike216.MainActivity216;
import com.androidpath.view.cbk.chabaike240.MainActivity240;
import com.androidpath.view.container.actionbar190.customview.MainActivity194;
import com.androidpath.view.container.actionbar190.demo190.MainActivity190;
import com.androidpath.view.container.actionbar190.list193.MainActivity193;
import com.androidpath.view.container.actionbar190.provider191.MainActivity191;
import com.androidpath.view.container.actionbar190.tab192.MainActivity192;
import com.androidpath.view.container.alertdialog110.MainActivity110;
import com.androidpath.view.container.asstes195.MainActivity195;
import com.androidpath.view.container.contextmenu111.MainActivity111;
import com.androidpath.view.container.dymicaddmenu117.MainActivity117;
import com.androidpath.view.container.notification112.MainActivity112;
import com.androidpath.view.container.optionmenu113.MainActivity113;
import com.androidpath.view.container.popupmenu114.MainActivity114;
import com.androidpath.view.container.subMenu115.MainActivity115;
import com.androidpath.view.container.toastdemo116.MainActivity116;
import com.androidpath.view.custom.surfaceview.SurfaceViewMainActivity;
import com.androidpath.view.listview.adddata81.MainActivity81;
import com.androidpath.view.listview.baseadapter80.MainActivity80;
import com.androidpath.view.listview.baseadapterpack100.MainActivity100;
import com.androidpath.view.listview.gradview102.MainActivity102;
import com.androidpath.view.listview.listviewdataparse83.MainActivity83;
import com.androidpath.view.listview.listviewexpandable101.MainActivity101;
import com.androidpath.view.listview.listviewjoke90.MainActivity90;
import com.androidpath.view.listview.lvemptyview103.SecondActivity103;
import com.androidpath.view.listview.simpleadapter82.MainActivity82;
import com.androidpath.view.normal.buttonbgcolor40.MainActivity40;
import com.androidpath.view.normal.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.view.normal.checkradio41.MainActivity41;
import com.androidpath.view.normal.clickreponse31.ButtonTestActivity31;
import com.androidpath.view.normal.edittext.autocompletetext51.MainActivity51;
import com.androidpath.view.normal.edittext.edittextdemo32.MainActivity32;
import com.androidpath.view.normal.imageviewdeal75.MainActivity75;
import com.androidpath.view.normal.imageviewtest.MainActivity33;
import com.androidpath.view.normal.layoutdemo2.LayoutActivity2;
import com.androidpath.view.normal.spinner.spinnerdemo42.MainActivity42;
import com.androidpath.view.normal.spinner.spinnerdemo43.MainActivity43;
import com.androidpath.view.normal.spinner.spinnerlink52.MainActivity52;
import com.androidpath.view.normal.spinner.spinnersimpleAdapter44.MainActivity44;
import com.androidpath.view.normal.viewtest34.MainActivity34;
import com.androidpath.view.viewpager.actionbar215.MainActivity215;
import com.androidpath.view.viewpager.circle212.MainActivity212;
import com.androidpath.view.viewpager.fragment214.MainActivity214;
import com.androidpath.view.viewpager.tabone220.MainActivity220;
import com.androidpath.view.viewpager.tabtwo221.MainActivity221;
import com.androidpath.view.viewpager.textview210.MainActivity210;
import com.androidpath.view.webview213.MainActivity213;
import com.androidpath.widget.view.HandActivity;

public class MainActivity extends BaseActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("exit");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutdemo2:
                startActivity(new Intent(MainActivity.this, LayoutActivity2.class));
                break;
            case R.id.languageSettings:
                startActivity(new Intent(MainActivity.this, LanguageActivity.class));
                break;

            case R.id.buttonselectordemo3:
                startActivity(new Intent(MainActivity.this, ButtonSelectorActivtiy3.class));
                break;
            case R.id.buttontestactivity31:
                startActivity(new Intent(MainActivity.this, ButtonTestActivity31.class));
                break;
            case R.id.edittextdemo32:
                startActivity(new Intent(MainActivity.this, MainActivity32.class));
                break;
            case R.id.imageviewTest33:
                startActivity(new Intent(MainActivity.this, MainActivity33.class));
                break;
            case R.id.viewTest34:
                startActivity(new Intent(MainActivity.this, MainActivity34.class));
                break;
            case R.id.handview:
                startActivity(new Intent(MainActivity.this, HandActivity.class));
                break;
            case R.id.buttonbgcolor40:
                startActivity(new Intent(MainActivity.this, MainActivity40.class));
                break;
            case R.id.checkRadio41:
                startActivity(new Intent(MainActivity.this, MainActivity41.class));
                break;
            case R.id.spinnerDemo42:
                startActivity(new Intent(MainActivity.this, MainActivity42.class));
                break;
            case R.id.spinnerDemo43:
                startActivity(new Intent(MainActivity.this, MainActivity43.class));
                break;
            case R.id.spinnerSimpleAdapter44:
                startActivity(new Intent(MainActivity.this, MainActivity44.class));
                break;
            case R.id.activityPassValue50:
                startActivity(new Intent(MainActivity.this, MainActivity54.class));
                break;
            case R.id.activityJump50:
                startActivity(new Intent(MainActivity.this, MainActivity50.class));
                break;
            case R.id.autoCompleteText51:
                startActivity(new Intent(MainActivity.this, MainActivity51.class));
                break;
            case R.id.spinnerLink52:
                startActivity(new Intent(MainActivity.this, MainActivity52.class));
                break;
            case R.id.activityPassValue55:
                startActivity(new Intent(MainActivity.this, MainActivity55.class));
                break;
            case R.id.getResult60:
                startActivity(new Intent(MainActivity.this, MainActivity60.class));
                break;
            case R.id.taskDemo61:
                startActivity(new Intent(MainActivity.this, MainActivity61.class));
                break;
            case R.id.AysncDemoOne70:
                startActivity(new Intent(MainActivity.this, MainActivity70.class));
                break;
            case R.id.AysncDemoTwo71:
                startActivity(new Intent(MainActivity.this, MainActivity71.class));
                break;
            case R.id.AysncGetImage72:
                startActivity(new Intent(MainActivity.this, MainActivity72.class));
                break;
            case R.id.AysncGetProgress73:
                startActivity(new Intent(MainActivity.this, MainActivity73.class));
                break;
            case R.id.ActivityFlagDemo74:
                startActivity(new Intent(MainActivity.this, MainActivity74.class));
                break;
            case R.id.ImageViewDeal75:
                startActivity(new Intent(MainActivity.this, MainActivity75.class));
                break;
            case R.id.ActivitySaveInstance76:
                startActivity(new Intent(MainActivity.this, MainActivity76.class));
                break;
            case R.id.listViewAdapter80:
                startActivity(new Intent(MainActivity.this, MainActivity80.class));
                break;
            case R.id.listViewAddData81:
                startActivity(new Intent(MainActivity.this, MainActivity81.class));
                break;
            case R.id.LVSimpleAdapter82:
                startActivity(new Intent(MainActivity.this, MainActivity82.class));
                break;
            case R.id.LVDataParse83:
                startActivity(new Intent(MainActivity.this, MainActivity83.class));
                break;
            case R.id.ListViewJoke90:
                startActivity(new Intent(MainActivity.this, MainActivity90.class));
                break;
            case R.id.BaseAdapterPack100:
                startActivity(new Intent(MainActivity.this, MainActivity100.class));
                break;
            case R.id.LvExpandable101:
                startActivity(new Intent(MainActivity.this, MainActivity101.class));
                break;
            case R.id.GradView102:
                startActivity(new Intent(MainActivity.this, MainActivity102.class));
                break;
            case R.id.LVEmptyView103:
                startActivity(new Intent(MainActivity.this, SecondActivity103.class));
                break;
            case R.id.AleatDialog110:
                startActivity(new Intent(MainActivity.this, MainActivity110.class));
                break;
            case R.id.ContextMenu111:
                startActivity(new Intent(MainActivity.this, MainActivity111.class));
                break;
            case R.id.Notification112:
                startActivity(new Intent(MainActivity.this, MainActivity112.class));
                break;
            case R.id.OptionMenu113:
                startActivity(new Intent(MainActivity.this, MainActivity113.class));
                break;
            case R.id.PopupMenu114:
                startActivity(new Intent(MainActivity.this, MainActivity114.class));
                break;
            case R.id.SubMenu115:
                startActivity(new Intent(MainActivity.this, MainActivity115.class));
                break;
            case R.id.ToastDemo116:
                startActivity(new Intent(MainActivity.this, MainActivity116.class));
                break;
            case R.id.DymicAddMenu117:
                startActivity(new Intent(MainActivity.this, MainActivity117.class));
                break;
            case R.id.DialogFragment120:
                startActivity(new Intent(MainActivity.this, MainActivity120.class));
                break;
            case R.id.StaticFragment121:
                startActivity(new Intent(MainActivity.this, MainActivity121.class));
                break;
            case R.id.PassValueFragement122:
                startActivity(new Intent(MainActivity.this, MainActivity122.class));
                break;
            case R.id.DynicAddFragment123:
                startActivity(new Intent(MainActivity.this, MainActivity123.class));
                break;
            case R.id.RadioFragment124:
                startActivity(new Intent(MainActivity.this, MainActivity124.class));
                break;
            case R.id.SharedProference130:
                startActivity(new Intent(MainActivity.this, MainActivity130.class));
                break;
            case R.id.fileStorge131:
                startActivity(new Intent(MainActivity.this, MainActivity131.class));
                break;
            case R.id.fileStorgeTwo132:
                startActivity(new Intent(MainActivity.this, MainActivity132.class));
                break;
            case R.id.sqlDemo140:
                startActivity(new Intent(MainActivity.this, MainActivity140.class));
                break;
            case R.id.sqlClientOne150:
                startActivity(new Intent(MainActivity.this, MainActivity150.class));
                break;
            case R.id.sqlServerOne151:
                startActivity(new Intent(MainActivity.this, MainActivity151.class));
                break;
            case R.id.sqlClientTwo152:
                startActivity(new Intent(MainActivity.this, MainActivity152.class));
                break;
            case R.id.sqlServerTwo153:
                startActivity(new Intent(MainActivity.this, MainActivity153.class));
                break;
            case R.id.sqlDemo154:
                startActivity(new Intent(MainActivity.this, MainActivity154.class));
                break;
            case R.id.simpleCursorAdapter155:
                startActivity(new Intent(MainActivity.this, MainActivity155.class));
                break;
            case R.id.contentObserver160:
                startActivity(new Intent(MainActivity.this, MainActivity160.class));
                break;
            case R.id.contentResolverContacts161:
                startActivity(new Intent(MainActivity.this, MainActivity161.class));
                break;
            case R.id.loadManager170:
                startActivity(new Intent(MainActivity.this, MainActivity170.class));
                break;
            case R.id.loadManagerContact171:
                startActivity(new Intent(MainActivity.this, MainActivity171.class));
                break;
            case R.id.LoadImage172:
                startActivity(new Intent(MainActivity.this, MainActivity172.class));
                break;
            case R.id.HandlerImage180:
                startActivity(new Intent(MainActivity.this, MainActivity180.class));
                break;
            case R.id.HandlerCycleImage181:
                startActivity(new Intent(MainActivity.this, MainActivity181.class));
                break;
            case R.id.HandlerLightCycle182:
                startActivity(new Intent(MainActivity.this, MainActivity182.class));
                break;
            case R.id.HandlerUpdateUI183:
                startActivity(new Intent(MainActivity.this, MainActivity183.class));
                break;
            case R.id.HandlerLooper184:
                startActivity(new Intent(MainActivity.this, MainActivity184.class));
                break;
            case R.id.AcitionBarDemo190:
                startActivity(new Intent(MainActivity.this, MainActivity190.class));
                break;
            case R.id.AcitionBarProvider191:
                startActivity(new Intent(MainActivity.this, MainActivity191.class));
                break;
            case R.id.AcitionBarTab192:
                startActivity(new Intent(MainActivity.this, MainActivity192.class));
                break;
            case R.id.AcitionBarList193:
                startActivity(new Intent(MainActivity.this, MainActivity193.class));
                break;
            case R.id.AcitionBarCustomView194:
                startActivity(new Intent(MainActivity.this, MainActivity194.class));
                break;
            case R.id.Asstes195:
                startActivity(new Intent(MainActivity.this, MainActivity195.class));
                break;
            case R.id.textViewViewPager210:
                startActivity(new Intent(MainActivity.this, MainActivity210.class));
                break;
            case R.id.chabaike211:
                startActivity(new Intent(MainActivity.this, MainActivity211.class));
                break;
            case R.id.HeadViewPager212:
                startActivity(new Intent(MainActivity.this, MainActivity212.class));
                break;
            case R.id.WebView213:
                startActivity(new Intent(MainActivity.this, MainActivity213.class));
                break;
            case R.id.FragmentViewPager214:
                startActivity(new Intent(MainActivity.this, MainActivity214.class));
                break;
            case R.id.ActionBarViewPager215:
                startActivity(new Intent(MainActivity.this, MainActivity215.class));
                break;
            case R.id.ChaBaiKe216:
                startActivity(new Intent(MainActivity.this, MainActivity216.class));
                break;
            case R.id.TabViewPager220:
                startActivity(new Intent(MainActivity.this, MainActivity220.class));
                break;
            case R.id.TabViewPagerTwo221:
                startActivity(new Intent(MainActivity.this, MainActivity221.class));
                break;
            case R.id.BroadCastReceiver230:
                startActivity(new Intent(MainActivity.this, MainActivity230.class));
                break;
            case R.id.SendBroadCast231:
                startActivity(new Intent(MainActivity.this, MainActivity231.class));
                break;
            case R.id.LocalBroadCastOne232:
                startActivity(new Intent(MainActivity.this, MainActivity232.class));
                break;
            case R.id.LocalBroadCastTwo233:
                startActivity(new Intent(MainActivity.this, MainActivity233.class));
                break;
            case R.id.BroadCastServer234:
                startActivity(new Intent(MainActivity.this, MainActivity234.class));
                break;
            case R.id.BroadCastClient235:
                startActivity(new Intent(MainActivity.this, MainActivity235.class));
                break;
            case R.id.ChaBaiKe240:
                startActivity(new Intent(MainActivity.this, MainActivity240.class));
                break;
            case R.id.ServiceDemo241:
                startActivity(new Intent(MainActivity.this, MainActivity241.class));
                break;
            case R.id.LocalBroadCastService242:
                startActivity(new Intent(MainActivity.this, MainActivity242.class));
                break;
            case R.id.MeidaService243:
                startActivity(new Intent(MainActivity.this, MainActivity243.class));
                break;
            case R.id.MeidaService246:
                startActivity(new Intent(MainActivity.this, MainActivity246.class));
                break;
            case R.id.StickService247:
                startActivity(new Intent(MainActivity.this, MainActivity247.class));
                break;
            case R.id.IntentService248:
                startActivity(new Intent(MainActivity.this, MainActivity248.class));
                break;
            case R.id.SurfaceViewBird:
                startActivity(new Intent(MainActivity.this, SurfaceViewMainActivity.class));
                break;
            default:

                break;

        }
    }
}
