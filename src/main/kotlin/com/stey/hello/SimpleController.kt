package com.stey.hello

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

/**
 * Created on 2020/03/02.
 *
 * @author Yoann CAPLAIN
 */
@RestController
@RequestMapping("/api")
class SimpleController {

    @GetMapping("/time-body")
    fun timeBody(@RequestBody time: TimeBody): TimeBody {
        return time
    }

    @GetMapping("/read-serialize")
    fun readAndSerializeDate(@RequestParam time: Instant): Instant {
        return time
    }

    @GetMapping("do-date")
    fun date(): Date {
        return Date()
    }

    @GetMapping("do-pageable")
    fun pageable(pageable: Pageable): Pageable {
        return pageable
    }

    @GetMapping("do-sort")
    fun sort(sort: Sort): Sort {
        return sort
    }

}

data class TimeBody(
        val time: Instant
)
