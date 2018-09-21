package com.motocycleway;

import android.content.Context;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class GameView extends SurfaceView implements SurfaceHolder.Callback {

    com.motocycleway.MainThread thread;
    public GameView(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void update() {
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
