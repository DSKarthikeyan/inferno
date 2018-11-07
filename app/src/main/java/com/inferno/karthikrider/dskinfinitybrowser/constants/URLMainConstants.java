package com.inferno.karthikrider.dskinfinitybrowser.constants;

/**
 * Created by karthikrider on 06-Nov-18.
 */

public class URLMainConstants {
    public final static String constantURLHTTPS = "https://";
    public final static String constantURLSearch = "search";
    public final static String constantURLSearchQuery = "?q=";
    public final static String constantDot = ".";
    public final static String constantFrontSlash = "/";

    public final static String constantURLWWW = "www";
    public final static String constantURLDotCom = "com";

    public final static String constantURLWebsiteNameGoogle = "google";
    public final static String constantURLWebsiteNameDuckDuckGO = "duckduckgo";
    public final static String constantURLWebsiteNameYahoo = "yahoo";


    public final static String getConstantURLHTTPSWWW = constantURLHTTPS + constantURLWWW + constantDot ;
    public final static String getConstantURLHTTPSDotCom = constantDot + constantURLDotCom ;
    public final static String getConstantURLSearchParam = constantURLSearch + constantURLSearchQuery ;

    public final static String homePageDuckDuckURL = URLMainConstants.getConstantURLHTTPSWWW
            + URLMainConstants.constantURLWebsiteNameDuckDuckGO + URLMainConstants.getConstantURLHTTPSDotCom;
    public final static String homePageGoogleURL = URLMainConstants.getConstantURLHTTPSWWW +
            URLMainConstants.constantURLWebsiteNameGoogle + URLMainConstants.getConstantURLHTTPSDotCom;
}
