package com.starnet.cqj.brokenstonefactory.view.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import com.starnet.cqj.brokenstonefactory.R
import kotlinx.android.synthetic.main.fragment_infos.*

/**
 * 作用：
 * Created by cqj on 2017-07-19.
 */
class InfosFragment : Fragment() {

    private val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
    private val PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f

    private val ALPHA_ANIMATIONS_DURATION = 200L

    var mIsTheTitleVisible = false

    var mIsTitleContainerVisible = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_infos, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        infosToolbar.title = ""

        appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScroll = appBarLayout.totalScrollRange
            val percentage: Float = Math.abs(verticalOffset).toFloat() / maxScroll.toFloat()
            handleAlphaOnTitle(percentage)
            handleToolbarTitleVisibility(percentage)
        }

        initParallaxValues()

    }

    private fun initParallaxValues(){
        val params =avatar.layoutParams as CollapsingToolbarLayout.LayoutParams
        params.parallaxMultiplier=0.9f
        avatar.layoutParams=params
    }

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
            if (!mIsTheTitleVisible) {
                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
                mIsTheTitleVisible = true
            }
        } else {
            if (mIsTheTitleVisible) {
                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
                mIsTheTitleVisible = false
            }
        }
    }

    private fun handleAlphaOnTitle(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTitleContainerVisible) {
                startAlphaAnimation(rlTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
                mIsTitleContainerVisible = false
            }
        } else {
            if (!mIsTitleContainerVisible) {
                startAlphaAnimation(rlTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
                mIsTitleContainerVisible = true
            }
        }
    }

    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val animation: AlphaAnimation = if (visibility == View.VISIBLE) {
            AlphaAnimation(0f, 1f)
        } else {
            AlphaAnimation(1f, 0f)
        }
        animation.duration = duration
        animation.fillAfter = true
        v.startAnimation(animation)
    }

}
