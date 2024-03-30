package com.babacan05.cineme.feature_movie.domain.util

import com.babacan05.cineme.feature_movie.data.model.remote.title_detail.TitleDetailDTO
import com.babacan05.cineme.feature_movie.domain.model.Actor
import com.babacan05.cineme.feature_movie.domain.model.MoreLikeTitle
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail


    fun mapTitleDetailDTOToTitleDetail(titleDetailDTO: TitleDetailDTO): TitleDetail {
        return TitleDetail(
            id=titleDetailDTO.id,
            name=titleDetailDTO.titleText.text,
            cast =titleDetailDTO.cast?.edges?.map {
               Actor(
                    name = it.node?.name?.nameText?.text ?: "",
                    imageUrl = it.node?.name?.primaryImage?.url ?: "",
                    character = it.node!!.characters[0].name
                )
            } ?: emptyList(),
            imageUrl = titleDetailDTO.primaryImage.url,
            videoUrls = titleDetailDTO.primaryVideos.edges[0].node.playbackURLs.map { it.url },
            rating = titleDetailDTO.ratingsSummary.aggregateRating,
            releaseYear = titleDetailDTO.releaseYear.year,
            plot = titleDetailDTO.plot.plotText.plainText,
            review = titleDetailDTO.featuredReviews.edges[0].node.text.originalText.plainText,
            genres = titleDetailDTO.genres.genres.map { it.text },
            moreTitles =titleDetailDTO.moreLikeThisTitles.edges.map {
                    MoreLikeTitle(
                        id =it.node.id,
                        name = it.node.titleText.text,
                       imageUrl = it.node.primaryImage.url,
                        ratingsSummary = it.node.ratingsSummary.aggregateRating) },
            director = titleDetailDTO.directors.flatMap {
                it.credits
            }.joinToString(separator = ",") { it.name.nameText.text }

        )
    }
