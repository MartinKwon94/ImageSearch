package com.example.imagesearch

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesearch.adapters.SearchAdapter
import com.example.imagesearch.data.Constant
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.FragmentSearchBinding
import com.example.imagesearch.model.ImageModel
import com.example.imagesearch.retrofit.ClientRetrofit.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Search : Fragment() {
    lateinit var binding: FragmentSearchBinding
    private var _binding: FragmentSearchBinding? = null
    private lateinit var mContext: Context
    private lateinit var adapter: SearchAdapter
    private lateinit var gridmanager: StaggeredGridLayoutManager
    private var resItems: ArrayList<ItemSearch> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupViews()
        setupListeners()
        return binding.root
    }


    private fun setupViews() {
        gridmanager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) //두줄로 리사이클러뷰
        binding.recyclerView1.layoutManager = gridmanager
        adapter = SearchAdapter(mContext)
        binding.recyclerView1.adapter = adapter
        binding.recyclerView1.itemAnimator = null //깜빡임 방지

        val lastSearch = getLastSearch(requireContext())
        binding.tvSearch.setText(lastSearch)
    }

    private fun setupListeners() {
        binding.ivIcSearch.setOnClickListener {
            val query = binding.tvSearch.text.toString()
            if (query.isNotEmpty()) {
                saveLastSearch(requireContext(), query)
                adapter.clearItem()
                fetchImageResults(query)
            } else {
                Toast.makeText(mContext, "키워드를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            val imm =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.tvSearch.windowToken, 0) //키보드 내리기
        }
    }

    private fun fetchImageResults(query: String) {
        val response = apiService.image_search(
            Constant.AUTH_HEADER,
            query,
            "recency",
            1,
            80
        )
            ?.enqueue(object :
                Callback<ImageModel?> {
                override fun onResponse(call: Call<ImageModel?>, response: Response<ImageModel?>) {
                    response.body()?.meta?.let { meta ->
                        if (meta.totalCount > 0) {
                            response.body()!!.document.forEach { document ->
                                val title = document.displaySitename
                                val dateTime = document.datetime
                                val url = document.thumbnailUri
                                resItems.add(ItemSearch(title, dateTime, url))
                            }
                        }
                    }
                    adapter.mItems = resItems
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<ImageModel?>, t: Throwable) {}
            })
    }
    fun saveLastSearch(context: Context, query: String) {
        val prefs = context.getSharedPreferences(Constant.PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(Constant.PREF_KEY, query).apply()
    }

    fun getLastSearch(context: Context): String? {
        val prefs = context.getSharedPreferences(Constant.PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(Constant.PREF_KEY, null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}