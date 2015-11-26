package demo;

import java.util.Scanner;

/**
 * 打印日历
 * Created by luts on 2015/11/26.
 */
public class PrintCalendar {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //提示用户输入年份
        System.out.println("Enter full year (e.g., 2001)");
        int year = input.nextInt();

        //提示用户输入月份
        System.out.println("Enter monrh in numer between 1 and 12");
        int month = input.nextInt();

        //打印日历
        printMonth(year, month);
    }

    public static void printMonth(int year, int month){
        //打印日历头
        printMonthTitle(year, month);

        //打印日历主体
        printMonthBody(year, month);
    }

    public static void  printMonthTitle(int year, int month){
        System.out.println("       " + getMonthName(month) + " " + year);

        System.out.println("---------------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    //获取月份英文名
    public static String getMonthName(int month){
        String Monthname = " ";
        switch (month){
            case 1: Monthname = "Jannuary"; break;
            case 2: Monthname = "February"; break;
            case 3: Monthname = "March"; break;
            case 4: Monthname = "April";break;
            case 5: Monthname = "May"; break;
            case 6: Monthname = "June"; break;
            case 7: Monthname = "July"; break;
            case 8: Monthname = "August"; break;
            case 9: Monthname = "September"; break;
            case 10: Monthname = "Octorber"; break;
            case 11: Monthname = "November"; break;
            case 12: Monthname = "December";
        }
        return Monthname;
    }

    //打印月份主体
    public static void printMonthBody(int year, int month){
        //获取月份第一天的星期
        int startDay = getStartDay(year, month);

        //计算月份总共的天数
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        //打印空格
        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");
        for (i = 1; i <= numberOfDaysInMonth; i++){
            System.out.printf("%4d",i);
            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static int getStartDay(int year, int month){
        final int START_DAY_FOR_JAN_1_1800 = 3;
        //计算1800/1/1到输入日期的天数
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        //返回输入日期的星期
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    //获取总天数
    public static int getTotalNumberOfDays(int year, int month){
        int total = 0;

        for (int i = 1800; i < year; i++){
            if (isLeapYear(i))
                total += 366;
            else
                total += 365;
        }

        for (int i = 1; i < month; i++){
            total = total + getNumberOfDaysInMonth(year , i);
        }

        return total;
    }

    public static int getNumberOfDaysInMonth(int year, int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return  31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return  30;
        if (month == 2)
            return isLeapYear(year) ? 29 : 28;
        return  0;
    }

    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
