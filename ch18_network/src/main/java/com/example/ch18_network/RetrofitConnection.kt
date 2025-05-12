package com.example.ch18_network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://apis.data.go.kr/1360000/WthrWrnInfoService/getWthrWrnList?serviceKey= 서비스키(일반 인증키(Encoding))
// &pageNo=1&numOfRows=10&dataType=XML&stnId=184&fromTmFc=20250509&toTmFc=20250509

class RetrofitConnection{

    //객체를 하나만 생성하는 싱글턴 패턴을 적용합니다.
    companion object {
        //API 서버의 주소가 BASE_URL이 됩니다.
        private const val BASE_URL = "https://apis.data.go.kr/1360000/WthrWrnInfoService/" // 접근하려는 웹 주소

        var jsonNetworkService : NetworkService
        val jsonRetrofit : Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // 전달받은 Json을 Converter
                .build()

        init{
            jsonNetworkService = jsonRetrofit.create(NetworkService::class.java)
        }
    }
}