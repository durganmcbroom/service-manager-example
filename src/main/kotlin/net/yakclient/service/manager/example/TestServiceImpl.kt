package net.yakclient.service.manager.example

import io.github.emilyydev.asp.Provides

@Provides(YakService::class)
public class TestServiceImpl() : YakService {
    override val name: String
        get() = "test service implementation"
}