import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

import org.http4k.core.Body
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.format.JacksonXml.auto

data class Foo(
    val text: String
)

data class Bar(
    @JacksonXmlText
    val text: String
)

fun testFoo(): Boolean {
    val expected = Foo("text")

    val lens = Body.auto<Foo>().toLens()

    // Body: <Foo><text>text</text></Foo>
    val response = lens(expected, Response(Status.OK))
    val actual = lens(response)
   
    return actual == expected 
}

fun testBar(): Boolean {
    val expected = Bar("text")

    val lens = Body.auto<Bar>().toLens()

    // Body: <Bar>text</Bar>
    val response = lens(expected, Response(Status.OK))
    val actual = lens(response)
    
    return actual == expected 
}

fun main() {
    if (testFoo())
    {
        println("Foo test succeeded")
    }
    else {
        println("Foo test failed")
    }

    if (testBar()) {
        println("Bar test succeeded")
    }
    else {
        println("Bar test failed")
    }
}
