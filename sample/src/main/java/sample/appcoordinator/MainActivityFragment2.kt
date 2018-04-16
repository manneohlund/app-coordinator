package sample.appcoordinator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import appcoordinator.annotation.Add
import appcoordinator.annotation.AddToBackStack
import appcoordinator.annotation.CustomAnimation
import appcoordinator.annotation.Hide
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */

@Add(containerId = R.id.content, tag = "MainActivityFragment2")
@CustomAnimation(enter = R.anim.abc_slide_in_bottom, exit = R.anim.abc_fade_out)
@AddToBackStack(value = true)
//@Hide(MainActivityFragment::class)
class MainActivityFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text.setText("$tag " + activity.supportFragmentManager.backStackEntryCount)
    }
}
