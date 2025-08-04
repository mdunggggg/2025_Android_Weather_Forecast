package com.sun.nhom5.example

import android.widget.Toast
import com.sun.nhom5.base.BaseActivity
import com.sun.nhom5.databinding.ActivitySampleBinding

class SampleActivity : BaseActivity<ActivitySampleBinding, ExamplePresenter>(), ExampleContract.View {

    private lateinit var repository: ITeamRepository

    override fun getViewBinding(): ActivitySampleBinding {
        return ActivitySampleBinding.inflate(layoutInflater)
    }

    override fun initializePresenter() {
        presenter = ExamplePresenter(TeamRepository())
    }

    override fun setupViews() {
        repository = TeamRepository()
        presenter = ExamplePresenter(repository)
        presenter?.attachView(this)
    }

    override fun setupListeners() {
        binding.loadMyTeamsButton.setOnClickListener {
            presenter?.loadMyTeams()
        }
    }

    override fun showMyTeams(teams: List<String>) {
        Toast.makeText(
            this,
            teams.joinToString { it },
            Toast.LENGTH_SHORT
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
