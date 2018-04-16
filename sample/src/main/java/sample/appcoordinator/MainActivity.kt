package sample.appcoordinator

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import appcoordinator.annotation.AddToBackStack
import appcoordinator.annotation.Container
import appcoordinator.annotation.CustomAnimation
import appcoordinator.extension.add
import appcoordinator.extension.getFragment
import appcoordinator.extension.setTag
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        @Container(id = R.id.content)
        @CustomAnimation(enter = R.anim.abc_fade_in, exit = R.anim.abc_fade_out)
        @AddToBackStack(value = false)
        class FragmentModel

        val mainActivityFragment = MainActivityFragment()
        mainActivityFragment.setTag("Testing")
        add(fragment = mainActivityFragment, transactionModel = FragmentModel())
        Log.e("MainActivity", mainActivityFragment.tag)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            //AppCoordinator.add(this, MainActivityFragment2())
            add(MainActivityFragment2())
            val fragment1 = getFragment("MainActivityFragment")
            val fragment2 = getFragment("MainActivityFragment2")
            Log.e("MainActivity", "" + getFragment(MainActivityFragment2::javaClass.name)?.toString())
        }
    }
}