package com.martinb.marvelapp.data.model

data class Result(val id: String,val name: String, val description: String, val modified: String,
                  val resourceURI: String, val urls: List<Url>, val thumbnail: Thumbnail,val comics: Comics,
                   val stories: Stories, val events: Events, val series: Series)