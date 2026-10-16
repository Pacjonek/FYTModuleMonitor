package com.aoe.fytcanbusmonitor

object CanbusCommandCodes {

    const val C_CMD_VIDEO = 1
    const val C_CMD_360_TOUCH_LY = 2
    const val C_CMD_SPEED_ALARM = 3
    const val C_CMD_TIME_SETTINGS = 7
    const val C_CMD_SAFE_DRIVER = 8
    const val C_CMD_NONSLIP_SET = 9
    const val C_CMD_STARTPROMPT = 10
    const val C_CMD_AIR_AUTOCLEAN = 11
    const val C_CMD_INCAR_AUTOVENTILATION = 12
    const val C_CMD_INCAR_AUTOLOCK = 13
    const val C_CMD_RAMP_START = 14

    const val C_CMD_START_REQ_ADD = 100
    const val C_CMD_SET_ADD = 101

    const val C_MISC_BEGIN = 1000
    const val C_CANBUS_ID = 1000

    const val C_DRIVER_ON_RIGHT = 1001
    const val C_SHOW_AIR_WINDOW = 1002
    const val C_CHANGE_PANORAMA = 1003
    const val C_SHOW_DOOR_WINDOW = 1004
    const val C_CAMERA_MODE = 1005
    const val C_CANBUS_FRAME_TO_MCU08 = 1008
    const val C_AIR_WINDOW_ENABLE = 1009
    const val C_DOOR_WINDOW_ENABLE = 1010
    const val C_ONSTAR_SYNC_ON = 1011
    const val C_CANBUS_FRAME_TO_MTU = 1012
    const val C_CANBUS_FRAME_TO_MCU_0X10 = 1013
    const val C_CANBUS_KEY_FUNC = 1014
    const val C_CANBUS_BACKCAR_FUNC = 1015
    const val C_RIGHT_CAMERA_STATE = 1016
    const val C_CANBUS_KEY_FUNC_WC = 1017
    const val C_CANBUS_RC_FUNC_WC = 1018

    const val C_CMD_360_TOUCH = 1029
    const val C_CANBUS_FRAME_TO_MCU30 = 1030
    const val C_CMD_PARK = 1031
    const val C_CMD_CANBUS_DVR = 1032

    /**
     *  val i0 = (iArr[0] >> 0) & 1)
     *  val i1 = (iArr[0] >> 1) & 1)
     *  val i2 = (iArr[0] >> 2) & 1)
     *  val i3 = (iArr[0] >> 3) & 1)
     *  val i4 = (iArr[0] >> 4) & 1)
     *  val i5 = (iArr[0] >> 5) & 1)
     *  t0.d.H3(151, 0, i0);
     *  t0.d.H3(151, 1, i1);
     *  t0.d.H3(151, 2, i2);
     *  t0.d.H3(151, 3, i3);
     *  t0.d.H3(151, 4, i4);
     *  t0.d.H3(151, 5, i5);
     * kt.y0(1049, new int[]{6, ((((iArr[0] >> 0) & 1) << 2) & 4) |
     * ((((iArr[0] >> 5) & 1) << 5) & 32) | ((((iArr[0] >> 2) & 1) << 6) & 64) |
     * ((((iArr[0] >> 3) & 1) << 7) & 128) | (16 & (((iArr[0] >> 4) & 1) << 4)) |
     * ((((iArr[0] >> 1) & 1) << 3) & 8)}, null, null);
     **/
    const val C_CANBUS_CAR_DOOR = 1035
    const val C_CMD_360_TURN_LIGHT_SWITCH = 1036
    const val C_CMD_360_RADAR_ACTIVATION = 1037

    /* OEM / Brand Specific */
    const val C_CANBUS_AUDI_CAR_TYPE = 1033
    const val C_CANBUS_BENZ_BUTTON = 1034
    const val C_CMD_JAGUAR_LZ = 1038
    const val C_CMD_TCROSS_ZH_BUTTON = 1039

    const val C_CMD_6606 = 1040

    // const val C_... = 1041
    const val C_DUDU_OBD = 1042
    const val C_KEYCODE_STUDY = 1043 // [ints: [0/1]]


}

object CanbusUpdateCodes {

    // DataCanbus.canbusId = value & 65535;
    // DataCanbus.carId = (value >> 16) & 65535;
    const val U_CANBUS_ID = 1000
    const val U_CANBUS_RAW_FRAME_TO_UI = 1019

