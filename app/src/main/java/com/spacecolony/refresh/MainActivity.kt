package com.spacecolony.refresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.spacecolony.refresh.fragment.ChallengeFragment
import com.spacecolony.refresh.fragment.HomeFragment
import com.spacecolony.refresh.fragment.PemenangFragment
import com.spacecolony.refresh.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val challengeFragment = ChallengeFragment()
        val pemenangFragment = PemenangFragment()
        val profileFragment = ProfileFragment()

        makecurrentfragment(homeFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makecurrentfragment(homeFragment)
                R.id.ic_tantangan -> makecurrentfragment(challengeFragment)
                R.id.ic_pemenang -> makecurrentfragment(pemenangFragment)
                R.id.ic_profile -> makecurrentfragment(profileFragment)

            }
            true
        }
    }

    private fun makecurrentfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_frame, fragment)
            commit()
        }
    }
    fun setbottomnav(status: Int) {
        bottom_nav.visibility = status
    }
    fun bottomnavstatus(): Boolean {
        return bottom_nav.isShown
    }
}