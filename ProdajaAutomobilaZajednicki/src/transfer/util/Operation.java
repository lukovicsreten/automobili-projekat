/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Sreten
 */
public interface Operation {

    public static final int LOGIN = 0;
    public static final int LOGOUT = 1;

    public static final int ADD_ADMINISTRATOR = 2;
    public static final int DELETE_ADMINISTRATOR = 3;
    public static final int UPDATE_ADMINISTRATOR = 4;
    public static final int GET_ALL_ADMINISTRATOR = 5;

    public static final int ADD_AUTOMOBIL = 6;
    public static final int DELETE_AUTOMOBIL = 7;
    public static final int UPDATE_AUTOMOBIL = 8;
    public static final int GET_ALL_AUTOMOBIL = 9;

    public static final int GET_ALL_DODATNA_OPREMA = 10;

    public static final int ADD_RACUN = 11;
    public static final int GET_ALL_RACUN = 12;

    public static final int ADD_MARKA = 13;
    public static final int DELETE_MARKA = 14;
    public static final int UPDATE_MARKA = 15;
    public static final int GET_ALL_MARKA = 16;

    public static final int GET_ALL_TIP_AUTOMOBILA = 17;

}
