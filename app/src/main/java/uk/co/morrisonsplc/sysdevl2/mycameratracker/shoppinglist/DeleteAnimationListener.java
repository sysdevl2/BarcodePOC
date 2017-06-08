package uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist;

import android.view.animation.Animation;

/**
 * Listenter used to remove an item after the animation has finished remove
 */
public class DeleteAnimationListener implements Animation.AnimationListener
{
    private int position;
    public DeleteAnimationListener(int position)
    {
        this.position = position;
    }
    @Override
    public void onAnimationEnd(Animation arg0) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }
}