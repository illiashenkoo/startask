package net.codecision.startask.utils.listener

import android.animation.Animator

open class SimpleAnimatorListener : Animator.AnimatorListener {
    
    override fun onAnimationRepeat(animator: Animator) {
        //it's method can be overridden
    }

    override fun onAnimationEnd(animator: Animator) {
        //it's method can be overridden
    }

    override fun onAnimationCancel(animator: Animator) {
        //it's method can be overridden
    }

    override fun onAnimationStart(animator: Animator) {
        //it's method can be overridden
    }

}