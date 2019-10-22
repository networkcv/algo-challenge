package com.lwj.algo._08_string;

/**
 * create by lwj on 2019/10/19
 * 使用String类API，进行一个简单的Json解析练习
 */
public class _00_ParseJson {
    static String src = "{" + "\"coord\": {" +
            "        \"lon\": -0.13," +
            "        \"lat\": 51.51" +
            "    }," +
            "    \"weather\": [" +
            "        {" +
            "            \"id\": 520," +
            "            \"main\": \"Rain\"," +
            "            \"description\": \"light intensityshowerrain\"," +
            "            \"icon\": \"09d\"" +
            "        }" +
            "    ]," +
            "    \"base\": \"stations\"," +
            "    \"main\": {" +
            "        \"temp\": 293.04," +
            "        \"pressure\": 1003," +
            "        \"humidity\": 77," +
            "        \"temp_min\": 289.26," +
            "        \"temp_max\": 296.48" +
            "    }," +
            "    \"visibility\": 10000," +
            "    \"wind\": {" +
            "        \"speed\": 3.1" +
            "    }," +
            "    \"clouds\": {" +
            "        \"all\": 74" +
            "    }," +
            "    \"dt\": 1569148567," +
            "    \"sys\": {" +
            "        \"type\": 1," +
            "        \"id\": 1414," +
            "        \"message\": 0.0198," +
            "        \"country\": \"GB\"," +
            "        \"sunrise\": 1569131156," +
            "        \"sunset\": 1569175255" +
            "    }," +
            "    \"timezone\": 3600," +
            "    \"id\": 2643743," +
            "    \"name\": \"London\"," +
            "    \"cod\": 200" +
            "}";

    public static void main(String[] args) {
        //定义要查询的key数组
        String[] keys = {"coord", "weather", "base", "main", "visibility", "wind", "clouds", "dt", "sys", "timezone", "id", "name", "cod"};
        doParseJson(keys);
    }

    private static void doParseJson(String[] keys) {
        //替换原始字符串中的空格
        src = src.replaceAll("\\s*", "");
        //将最后一个'}'替换为',' 方便后边处理
        src = src.substring(0, src.length() - 1) + ",";
        //打印解析结果
        for (String k : keys) {
            String[] strings = get(k);
            for (int i = 1; i < strings.length; i++) {
                System.out.println(k + ":" + strings[i]);
            }
            System.out.println("---------");
        }
    }

    public static String[] get(String key) {
        String p = "";
        int i = 0;
        //匹配Json串中一个key的对应多个value的情况
        while (true) {
            //找到key每次出现的位置
            i = src.indexOf(key, i + 1);
            //i==-1时，则没有找到key，退出循环
            if (i == -1)
                break;
            //找到key之后的第一个':'的位置,作为后面的字符串切割的开始位置的索引
            int m = src.indexOf(":", i);
            //匹配到key对应值的结束位置，作为后面的字符串切割的结束位置的索引
            int post = matchedPost(m);
            //切割字符串，去空格，拼接结果
            p = p + "--" + src.substring(m + 1, post).trim();
        }
        //将拼接结果转换为数组返回
        return p.split("--");
    }


    private static int matchedPost(int start) {
        int res;
        //判断':'后紧跟的是哪个括号
        int i = src.indexOf("{", start);
        int j = src.indexOf("[", start);
        int k = src.indexOf(",", start);
        int min = getMin(i, j, k);
        //根据不同的括号，找到对应括号结束位置的索引
        if (min == i) {
            res = src.indexOf("},", min) + 1;
        } else if (min == j) {
            res = src.indexOf("],", min) + 1;
        } else {
            res = src.indexOf(",", min);
        }
        return res;
    }

    private static int getMin(int i, int j, int k) {
        //获取匹配到3个索引中最靠近':'的那个，也就是最小的那个
        i = i == -1 ? src.length() : i;
        j = j == -1 ? src.length() : j;
        k = k == -1 ? src.length() : k;
        int min;
        min = i < j ? i : j;
        min = min < k ? min : k;
        return min;
    }
}
