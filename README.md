### MVC架构模式

- M 层 model ，负责处理数据，例如网络请求、数据变化

- V 层 对应的是布局 

- C 层 Controller， 对应的是Activity，处理业务逻辑，包含V层的事情，还会做其他的事情，导致 activity里的代码变的庞大

### 本demo演示MVC架构的使用

>- 网络框架
   >[retrofit2](https://github.com/square/retrofit/) + [协程](https://book.kotlincn.net/text/coroutines-overview.html)
   >[协程上下文与调度器 中文文档](https://book.kotlincn.net/text/coroutine-context-and-dispatchers.html)
   >[协程上下文与调度器 英文文档](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#thread-local-data)
>- 日志框架
   >[okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
>- 数据库
   >[room](https://developer.android.com/jetpack/androidx/releases/room?hl=en#kts)
>- api
   >[玩Android 开放API](api%E5%9C%B0%E5%9D%80%20https://www.wanandroid.com/blog/show/2)
>- Gradle依赖统一版本管理
   >[Version Catalog](https://docs.gradle.org/7.0/release-notes.html)
   >[TOML官网](https://toml.io/en/)
>- KSP
   >[从 kapt 迁移到 KSP](https://developer.android.com/build/migrate-to-ksp?hl=zh-cn)
   >[KSP官网文档](https://kotlinlang.org/docs/ksp-quickstart.html)
>- [TextInputEditText](https://developer.android.google.cn/reference/com/google/android/material/textfield/TextInputEditText?hl=en)
>- [ViewBinding](https://developer.android.com/topic/libraries/view-binding?hl=zh-cn)
   >[Android Gradle 插件 3.6.0推出的新特性](https://developer.android.com/build/releases/past-releases/agp-3-6-0-release-notes?hl=zh-cn)
   >[Android Gradle 插件 4.0.0开始放在buildFeatures](https://developer.android.com/build/releases/past-releases/agp-4-0-0-release-notes?hl=zh-cn)

