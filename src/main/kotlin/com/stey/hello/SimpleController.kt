package com.stey.hello

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

/**
 * Created on 2020/03/02.
 *
 * @author Yoann CAPLAIN
 */
@RestController
@RequestMapping("/api")
class SimpleController {

    @GetMapping("/read-serialize")
    fun readAndSerializeDate(@RequestParam time: Instant): Instant {
        return time
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
