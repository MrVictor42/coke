package br.com.victor.littleCoke.web.util;

import com.liferay.portal.kernel.util.LocaleUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LittleCokeUtil {

    public static String formatDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy", LocaleUtil.BRAZIL);
        SimpleDateFormat formatDay = new SimpleDateFormat("EEEE", LocaleUtil.BRAZIL);

        String formattedDate = formatDate.format(date);
        String dayOfWeek = formatDay.format(date);

        return formattedDate + " " + dayOfWeek;
    }

    public static String averageCokeByPersonFormatted(int quantityMembers) {
        double cokeTotal = 2000; // em ML
        double quantityPerPerson = cokeTotal / quantityMembers;

        return String.format("%.2f ml de Coca-Cola.", quantityPerPerson);
    }
}