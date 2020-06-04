package com.stey.hello.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Pageable
import java.io.IOException

@JsonComponent
class PageableSerializer : JsonSerializer<Pageable>() {

    override fun serialize(value: Pageable?, generator: JsonGenerator?, serializers: SerializerProvider?) {

        generator?.writeStartObject();
        generator?.writeNumberField("offset", value?.offset?:0);
        generator?.writeNumberField("pageNumber", value?.pageNumber?:0);
        generator?.writeNumberField("pageSize", value?.pageSize?:0);
        generator?.writeBooleanField("isPaged", value?.isPaged?:false);
        generator?.writeBooleanField("isUnpaged", value?.isUnpaged?:false);

        generator?.writeArrayFieldStart("sort");
        value?.sort?.iterator()?.forEachRemaining { v ->
            try {
                generator?.writeObject(v)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        };
        generator?.writeEndArray();
        generator?.writeEndObject();
    }
}