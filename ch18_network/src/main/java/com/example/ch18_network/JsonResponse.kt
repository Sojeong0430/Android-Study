package com.example.ch18_network

 // 사용하려는 데이터의 Key 값과 변수의 이름이 일치해야함
data class myJsonItem(val stnId:String, val title:String, val tmFc:String) // 필요힌 것만 가져오면 됨

data class myJsonItems(val item : MutableList<myJsonItem>?)

data class myJsonBody(val items : myJsonItems)

data class myJsonResponse(val body:myJsonBody)

data class JsonResponse(val response : myJsonResponse)