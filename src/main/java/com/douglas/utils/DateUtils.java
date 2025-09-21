package com.douglas.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.douglas.manager.user.DefaultUserManager;
import com.douglas.repository.InvoiceCycleRepository;

@Component
public class DateUtils {

    public static final DateTimeFormatter ddMMyyyy = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate startPeriodDate = null;
    LocalDate endPeriodDate = null;

    @Autowired
    private InvoiceCycleRepository invoiceCycleRepository;
    @Autowired
    private DefaultUserManager defaultUserManager;

    public static LocalDate currentDate() {
        LocalDate data = LocalDate.now();

        return data;
    }

    public static String dateConverterDMY(int day, int month, int year) {

        String date = LocalDate.of(year, month, day).format(ddMMyyyy);

        return date;
    }

    public List<LocalDate> startEndDate() {
        Integer openingDay = invoiceCycleRepository.findOneByUserId(defaultUserManager.getUserByUsername())
                .getOpeningDay();

        LocalDate currentDate = DateUtils.currentDate();

        if (currentDate.getDayOfMonth() < openingDay) {
            startPeriodDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth().minus(1), openingDay)
                    .minusDays(1);
        } else {
            startPeriodDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), openingDay).minusDays(1);
        }

        endPeriodDate = startPeriodDate.plusMonths(1);

        List<LocalDate> list = new ArrayList<>();

        list.add(startPeriodDate);
        list.add(endPeriodDate);

        return list;
    }

}
