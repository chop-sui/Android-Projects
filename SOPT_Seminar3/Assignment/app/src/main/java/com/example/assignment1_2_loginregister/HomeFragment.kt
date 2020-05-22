package com.example.bottomnavigator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment1_2_loginregister.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply{
            add(
                InstaData(
                    userName = "서정록",
                    img_profile ="https://image.shutterstock.com/image-vector/south-korea-flag-official-colors-260nw-1014914968.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/02/10/21/57/heart-1192662__340.jpg"
                ))
            add(
                InstaData(
                    userName = "김정은",
                    img_profile ="https://cdn.pixabay.com/photo/2016/01/20/09/03/north-korea-1151137__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/11/14/04/45/elephant-1822636__340.jpg"
                ))
            add(
                InstaData(
                    userName = "트럼프",
                    img_profile ="https://cdn.pixabay.com/photo/2017/01/24/13/02/donald-trump-2005343__340.png",
                    img_contents = "https://cdn.pixabay.com/photo/2013/08/28/12/03/plumage-176723__340.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}