    const val DOORS_BEGIN = 0
    const val U_DOOR_ENGINE = 0
    const val U_DOOR_FL = 1
    const val U_DOOR_FR = 2
    const val U_DOOR_RL = 3
    const val U_DOOR_RR = 4
    const val U_DOOR_BACK = 5
    const val DOORS_END = 6


    /**
    ## CARINFO codes
     * Stats data from the onboard computer screen
     *
     * `Range` : Vary depending on the car
     *
     * `WC` : Codename for HiWorld canbox family
     *
     * 'FIAT_ALL' : Codename for all Fiats (whatever that means) from Hiworld canbus box
     *
     * Renames: "WC" -> "HIWORLD" and "Fieyate" -> "Fiat"
     **/
    const val WC_FIAT_ALL_CARINFO_BEGIN = 98
    const val U_WC_FIAT_ALL_CARINFO_AVG_FUEL_CON = 99
    const val U_WC_FIAT_ALL_CARINFO_FUEL_RANGE = 100
    const val U_WC_FIAT_ALL_CARINFO_TOTAL_MILEAGE = 101
    const val U_WC_FIAT_ALL_CARINFO_TRIPA_AVG_FUEL_CON = 102
    const val U_WC_FIAT_ALL_CARINFO_TRIPA_AVG_SPEED = 103
    const val U_WC_FIAT_ALL_CARINFO_TRIPA_TRAVEL_MILEAGE = 104
    const val U_WC_FIAT_ALL_CARINFO_TRIPA_TRAVEL_TIME = 105
    const val U_WC_FIAT_ALL_CARINFO_TRIPB_AVG_FUEL_CON = 106
    const val U_WC_FIAT_ALL_CARINFO_TRIPB_AVG_SPEED = 107
    const val U_WC_FIAT_ALL_CARINFO_TRIPB_TRAVEL_MILEAGE = 108
    const val U_WC_FIAT_ALL_CARINFO_TRIPB_TRAVEL_TIME = 109
    const val WC_FIAT_ALL_CARINFO_END = 110
    /* # End Section */

    /**
     * # Extended range codes
     */
    const val CAR_EXTENDED_START = 500
    const val U_CAR_FRAME_NUM = 501

    /* Exterior Lighting & Indicators */
    const val U_CAR_LIGHT = 517
    const val U_CAR_LIGHT_WIDTH = 502
    const val U_CAR_LIGHT_NEAR = 503
    const val U_CAR_LIGHT_FAR = 504
    const val U_CAR_LIGHT_LEFT = 505
    const val U_CAR_LIGHT_RIGHT = 506
    const val U_CAR_LIGHT_FRONT = 507
    const val U_CAR_LIGHT_REAR = 508
    const val U_CAR_LIGHT_ENABLED = 541
    const val U_CAR_LIGHT_WIDTH_ENABLED = 526
    const val U_CAR_LIGHT_NEAR_ENABLED = 527
    const val U_CAR_LIGHT_FAR_ENABLED = 528
    const val U_CAR_LIGHT_LEFT_ENABLED = 529
    const val U_CAR_LIGHT_RIGHT_ENABLED = 530
    const val U_CAR_LIGHT_FRONT_ENABLED = 531
    const val U_CAR_LIGHT_REAR_ENABLED = 532

    const val U_CAR_WIPER_LEVEL = 509
    const val U_CAR_CUR_SPEED = 510
    const val U_CAR_AVG_SPEED = 511
    const val U_CAR_TOTAL_MILEAGE = 512
    const val U_CAR_REMAIN_MILEAGE = 513
    const val U_CAR_SEAT_BELT_LEFT = 514
    const val U_CAR_SEAT_BELT_RIGHT = 515
    const val U_CAR_ACCON = 516
    const val U_CAR_REAR_BACK = 518
    const val U_CAR_HANDBRAKE = 519
    const val U_CAR_CUR_FUEL = 520
    const val U_CAR_AVG_FUEL = 521
    const val U_CAR_TEMP_WATER = 522
    const val U_CAR_TEMP_MOTOR_OIL = 523
    const val U_CAR_ENGINE_SPEED = 524
    const val U_CAR_VOLTAGE = 525
    const val U_CAR_WIPER_LEVEL_ENABLED = 533
    const val U_CAR_CUR_SPEED_ENABLED = 534
    const val U_CAR_AVG_SPEED_ENABLED = 535
    const val U_CAR_TOTAL_MILEAGE_ENABLED = 536
    const val U_CAR_REMAIN_MILEAGE_ENABLED = 537
    const val U_CAR_SEAT_BELT_LEFT_ENABLED = 538
    const val U_CAR_SEAT_BELT_RIGHT_ENABLED = 539
    const val U_CAR_ACCON_ENABLED = 540
    const val U_CAR_REAR_BACK_ENABLED = 542
    const val U_CAR_HANDBRAKE_ENABLED = 543
    const val U_CAR_CUR_FUEL_ENABLED = 544
    const val U_CAR_AVG_FUEL_ENABLED = 545
    const val U_CAR_TEMP_WATER_ENABLED = 546
    const val U_CAR_TEMP_MOTOR_OIL_ENABLED = 547
    const val U_CAR_ENGINE_SPEED_ENABLED = 548
    const val U_CAR_VOLTAGE_ENABLED = 549
    const val U_CAR_DOOR_ENABLED = 550
    const val U_CAR_STEER_ANGLE_ENABLED = 551
    const val U_CAR_TEMP_OUT_ENABLED = 552
    const val U_DOOR_ENGINE_ADD = 553
    const val U_DOOR_FL_ADD = 554
    const val U_DOOR_FR_ADD = 555
    const val U_DOOR_RL_ADD = 556
    const val U_DOOR_RR_ADD = 557
    const val U_DOOR_BACK_ADD = 558
    const val U_SPEED_UNIT = 559
    const val U_CAR_EXTENDED_END = 560

