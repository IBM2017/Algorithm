

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class main {
    public static void main(String[] as) throws Exception{
        //请注意月份是从0-11,天数是1， 2013-1-1 至 2013-12-31
        Calendar start = Calendar.getInstance();
        start.set(2019, 0, 1); //2013-1-1 开始
        Calendar end = Calendar.getInstance();
        end.set(2020, 8, 10); // 2014--0-0结束，2014-1-1不算

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str  = "killsome analyhcdata;analyhcdata -T";
        File file = new File("G:\\迅雷下载\\test.sh");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWriter);


        while(start.compareTo(end) <= 0) {
//            int w = start.get(Calendar.DAY_OF_WEEK);
            //打印每天
            if (!format.format(start.getTime()).equals("20191025")
                    &&!format.format(start.getTime()).equals("20191030")
                    &&!format.format(start.getTime()).equals("20200624"))
                bw.write(str+format.format(start.getTime())+"\n");
            //循环，每次天数加1
            start.set(Calendar.DATE, start.get(Calendar.DATE) + 1);
        }
        bw.close();
    }

}
