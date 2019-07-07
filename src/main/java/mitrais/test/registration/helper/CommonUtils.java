package mitrais.test.registration.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class CommonUtils {

    public static String generateUUID(){
        String uid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(uid.substring(0,8));
        sb.append(uid.substring(9,13));
        sb.append(uid.substring(14,18));
        sb.append(uid.substring(19,23));
        sb.append(uid.substring(24));
        return sb.toString().toUpperCase();
    }

}
