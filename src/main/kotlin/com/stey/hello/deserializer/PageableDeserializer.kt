package com.stey.hello.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonTokenId
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort


@JsonComponent
class PageableDeserializer : JsonDeserializer<Pageable>() {

    override fun deserialize(parser: JsonParser?, context: DeserializationContext?): Pageable? {
        var sort: List<Sort.Order> = ArrayList();
        var pageNumber = 0;
        var pageSize = 0;
        val type = context?.typeFactory?.constructCollectionType(List::class.java, Sort.Order::class.java);

        if (parser?.isExpectedStartObjectToken!!) {
            parser.nextToken()
            if (parser.hasTokenId(JsonTokenId.ID_FIELD_NAME)) {
                var propName: String? = parser.currentName

                do {
                    parser.nextToken()
                    when (propName) {
                        "pageNumber" -> pageNumber = context?.readValue(parser, Int::class.java)!!
                        "pageSize" -> pageSize = context?.readValue(parser, Int::class.java)!!
                        "sort" -> sort = context?.readValue(parser, type)!!
                        else -> parser.skipChildren()
                    }
                } while (parser.nextFieldName().also { propName = it } != null)
            } else {
                context?.handleUnexpectedToken(handledType(), parser)
            }
        } else {
            context?.handleUnexpectedToken(handledType(), parser)
        }
        return PageRequest.of(pageNumber, pageSize, Sort.by(sort));
    }

}