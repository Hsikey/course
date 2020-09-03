package bean;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 将Date转换成String
     * @param date
     * @return
     */
    public String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }
    /**
     * 将Timestamp转换成String
     * 用于数据库中字段类型为datetime
     * @param timestamp
     * @return
     */
    public String time2String(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        String dateStr = date2String(date);
        return dateStr;
    }


}
