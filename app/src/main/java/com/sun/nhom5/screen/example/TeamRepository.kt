package com.sun.nhom5.screen.example

import kotlinx.coroutines.delay

interface ITeamRepository {
    suspend fun getMyTeams(): List<String>
}

class TeamRepository : ITeamRepository {
    override suspend fun getMyTeams(): List<String> {
        delay(1000)
        return listOf(
            "Hoang Manh Dung",
            "Dang Nguyet Minh",
            "Nguyen Anh Duc",
            "Le Quoc Trung"
        )
    }
}
