package com.example.producto1;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.abs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TouchListener implements View.OnTouchListener{

    private float xDelta;
    private float yDelta;
    private ActividadPuzzle actividad;

    public TouchListener(ActividadPuzzle actividad) {this.actividad = actividad;}

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getRawX();
        float y = motionEvent.getRawY();
        final double tolerance = sqrt(pow(view.getWidth(), 2) + pow(view.getHeight(), 2)) / 10;

        PiezaPuzzle pieza = (PiezaPuzzle) view;
        if (!pieza.canMove) {
            return true;
        }
        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                xDelta = x - lParams.leftMargin;
                yDelta = y - lParams.topMargin;
                pieza.bringToFront();
                break;
            case MotionEvent.ACTION_MOVE:
                lParams.leftMargin = (int) (x - xDelta);
                lParams.topMargin = (int) (y - yDelta);
                view.setLayoutParams(lParams);
                break;
            case MotionEvent.ACTION_UP:
                int xDiff = abs(pieza.xCoord - lParams.leftMargin);
                int yDiff = abs(pieza.yCoord - lParams.topMargin);
                if (xDiff <= tolerance && yDiff <= tolerance) {
                    lParams.leftMargin = pieza.xCoord;
                    lParams.topMargin = pieza.yCoord;
                    pieza.setLayoutParams(lParams);
                    pieza.canMove = false;
                    sendViewToBack(pieza);
                    actividad.checkGameOver();
                }
                break;
        }

        return true;
    }
    public void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup)child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child, 0);

        }
    }

}
