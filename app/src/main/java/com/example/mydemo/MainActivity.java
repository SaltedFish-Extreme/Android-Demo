package com.example.mydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private RadioGroup sex;
    private CheckBox sour, sweet, bitter, hot, salt, light;
    private SeekBar seekBar;
    private Button find;
    private Button click;
    private ImageView pic;
    private List<Food> list_food;
    private List<Food> list_get;
    private Person person;
    private boolean issour, issweet, isbitter, ishot, issalt, islight;
    private int price = 30;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //初始化数据
        initData();
        //监听器
        setListener();
        NextPic();
    }

    private void setListener() {
        RadioGroupListener radioGroupListener = new RadioGroupListener();
        sex.setOnCheckedChangeListener(radioGroupListener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        sour.setOnCheckedChangeListener(checkBoxListener);
        sweet.setOnCheckedChangeListener(checkBoxListener);
        bitter.setOnCheckedChangeListener(checkBoxListener);
        hot.setOnCheckedChangeListener(checkBoxListener);
        salt.setOnCheckedChangeListener(checkBoxListener);
        light.setOnCheckedChangeListener(checkBoxListener);
        SeekBarListener seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        ButtonListener buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        click.setOnClickListener(buttonListener);
    }

    private void initData() {
        list_food = new ArrayList<Food>();
        list_get = new ArrayList<Food>();
        person = new Person();
        list_food.add(new Food("炒饭", true, false, false, true, false, true, 20, R.drawable.chaofan));
        list_food.add(new Food("大虾", false, true, false, false, true, true, 30, R.drawable.daxia));
        list_food.add(new Food("古老肉", false, false, true, true, true, true, 35, R.drawable.gulaorou));
        list_food.add(new Food("咕噜肉", true, false, true, true, false, true, 35, R.drawable.gulurou));
        list_food.add(new Food("红烧", true, true, false, false, true, true, 40, R.drawable.hongshao));
        list_food.add(new Food("红烧肉", true, true, false, true, false, true, 40, R.drawable.hongshaorou));
        list_food.add(new Food("卤面", true, true, false, true, false, false, 20, R.drawable.lumian));
        list_food.add(new Food("冒菜", false, false, false, true, true, true, 50, R.drawable.maocai));
        list_food.add(new Food("排骨", true, false, false, false, true, true, 60, R.drawable.paigu));
        list_food.add(new Food("茄子", true, false, true, true, true, true, 30, R.drawable.qiezi));
        list_food.add(new Food("芹菜", true, true, false, false, true, true, 20, R.drawable.qincai));
        list_food.add(new Food("水煮鱼", true, true, false, true, false, true, 80, R.drawable.shuizhuyu));
        list_food.add(new Food("土豆丝", true, true, false, false, false, true, 15, R.drawable.tudousi));
        list_food.add(new Food("虾仁", true, false, false, false, true, true, 30, R.drawable.xiaren));
        list_food.add(new Food("鱼香肉丝", true, false, false, false, true, true, 30, R.drawable.yuxiangrousi));
    }

    private void initView() {
        name = findViewById(R.id.et_name);
        sex = findViewById(R.id.rg_sex);
        sour = findViewById(R.id.cb_sour);
        sweet = findViewById(R.id.cb_sweet);
        bitter = findViewById(R.id.cb_bitter);
        hot = findViewById(R.id.cb_hot);
        salt = findViewById(R.id.cb_salt);
        light = findViewById(R.id.cb_light);
        pic = findViewById(R.id.iv_pic);
        seekBar = findViewById(R.id.sb_price);
        seekBar.setProgress(30);
        find = findViewById(R.id.btn_find);
        click = findViewById(R.id.tb_click);
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //当用户选择当前RadioGroup组的Button时被触发
            switch (checkedId) {
                case R.id.rb_man:
                    person.setSex("男");
                    break;
                case R.id.rb_woman:
                    person.setSex("女");
                    break;
            }
            System.out.println("性别：" + person.getSex());
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //当控件状态改变时被触发
            CheckBox cbBox = (CheckBox) buttonView;
            switch (cbBox.getId()) {
                case R.id.cb_sour:
                    issour = isChecked;
                    break;
                case R.id.cb_sweet:
                    issweet = isChecked;
                    break;
                case R.id.cb_bitter:
                    isbitter = isChecked;
                    break;
                case R.id.cb_hot:
                    ishot = isChecked;
                    break;
                case R.id.cb_salt:
                    issalt = isChecked;
                    break;
                case R.id.cb_light:
                    islight = isChecked;
                    break;
            }
            System.out.println("当前喜好：" + " 酸：" + issour + " 甜：" + issweet + " 苦：" + isbitter + " 辣：" + ishot + " 咸：" + issalt + " 淡：" + islight);
        }
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            price = seekBar.getProgress();
            Toast.makeText(MainActivity.this, "价格" + price, Toast.LENGTH_SHORT).show();
        }
    }

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_find:
                    //当用户点击寻找时，需要筛查信息，并把结果显示到imageView上
                    list_get.clear();
                    checkData();
                    break;
                case R.id.tb_click:
                    //当用户点击显示用户及所选信息
                    if (name.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (person.getSex() == null) {
                        Toast.makeText(MainActivity.this, "请选择性别", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    try {
                        Toast.makeText(MainActivity.this,
                                "用户姓名：" + name.getText().toString() + " " +
                                        "用户性别：" + person.getSex() + " " +
                                        "所选食物：" + list_get.get(count).getName(), Toast.LENGTH_SHORT)
                                .show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "请选择菜品", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    private void checkData() {
        //找出菜品

        for (int i = 0; i < list_food.size(); i++) {
            Food food = list_food.get(i);
            if ((food.getPrice() <= price) &&
                    (food.isSour() == issour) && (food.isSweet() == issweet) && (food.isBitter() == isbitter) && (food.isHot() == ishot) && (food.isSalt() == issalt) && (food.isLight() == islight)) {
                list_get.add(food);
            }
        }
        if (list_get.size() == 0) {
            Toast.makeText(MainActivity.this, "没有了...", Toast.LENGTH_SHORT).show();
        } else {
            count = 0;
            showPic();
        }
        System.out.println("*******" + list_get.size());
    }

    private void showPic() {
        try {
            int a = list_get.get(count).getPic();
            pic.setImageDrawable(ResourcesCompat.getDrawable(getResources(), a, null));
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, "没有选择", Toast.LENGTH_SHORT).show();
        }
    }

    private void NextPic() {
        pic.setOnClickListener(v -> {
            if (list_get.size() == 1) {
                Toast.makeText(MainActivity.this, "没有了...", Toast.LENGTH_SHORT).show();
            }
            count++;
            if (count > list_get.size() - 1) {
                count = 0;
                showPic();
            } else {
                showPic();
            }
        });
    }
}