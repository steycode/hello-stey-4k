package com.stey.hello.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import java.util.*

@JsonComponent
class DateSerializer : JsonSerializer<Date>() {

    override fun serialize(value: Date?, generator: JsonGenerator?, serializers: SerializerProvider?) {
        val unixTimestamp = value?.time?.div(1000);
        generator?.writeNumber(unixTimestamp?:0);
    }
}