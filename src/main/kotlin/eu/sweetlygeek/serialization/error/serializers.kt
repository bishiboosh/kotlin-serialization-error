package eu.sweetlygeek.serialization.error

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Duration

object SecondsDurationSerializer : KSerializer<Duration> {
    private const val NANOS_PER_SECOND = 1_000_000_000L.toDouble()

    override val descriptor = PrimitiveSerialDescriptor("DurationAsSeconds", PrimitiveKind.DOUBLE)

    override fun deserialize(decoder: Decoder): Duration {
        return Duration.ofNanos((decoder.decodeDouble() * NANOS_PER_SECOND).toLong())
    }

    override fun serialize(encoder: Encoder, value: Duration) {
        val seconds = value.seconds
        val nanoSeconds = value.nano
        encoder.encodeDouble(seconds.toDouble() + nanoSeconds.toDouble() / NANOS_PER_SECOND)
    }
}