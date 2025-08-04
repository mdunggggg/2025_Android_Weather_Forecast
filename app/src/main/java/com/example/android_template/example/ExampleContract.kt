package com.example.android_template.example

import com.example.android_template.base.BaseContract

interface ExampleContract : BaseContract<ExampleContract.View, ExampleContract.Presenter> {
    interface View : BaseContract.View {
        fun showMyTeams(teams: List<String>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadMyTeams()
    }
}