    const val MISC_BEGIN = 1000
    const val U_AIR_WINDOW_ENABLED = 1001
    const val U_DOOR_WINDOW_ENABLED = 1002
    const val U_DRIVER_RIGHT_SIDE = 1003
    const val U_DOOR_SUPPORT = 1004
    const val U_CANBUS_VER = 1005
    const val U_TIP_ID = 1006
    const val U_EXIST_AIR = 1007
    const val U_SHOW_AIR_WINDOW = 1008
    const val U_MCU_CANBUS_SUPPORT_CNT = 1010
    const val U_SHOW_DOOR_WINDOW = 1011
    const val U_OUTSIDE_TEMP_SUPPORT = 1012
    const val U_AIR_CONTROL_PAGE = 1014
    const val U_AIR_CONTROL_SUPPORT = 1018
    const val U_CANBUS_AIR_VER = 1023
    const val U_CANBUS_FRAME_TO_MTU = 1024
    const val U_CANBUS_SLAVECAR_TOUCH_CALI = 1025
    const val U_CANBUS_SLAVECAR_BACKLIGHT = 1026
    const val U_CANBUS_PM25_CAR_IN = 1027
    const val U_CANBUS_PM25_CAR_OUT = 1028
    const val U_CANBUS_PM25_ENABLED = 1029
    const val U_CUR_SPEED = 1031
    const val U_ENGINE_SPEED = 1032
    const val U_GNSS_ANGLE = 1033
    const val U_CAR_ROTATING_SUPPORT = 1035
    const val U_UISERVER_TYPE = 1037
    const val U_NEW_AIREIXT_SP = 1041
    const val U_CANBUS_CAR_DOOR = 1043
    const val U_CANBUS_CAR_AIR = 1044
    const val U_6606_CARINFO = 1049
    const val U_CAR_TIRE_SUPPORT = 1050

    /**
     * # Cameras, Parking & Radars
     */
    const val U_PANORAMA_SUPPORT = 1009
    const val U_CAMERA_MODE = 1013
    const val U_RIGHTCAMERA_SUPPORT = 1017
    const val U_RIGHTCAMERA_STATE = 1020
    const val U_CAR_BACKCAR_SUPPORT = 1021
    const val U_CAR_BACKCAR_SHOW_STATE = 1030
    const val U_CAR_DVR_SUPPORT = 1034
    const val U_PARK_MODE = 1039
    const val U_REAR_MOVE_TYPE = 1040
    const val U_SIDERADAR_SUPPORT = 1046

    /**
     * # Audio, Radio, Bluetooth & OnStar
     */
    const val U_CAR_BT_ON = 1015
    const val U_CAR_RADIO_SUPPORT = 1016
    const val U_ONSTAR_SYNC_ON = 1022
    const val U_HIDE_RADIO = 1036
    const val U_BT_RECORD_5LIST = 1045


