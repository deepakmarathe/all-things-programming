/* 
 * Copyright (c) 2014 Vertica Systems, an HP Company
 *
 * Description: Support code for UDx subsystem
 *
 * Create Date: Thu Oct 16 15:18:23 America/New_York 2014
 */
/* Build-time identification for VerticaSDKJava */
package com.vertica.sdk;
public class BuildInfo {
    public static final String VERTICA_BUILD_ID_Brand_Name       = "Vertica Analytic Database";
    public static final String VERTICA_BUILD_ID_Brand_Version    = "v7.1.1-0";
    public static final String VERTICA_BUILD_ID_Codename         = "Dragline";
    public static final String VERTICA_BUILD_ID_Date             = "Thu Oct 16 15:18:23 America/New_York 2014";
    public static final String VERTICA_BUILD_ID_Machine          = "build2.verticacorp.com";
    public static final String VERTICA_BUILD_ID_Branch           = "releases/VER_7_1_RELEASE_BUILD_1_0_20141016";
    public static final String VERTICA_BUILD_ID_Revision         = "148158";
    public static final String VERTICA_BUILD_ID_Checksum         = "2d3d7663da4eb401e5b5f44466edf6a3";

    public static VerticaBuildInfo get_vertica_build_info() {
        VerticaBuildInfo vbi = new VerticaBuildInfo();
        vbi.brand_name      = BuildInfo.VERTICA_BUILD_ID_Brand_Name;
        vbi.brand_version   = BuildInfo.VERTICA_BUILD_ID_Brand_Version;
        vbi.codename        = BuildInfo.VERTICA_BUILD_ID_Codename;
        vbi.build_date      = BuildInfo.VERTICA_BUILD_ID_Date;
        vbi.build_machine   = BuildInfo.VERTICA_BUILD_ID_Machine;
        vbi.branch          = BuildInfo.VERTICA_BUILD_ID_Branch;
        vbi.revision        = BuildInfo.VERTICA_BUILD_ID_Revision;
        vbi.checksum        = BuildInfo.VERTICA_BUILD_ID_Checksum;
        return vbi;
    }
}
/* end of this file */
