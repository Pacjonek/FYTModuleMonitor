package com.aoe.fytcanbusmonitor


object CanbusCommandCodes {

    const val C_CMD_START_REQ_ADD = 100
    const val C_CMD_SET_ADD = 101

    const val MISC_BEGIN = 1000
    const val C_CANBUS_ID = 1000

    const val C_SHOW_AIR_POPUP = 1002
    const val C_CHANGE_PANORAMA = 1003
    const val C_SHOW_DOOR_POPUP = 1004
    const val C_CAMERA_MODE = 1005
    const val C_SWITCH_AIR_POPUP = 1009
    const val C_SWITCH_DOOR_POPUP = 1010
    const val C_SHOW_RIGHTCAMERA = 1016

    const val C_CANBUS_KEY_FUNC = 1014
    const val C_CANBUS_KEY_FUNC_WC = 1017
    const val C_CANBUS_RC_FUNC_WC = 1018


    const val C_FRAME_TO_MCU_PACKED_233 = 1008

    // 1009
    // 1010
    // 1011
    const val C_FRAME_TO_MCU_145 = 1012
    const val C_FRAME_TO_MCU_16 = 1013
    // 1014

    /**
     * ints[0]:
     *  0 - STEER. ANGLE
     *  1 - RADAR
     *  2 - OUTSIDE TEMPERATURE
     *  3 - CANBUS VERSION
     *  4 - IS CAR SUPPORT...
     *     1 - VOLUME
     *     2 - FIELD
     *     3 - EQ
     *  5 - CAMERA MODE
     *  6 - DOORS
     *  7 - TURN SIGNALS
     *  8 - SPEED
     */
    const val C_CANBUS_SET_FUNC = 1015
    const val C_CANBUS_FRAME_TO_MTU = 1030

    // 1035
    // 1036
    // 1037
    // 1038
    // 1039
    // 1040
    // 1041
    const val C_CMD_DUDU_OBD = 1042
    const val C_SWITCH_KEYCODE_STUDY = 1043 // [ints: [0/1]]
    const val C_CMD_CARINFO_PACKED_FRAME = 1044


    const val C_ONSTAR_SYNC_ON = 1011
    const val C_CMD_360_TOUCH = 1029
    const val C_CMD_PARK = 1031
    const val C_CMD_CANBUS_DVR = 1032

    const val C_SWITCH_RIGHT_SIDE_DRIVER = 1001
    const val C_SWITCH_DOOR_SUPPORT = 1035
    const val C_SWITCH_TURN_SIGNAL_SUPPORT = 1036
    const val C_SWITCH_RADAR360_SUPPORT = 1037
    const val C_SWITCH_OUTSIDE_TEMP_SUPPORT = 1045


    /* OEM / Brand Specific */
    const val C_CANBUS_AUDI_CAR_TYPE = 1033
    const val C_CANBUS_MERCEDES_BENZ_BUTTON = 1034
    const val C_CMD_JAGUAR_LZ = 1038
    const val C_CMD_CROSS_ZH_BUTTON = 1039


}

object CanbusUpdateCodes {

    const val DOORS_BEGIN = 0
    const val U_DOOR_HOOD = 0
    const val U_DOOR_FL = 1
    const val U_DOOR_FR = 2
    const val U_DOOR_RL = 3
    const val U_DOOR_RR = 4
    const val U_DOOR_TRUNK = 5
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
    const val CARINFO_WC_FIAT_ALL_BEGIN = 98
    const val U_CARINFO_WC_FIAT_ALL_AVG_FUEL_CON = 99
    const val U_CARINFO_WC_FIAT_ALL_FUEL_RANGE = 100
    const val U_CARINFO_WC_FIAT_ALL_TOTAL_MILEAGE = 101
    const val U_CARINFO_WC_FIAT_ALL_TRIPA_AVG_FUEL_CON = 102
    const val U_CARINFO_WC_FIAT_ALL_TRIPA_AVG_SPEED = 103
    const val U_CARINFO_WC_FIAT_ALL_TRIPA_TRAVEL_MILEAGE = 104
    const val U_CARINFO_WC_FIAT_ALL_TRIPA_TRAVEL_TIME = 105
    const val U_CARINFO_WC_FIAT_ALL_TRIPB_AVG_FUEL_CON = 106
    const val U_CARINFO_WC_FIAT_ALL_TRIPB_AVG_SPEED = 107
    const val U_CARINFO_WC_FIAT_ALL_TRIPB_TRAVEL_MILEAGE = 108
    const val U_CARINFO_WC_FIAT_ALL_TRIPB_TRAVEL_TIME = 109
    const val CARINFO_WC_FIAT_ALL_END = 110

