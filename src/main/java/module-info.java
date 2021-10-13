import net.yakclient.service.manager.example.YakService;

module yakclient.service.manager.example {
    requires kotlin.stdlib;
    requires io.github.emilyydev.asp;
    exports net.yakclient.service.manager.example;

    uses YakService;
}