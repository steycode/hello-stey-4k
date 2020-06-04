package com.stey.hello.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Sort
import kotlin.collections.ArrayList


@JsonComponent
class SortDeserializer : JsonDeserializer<Sort>() {
    override fun deserialize(parser: JsonParser?, context: DeserializationContext?): Sort {
        val sort : MutableList<Sort.Order> = ArrayList();

        if (parser?.currentToken === JsonToken.START_ARRAY) {
            while (parser.nextToken() !== JsonToken.END_ARRAY) {
                sort.add(parser.readValueAs(Sort.Order::class.java));
            }
        }
        return  Sort.by(sort);
    }
}