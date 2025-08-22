# Convention plugins

For more information, [see][now-in-android].

The `build-logic` folder defines project-specific convention plugins, used to keep a single
source of truth for common module configurations. By setting up convention plugins in `build-logic`,
we can avoid duplicated build script setup, messy `subproject` configurations, without the pitfalls
of the `buildSrc` directory.

[now-in-android]: https://github.com/android/nowinandroid/blob/main/build-logic