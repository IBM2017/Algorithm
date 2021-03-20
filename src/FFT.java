import java.util.HashMap;
import java.util.Map;

public class FFT {
    /**
      * 频谱图---时域变频域（已核对）
                 * 2018/7/30;fyf再次核对傅里叶正确
      * @param data 原始数据
      * @param fs 频率
      * @return 纵横坐标x,y  x：频率(坐标*频率/长度)，y：幅值（有效值）sqrt(x^2+y^2)
      */
    public static Map<String, Object> freqSpectrumq(double[] data, Integer fs) {
        /*  频域x：横坐标 (坐标*频率/长度)  幅值y：纵坐标 sqrt(x^2+y^2)  */
        int len = data.length;
        double[] x = new double[len];
        double[] y = new double[len];
        double[] yVal=new double[len];
        FFT.fft(data, y, len, 1);
        for(int i = 0; i < len; i++){
            double dou=Math.sqrt(Math.pow(data[i],2)+Math.pow(y[i],2));
            yVal[i]=dou;
            x[i] = (double)i*fs/len;
            if(i==len-1){
                x[i]=fs;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("x", x);
        map.put("y", yVal);
        return map;
    }

    public static void fft(double x[], double y[], int n, int sign) {
        int i, j, k, l, m =0, n1, n2;
        double c, c1, e, s, s1, t, tr, ti;
        for (j = 1, i = 1; i < 16; i++) {
            m = i;
            j = 2 * j;
            if (j == n)
            break;
        }
        n1 = n - 1;
        for (j = 0, i = 0; i < n1; i++) {
            if (i < j) {
                tr = x[j];
                ti = y[j];
                x[j] = x[i];
                y[j] = y[i];
                x[i] = tr;
                y[i] = ti;
            }
            k = n / 2;
            while (k < (j + 1)) {
                j = j - k;
                k = k / 2;
            }
            j = j + k;
        }
        for (int lk=0;lk<n;lk++){
            System.out.printf(x[lk]+" ");
        }
        System.out.println();
        for (int lk=0;lk<n;lk++){
            System.out.printf(y[lk]+" ");
        }
        System.out.println();
        n1 = 1;
        for (l = 1; l <= m; l++) {
            n1 = 2 * n1;
            n2 = n1 / 2;
            e = 3.14159265359 / n2;
            c = 1;
            s = 0;
            c1 = Math.cos(e);
            s1 = -sign*Math.sin(e);
            for (j = 0; j < n2; j++) {
                for (i = j; i < n; i += n1) {
                    k = i + n2;
                    tr = c*x[k] - s*y[k];
                    ti = c*y[k] + s*x[k];
                    x[k] = x[i] - tr;
                    y[k] = y[i] - ti;
                    x[i] = x[i] + tr;
                    y[i] = y[i] + ti;
                }
                t = c;
                c = c*c1 - s*s1;
                s = t*s1 + s*c1;
            }
        }
        if (sign == -1) {
            for (i = 0; i < n; i++) {
                x[i] /= n;
                y[i] /= n;
            }
        }
    }
}
