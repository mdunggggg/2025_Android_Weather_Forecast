package com.example.android_template.example

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.sun.nhom5.base.BaseFragment
import com.sun.nhom5.databinding.FragmentSampleBinding
import com.sun.nhom5.example.ExampleContract
import com.sun.nhom5.example.ExamplePresenter
import com.sun.nhom5.example.ITeamRepository
import com.sun.nhom5.example.TeamRepository

class SampleFragment : BaseFragment<FragmentSampleBinding, ExamplePresenter>(), ExampleContract.View {

    private lateinit var repository: ITeamRepository

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSampleBinding {
        return FragmentSampleBinding.inflate(inflater, container, false)
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
            context,
            teams.joinToString(", "),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun showLoading() {
        Toast.makeText(
            context,
            "Loading teams...",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun hideLoading() {
    }

    override fun showError(message: String) {
        Toast.makeText(
            context,
            "Error: $message",
            Toast.LENGTH_LONG
        ).show()
    }
}
