package com.CK.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";

    private static final String ROOT = DEV + VERSION;

    public static final String PATIENT = ROOT + "/patient";
    public static final String DOCTOR = ROOT + "/doctor";
    public static final String APPOINTMENT = ROOT + "/appointment";

    public static final String ADD = "/add";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";

    public static final String MAKE_APPOINTMENT = "/make-appointment";
    public static final String CANCEL_APPOINTMENT = "/cancel-appointment";
}