    const val CARSET_WC_FIAT_ALL_BEGIN = 111
    const val U_CARSET_WC_FIAT_ALL_MILAGE_UNIT = 112
    const val U_CARSET_WC_FIAT_ALL_FUEL_USAGE_UNIT = 113
    const val U_CARSET_WC_FIAT_ALL_TEMP_UNIT = 114
    const val U_CARSET_WC_FIAT_ALL_DOOR_AUTOLOCK = 115
    const val U_CARSET_WC_FIAT_ALL_DAY_LIGHT = 116
    const val U_CARSET_WC_FIAT_ALL_TRIB_ACTIVE = 117
    const val U_CARSET_WC_FIAT_ALL_MEASURE_UNIT = 118
    const val U_CARSET_WC_FIAT_ALL_REARV_GUID = 119
    const val U_CARSET_WC_FIAT_ALL_REARPARK_VOL = 120
    const val U_CARSET_WC_FIAT_ALL_FLAHLIGHT_LOCK = 121
    const val U_CARSET_WC_FIAT_ALL_CORNER_LIGHTS = 122
    const val U_CARSET_WC_FIAT_ALL_COURTESY_LIGHTS = 123
    const val U_CARSET_WC_FIAT_ALL_PARKSENSE = 124
    const val U_CARSET_WC_FIAT_ALL_REARVIEW_DELAY = 125
    const val U_CARSET_WC_FIAT_ALL_HEADLIGHT_DELAY = 126
    const val U_CARSET_WC_FIAT_ALL_COURTESY_LIGHTS_DELAY = 127
    const val U_CARSET_WC_FIAT_ALL_U_CARSET_D79_D6_B74 = 147
    const val U_CARSET_WC_FIAT_ALL_PRESSURE_UNIT = 151
    const val CARSET_WC_FIAT_ALL_END = 111

    /* # End Section */

    /**
     * # Extended range codes
     */
    const val CAR_EXTENDED_BEGIN = 500
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
    const val U_CAR_OUTSIDE_TEMP_ENABLED = 552
    const val U_DOOR_ENGINE_ADD = 553
    const val U_DOOR_FL_ADD = 554
    const val U_DOOR_FR_ADD = 555
    const val U_DOOR_RL_ADD = 556
    const val U_DOOR_RR_ADD = 557
    const val U_DOOR_BACK_ADD = 558
    const val U_SPEED_UNIT = 559
    const val CAR_EXTENDED_END = 560

    const val MISC_BEGIN = 1000

    // DataCanbus.canbusId = value & 65535;
    // DataCanbus.carId = (value >> 16) & 65535;
    const val U_CANBUS_FULL_ID = 1000
    const val U_CANBUS_VER = 1005

    /**
     * In case the Canbus WC2 protocol:
     * [233, 90, 165, LEN, CMD, ...PAYLOAD, CHECKSUM]
     */
    const val U_CANBUS_FRAME_TO_SERVICE_UI = 1019
    const val U_CANBUS_FRAME_TO_MTU = 1024
    const val U_CARINFO_FRAME_PACKED = 1049

