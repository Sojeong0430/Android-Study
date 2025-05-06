package com.example.ch11_jetpack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch11_jetpack.databinding.FragmentOneBinding
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class OneFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOneBinding.inflate(inflater,container,false)

        var datas = mutableListOf<String>()
        val db = DBHelper(inflater.context).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB", null) // 테이블의 모든 행 가져옴
        cursor.run {
            while(moveToNext()){
                datas.add(cursor.getString(1)) // 행의 두번째 칼럼 값 가져와서 저장
            }
        }
        db.close() // 끝난 후 반드시 종료

        val radapter = MyAdapter(datas)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        //binding.recyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerView.adapter = radapter
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        val requestLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                val todo = it.data!!.getStringExtra("result")
                if(todo != ""){
                    datas.add(todo!!)
                    radapter.notifyDataSetChanged()
                }
        }

        binding.fab.setOnClickListener{
            //datas.add("Item 100")
            //radapter.notifyDataSetChanged()

            val intent = Intent(it.context, AddActivity::class.java)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            intent.putExtra("today",dateFormat.format(System.currentTimeMillis()))
            requestLauncher.launch(intent)
        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_one, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}