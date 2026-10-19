package com.aoe.fytcanbusmonitor

object MainUpdateCodes {

    const val U_APP_ID = 0
    const val U_MCU_ON = 1
    const val U_STANDBY = 2
    const val U_BLACKSCREEN = 3
    const val U_ANY_KEY_BOOT = 5
    const val U_ACCCUT_POWER = 25
    const val U_OSD_TIME = 26
    const val U_BRIGHT_LEVEL = 31
    const val U_BRIGHT_LEVEL_DAY = 32
    const val U_BRIGHT_LEVEL_NIGHT = 33
    const val U_BLACKSCREEN_AUTO = 36
    const val U_APP_IS_VISIBLE = 39
    const val U_SLEEP_DEVICE_WAKEUP = 43
    const val U_ACC_ON = 50
    const val U_DEVICE_RESTART_LATER = 61
    const val U_MCU_BOOT_ON = 62
    const val U_ACCCUT_TURN_OFF_LCDC = 66
    const val U_ECARLINK_ON = 67
    const val U_ACCCUT_TURN_OFF_SCREEN_DELAY = 71
    const val U_SLEEP_ENTER_AIRPLANE_MODE = 76
    const val U_SCREEN_TOUCH_EVENT_POS = 77 // [ints: x, y]
    const val U_CAR_STARTSTOP_ENABLED = 88
    const val U_DEVICE_SLEEP_STATE = 103
    const val U_BLACKSCREEN_STANDBY = 110
    const val U_STATUSBAR_SCREENSHOT_SHORTCUT_ENABLED = 117

    /**
     * # Lighting & LEDs
     * `Lamplet` - car lights state
     */
    const val U_LAMPLET_U1 = 4
    const val U_LAMPLET_O2 = 181
    const val U_LAMPLET_BY_TIME_U1 = 29
    const val U_LAMPLET_ON_BOOT = 52
    const val U_LAMPLET_ON_ALWAYS = 53
    const val U_LAMPLET_COLOR_CTRL = 54
    const val U_LAMPLET_CLEAN_ON = 78
    const val U_LAMPLET_BY_TIME_O2 = 136
    const val U_AMBIENT_LIGHT_U1 = 79
    const val U_AMBIENT_LIGHT_O2 = 123
    const val U_AMBIENT_LIGHT_SWITCH = 149
    const val U_LED_COLOR = 99


    /**
     * # Navigation & GPS
     */
    const val U_NAVI_ON_BOOT = 6
    const val U_NAVI_PKG_NAME = 28
    const val U_GNSS_SPEED = 101
    const val U_NAVI_SOUND = 111
    const val U_NAVI_IN_FOREGROUND = 113
    const val U_GNSS_POSITION = 179
    const val U_GNSS_ALTITUDE_FIX_VALUE = 183

    /**
     * # Vehicle status & Telemetry
     */
    const val U_HANDBRAKE_ACTIVATED = 7
    const val U_HANDBRAKE_SWITCH = 8
    const val U_OUTSIDE_TEMP = 40
    const val U_STEER_ANGLE = 41
    const val U_TRUNK_CONTROL_STATE = 87
    const val U_CAR_BATTERY_VOLTAGE = 114
    const val U_STEER_TYPE = 120
    const val U_TURN_INDICATORS = 134
    const val U_DOOR_STATE = 151

    /**
     * # Storage & USB
     */
    const val U_DEVICE_SD1_EXIST = 9
    const val U_DEVICE_SD2_EXIST = 10
    const val U_DEVICE_USB_EXIST = 11
    const val U_USB_ERROR_ENABLED = 100
    const val U_USB_INDEX = 118

    /**
     * # Cameras, Reversing & 360 Panorama
     */
    const val U_BACKCAR = 12
    const val U_BACKCAR_TRACK_ENABLED = 23
    const val U_BACKCAR_MIRROR = 24
    const val U_BACKCAR_TYPE = 47
    const val U_PANORAMA_ON = 55
    const val U_MIRROR_UP_DOWN = 58
    const val U_BACKCAR_HOST_ENABLED = 65
    const val U_CAMERA_REQUESTED = 68
    const val U_BACKCAR360_CAMERA = 81
    const val U_BACKCAR360_CAMERA_ENABLED = 83
    const val U_REVERSING_TRACK_ENABLED = 102
    const val U_CAMERA_VOLTAGE = 119
    const val U_CAMERA_AHD_ENABLED = 121
    const val U_REVERSING_APP_PKG = 122
    const val U_CAMERA_POWER_ALWAYS_SUPPLY_ENABLED = 125
    const val U_FRONTCAMERA_ENABLED = 126
    const val U_REVERSING_STATIC_TRACK = 130
    const val U_CAMERA_POWER = 160
    const val U_REVERSING_CARPLAY_CONNECTED = 169
    const val U_REVERSING_ANTI_SHAKING = 180
    const val U_RIGHTCAMERA7870_SWITCH = 199

