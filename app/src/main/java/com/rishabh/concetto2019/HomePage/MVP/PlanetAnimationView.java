package com.rishabh.concetto2019.HomePage.MVP;

import android.animation.TimeAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.rishabh.concetto2019.R;

import java.util.Random;

public class PlanetAnimationView extends View
{
    /**
     * Class representing the state of a star
     */
    private static class Planet {
        private float x;
        private float y;
        private float scale;
        private float alpha;
        private float speed;
    }

    private static final int BASE_SPEED_DP_PER_S = 50;
    private static final int COUNT = 32;
    private static final int SEED = 1337;

    /** The minimum scale of a star */
    private static final float SCALE_MIN_PART = 0.25f;
    /** How much of the scale that's based on randomness */
    private static final float SCALE_RANDOM_PART = 0.55f;
    /** How much of the alpha that's based on the scale of the star */
    private static final float ALPHA_SCALE_PART = 0.5f;
    /** How much of the alpha that's based on randomness */
    private static final float ALPHA_RANDOM_PART = 0.5f;

    private final Planet[] mPlanets = new Planet[COUNT];
    private final Random mRnd = new Random(SEED);

    private TimeAnimator mTimeAnimator;
    private Drawable mDrawable,mDrawable2,mDrawable4,mDrawable5;

    private float mBaseSpeed;
    private float mBaseSize,mBaseSize2,mBaseSize4,mBaseSize5;
    private long mCurrentPlayTime;

    public PlanetAnimationView(Context context) {
        super(context);
        init();
    }

    public PlanetAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlanetAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mDrawable = ContextCompat.getDrawable(getContext(), R.drawable.star1);
        mDrawable2 = ContextCompat.getDrawable(getContext(), R.drawable.star2);
        mDrawable4 = ContextCompat.getDrawable(getContext(), R.drawable.star4);
        mDrawable5 = ContextCompat.getDrawable(getContext(), R.drawable.star5);

