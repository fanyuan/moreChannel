package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfo2 {
    public String name = "UserInfo2Name";
    public String[] tripMode={"公交车","地铁","开车"};
    public List<String> colleague = new ArrayList<>();
    public Map<String, String> task = new HashMap<>();

    public UserInfo2(){
        colleague.add("张三");
        colleague.add("李四");
        colleague.add("王五");

        task.put("monday","整理思路及确定整体框架");
        task.put("tuesday","开始进行编写");
        task.put("wednesday","检测及修订");
    }
}