    /**
     * # Parking Radars & Distance Sensors
     */
    const val U_RADAR = 13
    const val U_RADAR_FL = 14 // F - front; L - left
    const val U_RADAR_FML = 15 // F - front; M - middle; L - left
    const val U_RADAR_FMR = 16
    const val U_RADAR_FR = 17
    const val U_RADAR_RL = 18
    const val U_RADAR_RML = 19
    const val U_RADAR_RMR = 20
    const val U_RADAR_RR = 21
    const val U_BACKCAR_RADAR = 22
    const val U_BACKCAR_RADAR_ENABLED = 27
    const val U_RADAR_POWER = 75
    const val U_RADAR_PARK_ENABLED = 86
    const val U_RADAR_RSF = 90 // Radar Sensor Front
    const val U_RADAR_RSMF = 91
    const val U_RADAR_RSMB = 92
    const val U_RADAR_RSB = 93
    const val U_RADAR_LSF = 94
    const val U_RADAR_LSMF = 95
    const val U_RADAR_LSMB = 96
    const val U_RADAR_LSB = 97

    /**
     * # Audio, Video, Media & Voice Assistant
     */
    const val U_PLAYER_CMD = 37
    const val U_VOICE_ASSISTANT_CMD = 42
    const val U_ID3_TITLE = 49
    const val U_VOICE_ASSISTANT_AUDIO_DURING_USE = 57
    const val U_MCU_VIDEO_REQUESTED = 59
    const val U_SIGNAL_ON = 69
    const val U_SIGNAL_NTSC_PAL = 70
    const val U_AUX_ENABLED = 73
    const val U_MEDIA_PLAYBACK_PARAMS = 74
    const val U_CNC_AUX_ENABLED = 98
    const val U_VOICE_ASSISTANT_AUDIO_OCCUPIED_BY_APP = 104
    const val U_VIDEO_OUTPUT_PARAMS = 105
    const val U_MIC_TYPE = 107
    const val U_VIDEO_AUX_TV = 108
    const val U_AUX_IPOD_AUDIO_CHANNEL = 112
    const val U_IMAGE_IC_INITIALIZED = 137
    const val U_IMAGE_IC_UPGRADE = 140
    const val U_IMAGE_IC_UPGRADE_PROGRESS = 141
    const val U_VIDEO_ID = 153
    const val U_VIDEO_FORMAT = 154
    const val U_VIDEO_SIGNAL = 155
    const val U_VOICE_EXTRA_AUDIO = 156
    const val U_NAVI_EXTRA_AUDIO = 157
    const val U_TIPS_EXTRA_AUDIO = 158
    const val U_VOICE_ASSISTANT_PKG = 164
    const val U_EXTRA_MIC_ENABLED = 172
    const val U_CAR_VIDEO_SIZE = 173
    const val U_IMAGE_PARAM_8918 = 174

    /**
     * # Controls, Keys & Gestures
     */
    const val U_PANEL_KEY_TYPE = 51
    const val U_MCU_DIRECTION_KEY = 60
    const val U_PANEL_KEY_TYPE_CNT = 63
    const val U_GESTURE = 64
    const val U_MCU_PANEL_KEY_ENABLED = 82
    const val U_ROLL_KEY_TYPE = 89

    /**
     * # Climate / HVAC
     */
    const val U_AIR_CONTROL_SUPPORT = 72

    /**
     * # MCU Hardware, Diagnostics & Power Rails
     */
    const val U_MCU_VER = 34
    const val U_MCU_SERIAL = 35
    const val U_MCU_POWER_OPTION = 38
    const val U_TIP = 45
    const val U_MCU_ERROR_CODE = 46
    const val U_TIP_MCU_UPGRADE = 48
    const val U_FAN_CYCLE = 56
    const val U_SHOW_FLASH_WRITE_ON = 80
    const val U_SPI_OSD_VER = 84
    const val U_SPI_MCU_VER = 85
    const val U_MCU_MEMORY_CONTROL = 106
    const val U_VCOM_VOLTAGE = 109
    const val U_DEVICE_VOLTAGE = 115
    const val U_AVDD = 116

