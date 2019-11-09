package com.dream.demo.constant;

import java.util.concurrent.TimeUnit;

public class SysCode {
    public static class Question{
        public static String RIGHT = "1";
        public static String NO_ANSWER = "2";
        public static String WRONG = "0";
        public static String LIKE = "1";
        public static String UNLIKE = "0";
    }
    public static class Exam{
        //状态 1 未开始 2 进行中 3 已交卷
        public static String NOT_START = "1";
        public static String DOING = "2";
        public static String DONE = "3";
    }


    public  class ExpireEnum{
        public long time = 30;
        public TimeUnit timeUnit = TimeUnit.MINUTES;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
        }
    }
}
