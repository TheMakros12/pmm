package com.example.t10_a1_dura_marcos.api

import com.example.t10_a1_dura_marcos.data.LegoApiResponse
import com.example.t10_a1_dura_marcos.data.LegoResponse
import com.example.t10_a1_dura_marcos.data.PiezasResponse
import com.example.t10_a1_dura_marcos.data.ThemesApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LegoApiServices {

    @GET("themes/")
    suspend fun getThemes(@Query("limit") limit: Int = 1000): ThemesApiResponse

    @GET("sets/")
    suspend fun getSets(@Query("theme_id") themeId: Int,
                               @Query("page_size") pageSize: Int = 60,
                               @Query("ordering") order: String = "-year,-set_num"): LegoApiResponse

    @GET("sets/{set_num}/parts")
    suspend fun getPiezas(
        @Path("set_num") setNum: String,
        @Query("page_size") pageSize: Int = 1000
    ): PiezasResponse

}