    /**
     * # Reserved
     */
    const val U_RESERVED = 30
    const val U_RESERVED2 = 44

    const val OPTION_BASE_BEGIN = 123

    const val U_THIRD_DVR_SETUP = 124
    const val U_LOCK_PASSWORD = 127
    const val U_UNLOCK_DEVICE_MAC = 128
    const val U_LOCK_STATE = 129
    const val U_LOCK_ENABLED = 131
    const val U_KEYCODE_2CUSTOMER = 132
    const val U_ONCLICK_KEYCODE = 133
    const val U_PREVIEW_MODE = 135
    const val U_FOREGROUND_APP_CHANGED = 138
    const val U_DOUBLE_FLASH = 139
    const val U_MCU_SHUTDOWN_DELAY = 142

    // 143
    const val U_FAN_AUTO_MODE = 144
    const val U_FAN_AUTO_MODE_TEMPS = 145
    const val U_CPU_RUNNING_TEMP = 146
    const val U_BOOT_PLAY_VIDEO = 147
    const val U_SOFT_UPGRADE = 148
    const val U_APP_UI_WINDOW_FOCUS = 150

    // 152
    const val U_CALLING_EXTRA = 159
    const val U_SET_PROPERTY = 161
    const val U_USB_DVR_7731_SWITCH = 162
    const val U_SERIAL_PLUGIN_DEVICE = 163
    const val U_ENTER_UI_REMEMBER = 165
    const val U_CARLINK_WIRELESS_AUTO_CONN = 166
    const val U_CARLINK_WIRED_AUTO_CONN = 167
    const val U_SCREEN_ON = 168
    const val U_CARLINK_CARPLAY_CALL_STATE = 170
    const val U_BACKLIGHT_CTRL_TYPE = 171
    const val U_SINGLE_DELAY_SHUTDOWN = 175
    const val U_OBSTACLE_FLAG = 176
    const val U_SCREENSAVER_OP = 177
    const val U_UI_MODE = 178
    const val U_MOBILE_LINK_STATUS = 182
    const val U_ANDROID_AUDIO_STATE = 184
    const val U_CUSTOM_APP = 185
    const val U_APP_TO_BE_KILLED = 186
    const val U_SECOND_DISPLAY_BRIGHTNESS = 187
    const val U_SECOND_DISPLAY_BLACK = 188
    const val U_BOOT_BLACKSCREEN = 189
    const val U_CUSTOM_BOOT_APP = 190
    const val U_SECOND_BOOT_BLACK_SCREEN = 191
    const val U_SECOND_DISPLAY_VCOM_VOLTAGE = 192
    const val U_THIRD_PLAYER_PKG_NAME = 198
    const val U_HJ_BAIDU_IN_FRONT = 198

    // const val DEBUG_LOG_TYPE_FLAG = 201;


    /**
     * # Max limit
     */
    const val CNT_MAX = 256
}

object MainCommandCodes {

    /**
     * # Player commands
     * @renamed from `PLAYER_COMMAND_...`
     */
    const val C_PLAYER_PLAY = 0
    const val C_PLAYER_PLAYPAUSE = 1
    const val C_PLAYER_PAUSE = 2
    const val C_PLAYER_STOP = 3
    const val C_PLAYER_PREV = 4
    const val C_PLAYER_NEXT = 5
    const val C_PLAYER_FF = 6
    const val C_PLAYER_FB = 7
    const val C_PLAYER_NUM = 8
    const val C_PLAYER_REPEAT = 9

    /**
     * # Power, System & Sleep management
     */
    const val C_APP_ID = 0
    const val C_ANY_KEY_BOOT = 2
    const val C_STANDBY = 18
    const val C_RESTART_DEVICE_LATER = 19
    const val C_FACTORY_RESET = 38
    const val C_SYSTEM_PROPERTIES = 41
    const val C_ACCCUT_TURN_OFF_LCDC = 42
    const val C_ECARLINK_SWITCH = 43
    const val C_SLEEP_WAKEUP = 46
    const val C_SLEEP_ACTIVE_AIRPLANE = 48
    const val C_RESTART_DEVICE = 53
    const val C_START_STOP_SWITCH = 61
    const val C_AIRPLANE_MODE = 75
    const val C_EXIT_APP = 81