        mBaseSize  = Math.max(mDrawable.getIntrinsicWidth() , mDrawable.getIntrinsicHeight())  / 2f;
        mBaseSize2 = Math.max(mDrawable2.getIntrinsicWidth(), mDrawable2.getIntrinsicHeight()) / 5f;
        mBaseSize4 = Math.max(mDrawable4.getIntrinsicWidth(), mDrawable4.getIntrinsicHeight()) / 5f;
        mBaseSize5 = Math.max(mDrawable5.getIntrinsicWidth(), mDrawable5.getIntrinsicHeight()) / 2f;
        mBaseSpeed = BASE_SPEED_DP_PER_S * getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);

        // The starting position is dependent on the size of the view,
        // which is why the model is initialized here, when the view is measured.
        for (int i = 0; i < mPlanets.length; i++) {
            final Planet planet = new Planet();
            initializeStar(planet, width, height);
            mPlanets[i] = planet;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int viewHeight = getHeight();
        int i = 0;
        for (final Planet planet : mPlanets) {

            // Ignore the star if it's outside of the view bounds
            final float starSize = planet.scale * mBaseSize;
            if (planet.y + starSize < 0 || planet.y - starSize > viewHeight) {
                continue;
            }

            // Save the current canvas state
            final int save = canvas.save();

            // Move the canvas to the center of the star
            canvas.translate(planet.x, planet.y);

            // Rotate the canvas based on how far the star has moved
            final float progress = (planet.y + starSize) / viewHeight;
            canvas.rotate(360 * progress);

            // Prepare the size and alpha of the drawable
            final int size = Math.round(starSize);
            if(i%5==0) {
                mDrawable.setBounds(-size, -size, size, size);
                mDrawable.setAlpha(Math.round(255 * planet.alpha));

                // Draw the star to the canvas
                mDrawable.draw(canvas);
            }
            else if (i%5==1)
            {
                mDrawable2.setBounds(-size, -size, size, size);
                mDrawable2.setAlpha(Math.round(255 * planet.alpha));

                // Draw the star to the canvas
                mDrawable2.draw(canvas);
            }
            else if (i%5==3)
            {
                mDrawable4.setBounds(-size, -size, size, size);
                mDrawable4.setAlpha(Math.round(255 * planet.alpha));

                // Draw the star to the canvas
                mDrawable4.draw(canvas);
            }
            else
            {
                mDrawable5.setBounds(-size, -size, size, size);
                mDrawable5.setAlpha(Math.round(255 * planet.alpha));

                // Draw the star to the canvas
                mDrawable5.draw(canvas);
            }
            i++;

            // Restore the canvas to it's previous position and rotation
            canvas.restoreToCount(save);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mTimeAnimator = new TimeAnimator();
        mTimeAnimator.setTimeListener(new TimeAnimator.TimeListener() {
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                if (!isLaidOut()) {
                    // Ignore all calls before the view has been measured and laid out.
                    return;
                }
                updateState(deltaTime);
                invalidate();
            }
        });
        mTimeAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mTimeAnimator.cancel();
        mTimeAnimator.setTimeListener(null);
        mTimeAnimator.removeAllListeners();
        mTimeAnimator = null;
    }

    /**
     * Pause the animation if it's running
     */
    public void pause() {
        if (mTimeAnimator != null && mTimeAnimator.isRunning()) {
            // Store the current play time for later.
            mCurrentPlayTime = mTimeAnimator.getCurrentPlayTime();
            mTimeAnimator.pause();
        }
    }

    /**
     * Resume the animation if not already running
     */
    public void resume() {
        if (mTimeAnimator != null && mTimeAnimator.isPaused()) {
            mTimeAnimator.start();
            // Why set the current play time?
            // TimeAnimator uses timestamps internally to determine the delta given
            // in the TimeListener. When resumed, the next delta received will the whole
            // pause duration, which might cause a huge jank in the animation.
            // By setting the current play time, it will pick of where it left off.
            mTimeAnimator.setCurrentPlayTime(mCurrentPlayTime);
        }
    }

    /**
     * Progress the animation by moving the stars based on the elapsed time
     * @param deltaMs time delta since the last frame, in millis
     */
    private void updateState(float deltaMs) {
        // Converting to seconds since PX/S constants are easier to understand
        final float deltaSeconds = deltaMs / 1000f;
        final int viewWidth = getWidth();
        final int viewHeight = getHeight();

        for (final Planet planet : mPlanets) {
            // Move the star based on the elapsed time and it's speed
            planet.y -= planet.speed * deltaSeconds;

            // If the star is completely outside of the view bounds after
            // updating it's position, recycle it.
            final float size = planet.scale * mBaseSize;
            if (planet.y + size < 0) {
                initializeStar(planet, viewWidth, viewHeight);
            }
        }
    }

    /**
     * Initialize the given star by randomizing it's position, scale and alpha
     * @param planet the star to initialize
     * @param viewWidth the view width
     * @param viewHeight the view height
     */
    private void initializeStar(Planet planet, int viewWidth, int viewHeight) {
        // Set the scale based on a min value and a random multiplier
        planet.scale = SCALE_MIN_PART + SCALE_RANDOM_PART * mRnd.nextFloat();

        // Set X to a random value within the width of the view
        planet.x = viewWidth * mRnd.nextFloat();

        // Set the Y position
        // Start at the bottom of the view
        planet.y = viewHeight;
        // The Y value is in the center of the star, add the size
        // to make sure it starts outside of the view bound
        planet.y += planet.scale * mBaseSize;
        // Add a random offset to create a small delay before the
        // star appears again.
        planet.y += viewHeight * mRnd.nextFloat() / 4f;

        // The alpha is determined by the scale of the star and a random multiplier.
        planet.alpha = ALPHA_SCALE_PART * planet.scale + ALPHA_RANDOM_PART * mRnd.nextFloat();
        // The bigger and brighter a star is, the faster it moves
        planet.speed = mBaseSpeed * planet.alpha * planet.scale;
    }
}
