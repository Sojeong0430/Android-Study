package com.example.ch18_network

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch18_network.databinding.FragmentJsonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JsonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JsonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val TAG = "25android"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentJsonBinding.inflate(inflater,container,false)

        val loc = arguments?.getString("searchLoc") ?: "108"
        Log.d(TAG, loc)

        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val today = dateFormat.format(System.currentTimeMillis())

        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, -3) // 3일 전 날짜를 가지고 온다
        val three_ago = dateFormat.format(cal.time) // 3일 전 날짜를 yyyy-MM-dd 같은 포맷 문자열로 바꿈

        val call : Call<JsonResponse> = RetrofitConnection.jsonNetworkService.getJsonList(
            loc.toInt(),
            1,
            10,
            "json",
            "vAFsLjspvIdXWIickBuIbessXMW6J5vv0DJoyweELSvzzY6vbGCS8sVjcdAqedoihVUSs5s1p1pV/cZ5ub+F5w==", // Retrofit의 경우에는 디코딩 인증키 사용
            three_ago, today // 3일 전 부터 오늘까지
        )

        call?.enqueue(object : Callback<JsonResponse> {

            override fun onResponse(call: Call<JsonResponse>, response: Response<JsonResponse>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "Response: ${response}")
                    Log.d(TAG, "Response: ${response.body()}")

                    binding.jsonRecyclerView.layoutManager = LinearLayoutManager(activity)
                    binding.jsonRecyclerView.adapter = JsonAdapter(response.body()!!.response.body.items.item)
                    binding.jsonRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                }
            }

            override fun onFailure(call: Call<JsonResponse>, t: Throwable) {
                Log.e(TAG, "Request failed", t)
            }

        })
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JsonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JsonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}