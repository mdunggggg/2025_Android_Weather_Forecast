package com.example.android_template.example

import com.example.android_template.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExamplePresenter(
    private val teamRepository: ITeamRepository
) : BasePresenter<ExampleContract.View>(), ExampleContract.Presenter {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun loadMyTeams() {
        scope.launch {
            val teams = withContext(Dispatchers.IO) {
                teamRepository.getMyTeams()
            }
            if (isViewAttached()) {
                getView()?.showMyTeams(teams)
            }
            else {
                getView()?.showError("View is not attached")
            }
        }
    }

}