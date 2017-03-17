package com.epam.itweek.utils;

/**
* Created by Ivan_Hernandez on 3/16/2017.
*/

public interface Constants   {

    int SCREEN_WIDTH = 480;
    int SCREEN_HEIGHT = 800;

    //Update this value to change the game speed. Default = 1f
    float GLOBAL_SPEED_FACTOR = 1f;

    //Another speed factor, for the UI animation speed. Default = 1f
    float ANIMATION_SPEED_FACTOR_UI = 1f;

    //UI constants
    int BUTTON_SIZE_SMALL = 40;
    int BUTTON_SIZE_MED = 60;
    int BUTTON_SIZE_BIG = 100;
    int PIXELS_PER_UNIT = 20;


    //Buttons images path
    String BUTTON_OK = "img/ui/button_ok.png";
    String BUTTON_CANCEL = "img/ui/button_back.png";
    String BUTTON_START = "img/ui/button_start.png";
    String BUTTON_RESTART = "img/ui/button_restart.png";
    String BUTTON_BACK = "img/ui/button_back.png";
    String BUTTON_PAUSE = "img/ui/button_pause.png";
    String BUTTON_NONE = "img/ui/button_none.png";

}
