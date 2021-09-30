package eu.sweetlygeek.serialization.error

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

fun main() {
    Json {
        ignoreUnknownKeys = true
    }.decodeFromStream<ResultPage<Article>>(Article::class.java.getResourceAsStream("error.json"))
}