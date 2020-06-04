package com.stey.hello.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Sort
import java.io.IOException

@JsonComponent
class SortSerializer : JsonSerializer<Sort>() {

    override fun serialize(value: Sort?, generator: JsonGenerator?, serializers: SerializerProvider?) {
        generator?.writeStartArray();

        value?.iterator()?.forEachRemaining { v ->
            try {
                generator?.writeObject(v)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        generator?.writeEndArray()
    }
}