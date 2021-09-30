package eu.sweetlygeek.serialization.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Duration

@Serializable
data class Article(
    @SerialName("@id") val id: Long,
    val type: String? = null,
    val url: String? = null,
    val title: String? = null,
    @SerialName("chapo") val header: String? = null,
    val cover: Photo? = null,
    val video: Video? = null,
    val author: User? = null,
    val tags: Map<String, List<String>> = emptyMap(),
)

@Serializable
data class Photo(
    val id: Long? = null,
    val url: String,
    val legend: String? = null,
    val credit: String? = null
)

@Serializable
data class Video(
    @SerialName("@id") val id: Long,
    val url: String? = null,
    @SerialName("dailymotion_id") val dailymotionId: String? = null,
    val title: String? = null,
    val cover: Photo? = null,
    @Serializable(with = SecondsDurationSerializer::class) val duration: Duration = Duration.ZERO
)

@Serializable
data class User(
    @SerialName("@id") val id: Long,
    val avatar: Photo? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val nickname: String? = null,
    val isBrand: Boolean = false
)

@Serializable
data class ResultPage<T>(
    val items: List<T> = emptyList(),
    val count: Int = items.size,
    val total: Int = 0
)