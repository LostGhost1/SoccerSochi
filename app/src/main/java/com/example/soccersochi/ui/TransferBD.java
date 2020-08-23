package com.example.soccersochi.ui;

import java.util.ArrayList;

public class TransferBD {
    public ArrayList<String> imgsArray;
    public ArrayList<String> hrefsArray;
    public ArrayList<String> textsArray;
    public ArrayList<String> subtextsArray;

    public TransferBD(ArrayList<String> imgsArray, ArrayList<String> hrefsArray, ArrayList<String> textsArray, ArrayList<String> subtextsArray)
    {
        this.imgsArray = imgsArray;
        this.hrefsArray = hrefsArray;
        this.textsArray = textsArray;
        this.subtextsArray = subtextsArray;
    }
}
