package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.PhoneAdapter
import com.example.recyclerview.adapter.PhoneItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ds = arrayListOf<PhoneItem>()
        ds.add(PhoneItem("123456","Sumedh", "${System.currentTimeMillis()}"))
        ds.add(PhoneItem("987654","Vinod", "${System.currentTimeMillis()}"))
        ds.add(PhoneItem("159753","Aniruddha", "${System.currentTimeMillis()}"))

        val lvDs : MutableLiveData<ArrayList<PhoneItem>> = MutableLiveData()
        lvDs.value = ds

        val adapter = PhoneAdapter(this, lvDs.value?: arrayListOf())
        phoneList.layoutManager = LinearLayoutManager(this)
        phoneList.adapter = adapter

        lvDs.observe(this, Observer {
                adapter.freshData(it)
        })

        btSv.setOnClickListener{
        val itm = PhoneItem(etNum.text.toString(),
            etNm.text.toString(),
        "${System.currentTimeMillis()}"
        )
            ds.add(itm)
    }


}
}
