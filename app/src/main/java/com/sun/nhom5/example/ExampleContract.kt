package com.sun.nhom5.example

import com.sun.nhom5.base.BaseContract

interface ExampleContract : BaseContract<ExampleContract.View, ExampleContract.Presenter> {
    interface View : BaseContract.View {
        fun showMyTeams(teams: List<String>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadMyTeams()
    }
}
