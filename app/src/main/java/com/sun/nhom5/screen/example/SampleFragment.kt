package com.example.android_template.example

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.sun.nhom5.databinding.FragmentSampleBinding
import com.sun.nhom5.screen.base.BaseFragment
import com.sun.nhom5.screen.example.ExampleContract
import com.sun.nhom5.screen.example.ExamplePresenter
import com.sun.nhom5.screen.example.TeamRepository

class SampleFragment : BaseFragment<FragmentSampleBinding, ExamplePresenter>(), ExampleContract.View {

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSampleBinding {
        return FragmentSampleBinding.inflate(inflater, container, false)
    }

    override fun initializePresenter() {
        presenter = ExamplePresenter(TeamRepository())
    }

    override fun setupViews() {
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