    /**
     * # Screen & Display settings
     */
    const val C_OSD_TIME = 8
    const val C_BRIGHT_LEVEL = 10
    const val C_BRIGHT_LEVEL_DAY = 11
    const val C_BRIGHT_LEVEL_NIGHT = 12
    const val C_BLACKSCREEN_AUTO = 13
    const val C_BLACKSCREEN = 16
    const val C_ENABLE_STATUSBAR_SCREENSHOT_SHORTCUT = 82
    const val C_ROTATE_SCREEN = 83

    /**
     * # Lighting, Backlight & Ambient LED
     */
    const val C_LAMPLET_BY_TIME = 1
    const val C_LAMPLET_ON_BOOT = 30
    const val C_LAMPLET_ON_ALWAYS = 31
    const val C_LAMPLET_COLOR_CTRL = 32
    const val C_LAMPLET_CLEAN_ON = 49
    const val C_LAMPLET_TIME = 136
    const val C_AMBIENT_LIGHT_C1 = 50
    const val C_AMBIENT_LIGHT_O2 = 123
    const val C_AMBIENT_LIGHT_SWITCH = 149
    const val C_LED_COLOR = 64

    /**
     * # Navigation
     */
    const val C_NAVI_ON_BOOT = 3
    const val C_NAVI_PKG_NAME = 9

    /**
     * # Keys, Touch & Controls
     */
    const val C_JUMP_PAGE = 24
    const val C_KEY = 25
    const val C_PANEL_KEY_TYPE = 29
    const val C_GESTURE = 39
    const val C_MCU_PANEL_KEY_ENABLE = 55
    const val C_TOUCH = 56
    const val C_ROLL_KEY_TYPE = 63
    const val C_STEER_TYPE = 86

    /**
     * # Cameras, Reversing & 360 Panorama
     */
    const val C_BACKCAR_TRACK_ENABLE = 6
    const val C_BACKCAR_MIRROR = 7
    const val C_BACKCAR_TYPE = 28
    const val C_PANORAMA_ON = 33
    const val C_MIRROR_UP_DOWN = 35
    const val C_OUT_BACKCAR = 37
    const val C_HOST_BACKCAR_ENABLE = 40
    const val C_BACKCAR_360_CAMERA = 54
    const val C_360CAMERA_BACKCAR_ENABLE = 57
    const val C_RIGHT_CAMERA_STATE = 60
    const val C_VIDEO_STOP_CAMERA = 66
    const val C_360_CONTROL = 67
    const val C_BACKCAR_REVERSE_TRACK_ENABLE = 68
    const val C_360_ENTER_BACKCAR = 74
    const val C_360CAMERA_OFF = 76
    const val C_CAMERA_VOLTAGE = 85
    const val C_CAMERA_AHD_ENABLE = 87
    const val C_REVERSING_PKG_NAME = 88

    /**
     * # Parking Radars
     */
    const val C_BACKCAR_RADAR_ENABLE = 5
    const val C_RADAR_POWER = 45
    const val C_RADAR_PARK_ENABLE = 59

    /**
     * # Audio, Video & Voice Assistant
     */
    const val C_VOICE_ASSISTANT_CMD = 20
    const val C_VIDEO_ID_C1 = 22

    /**
    Setting media playback title: `{ints: [$appId], flts: null, strs: [$id3Title]}`
     **/
    const val C_PLAYBACK_PARAMS = 23
    const val C_VIDEO_IMAGE = 36
    const val C_VIDEO_POSITION = 44
    const val C_AUX_ENABLE = 47
    const val C_VIDEO_OUT_ON = 51
    const val C_VIDEO_OUTPUT_PARAMS = 69
    const val C_MIC_TYPE = 71
    const val C_VIDEO_AUX_TV = 72
    const val C_AUDIO_TV_IPOD_CHANNEL = 77
    const val C_BEEP = 80

    /**
     * # MCU, Hardware & Vehicle peripheral control
     */
    const val C_HANDBRAKE_SWITCH = 4
    const val C_MCU_SERIAL = 14
    const val C_MCU_POWER_OPTION = 15
    const val C_MCU_SWITCH_ON = 17
    const val C_MCU_ERROR_CODE = 21
    const val C_LANGUAGE = 26
    const val C_MCU_UPGRADE = 27
    const val C_FAN_CYCLE = 34
    const val C_SHOW_FLASH_WRITE_ON = 52
    const val C_TRUNK_CONTROL_CMD = 58
    const val C_ACCCUT_CONTROLLED_BY_MCU = 62
    const val C_USB_ERROR_ENABLE = 65
    const val C_MCU_MEMORY_CONTROL = 70
    const val C_VCOM_VOLTAGE = 73
    const val C_UPDATE_CONNECT_MCU = 78
    const val C_VAVDD = 79
    const val C_GPIO_JNI = 84