    /**
     * # Air condition status
     */
    const val AIR_BEGIN = 10
    const val U_AIR_POWER = 10
    const val U_AIR_AC = 11
    const val U_AIR_CYCLE = 12
    const val U_AIR_AUTO = 13
    const val U_AIR_DUAL = 14
    const val U_AIR_MAX_FRONT = 15
    const val U_AIR_REAR_DEFROST = 16
    const val U_AIR_FRONT_HOT = 17
    const val U_AIR_BLOW_UP_LEFT = 18
    const val U_AIR_BLOW_BODY_LEFT = 19
    const val U_AIR_BLOW_FOOT_LEFT = 20
    const val U_AIR_WIND_LEVEL_LEFT = 21
    const val U_AIR_BLOW_UP_RIGHT = 22
    const val U_AIR_BLOW_BODY_RIGHT = 23
    const val U_AIR_BLOW_FOOT_RIGHT = 24
    const val U_AIR_WIND_LEVEL_RIGHT = 25
    const val U_AIR_AUTO_RIGHT = 26
    const val U_AIR_TEMP_LEFT = 27
    const val U_AIR_TEMP_RIGHT = 28
    const val U_AIR_SEAT_HOT_LEFT = 29
    const val U_AIR_SEAT_HOT_RIGHT = 30
    const val U_AIR_SEAT_BLOW_LEFT = 31
    const val U_AIR_SEAT_BLOW_RIGHT = 32
    const val U_AIR_FLOW_AUTO = 33
    const val U_AIR_NANOE = 34
    const val U_AIR_SWING = 35
    const val U_AIR_CYCLE_AUTO = 36
    const val U_AIR_TEMP_UNIT = 37
    const val U_AIR_REAR = 38
    const val U_AIR_REAR_DUAL = 39
    const val U_AIR_REAR_TEMP_LEFT = 40
    const val U_AIR_REAR_TEMP_RIGHT = 41
    const val U_AIR_REAR_POWER = 42
    const val U_AIR_REAR_AUTO = 43
    const val U_AIR_REAR_WIN_LEV = 44
    const val U_AIR_REAR_VIEW_HOT = 45
    const val U_AIR_REAR_BLOW_BODY = 46
    const val U_AIR_REAR_BLOW_FOOT = 47
    const val U_AIR_REAR_BLOW_UP = 48
    const val U_AIR_BLOW_AUTO_LEFT = 49
    const val U_AIR_BLOW_AUTO_RIGHT = 50
    const val U_AIR_WIND_STRENGTH = 51
    const val U_AIR_ECO = 52
    const val U_AIR_ACMAX = 53
    const val U_AIR_AQS = 54
    const val U_AIR_MONO = 55
    const val U_AIR_TEMP_SET_V = 56
    const val U_AIR_ZONE = 57
    const val U_AIR_ION = 58
    const val U_AIR_REARVIEW_HOT = 59
    const val U_AIR_FULL_LEFT = 60
    const val U_AIR_FULL_RIGHT = 61
    const val U_AIR_SYNC = 62
    const val U_AIR_HEAT = 63
    const val U_CARINFO_AIR_LEV = 64
    const val U_AIR_FRONT_DEFROST = 65
    const val U_AIR_HOT_STEER = 66
    const val U_AIR_REAR_LOCK = 67
    const val U_AIR_PTC = 68
    const val U_AUTO_LEV = 69
    const val U_AIR_FAST = 70
    const val U_AIR_SOFT = 71
    const val U_AIR_BLOW_HEAD = 72
    const val U_AIR_AUTO_WIN_LEV = 73
    const val U_AIR_AUTO_WIN_BLOW = 74
    const val U_AIR_TEMP_TYPE = 75
    const val U_AIR_CLEAN = 76
    const val U_AIR_BLOW_MODE_LEFT = 77
    const val U_AIR_REAR_AC = 78
    const val U_AIR_FULL = 79
    const val U_AIR_PARK = 80
    const val U_AIR_REAR_AUTO_RIGHT = 81
    const val U_AIR_REAR_BLOW_BODY_RIGHT = 82
    const val U_AIR_REAR_BLOW_FOOT_RIGHT = 83
    const val U_AIR_REAR_BLOW_UP_RIGHT = 84
    const val U_AIR_REAR_COOL = 85
    const val U_AIR_REAR_MANUAL = 86
    const val U_AIR_BLOW_MODE_RIGHT = 87
    const val U_AIR_REAR_SEAT_HOT_LEFT = 88
    const val U_AIR_REAR_SEAT_HOT_RIGHT = 89
    const val U_AIR_REAR_SEAT_BLOW_LEFT = 90
    const val U_AIR_REAR_SEAT_BLOW_RIGHT = 91
    const val U_AIR_FRONT_ONLY = 92
    const val U_AIR_MASSAGESEAT_LEFT = 93
    const val U_AIR_MASSAGESEAT_RIGHT = 94
    const val U_AIR_LUMBARSEAT_LEFT = 95
    const val U_AIR_LUMBARSEAT_RIGHT = 96
    const val AIR_END = 97

