package com.qaautomation.app;
/*
 * Common parameters for scripts
 * You can change them to adapt your environment
 *
 * All script initialization parameters like Location of Firefox, Base URL, User Name, Password etc
 *  are stored in separate file Util.java for easy maintenance of scripts
 *
 */

public class Util {

    /* You can change the Path of FireFox driver based on your environment here */
    public static final String DRIVER_EXE = "D://Selenium drivers/Firefox driver/geckodriver.exe";

    // Setting Base URL
    public static final String BASE_URL = "http://prestashop-automation.qatestlab.com.ua/";

    // Time to wait when searching for a GUI element
    public static final int WAIT_TIME = 30;


    // Valid account for login
    public static final String LOGIN = "webinar.test@gmail.com";
    public static final String PASSWD = "Xcg7299bnSmMuRLp9ITw";


}

