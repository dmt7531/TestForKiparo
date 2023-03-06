package data.repository.xml

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "element", strict = false)
data class ElementXml(
    @field:Element(name = "id")
    var id: Int = 0,
    @field:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "date")
    var date: String? = null,
    @field:Element(name = "description")
    var description: String? = null,
    @field:Element(name = "keywords")
    var keywords: KeywordsXml? = null,
    @field:Element(name = "visible")
    var visible: Boolean = false,
)

@Root(name = "keywords", strict = false)
data class KeywordsXml(
    @field:ElementList(inline = true, entry = "element")
    var keywords: List<String>? = null,
)

@Root(name = "location", strict = false)
data class LocationXml(
    @field:Text
    var location: String? = null,
)

@Root(name = "news", strict = false)
data class NewsListXml(
    @field:ElementList(inline = true, entry = "element")
    var news: List<ElementXml>? = null,
)

@Root(name = "root", strict = false)
data class RootXml(
    @field:Element(name = "name")
    var name: String? = null,
    @field:Element(name = "location")
    var location: LocationXml? = null,
    @field:Element(name = "news")
    var news: NewsListXml? = null,
)

@Root(strict = false)
data class NewsXml(
    var id: Int = 0,
    var title: String? = null,
    var date: String? = null,
    var description: String? = null,
    var keywords: List<String>? = null,
    var visible: Boolean = false,
)