package net.codecision.startask.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.codecision.startask.ktx.core.view.setSingleClickListener

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionsButton.setSingleClickListener {
            startActivity(Intent(this, PermissionsActivity::class.java))
        }
    }

}
