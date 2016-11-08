package com.androidpath.main;

import android.content.Intent;
import android.os.Bundle;
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
import com.androidpath.container.alertdialog110.MainActivity110;
import com.androidpath.container.contextmenu111.MainActivity111;
import com.androidpath.container.dymicaddmenu117.MainActivity117;
import com.androidpath.container.notification112.MainActivity112;
import com.androidpath.container.optionmenu113.MainActivity113;
import com.androidpath.container.popupmenu114.MainActivity114;
import com.androidpath.container.subMenu115.MainActivity115;
import com.androidpath.container.toastdemo116.MainActivity116;
import com.androidpath.controls.buttonbgcolor40.MainActivity40;
import com.androidpath.controls.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.controls.checkradio41.MainActivity41;
import com.androidpath.controls.clickreponse31.ButtonTestActivity31;
import com.androidpath.controls.edittext.autocompletetext51.MainActivity51;
import com.androidpath.controls.edittext.edittextdemo32.MainActivity32;
import com.androidpath.controls.imageviewdeal75.MainActivity75;
import com.androidpath.controls.imageviewtest.MainActivity33;
import com.androidpath.controls.layoutdemo2.LayoutActivity2;
import com.androidpath.controls.spinner.spinnerdemo42.MainActivity42;
import com.androidpath.controls.spinner.spinnerdemo43.MainActivity43;
import com.androidpath.controls.spinner.spinnerlink52.MainActivity52;
import com.androidpath.controls.spinner.spinnersimpleAdapter44.MainActivity44;
import com.androidpath.controls.viewtest34.MainActivity34;
import com.androidpath.fragment.dialogframgment.MainActivity120;
import com.androidpath.fragment.dynicaddfragment123.MainActivity123;
import com.androidpath.fragment.fragmentpassvalue122.MainActivity122;
import com.androidpath.fragment.radiofragment124.MainActivity124;
import com.androidpath.fragment.staticfragment121.MainActivity121;
import com.androidpath.listview.adddata81.MainActivity81;
import com.androidpath.listview.baseadapter80.MainActivity80;
import com.androidpath.listview.baseadapterpack100.MainActivity100;
import com.androidpath.listview.gradview102.MainActivity102;
import com.androidpath.listview.listviewdataparse83.MainActivity83;
import com.androidpath.listview.listviewexpandable101.MainActivity101;
import com.androidpath.listview.listviewjoke90.MainActivity90;
import com.androidpath.listview.lvemptyview103.SecondActivity103;
import com.androidpath.listview.simpleadapter82.MainActivity82;
import com.androidpath.storge.contentResolverContacts161.MainActivity161;
import com.androidpath.storge.contentobserver160.MainActivity160;
import com.androidpath.storge.fileStorgetwo132.MainActivity132;
import com.androidpath.storge.filestorge131.MainActivity131;
import com.androidpath.storge.sharedproference130.MainActivity130;
import com.androidpath.storge.sql.simplecusoradapter155.MainActivity155;
import com.androidpath.storge.sql.sql140.MainActivity140;
import com.androidpath.storge.sql.sqlclientone150.MainActivity150;
import com.androidpath.storge.sql.sqlclienttwo152.MainActivity152;
import com.androidpath.storge.sql.sqldemo154.MainActivity154;
import com.androidpath.storge.sql.sqlserverone151.MainActivity151;
import com.androidpath.storge.sql.sqlservertwo153.MainActivity153;
import com.androidpath.widget.view.HandActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layoutdemo2:
                startActivity(new Intent(MainActivity.this, LayoutActivity2.class));
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
            default:

                break;

        }
    }
}