    const val U_AIR_POPUP_SWITCH = 1001
    const val U_DOOR_POPUP_SWITCH = 1002
    const val U_RIGHT_SIDE_DRIVER_SWITCH = 1003

    const val U_AIR_POPUP_SHOWN = 1008
    const val U_DOOR_POPUP_SHOWN = 1011
    const val U_AIRCONTROL_SHOWN = 1014

    const val U_DOOR_SUPPORT = 1004
    const val U_AIR_SUPPORT = 1007
    const val U_PANORAMA_SUPPORT = 1009
    const val U_OUTSIDE_TEMP_SUPPORT = 1012
    const val U_CARRADIO_SUPPORT = 1016
    const val U_AIRCONTROL_SUPPORT = 1018
    const val U_CARDVR_SUPPORT = 1034
    const val U_TURN_SIGNAL_SUPPORT = 1035
    const val U_SIDERADAR_SUPPORT = 1046
    const val U_CARTIRE_SUPPPORT = 1050

    const val U_TIP_ID = 1006

    const val U_CANBUS_MAX_SUPPORTED_CNT = 1010

    const val U_CANBUS_AIR_VER = 1023
    const val U_CANBUS_SLAVECAR_TOUCH_CALI = 1025
    const val U_CANBUS_SLAVECAR_BACKLIGHT = 1026
    const val U_CANBUS_PM25_CAR_IN = 1027
    const val U_CANBUS_PM25_CAR_OUT = 1028
    const val U_CANBUS_PM25_ENABLED = 1029

    const val U_VEHICLE_SPEED = 1031
    const val U_ENGINE_RPM = 1032
    const val U_GNSS_ANGLE = 1033
    const val U_SERVER_UI_TYPE = 1037

    const val U_NEW_AIREIXT_SP = 1041
    const val U_CANBUS_CAR_DOOR = 1043
    const val U_CANBUS_CAR_AIR = 1044

    /**
     * # Cameras, Parking & Radars
     */
    const val U_CAMERA_MODE = 1013
    const val U_RIGHTCAMERA_SUPPORT = 1017
    const val U_RIGHTCAMERA_STATE = 1020
    const val U_CAR_BACKCAR_SUPPORT = 1021
    const val U_CAR_BACKCAR_STATE = 1030
    const val U_PARK_MODE = 1039
    const val U_REAR_MOVE_TYPE = 1040

    /**
     * # Audio, OEM Radio, Bluetooth & OnStar
     */
    const val U_CAR_BT_STATE = 1015
    const val U_ONSTAR_SYNC_ON = 1022
    const val U_CAR_RADIO_HIDDEN = 1036
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
    const val U_AIR_MASSAGE_SEAT_LEFT = 93
    const val U_AIR_MASSAGE_SEAT_RIGHT = 94
    const val U_AIR_LUMBAR_SEAT_LEFT = 95
    const val U_AIR_LUMBAR_SEAT_RIGHT = 96
    const val AIR_END = 97

    /**
     * # OEM / Brand Specific
     */
    const val U_CAR_BMW_UI_SUPPORT = 1038
    const val U_MERCEDES_BUTTON = 1042
    const val U_JAGUAR_LZ_RADAR = 1047
    const val U_TCROSS_ZH_BUTTON = 1048
    const val U_KEYCODE_STUDY = 1053

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
    const val KEYCODE_TONE_UP = 19
    const val KEYCODE_TONE_DOWN = 20
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
    const val KEYCODE_SCREEN_CALIBRATION = 57
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
    const val KEYCODE_STANDBY = 69
    const val KEYCODE_DISPLAY = 70
    const val KEYCODE_BRIGHT_UP = 71
    const val KEYCODE_BRIGHT_DOWN = 72
    const val KEYCODE_AUDIO_SETTINGS = 73
    const val KEYCODE_FM = 74
    const val KEYCODE_AM = 75
    const val KEYCODE_BTAV = 76
    const val KEYCODE_NC = 77
    const val KEYCODE_TA = 78
}