    /**
     * # OEM / Brand Specific
     */
    const val U_BMW_CARUI_SUPPORT = 1038
    const val U_MERCEDES_BUTTON = 1042
    const val U_JAGUAR_LZ_RADAR = 1047
    const val U_TCROSS_ZH_BUTTON = 1048

    /**
     * # Max limit
     */
    const val CNT_MAX = 1200
}

object CanbusGetCodes {
    const val G_MCU_CANBUS_SUPPORT = 1000
    const val G_MISC_BEGIN = 1000

}

object CanbusKeycodes {
    const val KEYCODE_DEFAULT = -1

    const val KEYCODE_POWER = 0
    const val KEYCODE_NAVI = 1
    const val KEYCODE_MODE = 2
    const val KEYCODE_PREV = 3
    const val KEYCODE_NEXT = 4
    const val KEYCODE_HOME = 5
    const val KEYCODE_BACK = 6
    const val KEYCODE_VOL_UP = 7
    const val KEYCODE_VOL_DOWN = 8
    const val KEYCODE_MENU = 9
    const val KEYCODE_ALL_APPS = 10
    const val KEYCODE_EJECT = 11
    const val KEYCODE_MUTE = 12
    const val KEYCODE_VOICE_ASSISTANT = 13
    const val KEYCODE_SCREEN_DIM = 14
    const val KEYCODE_RECENT_TASKS = 15
    const val KEYCODE_PLAYPAUSE = 16
    const val KEYCODE_CAMERA = 17
    const val KEYCODE_PHONE = 18
    const val KEYCODE_TONE_PLUS = 19
    const val KEYCODE_TONE_MINUS = 20
    const val KEYCODE_BAND = 21
    const val KEYCODE_DVD = 22
    const val KEYCODE_PANORAMA = 23
    const val KEYCODE_RADIO = 24
    const val KEYCODE_SCREEN_OFF = 25
    const val KEYCODE_HANG = 26
    const val KEYCODE_FF = 27
    const val KEYCODE_FB = 28
    const val KEYCODE_ENTER = 29
    const val KEYCODE_ROLL_LEFT = 30
    const val KEYCODE_ROLL_RIGHT = 31
    const val KEYCODE_LEFT = 32
    const val KEYCODE_RIGHT = 33
    const val KEYCODE_UP = 34
    const val KEYCODE_DOWN = 35
    const val KEYCODE_PLAY = 36
    const val KEYCODE_PAUSE = 37
    const val KEYCODE_EQ = 38
    const val KEYCODE_SEARCH = 39
    const val KEYCODE_NUM1 = 40
    const val KEYCODE_NUM2 = 41
    const val KEYCODE_NUM3 = 42
    const val KEYCODE_NUM4 = 43
    const val KEYCODE_NUM5 = 44
    const val KEYCODE_NUM6 = 45
    const val KEYCODE_NUM7 = 46
    const val KEYCODE_NUM8 = 47
    const val KEYCODE_NUM9 = 48
    const val KEYCODE_NUM0 = 49
    const val KEYCODE_NX = 50
    const val KEYCODE_NJ = 51
    const val KEYCODE_TV = 52
    const val KEYCODE_AUX = 53
    const val KEYCODE_MEDIAPLAYER = 54
    const val KEYCODE_CAR_SETTINGS = 55
    const val KEYCODE_TIME_SETTINGS = 56
    const val KEYCODE_SCREEN_CALI = 57
    const val KEYCODE_SYSTEM_INFO = 58
    const val KEYCODE_DVR = 59
    const val KEYCODE_CARUSB = 60
    const val KEYCODE_CARRADIO = 61
    const val KEYCODE_AIRCONTROL = 62
    const val KEYCODE_CANBUS = 63
    const val KEYCODE_SCAN = 64
    const val KEYCODE_REPEAT = 65
    const val KEYCODE_RANDOM = 66
    const val KEYCODE_SEEK_UP = 67
    const val KEYCODE_SEEK_DOWN = 68
    const val KEYCODE_STAND_BY = 69
    const val KEYCODE_DISPLAY = 70
    const val KEYCODE_BRIGHT_MINUS = 71
    const val KEYCODE_BRIGHT_PLUS = 72
    const val KEYCODE_AUDIO_SETTINGS = 73
    const val KEYCODE_FM = 74
    const val KEYCODE_AM = 75
    const val KEYCODE_BT_AV = 76
    const val KEYCODE_NC = 77
    const val KEYCODE_TA = 78
}