    const val OPTION_BASE_BEGIN = 123

    // 123
    const val C_THIRD_DVR_SETUP = 124
    const val C_CAMERA_POWER_ALWAYS_SUPPLY_ENABLE = 125
    const val C_FRONT_CAMERA_ENABLE = 126
    const val C_LOCK_PASSWORD = 127
    const val C_UNLOCK_DEVICE_MAC = 128
    const val C_LOCK_STATE = 129
    const val C_STATIC_TRACK = 130
    const val C_LOCK_ENABLE = 131
    const val C_KEYCODE_2CUSTOMER = 132
    const val C_ONCLICK_KEYCODE = 133
    const val C_CAR_TURN_INDICATORS = 134
    const val C_PREVIEW_MODE = 135
    const val C_IMAGE_IC_INITIALIZE = 137
    const val C_FOREGROUND_APP_CHANGE = 138
    const val C_DOUBLE_FLASH = 139
    const val C_IMAGE_IC_UPGRADE = 140
    const val C_IMAGE_IC_UPGRADE_PROGRESS = 141
    const val C_MCU_SHUTDOWN_DELAY = 142

    // 143
    const val C_FAN_AUTO_MODE = 144
    const val C_FAN_AUTO_MODE_TEMPS = 145
    const val C_CPU_RUNNING_TEMP = 146
    const val C_BOOT_PLAY_VIDEO = 147
    const val C_SOFT_UPGRADE = 148
    const val C_APP_UI_WINDOW_FOCUS = 150
    const val C_DOOR_STATE = 151

    // 152
    const val C_VIDEO_ID_O2 = 153
    const val C_VIDEO_FORMAT = 154
    const val C_VIDEO_SIGNAL = 155
    const val C_VOICE_EXTRA_AUDIO = 156
    const val C_NAVI_EXTRA_AUDIO = 157
    const val C_TIPS_EXTRA_AUDIO = 158
    const val C_CALLING_EXTRA = 159
    const val C_CAMERA_POWER = 160
    const val C_SET_PROPERTY = 161
    const val C_USB_DVR_SWITCH_7731 = 162
    const val C_SERIAL_PLUGIN_DEVICE = 163
    const val C_VOICE_PKG = 164
    const val C_ENTER_UI_REMEMBER = 165
    const val C_CARLINK_WIRELESS_AUTO_CONN = 166
    const val C_CARLINK_WIRED_AUTO_CONN = 167
    const val C_SCREEN_ON = 168
    const val C_REVERSE_CARPLAY_CONNECT = 169
    const val C_CARLINK_CARPLAY_CALL_STATE = 170
    const val C_BACKLIGHT_CTRL_TYPE = 171
    const val C_EXTRA_MIC_ENABLE = 172
    const val C_CAR_VIDEO_SIZE = 173
    const val C_IMAGE_PARAM_8918 = 174
    const val C_SHUTDOWN_SINGLE_DELAY = 175
    const val C_OBSTACLE_FLAG = 176
    const val C_SCREENSAVER_OP = 177
    const val C_UI_MODE = 178
    const val C_GNSS_POSITION = 179
    const val C_REVERSE_ANTI_SHAKING = 180
    const val C_MOBILE_LINK_STATUS = 182
    const val C_GNSS_ALTITUDE_FIX_VALUE = 183
    const val C_ANDROID_AUDIO_STATE = 184
    const val C_CUSTOM_APP = 185
    const val C_APP_TO_BE_KILLED = 186
    const val C_SECOND_DISPLAY_BRIGHTNESS = 187
    const val C_SECOND_DISPLAY_BLACK = 188
    const val C_BOOT_BLACK_SCREEN = 189
    const val C_CUSTOM_BOOT_APP = 190
    const val C_SECOND_BOOT_BLACK_SCREEN = 191
    const val C_SECOND_DISPLAY_VCOM_VOLTAGE = 192
    const val C_RIGHTCAMERA7870_STATE = 199
    // 200
    // const val DEBUG_LOG_TYPE_FLAG = 201;
}

