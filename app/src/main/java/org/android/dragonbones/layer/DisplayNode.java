package org.android.dragonbones.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class DisplayNode extends SKNode implements SKDraw {
    protected Paint mPaint = new Paint();
    public Bitmap mImage;
    private Matrix mMatrix = new Matrix();
    private int zOrder = 0;
    public DisplayNode() {
        mPaint.setAntiAlias(true);
    }
    @Override
    public int zOrder() {
        return zOrder;
    }

    @Override
    public Matrix matrix() {
        return mMatrix;
    }

    @Override
    protected void onLayout(SKContext ctx) {
        mMatrix.set(ctx.matrix);
        zOrder = ctx.z + z;
        ctx.addDrawItem(this);
    }

    @Override
    public void draw(Canvas canvas, SKContext context) {
        super.draw(canvas, context);
        mPaint.setColor(0xff0000ff);
        canvas.drawText(name, 0, 0, mPaint);
        if (mImage!=null) {
            float left = mImage.getWidth() * -0.5f;
            float top = mImage.getHeight() * -0.5f;
            canvas.drawBitmap(mImage, left, top, mPaint);
//            mMatrix.setTranslate(centerX, centerY);
//            mMatrix.setScale(scaleX, scaleY);
//            mMatrix.setRotate((skX+skY)*0.5f, x, y);
//            canvas.drawBitmap(mImage, mMatrix, mPaint);
        }
//        canvas.drawBitmap();
    }
}
