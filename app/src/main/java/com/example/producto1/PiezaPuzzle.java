package com.example.producto1;

import android.content.Context;

public class PiezaPuzzle extends androidx.appcompat.widget.AppCompatImageView {

    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;

    public PiezaPuzzle(Context context) {super(context); }

}

