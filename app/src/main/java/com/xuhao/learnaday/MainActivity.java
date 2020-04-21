package com.xuhao.learnaday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Fragment
    private BookFragment bookFragment;
    private ExamFragment examFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

//    //Tab Layout
//    private View tabBookLayout;
//    private View tabExamLayout;
//    private View tabMessageLayout;
//    private View tabMineLayout;

    //Tab Menu Control
    private TextView tab_menu_book;
    private TextView tab_menu_exam;
    private TextView tab_menu_message;
    private TextView tab_menu_mine;

    //Fragment Manager
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化布局元素
        initViews();
        fragmentManager = getSupportFragmentManager();

        //设置初次启动时默认显示界面
        setTabSelection(0);

    }

    //获取控件实例，注册监听器
    private void initViews() {

        //获取每个标签按钮
        tab_menu_book = findViewById(R.id.tab_menu_book);
        tab_menu_exam = findViewById(R.id.tab_menu_exam);
        tab_menu_message = findViewById(R.id.tab_menu_message);
        tab_menu_mine = findViewById(R.id.tab_menu_mine);

        //注册监听器
        tab_menu_book.setOnClickListener(this);
        tab_menu_exam.setOnClickListener(this);
        tab_menu_message.setOnClickListener(this);
        tab_menu_mine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_menu_book:
                setTabSelection(0);
                break;
            case R.id.tab_menu_exam:
                setTabSelection(1);
                break;
            case R.id.tab_menu_message:
                setTabSelection(2);
                break;
            case R.id.tab_menu_mine:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    //根据传入的index设置选中的tab页
    private void setTabSelection(int index) {
        //首先清除掉上次的选中状态
        clearSelection();

        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏掉所有Fragment，防止多个同时出现在界面上
        hideFragments(transaction);

        switch (index) {
            case 0:
                //设置控件为选中
                tab_menu_book.setSelected(true);
                if (bookFragment == null) {
                    //如果为空，创建一个并添加到界面上
                    bookFragment = new BookFragment();
                    transaction.add(R.id.content, bookFragment);
                } else {
                    //如果不为空，直接将它显示到界面上
                    transaction.show(bookFragment);
                }
                break;
            case 1:
                tab_menu_exam.setSelected(true);
                if (examFragment == null) {
                    //如果为空，创建一个兵添加到界面上
                    examFragment = new ExamFragment();
                    transaction.add(R.id.content, examFragment);
                } else {
                    //如果不为空，直接将塔显示到界面上
                    transaction.show(examFragment);
                }
                break;
            case 2:
                tab_menu_message.setSelected(true);
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }
                break;
            case 3:
                tab_menu_mine.setSelected(true);
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    //清除所有选中状态
    private void clearSelection() {
        tab_menu_book.setSelected(false);
        tab_menu_exam.setSelected(false);
        tab_menu_message.setSelected(false);
        tab_menu_mine.setSelected(false);
    }

    //隐藏所有的Fragment
    private void hideFragments(FragmentTransaction transaction) {
        if ( bookFragment != null ) {
            transaction.hide(bookFragment);
        }
        if ( examFragment != null) {
            transaction.hide(examFragment);
        }
        if ( messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

}


