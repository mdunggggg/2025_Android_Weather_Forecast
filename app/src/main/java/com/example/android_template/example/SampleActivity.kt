package com.example.android_template.example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_template.R
import com.example.android_template.base.BaseActivity
import com.example.android_template.databinding.ActivitySampleBinding

class SampleActivity : BaseActivity<ActivitySampleBinding>(), ExampleContract.View {

    private lateinit var presenter: ExamplePresenter
    private lateinit var repository: ITeamRepository

    override fun getViewBinding(): ActivitySampleBinding {
        return ActivitySampleBinding.inflate(layoutInflater)
    }

    override fun setupViews() {
        repository = TeamRepository()
        presenter = ExamplePresenter(repository)
        presenter.attachView(this)
    }

    override fun setupListeners() {
        binding.loadMyTeamsButton.setOnClickListener {
            presenter.loadMyTeams()
        }
    }

    override fun showMyTeams(teams: List<String>) {
       Toast.makeText(
            this,
           teams.joinToString(", "),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun showLoading() {
        Toast.makeText(
            this,
            "Loading teams...",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun hideLoading() {
    }

    override fun showError(message: String) {
        Toast.makeText(
            this,
            "Error: $message",
            Toast.LENGTH_LONG
        ).show()
    }

}