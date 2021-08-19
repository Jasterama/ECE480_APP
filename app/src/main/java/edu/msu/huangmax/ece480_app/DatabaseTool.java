package edu.msu.huangmax.ece480_app;

import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import static android.content.Context.MODE_PRIVATE;

public class DatabaseTool {

    private String time;
    private SharedPreferences settings;
    private String userId;
    private String birthday;
    private final String link = "https://webdev.cse.msu.edu/~rumptzja/ece480/ece480app/";

    public DatabaseTool(String id, String birthday) {
        /* FOR TESTING ONLY */
        userId = id;
        this.birthday = "\"" + birthday + "\"";
    }
    public DatabaseTool(SharedPreferences prefs) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        time = formatter.format(new Date());

        settings = prefs;
        userId = settings.getString("ID", "");
        birthday = settings.getString("birthday", "");
        birthday = "\"" + birthday + "\"";
    }

    public boolean isValidUser() {
        final CountDownLatch latch = new CountDownLatch(1);
        final int[] value = new int[1];
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        String writeLink = link;
                        writeLink += "verify_user.php?" + "user_id="
                                + userId + "&birthday=" + birthday;
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        InputStream stream = con.getInputStream();
                        value[0] = stream.read();
                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value[0] != -1;
    }

    public void writeWakeUpQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        String writeLink = link;
                        writeLink += "wakeup_insert.php?" + "submit_time=" + time + "&user_id="
                                + userId + "&time=" + responses[0] + "&difficulty_sleeping=" + responses[1]
                                + "&waking_up_during=" + responses[2] + "&woke_up_early=" + responses[3];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeNapQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        for (int i = 0; i < responses.length; i++) {
                            if (responses[i].equals("")) {
                                responses[i] = "N/A";
                            }
                        }
                        String writeLink = link;
                        writeLink += "nap_insert.php?" + "submit_time=" + time + "&user_id="
                                + userId + "&nap_taken=" + responses[0] + "&first_nap_start=" + responses[1]
                                + "&first_nap_end=" + responses[2] + "&second_nap_start=" + responses[3]
                                + "&second_nap_end=" + responses[4] + "&third_nap_start=" + responses[5]
                                + "&third_nap_end=" + responses[6];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeBedtimeQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        for (int i = 0; i < responses.length; i++) {
                            if (responses[i].equals("")) {
                                responses[i] = "N/A";
                            }
                        }
                        String writeLink = link;
                        writeLink += "bedtime_insert.php?" + "submit_time=" + time + "&user_id="
                                + userId + "&bedtime=" + responses[0] + "&fatigue_level=" + responses[1]
                                + "&sleepiness_level=" + responses[2];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeTimerUse(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        for (int i = 0; i < responses.length; i++) {
                            if (responses[i].equals("")) {
                                responses[i] = "N/A";
                            }
                        }
                        String writeLink = link;
                        writeLink += "timer_insert.php?" + "user_id="
                                + userId + "&start_time=" + responses[0] + "&end_time=" + responses[1];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
