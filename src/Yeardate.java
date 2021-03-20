import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Yeardate {
    public static void main(String[] as) throws Exception{
        String[] filesname = {"wanli_p","wanli_kWh","wbkt_p","wbkt_kWh"};
        File file = new File("F:\\test.txt");
        if(!file.exists()){
            file.createNewFile();
        }


        Calendar end = Calendar.getInstance();
        end.set(2020, 8, 17);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fileWriter);


        for (int i = 0;i<filesname.length;i++){
            File fileDate = new File("F:\\"+filesname[i]+".txt");
            BufferedReader reader = null;
            Calendar start = Calendar.getInstance();
            start.set(2019, 0, 1); //2013-1-1 开始
            try {
                reader = new BufferedReader(new FileReader(fileDate));
                String lineString = reader.readLine();
                while (start.compareTo(end) <= 0){

                    String DateString = format.format(start.getTime());
                    if (DateString.equals(lineString)){
                        if ((lineString = reader.readLine())!=null){
                            lineString = lineString.trim();
                        }
                    }else {
                        bw.write(format.format(start.getTime())+"_"+filesname[i]+".rb"+"\n");
                    }

                    start.set(Calendar.DATE, start.get(Calendar.DATE) + 1);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                reader.close();
            }
        }
        bw.close();

    }
}
