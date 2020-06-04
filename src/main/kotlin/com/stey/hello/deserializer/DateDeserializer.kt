package com.stey.hello.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.springframework.boot.jackson.JsonComponent
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

@JsonComponent
class DateDeserializer : JsonDeserializer<Instant>() {
    override fun deserialize(parser: JsonParser?, context: DeserializationContext?): Instant {
        val format = SimpleDateFormat("YYYY-MM-DD");
        val value: String? = parser?.valueAsString;

        val date = format.parse(value);
        val calendar = Calendar.getInstance();
        calendar.time = date;
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.toInstant();
    }
}