object MainGetCodes {
    const val G_APP_ID = 0;
    const val G_AUTO_BLACK_SCREEN = 14
    const val G_BACKCAR_RADAR_ON = 28
    const val G_BACKCAR_TRACK_ON = 29
    const val G_BACK_CAR_MUTE_ON = 23
    const val G_BACK_CAR_ON = 26
    const val G_BEEP_ON = 27
    const val G_BLACK_SCREEN_ON = 15
    const val G_BRIGHTNESS_DAY = 18
    const val G_BRIGHTNESS_LEVEL = 35
    const val G_BRIGHTNESS_NIGHT = 19
    const val G_CANBUS_SUPPORT = 41
    const val G_CANBUS_SUPPORT_CNT = 40
    const val G_CANBUS_TYPE = 25
    const val G_CHANNEL = 3
    const val G_DEF_VOL_ON_BOOT = 13
    const val G_DVD_VERSION = 21
    const val G_DVR_ON = 34
    const val G_EXIST_CDC = 7
    const val G_EXIST_DISC = 5
    const val G_EXIST_IPOD = 6
    const val G_SYNCHRO_FLAGS = 4
    const val G_GPS_LISTEN_ON = 24
    const val G_GPS_MIX_ON = 12
    const val G_GPS_MIX_PERCENT = 38
    const val G_HANDBRAKE_ENABLED = 10
    const val G_HANDBRAKE_ON = 11
    const val G_IPOD_ENABLED = 32
    const val G_LAMPLET_ON = 17
    const val G_LANG = 36
    const val G_MCU_VERSION = 20
    const val G_MUTE_ON = 1
    const val G_NAVI_APP_PKG_NAME = 8
    const val G_OSD_TIME_ON = 16
    const val G_PAGE = 33
    const val G_PLAYER_TYPE = 37
    const val G_POWER_ON = 0
    const val G_POWER_OPTION = 22
    const val G_RADIO_AIR_LINE = 31
    const val G_RESET_DELAY_TIME = 30
    const val G_RUN_NAVI_ON_BOOT = 43
    const val G_STANDBY_ON = 39
    const val G_TV_ENABLE = 44
    const val G_VOL = 2
    const val G_VOL_MAIN_DEF = 42
}

object MainChipCodes {
    const val CHIP_NULL = 0
    const val CHIP_MST786 = 1
    const val CHIP_SPHE8700 = 2
    const val CHIP_RKPX3 = 3
    const val CHIP_SOFIA = 4
    const val CHIP_SG9832 = 5
    const val CHIP_RKPX5 = 6
    const val CHIP_SP9853 = 7
    const val CHIP_7731 = 8
    const val CHIP_7862 = 9
    const val CHIP_SP9863 = 10
    const val CHIP_SP7870 = 11
    const val CHIP_2386 = 12
}

object MainPlatformCodes {
    const val PLATFORM_E7 = 1
    const val PLATFORM_3188 = 2
    const val PLATFORM_8700 = 3
    const val PLATFORM_786 = 4
    const val PLATFORM_SOPHIA = 5
    const val PLATFORM_6025 = 6
    const val PLATFORM_PX5 = 7
    const val PLATFORM_9853 = 8
    const val PLATFORM_7731 = 9
    const val PLATFORM_7731_2 = 10
    const val PLATFORM_7862 = 11
    const val PLATFORM_8541 = 12
    const val PLATFORM_9863 = 13
    const val PLATFORM_7870 = 14
    const val PLATFORM_9863N = 15
    const val PLATFORM_2386 = 16
    const val PLATFORM_7865 = 17
    const val PLATFORM_6225 = 18

}

object MainAppIds {

    const val APP_ID_LAST = -1
    const val APP_ID_NULL = 0

    const val APP_ID_RADIO = 1
    const val APP_ID_BTPHONE = 2
    const val APP_ID_BTAV = 3
    const val APP_ID_DVD = 4
    const val APP_ID_AUX = 5
    const val APP_ID_TV = 6
    const val APP_ID_IPOD = 7
    const val APP_ID_AUDIO_PLAYER = 8
    const val APP_ID_VIDEO_PLAYER = 9
    const val APP_ID_THIRD_PLAYER = 10
    const val APP_ID_CAR_RADIO = 11
    const val APP_ID_CAR_BTPHONE = 12
    const val APP_ID_CAR_USB = 13
    const val APP_ID_DVR = 14
    const val APP_ID_3GPHONE = 15
    const val APP_ID_SPECIAL = 16

    const val CNT_MAX = 20

}
