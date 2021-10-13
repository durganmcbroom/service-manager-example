package net.yakclient.service.manager.example.test

import net.yakclient.service.manager.example.YakServiceManager
import net.yakclient.service.manager.example.loadFirst
import org.junit.jupiter.api.Test

class TestServiceManagement {
    @Test
    fun testServiceLoading() {
        println(YakServiceManager.loadFirst())
    }
}

