package com.peopleinteractive.task.feature.home

import com.peopleinteractive.core.utils.SystemUtils
import com.peopleinteractive.domain.repository.IUserRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Test


class HomeViewModelTest {

    private var testContext = Dispatchers.Unconfined

    private lateinit var viewModel: HomeViewModel

    @MockK
    private lateinit var repository: IUserRepository

    @MockK
    private lateinit var systemUtils: SystemUtils

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(Dispatchers.IO, repository, systemUtils)
    }

    @Test
    fun fetchTsoPerformanceTest() {

    }


}